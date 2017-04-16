package com.olddrivers.tickets.business.entities.repositories;

import com.olddrivers.tickets.business.entities.Movie;
import org.springframework.data.repository.*;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	
}
