import java.util.Scanner;

public class MatterState
{
    /**
        Accept user input value representing temperature in centigrade.
        Return whether water will be solid, liquid, or gas at that temperature
        and altitude (user supplied).
    */
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String errorNaI = "Error: Not an integer!";
        System.out.print("Enter a temperature in centigrade: ");
        final int WATER_FREEZING_POINT = 0;
        int altitude = 0;
        if (in.hasNextInt())
        {
            int temp = in.nextInt();
            System.out.print("Enter altitude in meters: ");
            if(in.hasNextInt())
            {
                altitude = in.nextInt();
            }
            else
            {
                System.out.println(errorNaI);
                System.exit(0);
            }
            // boiling point drops approx 1 deg per 300 meters altitude
            final int WATER_BOILING_POINT = 100 - (altitude / 300);
            if (temp <= WATER_FREEZING_POINT)
            {
                System.out.println("At " + altitude + " meters above sea-level, water is solid at this temperature.");
            }
            else if (temp > WATER_FREEZING_POINT && temp < WATER_BOILING_POINT)
            {
                System.out.println("At " + altitude + " meters above sea-level, water is liquid at this temperature.");
            }
            else
            {
                System.out.println("At " + altitude + " meters above sea-level, water is gaseous at this temperature.");
            }
        }
        else
        {
            System.out.println(errorNaI);
        }
    }
}
