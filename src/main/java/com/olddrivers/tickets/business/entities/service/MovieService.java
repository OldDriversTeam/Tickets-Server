package com.olddrivers.tickets.business.entities.service;

import java.util.ArrayList;
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
	private MovieRepository movieRepository;
	
	public MovieService() {
		super();
	}
	
	public List<Movie> findAll() {
		return (ArrayList<Movie>) movieRepository.findAll();
	}
}
