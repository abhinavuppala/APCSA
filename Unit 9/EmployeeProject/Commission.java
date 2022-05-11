
/**
 * Write a description of class Commission here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Commission extends Hourly
{
    // instance variables - replace the example below with your own
    private double sales;
    private double commissionRate;

    /**
     * Constructor for objects of class Commission
     */
    public Commission (String eName, String eAddress, String ePhone, String socSecNumber, double rate, double cRate)
    
    {
        super (eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = cRate;
    }

    public void addSales(double sales)
    {
        this.sales += sales;
    }
    
    public double pay()
    {
        double hPay = super.pay();
        double cPay = sales * commissionRate;
        sales = 0;
        
        return hPay + cPay;
    }
}
