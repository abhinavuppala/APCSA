public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;
    /** The 2-dimensional representation of this image.
    * Guaranteed not to be null.
    * All values in the array are within the range
    * [BLACK, WHITE], inclusive.
    */
   
    private int[ ][ ] pixelValues;
    /** constructor that takes a 2D array */
    public GrayImage(int [ ][ ] theArray)
    {
        pixelValues = theArray;
    }
    /** @return the total number of white pixels in
    * this image.
    * Postcondition: this image has not been changed.
    */
    public int countWhitePixels()
    {
        int count = 0;
        
        /*Use Nested Enhanced For ... Loops */
        for (int[] row: pixelValues)
        {
            for (int item: row)
            {
                if (item == WHITE)
                {
                    count++;
                }
            }
        }
        
        return count;
    }
    /**
    * Precondition: this image has not been changed.
    * @ return Returns the number of pixels that are not White or Black
    */
    public int countGrayPixels()
    {
        int count = 0;
        
        /*Use Nested Enhanced For ... Loops */
        for (int[] row: pixelValues)
        {
            for (int item: row)
            {
                if (item != WHITE && item != BLACK)
                {
                    count++;
                }
            }
        }
        
        return count;
    }
    /**
    * Precondition: the pixelImage is not NULL.
    * Prints out the 2D array in Row-Major order
    * Each value is seperated by a TAB.
    */
    public void printValues()
    {
        /* Use Nested For Loops that reference the indexes for each cell one at a time. */
        for (int i = 0; i < pixelValues.length; i++)
        {
            for (int j = 0; j < pixelValues[i].length; j++)
            {
                System.out.print(pixelValues[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    
    /**
    * Subtract the value of (r + 2, c + 2) from the cell (r, c) at each cell applicable.
    */
    public void processImage()
    {
    /* code goes here */
    for (int i = 0; i < pixelValues.length - 2; i++)
    {
        for (int j = 0; j < pixelValues[i].length - 2; j++)
        {
            pixelValues[i][j] -= pixelValues[i+2][j+2];
            if (pixelValues[i][j] < BLACK)
                pixelValues[i][j] = BLACK;
        }
    }
    }
}