package com.sadeqm.expenseTrackerApi.repositories;

import com.sadeqm.expenseTrackerApi.Domain.User;
import com.sadeqm.expenseTrackerApi.exceptions.EtAuthException;

public interface UserRepository {
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	
	User findByEmailAndPassword(String email, String password)throws EtAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer userId);
}
