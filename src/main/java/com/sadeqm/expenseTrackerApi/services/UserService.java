package com.sadeqm.expenseTrackerApi.services;

import com.sadeqm.expenseTrackerApi.Domain.User;
import com.sadeqm.expenseTrackerApi.exceptions.EtAuthException;

public interface UserService {
	User validateUser(String email, String password ) throws EtAuthException;
	
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
