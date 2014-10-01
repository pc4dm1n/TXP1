import java.util.Arrays;

/**
    Swaps the first and last elements of an array
*/
public class SwapFirstLast
{
    /**
        Function accepts and returns array, swapping the first
        and last elements
        @param array the array with which to swap elements
        @return a copy array with the first and last elements swapped
    */
    public static String[] swapPos(String[] array)
    {
        String[] newArray = Arrays.copyOf(array, array.length);
        String temp = newArray[0];
        newArray[0] = newArray[newArray.length - 1];
        newArray[newArray.length - 1] = temp;
        return newArray;
    }
    
    public static void main(String args[])
    {
        String[] myArray = {"a", "b", "c", "d", "e", "f", "g"};
        String[] result = swapPos(myArray);
        System.out.println("Initial array is: ");
        for(String elements : myArray)
        {
            System.out.printf("%5s", elements);
        }
        System.out.println();
        System.out.println("Array after swapping first and last elements: ");
        for(int i = 0; i < result.length; i++)
        {
            System.out.printf("%5s", result[i]);
        }
    }
}
