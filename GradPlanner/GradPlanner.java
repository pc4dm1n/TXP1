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
        ArrayList<Integer> compUnitTotal = new ArrayList<Integer>(); // user-supplied values
        int cusPerTerm = 0; // user-supplied value
        final int MONTHS_PER_TERM = 6;
        final int COST_PER_TERM = 2890;
        final int CUS_REQUIRED_PER_TERM = 12;
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
                    if(compUnitTotal.size() > 0)
                    {
                        System.out.print("Enter the number of CUs you plan to complete per term: ");
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
                                cusPerTerm = unitInt;
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
                if(cusPerTerm != 0) // avoid divide by zero
                {
                    int sum = unitSum(compUnitTotal);
                    int totalTerms = sum / cusPerTerm;
                    if(sum % cusPerTerm > 0) // round terms up
                    {
                        totalTerms++;
                    }
                    int totalCost = COST_PER_TERM * totalTerms;
                    int totalMonths = totalTerms * MONTHS_PER_TERM;
                    System.out.printf("Number of terms to complete %d competency units at %d units per term: %d\n", sum, cusPerTerm, totalTerms);
                    System.out.printf("Tuition cost for %d terms: $%,d\n", totalTerms, totalCost);
                    System.out.printf("Number of months to complete %d competency units at %d units per term: %d\n", sum, cusPerTerm, totalMonths);
                }
                else
                {
                    System.out.println("Error: you must enter valid data before calculating!");
                }
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
    /**
        Calculates the sum of integers in an ArrayList
        @param arrayList the ArrayList object from which to pull elements
        @return the sum of all elements of arrayList
    */
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
