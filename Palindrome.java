package assessment;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to check for palindrome");
		int number = sc.nextInt();
		int temp =number;
		int reversed = 0;
			
		 while(temp > 0) {
			int digit = temp%10;
			reversed = reversed*10 + digit;
			 temp = temp/10;
			 System.out.print(digit);
			}	
		
		 
		if(number == reversed) {
			System.out.println("\nThe given number is a Palindrome");
		}else {
			System.out.println("\nThe given number is not a Palidrome");

	}
	}
}

