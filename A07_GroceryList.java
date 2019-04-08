import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class A07_GroceryList
{
	static ArrayList<Double> prices = new ArrayList<Double>();
	static DecimalFormat df = new DecimalFormat("#,###.00");
	static double total = 0;

	public static void main(String[] args)
	{
		TakeInput();
		DisplayCosts();
	}

	public static void TakeInput()
	{
		for (int i = 1; i <= 5; i++)
		{
			Scanner input = new Scanner(System.in);

			System.out.print("Enter the cost of item #" + i + ":  ");
			prices.add(input.nextDouble());
		}
	}

	public static void DisplayCosts()
	{
		for (int i = 0; i < 5; i++)
		{
			total = 0;

			if (i == 0)
			{
				System.out.println();
				System.out.println();
				System.out.printf("%11s", "ITEM");
				System.out.printf("%14s", "COST");
				System.out.printf("%15s", "TOTAL");
				System.out.println();
				System.out.printf("%11s", "----");
				System.out.printf("%14s", "----");
				System.out.printf("%15s", "-----");
				System.out.println();
			}

			System.out.printf("%10s", "#" + (i + 1));
			System.out.printf("%15s", "$" + df.format(prices.get(i)));
			for (int j = i; j >= 0; j--)
				total += prices.get(j);
			System.out.printf("%15s", "$" + df.format(total));

			System.out.println();
		}
	}
}