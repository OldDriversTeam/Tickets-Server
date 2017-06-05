package com.olddrivers.tickets.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.entities.service.UserService;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	User findOne(@PathVariable("id") String id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse login(
	        @RequestParam("phone") String phone,
	        @RequestParam("password") String password) {
		AbstractResponse res = new AbstractResponse();
		User u1 = userService.findByPhone(phone);
		if(u1 == null) {
			res.put("error","user not exists");
			return res;
		}
		if(u1.getPassword().equals(password)) {
			res.put("id", u1.getId());
		} else {
			res.put("error","wrong password");
			return res;
		}
		return res;
	}
	
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse register(
			@RequestParam("phone") String phone,
	        @RequestParam("name") String name,
	        @RequestParam("password") String password) {
		AbstractResponse res = new AbstractResponse();
		if(userService.findByPhone(phone) != null) {
			res.put("error","user exists");
			return res;
		}
		User u1 = new User();
		u1.setPhone(phone);
		u1.setName(name);
		u1.setPassword(password);
		res.put("id",userService.register(u1).getId());
		return res;
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse Login(@RequestBody User user) {
		AbstractResponse res = new AbstractResponse();
		userService.update(user);
		res.put("result", true);
		return res;
	}
	
}
