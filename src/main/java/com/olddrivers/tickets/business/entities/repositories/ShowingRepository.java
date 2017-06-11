package com.olddrivers.tickets.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Showing;

public interface ShowingRepository extends CrudRepository<Showing, String> {

	@Query("select DISTINCT(s.room.cinema.id), s.date, s.room.cinema.name from Showing s where s.movie.id = ?1 AND s.date IN (?2)")
	List<Object[]> findCinemaListAndDateByMovieId(String movieId, List<String> dates);
	
	@Query("select s.id from Showing s where s.room.cinema.id = ?1 AND s.date = ?2 AND s.movie.id = ?3")
	List<String> findShowingIdListByCinemaIdAndDateAndMovieId(String cinemaId,String date,String movieId);
}
