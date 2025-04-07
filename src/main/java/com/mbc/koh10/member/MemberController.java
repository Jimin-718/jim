package com.mbc.koh10.member;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
public class MemberController {
	
	@Autowired
	SqlSession sqlSession;
	String path="C:\\mbc12AI\\spring\\day10_board\\src\\main\\webapp\\image";
	
	@RequestMapping(value = "/minput")
	public String m1() {
	
		
		return "memberinput";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck")
	public String m4(String id) {
		System.out.println("넘겨받은 id:"+id);
		MemberService ms=sqlSession.getMapper(MemberService.class);
		int count=ms.idcheck(id);
		String bigo="";
		if(count==1) 
		{
			bigo="no";
		}
		else 
		{
			bigo="ok";
		}
		
		return bigo;
			
	}
	

	@RequestMapping(value = "/membersave")
	public String m2(HttpServletRequest request) {
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		MemberService ms=sqlSession.getMapper(MemberService.class);
		PasswordEncoder pe = new BCryptPasswordEncoder();
		pw=pe.encode(pw);
		ms.inserts(id,pw,name);
	
		
		return "redirect:/";
	}
	@RequestMapping(value = "/mout")
	public String m3(HttpServletRequest request,Model mo) {
		
		HttpSession hs=request.getSession();
		Boolean state = (Boolean) hs.getAttribute("loginstate");
		
		
		
		if(state) 
		{
		MemberService ms=sqlSession.getMapper(MemberService.class);
		ArrayList<MemberDTO>list= ms.allout();
		mo.addAttribute("list",list);
	
		return "memberout";
		
		}
		else 
		{
			return "redirect:/main";
		}	
	
		
		
	}
	
	

	
}
