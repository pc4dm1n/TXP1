import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Arrays;
import java.util.Scanner;

/**
    This programs accepts either a seat number (A1) or ticket price ($10) and
    and prints the price with the option to select that seat or shows a list
    of seats available at that price respectively.
*/
public class SeatingChart
{
    /**
        Accepts a letter (A-F) and returns an int (1-6)
        @param rowLetter a letter (A-F) representing a row
        @return an int corresponding to a lettered row
    */
    public static int convertRowLetter(String rowLetter)
    {
        int result = 0;
        String[] values = {"A", "B", "C", "D", "E", "F"}; // row letters
        for(int i = 0; i < values.length; i++)
        {
            if(rowLetter.equals(values[i]))
            {
                result = i;
            }
        }
        return result;
    }
    
    /**
        Accepts a number (1-6) and returns a char (A-F)
        @param rowNum a number representing a row letter
        @return a String corresponding to a row number
    */
    public static String convertRowNum(int rowNum)
    {
        String result = "";
        String values[] = {"A", "B", "C", "D", "E", "F"}; // row letters
        for(int i = 0; i < values.length; i++)
        {
            if(rowNum == i)
            {
                result = values[i];
            }
        }
        return result;
    }
    
    public static void main(String args[])
    {
        Logger.getGlobal().setLevel(Level.OFF);
        int[][] seatPrices = 
        {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 15, 15, 15, 15, 15, 15, 10, 10},
            {10, 10, 15, 15, 15, 15, 15, 15, 10, 10},
            {10, 10, 15, 15, 15, 15, 15, 15, 10, 10},
            {15, 15, 20, 20, 20, 20, 20, 20, 15, 15},
            {15, 20, 25, 25, 30, 30, 25, 25, 20, 15}
        };
        /*
        for(int[] row : seatsPrices)
        {
            for(int elements : row)
            {
                System.out.printf("$%2d ", elements);
            }
            System.out.println();
        }
        */
        boolean done = false;
        Scanner in = new Scanner(System.in);
        while(!done)
        {
            String input = "";
            int dollars = 0;
            System.out.print("Would you like to select a seat, or see available seats for a particular price? (s for seat p for price or q to quit): ");
            if(in.hasNext())
            {
                input = in.next();
            }
            if(input.equals("p")) // seats by price
            {
                System.out.print("Enter the desired ticket price: ");
                if(in.hasNextInt())
                {
                    dollars = in.nextInt();
                    System.out.println("Seats available for $" + dollars + ": ");
                    for(int i = 0; i < seatPrices.length; i++)
                    {
                        for(int j = 0; j < seatPrices[0].length; j++)
                        {
                            if(seatPrices[i][j] == dollars)
                            {
                                System.out.printf("%2s ", convertRowNum(i) + (j + 1));
                            }
                        }
                    }
                    System.out.println();
                }
                else
                {
                    System.out.println("Error: please enter only numbers (e.g. 15 for $15).");
                }
            }
            else if(input.equals("s")) // seat selection
            {
                System.out.print("Enter a seat row and number (A1): ");
                if(in.hasNext())
                {
                    input = in.next();
                }
                int seatRow = convertRowLetter(input.substring(0, 1));
                int seatNo = Integer.parseInt(input.substring(1, input.length())) - 1;
                Logger.getGlobal().info(seatRow + ", " + seatNo);
                if((seatRow >= 0 && seatRow <= seatPrices.length) && (seatNo >= 0 && seatNo <= seatPrices[0].length))
                {
                    int seatPrice = seatPrices[seatRow][seatNo];
                    if(seatPrice != 0)
                    {
                        System.out.print("Seat " + input + " has a price of $" + seatPrice + ".  Would you like to purchase? (y or n): ");
                        if(in.hasNext())
                        {
                            String choice = in.next();
                            if(choice.equals("y"))
                            {
                                seatPrices[seatRow][seatNo] = 0; // set seat price to zero
                                System.out.println("Thank you for your purchase.");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Sorry, that seat has been sold.  Please make another selection.");
                    }
                }
                else
                {
                    System.out.println("Error: no such seat exists.");
                }
            }
            else if(input.equals("q"))
            {
                done = true;
            }
            else
            {
                System.out.println("Error: invalid selection.");
            }
        }
    }
}
