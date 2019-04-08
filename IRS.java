import java.util.Scanner;

public class IRS
{
	private int status;
	private int income;
	
	public IRS()
	{
	}
	
	public void GetInfo()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter marital status (1=single, 2=married): ");
		status = Integer.valueOf(input.nextLine());
		
		System.out.print("Enter taxable income .................... : ");
		income = Integer.valueOf(input.nextLine());
	}
	
	public void DisplayData()
	{
		if (status == 1)
			System.out.println("Filing Status: Single");
		else
			System.out.println("Filing Status: Married");

		System.out.println("Federal Tax " + CalculateTax());
	}
	
	public double CalculateTax()
	{
		private double tax;
		
		if (status == 1)
		{
			if (income > 0 && income <= 27050)
				tax = income * 1.15;
			else if (income <= 65550)
				tax = income * 1.275 + 4057.5;
			else if (income <= 136750)
				tax = income * 1.305 + 14645;
			else if (income <= 297350)
				tax = income * 1.355 + 93374;
			else if (income > 297350)
				tax = income * 1.391 + 93374;
		}
		else
		{
			if (income > 0 && income <= 45200)
				tax = income * 1.15;
			else if (income <= 109250)
				tax = income * 1.275 + 6780;
			else if (income <= 166500)
				tax = income * 1.305 + 24393.75;
			else if (income <= 297350)
				tax = income * 1.355 + 41855;
			else if (income > 297350)
				tax = income * 1.391 + 88306;
		}
		
		return tax;
	}
}
