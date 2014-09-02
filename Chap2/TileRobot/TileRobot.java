import java.util.Scanner;

public class TileRobot
{
    public static void main(String args[])
    {
        /**
            Given a row (x) and column (y), determine whether a black
            or white tile should be placed (using an alternating pattern
        */
        
        int rowNumber;
        int colNumber;
        // tile color represented by 0 (black) 1 (white)
        int tileColor;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row number: ");
        rowNumber = in.nextInt();
        
        System.out.print("Enter a column number: ");
        colNumber = in.nextInt();
        
        tileColor = Math.abs((rowNumber + colNumber) % 2);
        
        System.out.println("Place tile color " + tileColor + " at coordinates (" + rowNumber + "," + colNumber + ").");
    }
}
