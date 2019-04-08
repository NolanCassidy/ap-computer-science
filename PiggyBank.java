import java.text.DecimalFormat;

public class PiggyBank
{
	DecimalFormat df = new DecimalFormat("$#, ##0.00");
	int pennies, nickels, dimes, quarters;
	
	public PiggyBank()
	{
		pennies = 0;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}
	
	public PiggyBank(int startQuarters, int startDimes, int startNickels, int startPennies)
	{
		quarters = startQuarters;
		dimes = startDimes;
		nickels = startNickels;
		pennies = startPennies;
	}
	
	public void AddCoins(int startQuarters, int startDimes, int startNickels, int startPennies)
	{
		quarters += startQuarters;
		dimes += startDimes;
		nickels += startNickels;
		pennies += startPennies;
	}
	
	public void SetNumPennies(int setPennies)
	{
		pennies = setPennies;
	}
	
	public void SetNumNickels(int setNickels)
	{
		nickels = setNickels;
	}
	
	public void SetNumDimes(int setDimes)
	{
		dimes = setDimes;
	}
	
	public void SetNumQuarters(int setQuarters)
	{
		quarters = setQuarters;
	}
	
	public int GetNumPennies()
	{
		return pennies;
	}
	
	public int GetNumNickels()
	{
		return nickels;
	}
	
	public int GetNumDimes()
	{
		return dimes;
	}
	
	public int GetNumQuarters()
	{
		return quarters;
	}
	
	public String GetTotalValue()
	{
		return df.format(pennies * .01 + nickels * .05 + dimes * .1 + quarters * .25);
	}
}
