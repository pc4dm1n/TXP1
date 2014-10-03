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
        while(programRun)
        {
            String input = "";
            ArrayList<Integer> compUnitTotal = new ArrayList<Integer>();
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
                    String courseInput = "";
                    System.out.print("Enter remaining course units individually (-1 to return to main options): ");
                    courseInput = in.next();
                    String err = "Error: please enter integers greater than 0 (or -1 to return to main options).";
                    try
                    {
                        int courseInt = Integer.parseInt(courseInput);
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
}
