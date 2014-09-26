/**
    This program finds the smallest of three numbers or produces the mean of three numbers
    given a user choice indicating the former or latter and three integers.
*/

import java.util.Scanner;

public class SmallestMean
{
    /**
        Finds the smallest of three doubles
        @param x the first double for comparison
        @param y the second double for comparison
        @param z the third double for comparison
    */
    public static double smallest(double x, double y, double z)
    {
        double result = Math.min(x, Math.min(x, z));  // compare the smallest result of y, z to x
        return result;
    }
    /**
        Finds the mean of three doubles
        @param x the first double
        @param y the second double
        @param z the third double
    */
    public static double mean(double x, double y, double z)
    {
        double result = (x + y + z) / 3;
        return result;
    }
    public static void main(String args[])
    {
        boolean quit = false;
        String input = "";
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.print("Enter 's' to find the smallest or 'm' for mean ('q' to quit): "); // prompt for method choice
            if(in.hasNext())
            {
                input = in.next();
                if(input.equals("s"))
                {
                    double x = 0;
                    double y = 0;
                    double z = 0;
                    System.out.print("Enter one double: ");
                    if(in.hasNextDouble())
                    {
                        x = in.nextDouble();
                    }
                    System.out.print("Enter another double: ");
                    if(in.hasNextDouble())
                    {
                        y = in.nextDouble();
                    }
                    System.out.print("Enter another double: ");
                    if(in.hasNextDouble())
                    {
                        z = in.nextDouble();
                    }
                    System.out.println("The smallest of these doubles is " + smallest(x, y, z));
                }
                else if(input.equals("m"))
                {
                    double x = 0;
                    double y = 0;
                    double z = 0;
                    System.out.print("Enter on double: ");
                    if(in.hasNextDouble())
                    {
                        x = in.nextDouble();
                    }
                    System.out.print("Enter another double: ");
                    if(in.hasNextDouble())
                    {
                        y = in.nextDouble();
                    }
                    System.out.print("Enter another double: ");
                    if(in.hasNextDouble())
                    {
                        z = in.nextDouble();
                    }
                    System.out.println("The mean of these doubles is " + mean(x, y, z));
                }
                else
                {
                    quit = true;
                }
            }
            else
            {
                quit = true;
            }
        }
        while(!quit);
    }
}
