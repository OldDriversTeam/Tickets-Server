package com.olddrivers.tickets.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.Movie;
import com.olddrivers.tickets.business.entities.service.MovieService;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;
import com.olddrivers.tickets.web.controllers.response.ObjectListResponse;

@Controller
@RequestMapping("/api/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	AbstractResponse FindOne(@PathVariable("id") String id) {
		Movie m1 = movieService.findOne(id);
		AbstractResponse res = new AbstractResponse();
		res.put("id", m1.getId());
		res.put("name", m1.getName());
		res.put("releaseDate", m1.getReleaseDate());
		res.put("storyLine", m1.getStoryLine());
		res.put("detail", m1.getDetail());
		res.put("poster", m1.getPoster());
		res.put("avgScore", m1.getAvgScore());
		res.put("isShow", m1.getIsShow());
		res.put("movieType", m1.getMovieType().getName());
		return res;
	}
	
	@RequestMapping(value = "/onshow", method = RequestMethod.GET)
	@ResponseBody
	AbstractResponse FindOne() {
		List<Object[]> list = movieService.findMovieOnShow(true);
		return new ObjectListResponse(list, "movieList");
	}
	
}
