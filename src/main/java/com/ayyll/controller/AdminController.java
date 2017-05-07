package com.ayyll.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public ModelAndView admin() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/check");
		return mav;
	}
	@RequestMapping(value = "/check_password",method = RequestMethod.POST)
	public ModelAndView check(@Param("password") String password) {
		
		ModelAndView mav = new ModelAndView();
		if(password.equals("lili.520")) {
			mav.setViewName("user/admin");
		} else {
			mav.setViewName("redirect:/index.jsp");
		}
		return mav;
	}
}
