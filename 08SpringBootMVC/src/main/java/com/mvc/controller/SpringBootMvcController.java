package com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SpringBootMvcController {
	
	@RequestMapping("/")
    public ModelAndView showLoginPage(Model model) {
        model.addAttribute("message", "You are welcom");
        return new ModelAndView("welcome");
    }
	
	@RequestMapping("/hello")
    public ModelAndView sayToHello(Model model) {
        model.addAttribute("message", "Hi Hello!!");
        return new ModelAndView("welcome");
    }
}
