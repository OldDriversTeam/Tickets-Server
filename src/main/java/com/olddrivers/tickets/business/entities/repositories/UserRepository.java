package com.olddrivers.tickets.business.entities.repositories;

import com.olddrivers.tickets.business.entities.User;
import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository<User, String> {
	
	public User findByName(String name);
	public User findByPhoneAndPassword(String phone, String password);
	
	
	// make phone and email unique
	public User findByPhone(String phone);
}
