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
                    int courseInput = 0;
                    System.out.print("Enter remaining course units individually (-1 to return to main options): ");
                    if(in.hasNextInt())
                    {
                        courseInput = in.nextInt();
                    }
                    if(courseInput == -1) // return to main options
                    {
                        done = true;
                    }
                    else if(courseInput > 0) // add CUs to ArrayList
                    {
                        compUnitTotal.add(courseInput);
                    }
                    else // invalid input
                    {
                        System.out.println("Error: please enter integers greater than 0 (or -1 to return to main options).");
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
