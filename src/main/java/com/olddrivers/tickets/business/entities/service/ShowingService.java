package com.olddrivers.tickets.business.entities.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.Showing;
import com.olddrivers.tickets.business.entities.repositories.ShowingRepository;

@Service
@Transactional
public class ShowingService {
	@Autowired
	private ShowingRepository showingRepo;
	
	public ShowingService() {
		super();
	}
	
	public Showing findOne(final String id) {
		return showingRepo.findOne(id);
	}
	
	public Map<String, List<String>> getShowingsByMovieId(final String movieId) {
		Map<String, List<String>> dataMap = new LinkedHashMap<String, List<String>>();
		List<Object[]> cinemaAndDateList = showingRepo.findCinemaListAndDateByMovieId(movieId);
		for (int i = 0; i < cinemaAndDateList.size(); i++) {
			dataMap.put((String)cinemaAndDateList.get(i)[1], new ArrayList<String>());
		}
		for (int i = 0; i < cinemaAndDateList.size(); i++) {
			dataMap.get(cinemaAndDateList.get(i)[1]).add((String)cinemaAndDateList.get(i)[0]);
		}
		return dataMap;
		
	}
}
