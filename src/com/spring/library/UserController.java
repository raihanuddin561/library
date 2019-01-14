package com.spring.library;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.library.model.Authorities;
import com.spring.library.model.Users;
import com.spring.library.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/createaccount")
	public String createAccount(Model model,@Valid Users user,BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("user",user);
			return "createaccount";
		}else {
			if(user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null && user.getEmail() != null && user.getPassword() != null) {
				Authorities authority = new Authorities(user.getUsername(),"ROLE_USER");
				userService.addUser(user);
				userService.addAuthority(authority);
				return "createaccountmessage";
			}else {
				System.out.println("form loading");
				model.addAttribute("user",user);
				return "createaccount";
			}
		}
		
	}
}
