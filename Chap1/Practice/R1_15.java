import java.util.Scanner;

public class R1_15
{
	public static void main(String args[])
	{
		/**
			Calculate the total cost of driving to work versus
			buying a train ticket.
		*/
		Scanner in = new Scanner(System.in);
		
		// get train ticket price from user
		System.out.print("Enter the price of a train ticket to travel to work: ");
		double ticketPrice = in.nextDouble();
		
		// get distance travelled from user
		System.out.print("Enter the number of miles you travel one-way to work: ");
		double distance = in.nextDouble();
		
		// get mpg from user
		System.out.print("Enter your vehicle's miles per gallon (mpg) rating: ");
		double mpg = in.nextDouble();
		
		// assume $4 per gallon for fuel
		final double COST_PER_GALLON = 4;
		
		// assume 5 cent maintenance cost per mile
		final double MAINTENANCE_COST = 0.05 * distance;
		
		// calculate total cost to drive
		double driveCost = ((distance / mpg) * COST_PER_GALLON) + MAINTENANCE_COST;
		
		// print the total cost to drive compared to the train ticket price
		System.out.print("It will cost you $");
		System.out.printf("%.2f", driveCost);
		System.out.println(" to drive to work.");
		System.out.print("The train ticket price is $");
		System.out.printf("%.2f", ticketPrice);
		System.out.println(".");
	}
}
