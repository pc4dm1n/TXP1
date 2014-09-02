/**
	Output miles, feet, and inches for a given
	number of meters
*/

import java.util.Scanner;

public class MetricToEmperial
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Enter a number of meters to convert it to miles, feet, and inches.");
		System.out.println("");
		
		// get number of meters from user
		System.out.print("Enter the number of meters: ");
		double meters = in.nextDouble();
		
		final double METERS_TO_FEET = 3.28084;
		final double FEET_TO_MILES = 5280;
		final double INCHES_TO_FEET = 12;
		
		double feet = meters * METERS_TO_FEET;
		double miles = feet / FEET_TO_MILES;
		double inches = feet * INCHES_TO_FEET;
		
		System.out.println(meters + " meters is equal to: ");
		System.out.println(feet + " feet");
		System.out.println(miles + " miles");
		System.out.println(inches + " inches");
	}
}
