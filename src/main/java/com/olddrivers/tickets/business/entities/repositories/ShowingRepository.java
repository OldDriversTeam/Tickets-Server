package com.olddrivers.tickets.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Showing;

public interface ShowingRepository extends CrudRepository<Showing, String> {

	@Query("select DISTINCT(s.room.cinema.id),s.date from Showing s where s.movie.id = ?1")
	List<Object[]> findCinemaListAndDateByMovieId(String movieId);
}
