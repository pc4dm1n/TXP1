/**
    Counts the number of elements in an array that are equal
    to zero
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CountZeros
{
    public static void main(String args[])
    {
        Logger.getGlobal().setLevel(Level.OFF);
        Scanner in = new Scanner(System.in);
        int currentSize = 0;  // companion var
        int[] myArray = new int[8];
        boolean quit = false;  // sentinel

        do
        {
            if(currentSize >= myArray.length)
            {
                myArray = Arrays.copyOf(myArray, 2 * myArray.length);  // double array size if max limit is reached
            }

            System.out.print("Enter an integer (q to quit): ");
            if(in.hasNextInt())
            {
                myArray[currentSize] = in.nextInt();  // add int values to array
                currentSize++;
            }
            else
            {
                quit = true;  // quit on non-int
            }
        }
        while(!quit);  // accept input until a non-int value is given
        
        int zeros = 0;
        for(int elements : myArray)  // loop through elements
        {
            Logger.getGlobal().info("Array value is " + elements);
            if(elements == 0)
            {
                zeros++;  // track num of zeros
            }
        }
        System.out.println("The given array contains " + zeros + " zeros.");
    }
}
