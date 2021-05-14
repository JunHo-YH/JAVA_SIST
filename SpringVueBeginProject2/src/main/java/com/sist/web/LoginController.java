package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
   @GetMapping("member/login.do")
   public String member_login()
   {
	   return "member/login";
   }
   @PostMapping("member/login_ok.do")
   public String member_login_ok(String id,String pwd,HttpSession session)
   {
	   
	   return "member/login_ok";
   }
}
