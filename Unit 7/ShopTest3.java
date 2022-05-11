import java.util.Scanner;

public class ShopTest3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ShoppingCart3 sc = new ShoppingCart3();
        
        String name = "";
        double price;
        int quantity;
        int i = 0;
        
        System.out.println("Welcome to Shopper's Paradise!\n");
        
        while (!name.equalsIgnoreCase("q"))
        {
            if (i == 0)
                System.out.print("Enter the name of the first item: ");
            else
                System.out.print("Enter the name of the next item or type Q to quit: ");
            
            name = scan.next();
            
            if (name.equalsIgnoreCase("q"))
                break;
            
            System.out.print("Enter the quantity: ");
            quantity = scan.nextInt();
            
            System.out.print("Enter the price of each item: ");
            price = scan.nextDouble();
            System.out.println();
            
            sc.addToCart(name, price, quantity);
            System.out.println(sc.toString());
            
            i++;
        }
        
        System.out.println("Please pay $" + sc.getTotalPrice());
    }
}