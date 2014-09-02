import java.util.Scanner;

public class NoTiles
{
	/**
		Calculate the number of alternating tiles needed
		to span a wall, leaving the same type tile at each
		end.
	*/
	public static void main(String args[])
	{
		int noPairs;
		int totalWidth;
		int tileWidth;
		int noTiles;
		int endGap;

        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the total width the tiles will span in inches: ");
        totalWidth = in.nextInt();

        System.out.print("Enter the width of your tiles in inches: ");
        tileWidth = in.nextInt();
		
		noPairs = (totalWidth - tileWidth) / (2 * tileWidth);
		noTiles = 1 + 2 * noPairs;
		endGap = (totalWidth - noTiles * tileWidth) / 2;
                
        System.out.println();
        System.out.print("Use " + noTiles + " tiles, leaving a gap of " + endGap + " inches at each end.");
        System.out.println();
	}
}
