package com.olddrivers.tickets.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.olddrivers.tickets.business.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {

	@Query("from Ticket t where t.user.id = ?1")
	List<Ticket> findTicketsByUserId(String userId);

	
	@Query("from Ticket t where t.showing.id = ?1")
	List<Ticket> findSoldTicketsByShowingId(String showingId);

}
