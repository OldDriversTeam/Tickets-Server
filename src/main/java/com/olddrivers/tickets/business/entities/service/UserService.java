package com.olddrivers.tickets.business.entities.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.entities.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserService() {
		super();

	}

	public User findOne(final String id) {
		return userRepo.findOne(id);
	}

	public User findByPhoneAndPassword(final String phone, final String password) {
		return userRepo.findByPhoneAndPassword(phone, password);
	}

	public User findByPhone(final String phone) {
		return userRepo.findByPhone(phone);
	}

	public List<User> findAll() {
		return (ArrayList<User>) userRepo.findAll();
	}

	public User register(User user) {
		 return userRepo.save(user);
	}

	public User update(User user) {
		return userRepo.save(user);
	}

}
