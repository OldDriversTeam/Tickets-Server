package com.olddrivers.tickets.business.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, String> {

}
