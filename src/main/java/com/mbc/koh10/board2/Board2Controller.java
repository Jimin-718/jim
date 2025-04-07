package com.mbc.koh10.board2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbc.koh10.board.BoardDTO;
import com.mbc.koh10.board.BoardService;

@Controller
public class Board2Controller {
	@Autowired
	SqlSession sqlSession;
	@RequestMapping(value = "/b2input")
	public String bbb1()
	{
		return "board2input";//
	}
	
	@RequestMapping(value = "/mapgo")
	public String bbb111()
	{
		return "mapgo";//
	}
	
	@RequestMapping(value = "/board2save")
	public String bbb2(HttpServletRequest request)
	{
		String name=request.getParameter("boardwriter");
		String title=request.getParameter("boardtitle");
		String content=request.getParameter("boardcontent");
		Board2Service bs = sqlSession.getMapper(Board2Service.class);
		bs.insertb(name,title,content);
		return "redirect:/";//
	}
	
//	@RequestMapping(value = "/b2out")
//	public String bbb3(Model model)
//	{
////		Board2Service bs =sqlSession.getMapper(Board2Service.class);
////		ArrayList<Board2DTO>list=bs.allout();
////		model.addAttribute("list", list);
////		
////		
//		return "board2out";//
//	}
	
	// --  2222 -->
	   @RequestMapping(value="/b2out")
	      public String bbbb(HttpServletRequest request, PageDTO dto,Model mo) {
	         String nowPage=request.getParameter("nowPage");
	         String cntPerPage=request.getParameter("cntPerPage");
	         Board2Service bs = sqlSession.getMapper(Board2Service.class);
	         //전체레코드수구하기
	         int total=bs.total();
	         if(nowPage==null && cntPerPage == null) {
	            nowPage="1";
	            cntPerPage="5";
	         }
	         else if(nowPage==null) {
	            nowPage="1";
	         }
	         else if(cntPerPage==null) {
	            cntPerPage="5";
	         }      
	         dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	         mo.addAttribute("paging",dto);
	         mo.addAttribute("list",bs.page(dto));
	         return "board2out";
	    //2222222222
	   }//
	
	@RequestMapping(value = "/detail2")
	public String bbb4(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		//조회수 1증가 
		Board2Service bs =sqlSession.getMapper(Board2Service.class);
		bs.readcntup(bnum);
		////조회수1 증가종료
	    Board2DTO dto= bs.detail(bnum);
	    model.addAttribute("dto", dto);
		
		
		return "detailview2";//
	}

	@RequestMapping(value = "/reply",method = RequestMethod.POST)
	public String bbb5(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnumber"));
		Board2Service bs=sqlSession.getMapper(Board2Service.class);
		Board2DTO dto=bs.data(bnum);
		model.addAttribute("dto", dto);
		
		return "reply2";//
	}
	
	@RequestMapping(value = "/reply2save",method = RequestMethod.POST)
	public String bbb6(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnumber"));
		int groups=Integer.parseInt(request.getParameter("groups"));
		int step=Integer.parseInt(request.getParameter("step"));
		int indent=Integer.parseInt(request.getParameter("indent"));
		String name=request.getParameter("boardwriter");
		String title=request.getParameter("boardtitle");
		String content=request.getParameter("boardcontent");
		
		/// MyBatis를 이용하여 stetup매서드 호출(댓글의 step 정리) 
		Board2Service bs=sqlSession.getMapper(Board2Service.class);
		bs.stetup(groups,step);//
		
		//새로운 댓글을 달기위해 step과 indent 값을 증가시킴
		step++;
		indent++;
		
		//새로운 댓글을 db에 삽입
		bs.appendc(bnum,title,name,content,groups,step,indent);
		
		
		return "redirect:/";
	}
	
	
}
