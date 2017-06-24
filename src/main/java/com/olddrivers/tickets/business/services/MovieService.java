package com.olddrivers.tickets.business.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.Movie;
import com.olddrivers.tickets.business.entities.repositories.MovieRepository;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	public MovieService() {
		super();
	}
	
	public Movie findOne(String id) {
		return movieRepo.findOne(id);
	}
	
	public List<Object[]> findMovieOnShowWithDetail(Boolean isShow) {
		return movieRepo.findMovieOnShowWithDetail(isShow);
	}
	
	public List<Object[]> findMovieOnShowWithoutDetail(Boolean isShow) {
		return movieRepo.findMovieOnShowWithoutDetail(isShow);
	}
}
