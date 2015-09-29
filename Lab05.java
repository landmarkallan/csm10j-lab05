/*
********************************************************************************
* Student Name: Mark Land                             Moorpark College         *
* Program Name: Lab05.java                            CS M10J (Intro Java)     *
* Comment     : Handling Max Int Mem Limit Program    Intro to Prog using Java *
*               ch. 9, Prog Exer #10, pg. 461         Fall of 2015             *
*               Due on 9-29-15, sum of two numbers    Prof. John C. Reynolds   *
********************************************************************************
*/

/*
Program Purpose:

The purpose of this program is to get two int inputs from the user and display
their sum, without the issue of the max int mem storage limit of 2147483647.
*/

// Packages~Libraries~Modules:

import java.util.Scanner;

// Classes:

public class Lab05
{
	// Class-Global Constants ~ Variables ~ Object Instantiation:
	
	static Scanner console = new Scanner(System.in);
	
	static String input_string_1, input_string_2, output_string = "";
	
	static int[] input_integerlist_1, input_integerlist_2;
	
	static int carry = 0;
	
	// Methods~Functions:

	public static void main(String[] args)
	{
		Header();
		Purpose();
		Program();
	}
	
	public static void Header()
	{
		System.out.println("\n\n****************************************" +
			"****************************************");
		System.out.println("* Student Name: Mark Land               " +
		"              Moorpark College         *");
		System.out.println("* Program Name: Lab05.java              " +
		"              CS M10J (Intro Java)     *");
		System.out.println("* Comment     : Handling Max Int Mem Lim" +
		"it Program    Intro to Prog using Java *");
		System.out.println("*               ch. 9, Prog Exer #10, pg" +
		". 461         Fall of 2015             *");
		System.out.println("*               Due on 9-29-15, sum of t" +
		"wo numbers    Prof. John C. Reynolds   *");
		System.out.println("****************************************" +
			"****************************************\n\n");
	}
	
	public static void Purpose()
	{
		System.out.print("The purpose of this program is to get two int " +
		"inputs from the user and display \ntheir sum, without the issue " +
		"of the max int mem storage limit of 2147483647.");
	}
	
	public static void Program()
	{
		// get inputs as a string
		
		System.out.print("\n\n\nEnter the first number: ");
		input_string_1 = console.next();
		
		System.out.print("Enter the second number: ");
		input_string_2 = console.next();
		
		// initializing the quantity of slots in the arrays~lists:
		
		input_integerlist_1 = new int[input_string_1.length()];
		input_integerlist_2 = new int[input_string_2.length()];
		
		// copying the strings into integer arrays, in reverse order
		// 		(1's digit first, to, Nth digit):
		
		for (int count = 0; count < input_string_1.length(); count++)
		{
			input_integerlist_1[count] = Character.getNumericValue(
				input_string_1.charAt(input_string_1.length() - 1 - count));
		}
		
		for (int count = 0; count < input_string_2.length(); count++)
		{
			input_integerlist_2[count] = Character.getNumericValue(
				input_string_2.charAt(input_string_2.length() - 1 - count));
		}
		
		// calculating and returning string of the sum of the two integer
		//		arrays, and displayment:
		
		System.out.println("\n\n   " + input_string_1);
		System.out.println("+  " + input_string_2);
		System.out.println("=  " + Calculate(input_integerlist_1,
			input_integerlist_2) + "\n");
	}
	
	public static String Calculate(int[] input_integerlist_parameter_1,
		int[] input_integerlist_parameter_2)
	{
		if (input_integerlist_parameter_1.length >
			input_integerlist_parameter_2.length)
		{
			for (int count = 0; count < input_integerlist_parameter_2.length;
				count++)
			{
				if ((input_integerlist_parameter_1[count] +
					input_integerlist_parameter_2[count] + carry) >= 10)
				{
					output_string = Integer.toString((
						input_integerlist_parameter_1[count] +
						input_integerlist_parameter_2[count] + carry) % 10) +
						output_string;
						
					carry = (input_integerlist_parameter_1[count] +
						input_integerlist_parameter_2[count] + carry) / 10;
				}
				else
				{
					output_string = Integer.toString(
						input_integerlist_parameter_1[count] +
						input_integerlist_parameter_2[count] + carry) +
						output_string;
						
					carry = 0;
				}
			}
			for (int count = input_integerlist_parameter_2.length; count <
				input_integerlist_parameter_1.length; count++)
			{
				if ((input_integerlist_parameter_1[count] + carry) >= 10)
				{
					output_string = Integer.toString((
						input_integerlist_parameter_1[count] + carry) % 10) +
						output_string;
						
					carry = (input_integerlist_parameter_1[count] + carry) / 10;
				}
				else
				{
					output_string = Integer.toString(
						input_integerlist_parameter_1[count] + carry) +
						output_string;
						
					carry = 0;
				}
			}
		}
		else if (input_integerlist_parameter_1.length < 
			input_integerlist_parameter_2.length)
		{
			for (int count = 0; count < input_integerlist_parameter_1.length;
				count++)
			{
				if ((input_integerlist_parameter_1[count] + 
					input_integerlist_parameter_2[count] + carry) >= 10)
				{
					output_string = Integer.toString((
						input_integerlist_parameter_1[count] +
						input_integerlist_parameter_2[count] + carry) % 10) +
						output_string;
						
					carry = (input_integerlist_parameter_1[count] + 
						input_integerlist_parameter_2[count] + carry) / 10;
				}
				else
				{
					output_string = Integer.toString(
						input_integerlist_parameter_1[count] + 
						input_integerlist_parameter_2[count] + carry) + 
						output_string;
						
					carry = 0;
				}
			}
			for (int count = input_integerlist_parameter_1.length; count < 
				input_integerlist_parameter_2.length; count++)
			{
				if ((input_integerlist_parameter_2[count] + carry) >= 10)
				{
					output_string = Integer.toString((
						input_integerlist_parameter_2[count] + carry) % 10) +
						output_string;
						
					carry = (input_integerlist_parameter_2[count] + carry) / 10;
				}
				else
				{
					output_string = Integer.toString(
						input_integerlist_parameter_2[count] + carry) +
						output_string;
						
					carry = 0;
				}
			}
		}
		else if (input_integerlist_parameter_1.length == 
			input_integerlist_parameter_2.length)
		{
			for (int count = 0; count < input_integerlist_parameter_1.length;
				count++)
			{
				if ((input_integerlist_parameter_1[count] + 
					input_integerlist_parameter_2[count] + carry) >= 10)
				{
					output_string = Integer.toString((
						input_integerlist_parameter_1[count] + 
						input_integerlist_parameter_2[count] + carry) % 10) + 
						output_string;
						
					carry = (input_integerlist_parameter_1[count] + 
						input_integerlist_parameter_2[count] + carry) / 10;
				}
				else
				{
					output_string = Integer.toString(
						input_integerlist_parameter_1[count] + 
						input_integerlist_parameter_2[count] + carry) + 
						output_string;
					
					carry = 0;
				}
			}
		}
		if (carry > 0)
		{
			output_string = Integer.toString(carry) + output_string;
			carry = 0;
		}
		return (output_string);
	}
}
