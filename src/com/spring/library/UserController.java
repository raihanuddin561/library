package com.spring.library;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.library.config.AppConfig;
import com.spring.library.dao.UserDaoImpl;
import com.spring.library.model.User;


@Controller
public class UserController {
	
	@RequestMapping("/createaccount")
	public String createAccount(Model model,@Valid User user,BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("user",user);
			return "createaccount";
		}else {
			if(user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null && user.getEmail() != null && user.getPassword() != null) {
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				UserDaoImpl userDao = context.getBean("daoBean",UserDaoImpl.class);
				userDao.addUser(user);
				return "createaccountmessage";
			}else {
				System.out.println("form loading");
				return "createaccount";
			}
		}
		
	}
}
