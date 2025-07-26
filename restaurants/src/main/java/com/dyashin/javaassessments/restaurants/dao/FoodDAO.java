package com.dyashin.javaassessments.restaurants.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dyashin.javaassessments.restaurants.dto.Food;

public class FoodDAO {
	private Connection conn;

	 public FoodDAO() throws SQLException {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "9113899600");
	    }

	    public List<Food> getAllFoods() throws SQLException {
	        List<Food> list = new ArrayList<>();
	        ResultSet rs = conn.createStatement().executeQuery("Select * from food_menu");
	        while (rs.next()) {
	            list.add(listOfFood(rs));
	        }
	        return list;
	    }

	    public Food getFoodById(int id) throws SQLException {
	        PreparedStatement ps = conn.prepareStatement("Select * from food_menu where food_id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) return listOfFood(rs);
	        return null;
	    }

	    public List<Food> searchFoodByName(String name) throws SQLException {
	        List<Food> list = new ArrayList<>();
	        PreparedStatement ps = conn.prepareStatement("Select * from  food_menu where food_name like ?");
	        ps.setString(1,name);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            list.add(listOfFood(rs));
	        }
	        return list;
	    }

	    public void addFood(Food food) throws SQLException {
	        PreparedStatement ps = conn.prepareStatement("insert into food_menu values (?, ?, ?, ?, ?, ?)");
	        ps.setInt(1, food.getId());
	        ps.setString(2, food.getName());
	        ps.setString(3, food.getType());
	        ps.setString(4, food.getDescription());
	        ps.setInt(5, food.getCost());
	        ps.setString(6, food.getQuantity());
	        ps.executeUpdate();
	    }

	    public void updateFood(Food food) throws SQLException {
	        PreparedStatement ps = conn.prepareStatement(
	            "Update food_menu set food_name=?, food_type=?, food_description=?, food_cost=?, food_quantity=? Where food_id=?"
	        );
	        ps.setString(1, food.getName());
	        ps.setString(2, food.getType());
	        ps.setString(3, food.getDescription());
	        ps.setInt(4, food.getCost());
	        ps.setString(5, food.getQuantity());
	        ps.setInt(6, food.getId());
	        ps.executeUpdate();
	    }

	    public void deleteFood(int id) throws SQLException {
	        PreparedStatement ps = conn.prepareStatement("Delete from food_menu Where food_id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	    }

	    private Food listOfFood(ResultSet rs) throws SQLException {
	        return new Food(
	            rs.getInt("food_id"),
	            rs.getString("food_name"),
	            rs.getString("food_type"),
	            rs.getString("food_description"),
	            rs.getInt("food_cost"),
	            rs.getString("food_quantity")
	        );
	    }
	}
