// ******************************************************************
// TestFib.java
//
// A simple driver that uses the Fib class to compute the
// nth element of the Fibonacci sequence.
// ******************************************************************
import java.util.Scanner;
public class TestFib
{
    public static void main(String[] args)
    {
        int n, fib;
        Scanner scan = new Scanner(System.in);
        System.out.println("Remember, 0 is the first term, 1 is the second term, etc.\nof the Fibonacci Sequence.");
        System.out.print("Enter an integer: ");
        n = scan.nextInt();
        
        fib = Fib.fib2(n);
        System.out.println("Fib2(" + n + ") is " + fib);
        
        Fib.printStatements = 0;
        fib = Fib.fib1(n);
        System.out.println("Fib1(" + n + ") is " + fib);
        System.out.println("Total calls: " + Fib.printStatements);
        Fib.printStatements = 0;
    }
}