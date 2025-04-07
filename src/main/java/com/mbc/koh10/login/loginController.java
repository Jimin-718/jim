package com.mbc.koh10.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value="/login")
	public String log1() 
	{
		return "login";
	}
	
	@RequestMapping(value="/loginsave")
	public String log2(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		//
		loginService ls=sqlSession.getMapper(loginService.class);
		String cpw=ls.pwselect(id);
		
		PasswordEncoder pe = new BCryptPasswordEncoder();
		boolean flag=pe.matches(pw, cpw);
		if(flag) {
			HttpSession hs=request.getSession();
			hs.setAttribute("loginstate",true);
			hs.setAttribute("id",id);
			return "redirect:/main";
		}
		else {		
			response.setContentType("text/html;charset=utf-8");//alert창에서 한글 지원
	         PrintWriter pww=response.getWriter();
	         pww.print("<script>alert('아이디나 패스워드가 틀려요!!')</script>");
	         pww.print("<script>location.href='login'</script>");
	         pww.close();
			return "redirect:/login";
		}		
	}
	
	@RequestMapping(value="/logout")
	public String log3(HttpServletRequest request) {
		HttpSession hs=request.getSession();
		hs.removeAttribute("loginstate");
		hs.removeAttribute("id");
		return "redirect:/";
	}
	

}
