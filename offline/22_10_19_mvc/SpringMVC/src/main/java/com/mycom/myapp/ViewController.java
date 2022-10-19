package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {
	@GetMapping(value="/viewTest1")
	public String viewTest1() {
		System.out.println("viewTest1");
		return "viewTest1";
	}
	
	@GetMapping(value="/viewTest2")
	public String viewTest2() {
		System.out.println("viewTest2");
		return "sub/viewTest2";
	}
	
	@GetMapping(value="/viewTest3")
	public String viewTest3(Model model) {
		System.out.println("viewTest3");
		model.addAttribute("seq","1234");
		model.addAttribute("empDto",new EmpDto(3000,"gildong","hong","hhhh@naver.com","2022-10-10"));
		return "viewTest3";
	}
	
	
	@GetMapping(value="/viewTest4")
	public ModelAndView viewTest4() {
		ModelAndView mav = new ModelAndView();
		System.out.println("viewTest3");
		mav.addObject("seq","1234");
		mav.addObject("empDto",new EmpDto(3000,"gildong","hong","hhhh@naver.com","2022-10-10"));
		mav.setViewName("viewTest4");
		return mav;
	}
	
	
	@GetMapping(value="redirectTest")
	public String redirectTest() {
		System.out.println("redirect");
		return "redirect:/viewTest3";
	}
}
