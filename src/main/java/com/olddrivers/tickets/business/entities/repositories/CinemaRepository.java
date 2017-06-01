package com.olddrivers.tickets.business.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, String> {

}
