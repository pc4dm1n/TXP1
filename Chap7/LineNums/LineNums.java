/**
    This program reads input from a text file (user prompted) and
    outputs a new text file (user prompted for file name) containing
    line numbers.
*/
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LineNums
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String inFile = "";
        String outFile = "";
        while(!done)
        {
            System.out.print("Enter an input file name: ");
            if(in.hasNext())
            {
                inFile = in.next();
                done = true;
            }
        }
        done = false;
        while(!done)
        {
            System.out.print("Enter an output file name: ");
            if(in.hasNext())
            {
                outFile = in.next();
                done = true;
            }
        }
        try
        {
            String[] input = readFile(inFile);
            try
            {
                PrintWriter out = new PrintWriter(outFile);
                try
                {
                    for(int i = 0; i < input.length; i++)
                    {
                        out.println("/* " + (i + 1) + " */ " + input[i]);
                    }
                }
                finally
                {
                    out.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        catch(NullPointerException exception)
        {
            System.out.println("Error: no such file found.");
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Error: no such file found.");
        }
    }
    /**
        Reads input from a file
        @param fileName the file from which to read input
        @return an array of strings containing each line of text from fileName
    */
    public static String[] readFile(String fileName) throws FileNotFoundException
    {
        String[] input = new String[100];
        int currentSize = 0; // companion variable
        Scanner in = null;
        try
        {
            File inputFile = new File(fileName);
            in = new Scanner(inputFile);
            while(in.hasNext())
            {
                if(currentSize >= input.length)
                {
                    String[] lines = Arrays.copyOf(input, 2 * input.length);
                    input = lines;
                }
                input[currentSize] = in.nextLine();
                currentSize++;
            }
            String[] trimmed = Arrays.copyOf(input, currentSize);
            input = trimmed;
        }
        finally
        {
            in.close();
        }
        return input;
    }
    /**
        Writes output to a file
        @param fileName the file to which output is written
    */
    public static void writeFile(String fileName)
    {
        try
        {
            PrintWriter out = new PrintWriter(fileName);
            try
            {
                out.println(""); // print lines to file
            }
            finally
            {
                out.close();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}