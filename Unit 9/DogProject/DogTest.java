// ****************************************************************
// DogTest.java
//
// A simple test class that creates a Dog and makes it speak.
//
// ****************************************************************
public class DogTest
{
    public static void main(String[] args)
    {
        Yorkshire york = new Yorkshire("Bob");
        System.out.println(york.getName() + " says " + york.speak());
        
        Labrador lab = new Labrador("Colt", "Chocolate");
        System.out.println(lab.getName() + " says " + lab.speak());
    }
}