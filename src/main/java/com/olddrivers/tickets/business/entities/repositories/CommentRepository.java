package com.olddrivers.tickets.business.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, String> {

}
