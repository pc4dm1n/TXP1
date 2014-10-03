/**
    This program accepts a number of competency units (CUs) per course remaining
    in a student's degree program, and the number of CUs the student plans to
    complete per term and outputs the number of terms left to complete based on
    input data, the tuition cost based on the number of remaining terms, and the
    number of months to completion, based on input data.
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class GradPlanner
{
    public static void main(String args[])
    {
        Logger.getGlobal().setLevel(Level.INFO);
        Scanner in = new Scanner(System.in);
        boolean programRun = true;
        ArrayList<Integer> compUnitTotal = new ArrayList<Integer>();
        final int MONTHS_PER_TERM = 6;
        final int COST_PER_TERM = 2890;
        final int CUS_REQUIRED_PER_TERM = 12;
        int totalCost = 0;
        while(programRun)
        {
            String input = "";
            System.out.print("Enter courses remaining (r), units to take per term (u), or calculate (c); q to quit: ");
            if(in.hasNext())
            {
                input = in.next();
            }
            if(input.toLowerCase().equals("r")) //user selects to enter courses
            {
                boolean done = false;
                while(!done)
                {
                    System.out.print("Enter remaining course units individually (-1 to return to main options): ");
                    String courseInput = in.next();
                    String err = "Error: please enter integers greater than zero (or -1 to return to main options).";
                    try
                    {
                        int courseInt = Integer.parseInt(courseInput); // parseInt to avoid problems with unexpected input
                        if(courseInt == -1) // return to main options
                        {
                            done = true;
                        }
                        else if(courseInt > 0) // add CUs to ArrayList
                        {
                            compUnitTotal.add(courseInt);
                        }
                        else
                        {
                            System.out.println(err);
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println(err);
                    }
                }
            }
            else if(input.toLowerCase().equals("u")) // user selects to enter units to take per term
            {
                boolean done = false;
                while(!done)
                {
                    System.out.print("Enter the number of CUs you plan to complete per term: ");
                    if(compUnitTotal.size() > 0)
                    {
                        String unitInput = in.next();
                        try
                        {
                            int unitInt = Integer.parseInt(unitInput); // parseInt to avoid problems with unexpected input
                            int compUnitsNeeded = unitSum(compUnitTotal);
                            if(unitInt <= 0)
                            {
                                System.out.println("Error: please enter an integer greater than zero.");
                            }
                            else if(compUnitsNeeded >= CUS_REQUIRED_PER_TERM && unitInt < CUS_REQUIRED_PER_TERM)
                            {
                                System.out.println("Invalid: undergraduate students must take a minimum 12 CUs per term.");
                            }
                            else
                            {
                                System.out.println("OK");
                                done = true;
                            }
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Error: please enter an integer greater than zero.");
                        }
                    }
                    else
                    {
                        System.out.println("Error: you must enter competency units to complete before entering units per term.");
                        done = true;
                    }
                }
            }
            else if(input.toLowerCase().equals("c")) // user selects to calculate
            {
                
            }
            else if(input.toLowerCase().equals("q")) // user selects to quit program
            {
                programRun = false;
            }
            else // invalid input
            {
                System.out.println("Error: invalid option.");
            }
        }
    }
    public static int unitSum(ArrayList<Integer> arrayList)
    {
        int result = 0;
        for(int i = 0; i < arrayList.size(); i++)
        {
            result = result + arrayList.get(i);
        }
        return result;
    }
}
