package com.olddrivers.tickets.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateCotroller {

	@RequestMapping({"/", "/index","/login","/regist"})
	public String index() {
		return "index";
	}
}
