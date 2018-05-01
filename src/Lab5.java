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
			System.out.println("e^" + realNum + " = " + eTaylor(realNum));
			continue;
			case 3: palindromeCheck();
			continue;
			case 4: System.exit(0);
			}
		}
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

		//markers for the beginning and end 
		//of the string entered by the user
		int beginning = 0;
		int end = someWord.length()-1;
		boolean isPalidrome = true;
		while(beginning < end){

			char beginLetter = someWord.charAt(beginning);
			char endLetter = someWord.charAt(end);

			if(beginLetter != endLetter){
				isPalidrome = false;
				break;
			}
			total++;
			beginning++;
			end--;
		}
		if(isPalidrome == true){
			count++;
			System.out.println(someWord + " is a palidrome");
		}else{
			System.out.println(someWord + " is not a palidrome");
		}
		System.out.println("Total: " + count + " palidromes "
				+ "out of " + total);
	}
}