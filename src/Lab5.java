import java.util.Scanner;
import java.util.*;

/**
 * The first method of this class will return the values, per day,
 * of the increase in value after adding 1 + previousAmount / 2
 * then stop once 1m is reached.
 * 
 * The second method uses a helper method to produce the value
 * of a number when run through the Taylor Series calculation
 * The helper method will take in the value given to the parent method
 * then calculate the exponential value and factorial, then return
 * the value of those two calculations divided by each other. 
 * 
 * The final calculation will take in a String from the user and
 * check if it is a palindrome or not.
 */


public class Lab5 {

	/****************************************************/
	/* Main method here. All methods that are used are  */
	/* called here, helper methods excluded.			*/
	/****************************************************/
	public static void main(String[] args)  {
		int selection = 1;
		Scanner menuSelection = new Scanner(System.in);
		while(selection != 0){
			System.out.println("Enter 1 to check how long it takes to get rich on a magic coin");
			System.out.println("Enter 2 to calculate e^x for any real x");
			System.out.println("Enter 3 to enter palindrome words");
			System.out.println("Enter 4 to re-print the menu");
			System.out.println("Enter 0 to exit");
			System.out.println("What is your choice?");
			selection = menuSelection.nextInt();
			
			switch(selection){
			case 1: getRichQuick();
			continue;
			case 2: System.out.println("Enter a real number");
			double realNum = menuSelection.nextDouble();
			System.out.println(eTaylor(realNum));
			continue;
			}
		}


		//getRichQuick();

		//testing the eTaylor method. 
		//using 0 as the input should return 1.0 if working correctly
		//System.out.println(eTaylor(0));

		palindromeCheck();
	}

	public static void getRichQuick() {
		// Declare your variables here and implement your logic
		double total = 0;
		double currentTotal;
		int counter = 0;
		while (total <= 1000000){
			counter++;
			total = total + (1+(total/2));
			System.out.println("Day " + counter +": "+ total);
		}
	}

	public static double eTaylor(double x) {
		double taylorNumber = 0.0;

		taylorNumber = 1 + x + NthDividedByFactorial(x);

		return taylorNumber;
	}

	/****************************************************/
	/* helper method for getting the value of x raised  */
	/* to the nth power. Just multiply by two until n.	*/
	/* then the second loop gets the factorial value	*/
	/****************************************************/
	public static double NthDividedByFactorial(double x){
		int n = 5;
		int factorial = 1;
		for(int i=1;i<=n;i++){
			x = x * 2;
		}

		for(int q=1;q<=n;q++){
			factorial = factorial * q;
		}
		double xModified = x/factorial;
		return xModified;
	}

	// Part 3
	/**
	 * This program reads words, identifies, counts and writes all the palindromes and the total
	 * palindrome count.
	 */
	public static void palindromeCheck(){

		String someWord = ""; // Stores words read from user input
		int count = 0;        // keeps track of Palindrome words only
		int total = 0;        // Counts the total number of lines read from the given input

		System.out.println("Enter some words separated by white space");

		// declare your Scanner object here
		Scanner keyboard = new Scanner(System.in);
		someWord = keyboard.nextLine();

		// for each word user enters
		while (keyboard.hasNext()) {
			someWord = keyboard.nextLine();
			total++;

			System.out.println("  " + total + " " + someWord);
		}

		// x is a variable for count and y is variable total
		// #2. print There are x palindromes out of y words 

	}

	// Part 4 goes here, write a menu using the following specifications

	//Welcome to Lab5!
	//Enter 1 to check how long it takes to get rich on a magic dollar coin. 
	//Enter 2 to calculate e^x for any real x. 
	//Enter 3 to enter palindrome words.
	//Enter 4 to re-print the menu. 
	//Enter 0 to exit. 

	// -- Sample outputs, delete these after completing the lab and verifying your output --
	//What is your choice? 3        
	//Enter an x: 1 e^1 = 2.7182818284590452  
	//What is your choice? 0 
	//Thanks for participating! Goodbye. 


}





