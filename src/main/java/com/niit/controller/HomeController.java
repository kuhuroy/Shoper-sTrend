package com.niit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("home controller beans is create");
	}
	
	@RequestMapping("/home")
	public String getHomePage() {
		return "home";
	}
}
