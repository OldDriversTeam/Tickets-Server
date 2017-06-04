package com.olddrivers.tickets.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.Room;
import com.olddrivers.tickets.business.entities.service.RoomService;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;

@Controller
@RequestMapping("/api/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse findOne(@PathVariable("id") String id) {
		Room r1 = roomService.findOne(id);
		
		AbstractResponse res = new AbstractResponse();
		res.put("id", r1.getId());
		res.put("name", r1.getType());
		res.put("col", r1.getCol());
		res.put("row", r1.getRow());
		res.put("cinemaId", r1.getCinema().getId());
		
		return res;
		
	}
	
}
