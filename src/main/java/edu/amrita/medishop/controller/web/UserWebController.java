package edu.amrita.medishop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.amrita.medishop.service.UserService;

@Controller
public class UserWebController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/login")
	public String showHomePage() {
		return "medishop_login";
	}
	
	@RequestMapping("/signup") 
	public String showLoginPage() {
		return "signup";
	}
	
}
