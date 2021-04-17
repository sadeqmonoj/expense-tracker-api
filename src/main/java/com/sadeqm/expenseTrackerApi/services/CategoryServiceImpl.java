package com.sadeqm.expenseTrackerApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sadeqm.expenseTrackerApi.Domain.Category;
import com.sadeqm.expenseTrackerApi.exceptions.EtBadRequestException;
import com.sadeqm.expenseTrackerApi.exceptions.EtResourceNotFoundException;
import com.sadeqm.expenseTrackerApi.repositories.CategoryRepository;

//test comment
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> fetchAllCategories(Integer userId) {
		// TODO Auto-generated method stub
		return categoryRepository.fetchAll(userId);
	}

	@Override
	public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
		// TODO Auto-generated method stub
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
		
		int categoryId = categoryRepository.create(userId, title, description);
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
		
		categoryRepository.update(userId, categoryId, category);
		
	}

	@Override
	public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId)
			throws EtResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
