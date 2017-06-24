package com.olddrivers.tickets.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.Room;
import com.olddrivers.tickets.business.entities.repositories.RoomRepository;

@Service
@Transactional
public class RoomService {
	@Autowired
	private RoomRepository roomRepo;
	
	public RoomService() {
		super();
	}
	
	public Room findOne(final String id) {
		return roomRepo.findOne(id);
	}
}
