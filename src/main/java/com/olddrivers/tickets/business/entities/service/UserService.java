package com.olddrivers.tickets.business.entities.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.entities.repositories.UserRepository;
import com.olddrivers.tickets.util.FailedError;
import com.olddrivers.tickets.util.LoginForm;
import com.olddrivers.tickets.util.Message;
import com.olddrivers.tickets.util.Status;;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserService() {
		super();

	}

	// API

	public User findOne(final String id) {
		return userRepo.findOne(id);
	}

	public User findByName(final String name) {
		return userRepo.findByName(name);
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

	public Message Login(LoginForm loginForm) {
		if (findByPhone(loginForm.getPhone()) == null) {
			return new Message(Status.FAILED, FailedError.USER_NOT_EXISTED, new User());
		} else {
			User data = findByPhoneAndPassword(loginForm.getPhone(), loginForm.getPassword());
			if (data == null) {
				return new Message(Status.FAILED, FailedError.PASSWORD_ERROR, new User());
			} else {
				return new Message(Status.SUCCEED, FailedError.NO_ERROR, data);
			}
		}
	}

	public Message Add(User user) {
		if (findByPhone(user.getPhone()) == null) {
			return new Message(Status.SUCCEED, FailedError.NO_ERROR, userRepo.save(user));
		} else {
			return new Message(Status.FAILED, FailedError.PHONE_EXISTED, new User());
		}
	}

	public Message Update(User user) {
		if(findOne(user.getId()) != null)
			return new Message(Status.SUCCEED, FailedError.NO_ERROR, userRepo.save(user));
		else
			return new Message(Status.FAILED,FailedError.USER_NOT_EXISTED,new User());
	}

}
