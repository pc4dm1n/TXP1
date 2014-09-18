import java.util.Scanner;
/**
    Take a given letter size inches (user inputs height and width)
    and convert it into millimeters (mm)
*/
public class LetterConvert
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        // conversion rate for inches to millimeters
        final double INCHES_TO_MM = 25.4;
        
        // get letter width
        System.out.print("Enter the width of your letter size in inches: ");
        double letterWidth = in.nextDouble();
        
        // get letter height
        System.out.print("Enter the height of your letter size in inches: ");
        double letterHeight = in.nextDouble();
        
        // convert inches to millimeters
        double newLetterWidth = letterWidth * INCHES_TO_MM;
        double newLetterHeight = letterHeight * INCHES_TO_MM;
        
        // output computation to user
        System.out.print("A letter size of " + letterWidth + " x " + letterHeight + " is equivalent to ");
        // limit floats to two decimals
        System.out.printf("%.2f x %.2f millimeters.\n", newLetterWidth, newLetterHeight);
    }
}
