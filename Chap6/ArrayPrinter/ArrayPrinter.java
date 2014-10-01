/**
    Initialize an array containing ten random ints and prints the following:
        .each element at an even index
        .each even element
        .all elements in reverse order
        .first and last elements
*/
public class ArrayPrinter
{
    final String ELEMENT_FORMAT = "%7d";
    
    /**
        Generates a random integer between 0 and max
        @param max indicates maximum number
    */
    public static int randInt(int max)
    {
        int result = (int)(Math.random() * (max + 1));
        return result;
    }
    
    /**
        Prints every other element, starting at the specified index
        @param array the array to process
        @param startingIndex the index to begin at
    */
    public static void printEven(int[] array, int startingIndex)
    {
        for(int i = startingIndex; i < array.length; i = i + 2)
        {
            System.out.printf("%7d", array[i]);
            System.out.println();
        }
    }
    
    /**
        Print array elements in reverse
        @param array the array object to process
    */
    public static void printRev(int[] array)
    {
        for(int i = array.length - 1; i >= 0; i--)
        {
            System.out.printf("%7d", array[i]);
            System.out.println();
        }
    }
        
    public static void main(String args[])
    {
        int[] myVals = new int[10];
        for(int i = 0; i < myVals.length; i++)
        {
            myVals[i] = randInt(100); // store set each element to a random int 0-100
        }
        System.out.println("Even index elements are: ");
        printEven(myVals, 0); // print even indexes
        System.out.println();
        System.out.println("Even elements are: ");
        printEven(myVals, 1); // print even elements
        System.out.println();
        System.out.println("Reverse order elements are: ");
        printRev(myVals); // print reverse order
        System.out.println();
        System.out.print("First element is " + myVals[0] + ", last element is " + myVals[9] + "."); // print first and last elements
        System.out.println();
    }
}