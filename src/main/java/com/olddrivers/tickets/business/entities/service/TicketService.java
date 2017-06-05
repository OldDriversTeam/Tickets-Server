package com.olddrivers.tickets.business.entities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.Ticket;
import com.olddrivers.tickets.business.entities.repositories.TicketRepository;

@Service
@Transactional
public class TicketService {
	@Autowired
	TicketRepository ticketRepo;
	
	public TicketService() {
		super();
	}
	
	public Ticket findOne(final String id) {
		return ticketRepo.findOne(id);
	}
	
	public List<Ticket> findTicketsByUserId(final String userId) {
		return ticketRepo.findTicketsByUserId(userId);
	}

	public List<Ticket> findSoldTicketsByShowingId(String showingId) {
		return ticketRepo.findSoldTicketsByShowingId(showingId);
	}

	public Ticket buyTicket(Ticket temp) {
		return ticketRepo.save(temp);
		
	}
}
