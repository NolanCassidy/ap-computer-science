import java.util.Scanner;

public class CheckPackage
{
	int side1, side2, side3, weight, length, girth;
	boolean large = false;
	boolean heavy = false;

	public CheckPackage()
	{
	}

	public void GetPackageInfo()
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the side #1 length in inches: ");
		side1 = Integer.valueOf(input.nextLine());

		System.out.print("Enter the side #2 length in inches: ");
		side2 = Integer.valueOf(input.nextLine());

		System.out.print("Enter the side #3 length in inches: ");
		side3 = Integer.valueOf(input.nextLine());

		System.out.print("Enter the package weight: ");
		weight = Integer.valueOf(input.nextLine());
	}

	public void DisplayResults()
	{
		if (side1 > side2 && side1 > side3)
		{
			length = side1;
			girth = (side2 + side3) * 2;
		}
		if (side2 > side1 && side2 > side3)
		{
			length = side2;
			girth = (side1 + side3) * 2;
		}
		if (side3 > side1 && side3 > side2)
		{
			length = side3;
			girth = (side1 + side2) * 2;
		}

		if (length + girth > 100)
			large = true;
		else
			large = false;

		if (weight > 70)
			heavy = true;
		else
			heavy = false;
		
		System.out.println();
		
		System.out.println("Package weight: " + weight);
		System.out.println("Package length: " + length);
		System.out.println("Package girth:  " + girth);
		System.out.println();
		
		
		if (!large && !heavy)
			System.out.println("The package is acceptable.");
		if (!large && heavy)
			System.out.println("The package is too heavy.");
		if (large && !heavy)
			System.out.println("The package is too large.");
		if (large && heavy)
			System.out.println("The package is to large and too heavy.");
	}
}
