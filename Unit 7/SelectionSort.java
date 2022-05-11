// Java program for implementation of Selection Sort
public class SelectionSort
{
    //Sorts the array from smallest to largest order.
    public static void sort(int a[])
    {
        // One by one move thru the array
        // Find the minimum element in unsorted array
        // Swap the found minimum element with the first element
        
        for (int i = 0; i < a.length - 1; i++) // iterating through different starting indices
        {
            int minIndex = i;
            for (int j = minIndex + 1; j < a.length; j++) // looking for the min value
            {
                if (a[minIndex] > a[j]) // this if statement runs until eventually min value is at the specified index i
                {
                    // swap the two values
                    int temp = a[j];
                    a[j] = a[minIndex];
                    a[minIndex] = temp;
                }
            }
        }
        
    }
    
    public static void printArray(int a[])
    {
        System.out.print("{");
        for (int i = 0; i < a.length-1; i++)
        {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length-1] + "}");
    }
}