package com.example.demo.service;

import java.util.List;

import vn.iostar.demo.model.Category;


public interface ICategoryService {
	List<com.example.demo.model.Category> finAll();
	com.example.demo.model.Category findById(int id);
	void insert(com.example.demo.model.Category category);
	void update (Category category);
	void delete(int id);
	List<com.example.demo.model.Category> finName(String keyword);
	void update(com.example.demo.model.Category category);
}
