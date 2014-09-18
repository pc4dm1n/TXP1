import java.util.Scanner;

public class CheckIntSign
{
    /**
        Take integer from user and output whether integer is positive,
        negative, or zero
    */
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        // prompt for int
        System.out.print("Enter an integer: ");
        // check for non-int
        if (in.hasNextInt())
        {
            int number = in.nextInt();
            // determine whether number is negative, zero, or positive
            if (number < 0)
            {
                System.out.println(number + " is a negative number.");
            }
            else if (number == 0)
            {
                System.out.println(number + " is zero.");
            }
            else
            {
                System.out.println(number + " is a positive number.");
            }
        }
        else
        {
            // throw error for non-int input
            System.out.println("Error: not an integer.");
        }
        
    }
}
