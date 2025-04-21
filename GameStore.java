package assessment;

import java.util.Scanner;

public class GameStore {
	int total = 0;

	public void displayMenu() {
		System.out.println("\n ````Game Store Menu````" + "\n1. Call of Warfare: ₹1500" + "\n2. Speed Racers: ₹1200"
				+ "\n3. Mystery Mansion: ₹1000" + "\n4. Pixel Adventure: ₹800" + "\n5. Puzzle Mania: ₹500"
				+ "\n6. Checkout/Exit");
		System.out.print("Enter your choice: ");
	}

	public int gameQuantity(String gameName) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many copies of " + gameName + " you would like to purchase ?");
		int quantity = sc.nextInt();
		System.out.println("Game(s) added to your Cart!");
		return quantity;
	}

	public void exit() {
		System.out.println("Total Cost: ₹" + total);
	}

	public void choicePreffered(int choice) {
		int quantity;
		switch (choice) {
		case 1:
			quantity = gameQuantity("Call of Warfare");
			total += 1500 * quantity;
			break;
		case 2:
			quantity = gameQuantity("Speed Racers");
			total += 1200 * quantity;
			break;
		case 3:
			quantity = gameQuantity("Mystery Mansion");
			total += 1000 * quantity;
			break;
		case 4:
			quantity = gameQuantity("Pixel Adventure");
			total += 800 * quantity;
			break;
		case 5:
			quantity = gameQuantity("Puzzle Mania");
			total += 500 * quantity;
			break;
		default:
			System.out.println("Invalid option.");
		}
	}

}
