package com.olddrivers.tickets.web.controllers;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.Room;
import com.olddrivers.tickets.business.entities.Showing;
import com.olddrivers.tickets.business.entities.service.RoomService;
import com.olddrivers.tickets.business.entities.service.ShowingService;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;
import com.olddrivers.tickets.web.controllers.response.ObjectListResponse;

@Controller
@RequestMapping("/api/showings")
public class ShowingController {
	@Autowired
	private ShowingService showingService;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	AbstractResponse FindOne(@PathVariable("id") String id) {
		Showing s1 = showingService.findOne(id);
		Room r1 = roomService.findOne(s1.getRoom().getId());
		AbstractResponse res = new AbstractResponse();
		res.put("id", s1.getId());
		res.put("date", s1.getDate());
		res.put("time", s1.getTime());
		res.put("price", s1.getPrice());
		res.put("movieId", s1.getMovie().getId());
		res.put("cinemaId", r1.getCinema().getId());
		res.put("roomId", s1.getRoom().getId());
		return res;
	}
	
	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse getShowingsByMovieId(@PathVariable("movieId") String movieId) {
		Map<String, List<String>> dataMap = showingService.getShowingsByMovieId(movieId);
		List<LinkedHashMap<String, Object>> dataList = new LinkedList<LinkedHashMap<String, Object>>();
		for (int i = 0; i < dataMap.size(); i++) {
			Map<String, Object> temp = new LinkedHashMap<String, Object>();
		}
		return new ObjectListResponse(dataList, "");
	}
}