import java.util.Scanner;

public class PhoneNum
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter your phone number (digits only please): ");
        // 5551112234
        String rawPhone = in.next();
        
        String areaCode = "(" + rawPhone.substring(0,3) + ")";
        String prefix = " " + rawPhone.substring(3,6) + "-";
        String suffix = rawPhone.substring(6);
        String prettyPhone = areaCode + prefix + suffix;
        
        System.out.print("Your phone number is " + prettyPhone);
    }
}
