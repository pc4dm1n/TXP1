/**
    Accept user string and print it out with three exclamation points
    
*/
import java.util.Scanner;
public class Shout
{
    /**
        Print user string with three exclamation points "shout"
        @param text the string to add exclamation points to
    */
    public static void shout(String text)
    {
        String shout = text + "!!!";
        System.out.println(shout);
    }
    
    public static void main(String args[])
    {
        String input = "";
        Scanner in = new Scanner(System.in);
        
        // accept user String
        System.out.print("Enter a string: ");
        if(in.hasNext())
        {
            input = in.next();
        }
        else {
            return;
        }
        
        // call shout method
        shout(input);
    }
}