package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FoodController {
   // 화면 이동 
   @GetMapping(value="food/food_list.do")
   public String food_list(int no,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("main_jsp", "../food/food_list.jsp");
	   return "main/main";
   }
   @GetMapping(value="food/detail.do")
   public String food_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("main_jsp", "../food/detail.jsp");
	   return "main/main";
   }
}
