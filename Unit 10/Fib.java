// ******************************************************************
// Fib.java
//
// A utility class that provide methods to compute elements of the
// Fibonacci sequence.
// ******************************************************************
public class Fib
{
    public static int printStatements; // static variable to count total print statements during execution
    
    //--------------------------------------------------------------
    // Recursively computes fib(n)
    // PRECONDITION: n >= 0
    //--------------------------------------------------------------
    public static int fib1(int n)
    {
        printStatements++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib1(n-1) + fib1(n-2);
    }
    
    public static int fib2(int n)
    {
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        System.out.print("["+a[0]+","+a[1]);
        for (int i = 2; i < a.length; i++)
        {
            a[i] = a[i-1] + a[i-2];
            System.out.print(","+a[i]);
        }
        System.out.println("]");
        return a[a.length - 1];
    }
}