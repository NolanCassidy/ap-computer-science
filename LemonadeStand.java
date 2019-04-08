import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LemonadeStand
{
	private String myStandOwner;
	private int myNumServings;
	private double myTillValue = 0;
	private double mySellingPrice;
	// Set the format for displaying currency
	private NumberFormat Currency = new DecimalFormat("#,##0.00");

	// Constructor #1 (stand owner, selling price, and number of servings available)
	public LemonadeStand(String standOwner, double sellingPrice, int numServings)
 {
		myStandOwner = standOwner;
		mySellingPrice = sellingPrice;
		myNumServings = numServings;
 }

	// Constructor #2 (stand owner and selling price only, default of 250 servings)
	public LemonadeStand(String standOwner, double sellingPrice)
 {
		myStandOwner = standOwner;
		mySellingPrice = sellingPrice;
		myNumServings = 250;
		
		System.out.println("A lemonade stand has been set up for " + myStandOwner + " with " + myNumServings + " servings and a selling price of " + myNumServings + ".")
 }

	// This private method is available only to other methods in this class 
	private void DisplayStandData()
	{
		System.out.println(myStandOwner + "'s stand" + " now has a till value of $" + Currency.format(myTillValue)
					+ " and has " + myNumServings + " servings of lemonade left.");
	}

	public String GetOwnerName()
 {
		return myStandOwner;
 }

	public String GetTillValue()
 {
		
 }

	public void SellServings(int numToSell)
 {
		myNumServings -= numToSell;
 }
}