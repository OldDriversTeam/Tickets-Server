package com.olddrivers.tickets.business.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {

}
