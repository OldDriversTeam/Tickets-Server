package com.olddrivers.tickets.business.entities.repositories;

import com.olddrivers.tickets.business.entities.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

public interface MovieRepository extends CrudRepository<Movie, String> {
	
	@Query("select m.id, m.name, m.avgScore, m.poster, m.storyLine from Movie m where m.isShow = ?1")
	List<Object[]> findMovieOnShow(Boolean isShow);
	
}
