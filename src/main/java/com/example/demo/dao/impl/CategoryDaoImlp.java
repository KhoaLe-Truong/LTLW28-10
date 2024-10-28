package com.example.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectMySQL;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoriModels;

public class CategoryDaoImlp implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoriModels> finAll() {
		String sql = "select * from categories";
		List<CategoriModels> list = new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoriModels category = new CategoriModels();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public CategoriModels findById(int id) {
		String sql = "select * from categories where categoryid=?";
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoriModels category = new CategoriModels();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(CategoriModels category) {
		String sql = "INSERT INTO categories(categoryname,images,status ) VALUES (?,?,?)";
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			rs = ps.executeQuery();
			conn.close();
			ps.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void update(CategoriModels category) {
		String sql = "update categories SET categoryname=?, images=?, status=? WHERE categoryid=?";
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			rs = ps.executeQuery();
			conn.close();
			ps.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid=?";
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			conn.close();
			ps.close();
		} catch (Exception e) {
		}

	}

	@Override
	public List<CategoriModels> finName(String keyword) {
		String sql = "select * from categories where categoryname like ?";
		List<CategoriModels> list = new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(0,"%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoriModels category = new CategoriModels();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
		}
		return null;
	}

}
