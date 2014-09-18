import java.util.Scanner;

public class NumberCompare
{
    /**
        Compare three numbers and print whether they are all the same,
        all different, or neither.
    */
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        // prompt user for integers
        System.out.print("Enter an integer: ");
        int firstNum = in.nextInt();
        System.out.print("Enter another integer: ");
        int secondNum = in.nextInt();
        System.out.print("Enter a third integer: ");
        int thirdNum = in.nextInt();
        
        // compare each number and display result
        if (firstNum == secondNum && secondNum == thirdNum)
        {
            System.out.println("All the same");
        }
        else if (firstNum != secondNum && secondNum != thirdNum && firstNum != thirdNum)
        {
            System.out.println("All different");
        }
        else
        {
            System.out.println("Neither");
        }
    }
}
