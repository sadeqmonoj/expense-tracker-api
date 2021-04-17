package com.sadeqm.expenseTrackerApi.repositories;

import java.util.List;

import com.sadeqm.expenseTrackerApi.Domain.Category;
import com.sadeqm.expenseTrackerApi.exceptions.EtBadRequestException;
import com.sadeqm.expenseTrackerApi.exceptions.EtResourceNotFoundException;

public interface CategoryRepository {

	List<Category> fetchAll(Integer userId) throws EtResourceNotFoundException;
	
	Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
	
	Integer create(Integer userId, String title, String description) throws EtBadRequestException;
	
	void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
	
	void removeById(Integer userId, Integer categoryId) ;
}
