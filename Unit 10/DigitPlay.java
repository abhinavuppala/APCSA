// *******************************************************************
// DigitPlay.java
//
// Finds the number of digits in a positive integer.
// *******************************************************************
import java.util.Scanner;
public class DigitPlay
{
    public static void main (String[] args)
    {
        int num; //a number
        Scanner scan = new Scanner(System.in);
        System.out.print ("Please enter a positive integer: ");
        num = scan.nextInt ();
        System.out.println ();
        
        if (num <= 0)
            System.out.println ( num + " isn't positive -- start over!!");
        else
        {
            // Call numDigits to find the number of digits in the number
            // Print the number returned from numDigits
            System.out.println ("\nThe number " + num + " contains " +
            + numDigits(num) + " digits, and it's sum is " + sumDigits(num) + ".\n");

        }
        
        // add loop to prompt user for identification numbers to check.
        // use the following id num’s as test data:
        // 3429072 --- error
        // 1800237 --- ok
        // 88231256 --- ok
        // 3180012 --- error
        
        System.out.println("Validating ID Numbers\n-----------------------------");
        System.out.println("Numbers are valid if their sum is divisible by 7. Input -1 to quit the program.");
        while (num != -1)
        {
            num = scan.nextInt();
            
            if (num == -1)
                break;
            else if (num <= 0)
                System.out.println( num + " isn't positive -- try again!!");
            else
            {
                System.out.print(num);
                if (sumDigits(num) % 7 == 0)
                    System.out.println(" --- ok");
                else
                    System.out.println(" --- error");
            }
        }
    }
    
    // -----------------------------------------------------------
    // Recursively counts the digits in a positive integer
    // -----------------------------------------------------------
    public static int numDigits(int num)
    {
        if (num < 10)
            return (1);
        else
            return (1 + numDigits(num/10));
    }
    
    public static int sumDigits(int num)
    {
        if (num < 10)
            return (num % 10);
        else
            return (num % 10 + sumDigits(num/10));
    }
}