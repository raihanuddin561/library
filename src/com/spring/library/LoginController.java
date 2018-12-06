package com.spring.library;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class LoginController {


	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String logout() {
		return "loggedout";
	}
	
	@RequestMapping("/denied")
	public String deniedPage() {
		return "denied";
	}
	
	
	}
	
	
	

