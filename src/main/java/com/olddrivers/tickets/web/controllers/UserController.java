package com.olddrivers.tickets.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.services.UserService;
import com.olddrivers.tickets.util.LoginForm;
import com.olddrivers.tickets.util.RegistForm;
import com.olddrivers.tickets.util.State;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse login(@RequestBody LoginForm loginForm) {
		AbstractResponse res = new AbstractResponse();
		User u1 = userService.findByPhone(loginForm.getPhone());
		if(u1 == null) {
			res.put("state", State.USER_NOT_EXISTS);
			return res;
		}
		if(u1.getPassword().equals(loginForm.getPassword())) {
			res.put("state", State.SUCCEED);
			res.put("user", u1);
		} else {
			res.put("state", State.WRONG_PASSWORD);
		}
		return res;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse register(@RequestBody RegistForm registForm) {
		AbstractResponse res = new AbstractResponse();
		if(userService.findByPhone(registForm.getPhone()) != null) {
			res.put("state",State.PHONE_EXISTED);
			return res;
		}
		User u1 = new User();
		u1.setPhone(registForm.getPhone());
		u1.setName(registForm.getName());
		u1.setPassword(registForm.getPassword());
		res.put("state",State.SUCCEED);
		res.put("user",userService.register(u1));
		return res;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	AbstractResponse Login(@RequestBody User user) {
		AbstractResponse res = new AbstractResponse();
		if(userService.findOne(user.getId()) != null) {
			userService.update(user);
			res.put("state", State.SUCCEED);
		} else {
			res.put("state", State.FAILED);
		}
		return res;
	}
	
}
