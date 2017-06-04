package com.olddrivers.tickets.business.entities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.Cinema;
import com.olddrivers.tickets.business.entities.repositories.CinemaRepository;

@Service
@Transactional
public class CinemaService {
	@Autowired
	private CinemaRepository cinemaRepo;
	
	public CinemaService() {
		super();
	}
	
	public Cinema findOne(final String id) {
		return cinemaRepo.findOne(id);
	}

}
