import java.util.Scanner;
public class Calc1913Tax
{
    public static void main(String args[])
    {
        /** 
            Take user's annual income and calculate taxes owed
            using 1913 tax schedule
        */
        Scanner in = new Scanner(System.in);
        
        double income = 0;
        double taxPercent = 0;
        String err = "Error: not a double.";
        
        System.out.print("Enter your annual income: ");
        if (in.hasNextDouble())
        {
            income = in.nextDouble();
        }
        else
        {
            System.out.println(err);
        }
        
        if (income <= 50000)
        {
            taxPercent = 0.1;
        }
        else if (income > 50000 && income <= 75000)
        {
            taxPercent = 0.2;
        }
        else if (income > 75000 && income <= 100000)
        {
            taxPercent = 0.3;
        }
        else if (income > 100000 && income <= 250000)
        {
            taxPercent = 0.4;
        }
        else if (income > 250000 && income <= 500000)
        {
            taxPercent = 0.5;
        }
        else {
            taxPercent = 0.6;
        }
        double taxOwed = income * taxPercent;
        System.out.printf("Given an annual income of $%.0f you could expect to pay $%.2f based on the 1913 tax schedule.\n", income, taxOwed);
    }
}
