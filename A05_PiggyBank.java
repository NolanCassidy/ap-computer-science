public class A05_PiggyBank
{
	public static void main(String[] args)
	{
		PiggyBank bank1 = new PiggyBank();
		System.out.println("There are " + bank1.GetNumPennies() + " pennies in the first bank.");
		System.out.println("The total value of the first bank is: " + bank1.GetTotalValue());
		bank1.AddCoins(2, 4, 5, 9);
		System.out.println("\nThere are " + bank1.GetNumPennies() + " pennies in the first bank.");
		System.out.println("There are " + bank1.GetNumNickels() + " nickels in the first bank.");
		System.out.println("There are " + bank1.GetNumDimes() + " dimes in the first bank.");
		System.out.println("There are " + bank1.GetNumQuarters() + " quarters in the first bank.");
		System.out.println("The total value of the first bank is: " + bank1.GetTotalValue());
		PiggyBank bank2 = new PiggyBank(4, 7, 0, 18);
		bank2.SetNumNickels(5);
		bank2.SetNumDimes(3);
		System.out.println("\nThere are " + bank2.GetNumNickels() + " nickels in the second bank.");
		System.out.println("There are " + bank2.GetNumDimes() + " dimes in the second bank.");
		System.out.println("The total value of the second bank is: " + bank2.GetTotalValue());
		bank2.AddCoins(2, 4, 5, 9);
		System.out.println("\nThere are " + bank2.GetNumPennies() + " pennies in the second bank.");
		System.out.println("There are " + bank2.GetNumQuarters() + " quarters in the second bank.");
		System.out.println("The total value of the second bank is: " + bank2.GetTotalValue());
	}
}