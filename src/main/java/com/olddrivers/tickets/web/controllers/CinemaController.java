package com.olddrivers.tickets.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.Cinema;
import com.olddrivers.tickets.business.services.CinemaService;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;

@Controller
@RequestMapping("/api/cinemas")
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse findOne(@PathVariable("id") String id) {
		Cinema c1 = cinemaService.findOne(id);
		AbstractResponse res = new AbstractResponse();
		res.put("id", c1.getId());
		res.put("name",c1.getName());
		res.put("address",c1.getAddress());
		res.put("phone",c1.getPhone());
		res.put("cityName",c1.getCity().getName());
		return res;
	}
}
