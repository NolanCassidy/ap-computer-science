import java.util.Scanner;

public class A08_IRS
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		IRS tax = new IRS();
		String again = "";
		do
		{
			tax.GetInfo();
			tax.DisplayData();
			System.out.print("\nCalculate tax for someone else (y/n)? ");
			again = input.nextLine();
		} while (again.toLowerCase().equals("y"));
		input.close();
	}
}
/*
Enter marital status (1=single, 2=married): 1
Enter taxable income: 72475
Filing Status: Single
Federal Tax: $16,757.12
Calculate tax for someone else (y/n)? y
Enter marital status (1=single, 2=married): 2
Enter taxable income: 72475
Filing Status: Married
Federal Tax: $14,280.62
Calculate tax for someone else (y/n)? Y
Enter marital status (1=single, 2=married): 1
Enter taxable income: 12200
Filing Status: Single
Federal Tax: $1,830.00
Calculate tax for someone else (y/n)? y
Enter marital status (1=single, 2=married): 2
Enter taxable income: 340000
Filing Status: Married
Federal Tax: $104,982.15
Calculate tax for someone else (y/n)? n
*/