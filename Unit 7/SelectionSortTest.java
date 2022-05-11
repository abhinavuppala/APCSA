
/**
 * Write a description of class SelectionSortTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SelectionSortTest
{
    public static void main(String[] args)
    {
        int[] a = {9, 7, 3, 5, 4, 2, 1, 8, 6, 0};
        
        System.out.println("-----------------\nUnsorted Array: ");
        SelectionSort.printArray(a);
        
        System.out.println();
        SelectionSort.sort(a);
        
        System.out.println("-----------------\nSorted Array: ");
        SelectionSort.printArray(a);
    }
}
