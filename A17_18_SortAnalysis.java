import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A17_18_SortAnalysis
{
	static int resultChoice;
	static int swaps;
	static int steps;
	static String type;

	static ArrayList<Comparable> comparable = new ArrayList<Comparable>();

	public static void main(String[] args)
	{
		System.out.println("SWIGGITY SWAGGITY PROGRAM");

		DiscOrNah();
	}

	public static void DiscOrNah()
	{
		Scanner input = new Scanner(System.in);
		String in = "";

		do
		{
			System.out.println("\nChoose the source for your sort: ");
			System.out.println("   1) Disk text file");
			System.out.println("   2) Enter data manually");
			System.out.println("   3) Computer populates list (with integers)");
			System.out.println("   4) QUIT PROGRAM");
			System.out.print("\nEnter a choice (1-4): ");
			in = input.next().toString();
		} while (!in.equals("1") && !in.equals("2") && !in.equals("3") && !in.equals("4"));

		if (in.equals("1"))
			Disc();
		if (in.equals("2"))
			Manual();
		if (in.equals("3"))
			Random();
		if (in.equals("4"))
			System.out.println("\nYou quit the program dickweed.");
	}

	public static void Disc()
	{
		Scanner input = new Scanner(System.in);
		String fileName = "";

		System.out.println("\nEnter the name of the disc text file containing elements to be added"
					+ "\nto the list <press ENTER by itself to return to the previous menu>: ");
		fileName = input.next();

		if (fileName.equals(""))
			DiscOrNah();
		else
		{
			try
			{
				Scanner fileScanner = new Scanner(new File(fileName));

				while (fileScanner.hasNextInt())
					comparable.add(fileScanner.nextInt());
			}
			catch (FileNotFoundException e)
			{
				System.out.println("\nERROR: The disc text file cannot be found or read.");
				Disc();
			}

			ChooseSort();
		}
	}

	public static void Manual()
	{
		Scanner input = new Scanner(System.in);
		String in = "";
		int i = 1;

		System.out.println("\nEnter your own elements <press ENTER by itself to return to the previous menu>:");

		do
		{
			System.out.print("   Element #" + i + ": ");
			in = input.nextLine().toString();
			if (i == 1)
				Type(in);

			if (!in.equals(""))
				try
				{
					if (type.equals("integer"))
						comparable.add(Integer.valueOf(Integer.parseInt(in)));
					else if (type.equals("double"))
						comparable.add(Double.valueOf(Double.parseDouble(in)));
					else
						comparable.add(in);
					i++;
				}
				catch (Exception error)
				{
					System.out.println("      Invalid data...please re-enter.");
				}
		} while (!in.equals(""));

		ChooseSort();
	}

	public static void Random()
	{
		Scanner input = new Scanner(System.in);
		int num;
		int random;

		System.out.print("\nHow many unique positive integers should the computer randomly place in the list"
					+ "\nto be sorted <press ENTER by itself or type '0' to return to the previous menu>?");
		try
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			num = Integer.parseInt(input.next());

			for (int k = 1; k <= num; k++)
				temp.add(k);

			for (int i = num; i > 0; i--)
			{
				random = (int) (Math.random() * i);
				comparable.add(temp.get(random));
				temp.remove(random);
			}

			if (num == 0)
				DiscOrNah();

			ChooseSort();
		}
		catch (Exception e)
		{
			System.out.println("Enter an integer, bunghole.");
			Random();
		}
	}

	public static void Type(String variable)
	{
		type = "";

		try
		{
			Integer.parseInt(variable);
			type = "integer";
		}
		catch (NumberFormatException localNumberFormatException)
		{
			try
			{
				Double.parseDouble(variable);
				type = "double";
			}
			catch (NumberFormatException localNumberFormatException1)
			{
				type = "string";
			}
		}
	}

	public static void ChooseSort()
	{
		Scanner input = new Scanner(System.in);
		String in = "";

		do
		{
			System.out.println("\nChoose which type of sort you would like to use:");
			System.out.println("   1) Bubble Sort");
			System.out.println("   2) Selection Sort");
			System.out.println("   3) Insertion Sort");
			System.out.println("   4) Quicksort (recursive)");
			System.out.println("   5) Mergesort (recursive)");
			System.out.println("   6) RETURN TO PREVIOUS MENU");
			System.out.print("\nEnter a choice (1-6): ");
			in = input.next().toString();
		} while (!in.equals("1") && !in.equals("2") && !in.equals("3") && !in.equals("4") && !in.equals("5")
					&& !in.equals("6"));

		if (in.equals("1"))
			Bubble();
		if (in.equals("2"))
			Selection();
		if (in.equals("3"))
			Insertion();
		if (in.equals("4"))
			Quicksort();
		if (in.equals("5"))
			Mergesort(0, comparable.size() - 1);
		if (in.equals("6"))
			DiscOrNah();
	}

	public static void Bubble()
	{
		Scanner input = new Scanner(System.in);

		swaps = 0;
		steps = 0;

		ResultChoice();
		System.out.println("\nOriginal List: " + comparable + "\n");

		for (int i = comparable.size() - 1; i > 0; i--)
			for (int k = 0; k < i; k++)
			{
				steps += 3;
				if ((comparable.get(k)).compareTo(comparable.get(k + 1)) > 0)
				{
					Swap(k, k + 1);
					if (resultChoice == 1)
					{
						System.out.println("Revised List:  " + comparable + "  Swapped " + comparable.get(k) + " with "
									+ comparable.get(k + 1));
						input.nextLine();
					}
				}
			}

		System.out.println("Final List:    " + comparable);
		System.out.println("Swaps: " + swaps);
		System.out.println("Steps: " + steps);
	}

	public static void Selection()
	{
		Scanner input = new Scanner(System.in);

		swaps = 0;
		steps = 0;

		ResultChoice();
		System.out.println("\nOriginal List: " + comparable + "\n");

		for (int i = comparable.size(); i >= 2; i--)
		{
			int max = 0;
			for (int k = 1; k < i; k++)
			{
				steps += 3;
				if (comparable.get(k).compareTo(comparable.get(max)) > 0)
					max = k;
			}
			steps += 4;
			Swap(max, i - 1);
			if (resultChoice == 1)
			{
				System.out.print("Revised List:  " + comparable + "  Swapped largest unsorted element ("
							+ comparable.get(i - 1) + ") to correct spot");
				input.nextLine();
			}
		}

		System.out.println("Final List:    " + comparable);
		System.out.println("Swaps: " + swaps);
		System.out.println("Steps: " + steps);
	}

	public static void Insertion()
	{
		Scanner input = new Scanner(System.in);

		steps = 0;

		ResultChoice();
		System.out.println("\nOriginal List: " + comparable + "\n");

		for (int i = 1; i < comparable.size(); i++)
		{
			steps += 1;
			Comparable hold = comparable.get(i);
			int position = i;

			for (position = i; position > 0 && comparable.get(position - 1).compareTo(hold) > 0;)
			{
				comparable.set(position, comparable.get(position - 1));
				steps += 4;
				position--;

				if (resultChoice == 1)
				{
					System.out.print("Revised List:  " + comparable + "  Hold " + hold + ", Shift "
								+ comparable.get(position) + " to spot " + (position + 2));
					input.nextLine();
				}
			}

			comparable.set(position, hold);
			steps++;

			if (resultChoice == 1)
			{
				System.out.print("Revised List:  " + comparable);
				System.out.print("  Inserted " + hold + " in spot " + (position + 1));
				input.nextLine();
			}
		}

		System.out.println("Final List:    " + comparable);
		System.out.println("Steps: " + steps);
	}

	public static void Quicksort()
	{
		System.out.println("Nope");
		ChooseSort();
	}

	public static void Mergesort(int first, int last)
	{
		Scanner input = new Scanner(System.in);

		swaps = 0;
		steps = 0;

		ResultChoice();
		System.out.println("\nOriginal List: " + comparable + "\n");
		
		steps += 1;
		if (first != last)
		{
			if (first + 1 == last)
			{
				steps += 3;
				if ((comparable.get(first)).compareTo(comparable.get(last)) > 0)
				{
					steps += 4;
					swaps += 1;
					Swap(first, last);
					if (resultChoice == 1)
					{
						System.out.print("Revised List:     " + comparable + "     Just Swapped:  First = '" + first
									+ "'; Last = '" + last + "':  Press ENTER...");
						input.nextLine();
					}
				}
			}
			else
			{
				int mid = (first + last) / 2;
				if (resultChoice == 1)
				{
					System.out.print("Revised List:     " + comparable + "     Splitting Left:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					input.nextLine();
				}
				Mergesort(first, mid);
				if (resultChoice == 1)
				{
					System.out.print("Revised List:     " + comparable + "     Splitting Right:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					input.nextLine();
				}
				Mergesort(mid + 1, last);
				if (resultChoice == 1)
				{
					System.out.print("Revised List:     " + comparable + "     Calling Merge:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					input.nextLine();
				}
				MergeParts(first, mid, last);
			}
		}
		System.out.println(comparable);
	}

	public static void MergeParts(int first, int mid, int last)
	{
		Scanner input = new Scanner(System.in);

		int a = first;
		int b = mid + 1;
		int c = first;
		int total = last - first + 1;
		ArrayList<Comparable> temp = new ArrayList(comparable);
		for (int loop = 1; loop <= total; loop++)
		{
			steps += 1;
			if (a > mid)
			{
				steps += 2;
				temp.set(c, comparable.get(b++));
			}
			else
			{
				steps += 1;
				if (b > last)
				{
					steps += 2;
					temp.set(c, comparable.get(a++));
				}
				else
				{
					steps += 5;
					if ((comparable.get(a)).compareTo(comparable.get(b)) < 0)
						temp.set(c, comparable.get(a++));
					else
						temp.set(c, comparable.get(b++));
				}
			}
			c++;
			if (resultChoice == 1)
			{
				System.out.print("Revised List:     " + temp + "     Temp List in Merge:  Press ENTER...");
				input.nextLine();
			}
		}
		for (int loop = first; loop <= last; loop++)
		{
			steps += 2;
			comparable.set(loop, temp.get(loop));
		}
	}

	public static void Swap(int spotA, int spotB)
	{
		Comparable spotC = comparable.get(spotA);
		comparable.set(spotA, comparable.get(spotB));
		comparable.set(spotB, spotC);
		swaps += 1;
		steps += 4;
	}

	public static void ResultChoice()
	{
		Scanner input = new Scanner(System.in);
		String in = "";

		do
		{
			System.out.println("Would you like to see:");
			System.out.println("   1) The results of each pass");
			System.out.println("   2) Just the number of passes");
			System.out.print("\nEnter a choice (1-2): ");
			in = input.nextLine();
		} while (!in.equals("1") && !in.equals("2"));
		resultChoice = Integer.valueOf(in);
	}
}