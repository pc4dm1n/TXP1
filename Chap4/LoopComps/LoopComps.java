import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LoopComps
{
    public static void main(String args[])
    {
        Logger.getGlobal().setLevel(Level.OFF);
        Scanner zebra = new Scanner(System.in);
        int total = 0;
        int input1 = 0;
        int input2 = 0;

        System.out.print("Enter an integer: ");
        if(zebra.hasNextInt())
        {
            input1 = zebra.nextInt();
        }
        
        System.out.print("Enter a second integer: ");
        if(zebra.hasNextInt())
        {
            input2 = zebra.nextInt();
        }
        
        if(input1 < input2)
        {
            Logger.getGlobal().info("input1 is lower");
            if(input1 % 2 == 0)
            {
                Logger.getGlobal().info("Input1 is even");
                input1++;
            }
            
            for(int i = input1; i <= input2; i = i + 2)
            {
                total = i + total;
            }
        }
        else
        {
            Logger.getGlobal().info("Second integer is smaller");
            if(input2 % 2 == 0)
            {
                Logger.getGlobal().info("Input2 is even");
                input2++;
            }
            for(int i = input2; i <= input1; i = i + 2)
            {
                total = i + total;
            }
        }
        System.out.println("The sum of all odd numbers between " + input1 + " and " + input2 + " is " + total);
    }
}
