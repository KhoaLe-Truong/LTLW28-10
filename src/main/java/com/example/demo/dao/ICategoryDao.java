package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Category;
public interface ICategoryDao {
	List<Category> finAll();
	Category findById(int id);
	void insert(Category category);
	void update (Category category);
	void delete(int id);
	List<Category> finName(String keyword);
}
