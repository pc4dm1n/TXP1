import java.util.Scanner;

public class Input {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = in.nextInt();
        
        System.out.println("");
        System.out.println("You are " + (age * 365 * 24 * 60) + " minutes old.");
        System.out.println("You are " + (age * 365 * 24) + " hours old.");
        System.out.println("You are " + (age * 365) + " days old.");
        System.out.println("You are " + ((double)age / 10) + " decades old.");
        System.out.println("You are halfway to being " + (age * 2) + " years old.");
    }
}