
/**
 * Write a description of class GrayImageTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GrayImageTest
{
    public static void main (String[] args)
    {
        int[ ][ ] values = { {221, 184, 178, 84, 135},
                            {84, 255, 255, 130, 84},
                            {78, 255, 0, 0, 78},
                            {84, 130, 255, 130, 84} };
        // Create an instatance of GrayImage Class
        GrayImage gi = new GrayImage(values);
        //Print out the number of white pixels.
        System.out.println("The number of WHITE pixels is: " + gi.countWhitePixels() + "\n----------------------------------");
        //Print out the number of gray pixels.
        System.out.println("The number of GRAY pixels is: " + gi.countGrayPixels() + "\n----------------------------------");
        //Print out the original 2D array before any changes have been made.
        System.out.println("The value of the pixels in the array before processImage():");
        gi.printValues();
        System.out.println("----------------------------------");
        //Change the values of the pixel array according instructions in the lab manual.
        gi.processImage();
        //Print out the entire 2D array after the changes have been made.
        System.out.println("The value of the pixels in the array after processImage():");
        gi.printValues();
        System.out.println("----------------------------------");
    }
}
