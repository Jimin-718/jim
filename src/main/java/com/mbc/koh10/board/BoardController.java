package com.mbc.koh10.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@Autowired
	SqlSession sqlSession;
	@RequestMapping(value = "/boardinput")
	public String bb1()
	{
		return "binput";//
	}
	///
	@RequestMapping(value = "/boardsave")
	public String bb2(HttpServletRequest request)
	{
		String name=request.getParameter("boardwriter");
		String title=request.getParameter("boardtitle");
		String content=request.getParameter("boardcontent");
		BoardService bs = sqlSession.getMapper(BoardService.class);
		bs.insertboard(name,title,content);
		return "binput";//
	}
	//출력
	@RequestMapping(value = "/boardout")
	public String bb3(Model model)
	{
		BoardService bs =sqlSession.getMapper(BoardService.class);
	ArrayList<BoardDTO>list=bs.boardallout();
	model.addAttribute("list", list);
		return "bout";//
	}
	//자세히보기.....조회수 1증가기능?
	@RequestMapping(value = "/detail")
	public String bb4(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		//조회수 1증가 
		BoardService bs =sqlSession.getMapper(BoardService.class);
		bs.readcntup(bnum);
		////조회수1 증가종료
	BoardDTO dto= bs.detail(bnum);//이 글번호에 해당되는 자료를 요청
	model.addAttribute("dto", dto);
		return "detailview";//
	}
	///자세히보기에서 댓글을 클릭한 경우
	@RequestMapping(value = "/detailsave",method = RequestMethod.POST)
	public String bb5(HttpServletRequest request,Model model)
	{//자세히 보기에서 댓글을 원할경우 원글에 대한 원글 정보를 가져오기 위해 글번호 받아옴
		int bnum=Integer.parseInt(request.getParameter("boardnumber"));
		BoardService bs=sqlSession.getMapper(BoardService.class);
	BoardDTO dto=bs.dtodata(bnum);
	model.addAttribute("dto", dto);
		return "reply";//댓글달기 폼..
	}
	//댓글달기 폼에서 넘어온 자료들을 넘겨 받음
	@RequestMapping(value = "/replysave",method = RequestMethod.POST)
	public String bb6(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnumber"));
		int groups=Integer.parseInt(request.getParameter("groups"));
		int step=Integer.parseInt(request.getParameter("step"));
		int indent=Integer.parseInt(request.getParameter("indent"));
		String name=request.getParameter("boardwriter");
		String title=request.getParameter("boardtitle");
		String content=request.getParameter("boardcontent");
		/// step  
		BoardService bs=sqlSession.getMapper(BoardService.class);
		bs.stetup(groups,step);//
		step++;
		indent++;
		
		
		bs.appendc(bnum,title,name,content,groups,step,indent);
		
		
		return "redirect:./";//댓글달기 폼..
	}
}
