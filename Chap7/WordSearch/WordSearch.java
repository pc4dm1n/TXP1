/**
    This program searches a list of text files presented at the prompt
    for a word, also given at command prompt.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordSearch
{
    public static void main(String args[])
    {
        if(args.length <= 0 || args[0].charAt(0) == '-')
        {
            usage();
        }
        else
        {
            String searchTerm = args[0];
            for(int i = 1; i < args.length; i++)
            {
                String inFile = args[i];
                String output = "";
                try
                {
                    output = output + searchFile(inFile, searchTerm);
                    System.out.print(output);
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("Error: no such file found.");
                }
            }
        }
    }
    /**
        Read input from a file and returns the line, if any, at which a
        a match is found.
        @param filename the name of the input file
        @param searchTerm a string to look for in each word
        @return 
    */
    public static String searchFile(String filename, String searchTerm) throws FileNotFoundException
    {
        String input = "";
        Scanner in = null;
        String result = "";
        try
        {
            File inputFile = new File(filename);
            in = new Scanner(inputFile);
            while(in.hasNext())
            {
                //String testString = in.next();
                String lineContaining = in.nextLine();
                if(lineContaining.contains(searchTerm))
                {
                    result = result + filename + ":" + lineContaining + "\n";
                }
            }
        }
        finally
        {
            in.close();
        }
        return result;
    }
    /**
        Print use information to the console
    */
    public static void usage()
    {
        System.out.println("Usage:");
        System.out.println("java WordSearch [search term] [file1] [file2]...");
        System.out.println();
        System.out.println("Switches:");
        System.out.println("java WordSearch -h        - print this help menu");
    }
}