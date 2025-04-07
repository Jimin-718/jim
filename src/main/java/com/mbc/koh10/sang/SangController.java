package com.mbc.koh10.sang;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class SangController {
	
	@Autowired
	SqlSession sqlSession;
	String path="C:\\mbc12AI\\spring\\day10_board\\src\\main\\webapp\\image";
	
	@RequestMapping(value = "/sinput")
	public String s1() {
	
		
		return "sanginput";
	}
	
	@RequestMapping(value = "/sangsave")
	public String s2(MultipartHttpServletRequest requset) throws IllegalStateException, IOException {
	MultipartFile mf = requset.getFile("simage");
	String sname=requset.getParameter("sname");
	String simage=mf.getOriginalFilename();
	
	UUID ui = UUID.randomUUID();
	simage=ui+simage;
	mf.transferTo(new File(path+"\\"+simage));
	
	
	SangService ss = sqlSession.getMapper(SangService.class);
	ss.inserts(sname,simage);
	
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/sout")
	public String s3(Model model) {
		
		SangService ss= sqlSession.getMapper(SangService.class);
		ArrayList<SangDTO>list=ss.allout();
		model.addAttribute("list", list);
	
		
		return "sangout";
	}
	
	@RequestMapping(value = "/sdelete")
	public String s4(HttpServletRequest request,Model model) {
		
		int snum=Integer.parseInt(request.getParameter("snum")); 
		SangService ss = sqlSession.getMapper(SangService.class);
	   SangDTO dto =ss.delete1(snum);
	   model.addAttribute("dto", dto);
	
		
		return "sangdelete";
	}
	@RequestMapping(value = "/sdelete2")
	public String s5(HttpServletRequest request) {
		String simage=request.getParameter("simage");
		
		
		int snum=Integer.parseInt(request.getParameter("snum")); 
		SangService ss = sqlSession.getMapper(SangService.class);
		ss.delete2(snum);
		File ff=new File(path+"\\"+simage);
		ff.delete();
		
	
		
		return "redirect:/";
	}
	@RequestMapping(value = "/supdate")
	public String s5(HttpServletRequest request,Model model) {
		
		int snum=Integer.parseInt(request.getParameter("snum")); 
	   SangService ss = sqlSession.getMapper(SangService.class);
	   SangDTO dto =ss.update1(snum);
	   model.addAttribute("dto", dto);
	
		
		return "sangupdate";
	}
	
	@RequestMapping(value = "/supdate2")
	public String s6(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		
		
		int snum=Integer.parseInt(request.getParameter("snum")); 
		String sname=request.getParameter("sname");
		String oldname=request.getParameter("old");
		System.out.println("구화일이름 :"+oldname);
		MultipartFile mf=request.getFile("simage");
		String simage=mf.getOriginalFilename();
		
		
		UUID uu = UUID.randomUUID();
		simage=uu.toString()+"_"+simage;
		mf.transferTo(new File(path+"\\"+simage));
	 
		SangService ss = sqlSession.getMapper(SangService.class);
		ss.update2(snum,sname,simage);
		
		
		File ff=new File(path+"\\"+oldname);
		ff.delete();
		
	
		
		return "redirect:/";
	}
	@RequestMapping(value = "/search")
	public String s7(HttpServletRequest request,Model model) {
		
		String spname=request.getParameter("spname");
		SangService ss = sqlSession.getMapper(SangService.class);
		ArrayList<SangDTO>list=ss.search1(spname);
	    model.addAttribute("list", list);
		
		return "searchview";
	}
	
	
	
	
}
