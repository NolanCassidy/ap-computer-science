public class Practice_Quiz_04
{
	public static void main(String[] args)
	{
		// Set up a stand for Betty with a selling price of $5.00 and 400 servings
		LemonadeStand stand1 = new LemonadeStand("Betty", 5.00, 400);
		// Set up a stand for Martin with a selling price of $8.75
		LemonadeStand stand2 = new LemonadeStand("Martin", 8.75);
		// Sell 5 cups of lemonade from Martin's stand
		stand2.SellServings(5);
		// Sell 24 cups of lemonade from Betty's stand
		stand1.SellServings(24);
		// Sell 352 cups of lemonade from Betty's stand
		stand1.SellServings(352);
		// Display the owner's name for 'stand1'
		System.out.println("The owner of 'stand1' is: " + stand1.GetOwnerName());
		// Display the current till value for 'stand2'
		System.out.println("The current till value for 'stand2' is: " + stand2.GetTillValue());
		// Try to sell 25 cups of lemonade from Betty's stand
		stand1.SellServings(25);
	}
}
/*
A lemonade stand has been set up for Betty with 400 servings and a selling price of $5.00.
A lemonade stand has been set up for Martin with 250 servings and a selling price of $8.75.
Martin's stand now has a till value of $43.75 and has 245 servings of lemonade left.
Betty's stand now has a till value of $120.00 and has 376 servings of lemonade left.
Betty's stand now has a till value of $1,880.00 and has 24 servings of lemonade left.
The owner of 'stand1' is: Betty
The current till value for 'stand2' is: $43.75
Not enough servings left to cover the buyer's request!
*/