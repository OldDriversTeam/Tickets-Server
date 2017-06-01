package com.olddrivers.tickets.business.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Movie;

public interface MovieTypeRepository extends CrudRepository<Movie, String> {

}
