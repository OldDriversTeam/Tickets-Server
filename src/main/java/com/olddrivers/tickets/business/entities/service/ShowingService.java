package com.olddrivers.tickets.business.entities.service;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public Map<String, List<Map<String, String>>> getShowingsByMovieId(final String movieId, final List<String> dates) {
		Map<String, List<Map<String, String>>> dataMap = new LinkedHashMap<String, List<Map<String, String>>>();
		List<Object[]> cinemaAndDateList = showingRepo.findCinemaListAndDateByMovieId(movieId,dates);
		for (int i = 0; i < cinemaAndDateList.size(); i++) {
			if(!dataMap.containsKey((String)cinemaAndDateList.get(i)[1])) {
				List<Map<String, String>> cinemas = new ArrayList<Map<String, String>>();
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("id", (String)cinemaAndDateList.get(i)[0]);
				temp.put("name",(String)cinemaAndDateList.get(i)[2]);
				cinemas.add(temp);
				dataMap.put((String)cinemaAndDateList.get(i)[1],cinemas);
			} else {
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("id", (String)cinemaAndDateList.get(i)[0]);
				temp.put("name",(String)cinemaAndDateList.get(i)[2]);
				dataMap.get(cinemaAndDateList.get(i)[1]).add(temp);
			}
		}
		return dataMap;
	}
	
	public List<String> findShowingIdListByCinemaIdAndDateAndMovieId(final String cinemaId,final String date,final String movieId) {
		return showingRepo.findShowingIdListByCinemaIdAndDateAndMovieId(cinemaId, date, movieId);
	}
}
