package com.dyashin.javaassessments.restaurants.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.dyashin.javaassessments.restaurants.dao.FoodDAO;
import com.dyashin.javaassessments.restaurants.dto.Food;

public class FoodResturantMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		FoodDAO dao = new FoodDAO();

		while (true) {
			System.out.println("\n--- Food Menu Application ---");
			System.out.println("1. Open Food Menu");
			System.out.println("2. Search the Food");
			System.out.println("3. Show All Food Items");
			System.out.println("4. Operate on Food Database");
			System.out.print("Choose: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				openFoodMenu(dao, sc);
				break;
			case 2:
				searchFood(dao, sc);
				break;
			case 3:
				openFoodMenu(dao, sc);
				break;
			case 4:
				operateDB(dao, sc);	
				break;
			default:
				System.out.println("Invalid Option");

			}
		}
	}

	static void openFoodMenu(FoodDAO dao, Scanner sc) throws Exception {
		System.out.println("A. Display all food items");
		System.out.println("B. Display food items randomly");
		System.out.println("C. Display particular food");
		String option = sc.next();

		switch (option) {
		case "A":
			showAll(dao);
			break;
		case "B": {
			List<Food> foods = dao.getAllFoods();
			Collections.shuffle(foods);
			foods.forEach(System.out::println);
		}
			break;
		case "C": {
			System.out.print("Enter food ID: ");
			int id = sc.nextInt();
			Food f = dao.getFoodById(id);
			System.out.println(f != null ? f : "Food not found.");
		}
			break;
		default:
			System.out.println("Invalid Option.");
		}
	}

	static void searchFood(FoodDAO dao, Scanner sc) throws Exception {
		System.out.print("Enter food name to search: ");
		String name = sc.nextLine();
		List<Food> results = dao.searchFoodByName(name);

		System.out.println(" File No "+ " Attributes "+" Type " + " Choose ID ");
		for (Food food : results) {
			System.out.println(food.getId() + food.getName() + food.getType() + food.getId());
		}

		System.out.print("Enter ID to view all the food items : ");
		int id = sc.nextInt();
		Food food = dao.getFoodById(id);
		System.out.println(food != null ? food : "Food not found.");
	}

	static void showAll(FoodDAO dao) throws Exception {
		List<Food> list = dao.getAllFoods();
		for (Food food : list)
			System.out.println(food);
	}

	static void operateDB(FoodDAO dao, Scanner sc) throws Exception {
		System.out.println("A. Add Food");
		System.out.println("B. Edit Food");
		System.out.println("C. Delete Food");
		String option = sc.next().toUpperCase();

		switch (option) {
		case "A":
			Food food = readFoodInput(sc);
			dao.addFood(food);
			System.out.println("Food added.");
			break;
		case "B": {
			System.out.print("Enter food id to edit: ");
			int id = sc.nextInt();
			Food food1 = readFoodInput(sc);
			food1.setId(id);
			dao.updateFood(food1);
			System.out.println("Food updated.");
		}
			break;
		case "C": {
			System.out.print("Enter food ID to delete: ");
			int id = sc.nextInt();
			dao.deleteFood(id);
			System.out.println("Food deleted.");
		}
			break;
		default:
			System.out.println("Invalid Option.");
		}

	}

	static Food readFoodInput(Scanner sc) {
		System.out.print("Food Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Food Type: ");
		String type = sc.nextLine();
		System.out.print("Food Description: ");
		String description = sc.nextLine();
		System.out.print("Food Cost: ");
		int cost = sc.nextInt();
		sc.nextLine();
		System.out.print("Food Quantity: ");
		String quantity = sc.nextLine();

		return new Food(name, type, description, cost, quantity);
	}
}
