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
	//���
	@RequestMapping(value = "/boardout")
	public String bb3(Model model)
	{
		BoardService bs =sqlSession.getMapper(BoardService.class);
	ArrayList<BoardDTO>list=bs.boardallout();
	model.addAttribute("list", list);
		return "bout";//
	}
	//�ڼ�������.....��ȸ�� 1�������?
	@RequestMapping(value = "/detail")
	public String bb4(HttpServletRequest request,Model model)
	{
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		//��ȸ�� 1���� 
		BoardService bs =sqlSession.getMapper(BoardService.class);
		bs.readcntup(bnum);
		////��ȸ��1 ��������
	BoardDTO dto= bs.detail(bnum);//�� �۹�ȣ�� �ش�Ǵ� �ڷḦ ��û
	model.addAttribute("dto", dto);
		return "detailview";//
	}
	///�ڼ������⿡�� ����� Ŭ���� ���
	@RequestMapping(value = "/detailsave",method = RequestMethod.POST)
	public String bb5(HttpServletRequest request,Model model)
	{//�ڼ��� ���⿡�� ����� ���Ұ�� ���ۿ� ���� ���� ������ �������� ���� �۹�ȣ �޾ƿ�
		int bnum=Integer.parseInt(request.getParameter("boardnumber"));
		BoardService bs=sqlSession.getMapper(BoardService.class);
	BoardDTO dto=bs.dtodata(bnum);
	model.addAttribute("dto", dto);
		return "reply";//��۴ޱ� ��..
	}
	//��۴ޱ� ������ �Ѿ�� �ڷ���� �Ѱ� ����
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
		
		
		return "redirect:./";//��۴ޱ� ��..
	}
}
