package com.olddrivers.tickets.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.entities.service.UserService;
import com.olddrivers.tickets.util.LoginForm;
import com.olddrivers.tickets.util.Message;
import com.olddrivers.tickets.util.RegistForm;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	User FindOne(@PathVariable("id") String id) {
		return userService.findOne(id);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	User FindByName(@PathVariable("name") String name) {
		return userService.findByName(name);
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	@ResponseBody
	Message Login(@RequestBody LoginForm loginForm) {
		
		System.out.println(loginForm.toString());
		
		return userService.Login(loginForm);
	}
	
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	@ResponseBody
	Message Add(@RequestBody RegistForm registForm) {
		
		System.out.println(registForm);
		
		Message m = userService.Add(new User(registForm));
		
		return m;
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	@ResponseBody
	Message Login(@RequestBody User user) {
		return userService.Update(user);
	}
	
}
