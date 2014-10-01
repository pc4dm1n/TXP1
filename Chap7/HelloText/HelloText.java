/**
    This program writes a message to the hello.txt file, closes the file,
    reopens the same file, reads the text in the file to a String, and prints
    the String.
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloText
{
    public static void main(String args[])
    {
        String file = "hello.txt"; // default filenames
        if(args.length > 0)
        {
            for(int i = 0; i < args.length; i++)
            {
                String arg = args[i];
                if(arg.charAt(0) == '-') // command-line option
                {
                    char option = arg.charAt(1);
                    if(option == 'f') // user-specified filename
                    {
                        file = args[i + 1];
                    }
                    else
                    {
                        usageHelp(); // print help menu
                        return;
                    }
                }
            }
        }
        try
        {
            PrintWriter out = new PrintWriter(file); // write to file
            try
            {
                out.println("Hello, world!");
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
        try // read file
        {
            readFile(file);
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Error: no such file found.");
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    public static void readFile(String filename) throws FileNotFoundException
    {
        String input = "";
        Scanner in = null;
        try
        {
            File inputFile = new File(filename);
            in = new Scanner(inputFile);
            while(in.hasNext())
            {
                input = input + in.nextLine();
                System.out.println(input);
            }
        }
        finally
        {
            in.close();
        }
    }
    public static void usageHelp()
    {
        System.out.println("Usage: java HelloText [options] [filename]");
        System.out.println("Options:");
        System.out.println("     -f     Specifies a file to write to and read from.");
        System.out.println("     -h     Shows this help menu.");
    }
}
