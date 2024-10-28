package com.example.demo.service.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImlp;
import vn.iostar.demo.model.Category;
import vn.iostar.models.CategoriModels;
import vn.iostar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
			public ICategoryDao cateDao = new CategoryDaoImlp();
			
	@Override
	public List<CategoriModels> finAll() {
		// TODO Auto-generated method stub
		return cateDao.finAll();
	}

	@Override
	public CategoriModels findById(int id) {
		// TODO Auto-generated method stub
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoriModels category) {
		cateDao.insert(category);
	}

	@Override
	public void update(CategoriModels category) {
		CategoriModels cate= new CategoriModels();
		cate = cateDao.findById(category.getCategoryid());
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}

	@Override
	public List<CategoriModels> finName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
