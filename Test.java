import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test
{
	private static Scanner inputUser = new Scanner(System.in);
	private static int choice0;
	private static int choice1;
	private static int choice2;
	private static int swaps;
	private static int steps;

	public static void main(String[] args)
	{
		ArrayList<Comparable> list = new ArrayList();
		try
		{

			do
			{
				choice0 = 0;
				list.clear();
				ChooseDataSource(list);
				if (list.size() > 0)
				{
					choice1 = 0;
					choice2 = 0;
					ChooseSortType(list);
				}
				else if (choice0 == 4)
				{
					System.out.println("\nGoodbye.");
				}
				else
				{
					System.out.println("\nNo Data Entered!  Goodbye.");
				}
			} while (choice0 != 4);
		}
		catch (Exception error)
		{
			System.out.println("\nBad Input!  Goodbye.");
		}
		finally
		{
			inputUser.close();
		}
	}

	public static void ChooseDataSource(ArrayList<Comparable> list)
	{
		while ((choice0 < 1) || (choice0 > 4) || ((list.size() == 0) && (choice0 != 4)))
		{
			try
			{
				System.out.println("\nChoose the source for your sort data:");
				System.out.println("   1) Disk text file");
				System.out.println("   2) Enter data manually");
				System.out.println("   3) Computer populates list (with integers)");
				System.out.println("   4) QUIT PROGRAM");

				System.out.print("\nEnter a choice (1-4):  ");
				choice0 = Integer.parseInt(inputUser.nextLine());
				if (choice0 == 1)
				{
					GetElementsFromFile(list);
				}
				if (choice0 == 2)
				{
					GetElementsFromUser(list);
				}
				if (choice0 == 3)
				{
					PopulateWithRandomIntegers(list);
				}
			}
			catch (Exception localException)
			{
			}
		}
	}

	public static void GetElementsFromFile(ArrayList<Comparable> list)
	{
		int variableType = 0;
		boolean fileDataError = false;
		boolean badFile;
		do
		{
			badFile = false;
			System.out.println("\nEnter the name of the disk text file containing elements to be added");
			System.out.print("to the list (press ENTER by itself to return to the previous menu):  ");
			String fileName = inputUser.nextLine();
			if (!fileName.equals(""))
			{
				try
				{
					Scanner inputFile = new Scanner(new File(fileName));
					while (inputFile.hasNext())
					{
						String temp = inputFile.next();
						if (list.size() == 0)
						{
							variableType = DetermineElementType(temp);
						}
						try
						{
							if (variableType == 1)
							{
								list.add(Integer.valueOf(Integer.parseInt(temp)));
							}
							else if (variableType == 2)
							{
								list.add(Double.valueOf(Double.parseDouble(temp)));
							}
							else
							{
								list.add(temp);
							}
						}
						catch (Exception error)
						{
							fileDataError = true;
						}
					}
				}
				catch (IOException error)
				{
					badFile = true;
					System.out.println("\nERROR:  The disk text file cannot be found or read.");
				}
			}
		} while (badFile);
		if (fileDataError)
		{
			System.out.println("\nNOTE:  Some invalid data in the disk text file was skipped!");
		}
	}

	public static void GetElementsFromUser(ArrayList<Comparable> list) throws Exception
	{
		int variableType = 0;

		System.out.println("\nEnter your own elements (press ENTER by itself to return to the previous menu):");
		String temp;
		do
		{
			System.out.print("   Element #" + (list.size() + 1) + ":  ");
			temp = inputUser.nextLine();
			if (list.size() == 0)
			{
				variableType = DetermineElementType(temp);
			}
			if (!temp.equals(""))
			{
				try
				{
					if (variableType == 1)
					{
						list.add(Integer.valueOf(Integer.parseInt(temp)));
					}
					else if (variableType == 2)
					{
						list.add(Double.valueOf(Double.parseDouble(temp)));
					}
					else
					{
						list.add(temp);
					}
				}
				catch (Exception error)
				{
					System.out.println("      Invalid data...please re-enter.");
				}
			}
		} while (!temp.equals(""));
	}

	public static void PopulateWithRandomIntegers(ArrayList<Comparable> list) throws Exception
	{
		Random random = new Random();

		System.out.println("\nHow many unique positive integers should the computer randomly place in the list");
		System.out.print("to be sorted (press ENTER by itself or type '0' to return to the previous menu)?  ");
		String temp = inputUser.nextLine();
		if (!temp.equals(""))
		{
			ArrayList<Comparable> orderedList = new ArrayList();
			for (int i = 1; i <= Integer.parseInt(temp); i++)
			{
				orderedList.add(Integer.valueOf(i));
			}
			for (int i = 1; i <= Integer.parseInt(temp); i++)
			{
				list.add((Comparable) orderedList.remove(random.nextInt(orderedList.size())));
			}
		}
	}

	public static void ChooseSortType(ArrayList<Comparable> list)
	{
		ArrayList<Comparable> original = new ArrayList(list);
		while (choice1 != 6)
		{
			swaps = 0;
			steps = 0;
			while ((choice1 < 1) || (choice1 > 6))
			{
				try
				{
					System.out.println("\nChoose which type of sort you would like to use:");
					System.out.println("   1) Bubble Sort");
					System.out.println("   2) Selection Sort");
					System.out.println("   3) Insertion Sort");
					System.out.println("   4) Quicksort (recursive)");
					System.out.println("   5) Mergesort (recursive)");
					System.out.println("   6) RETURN TO PREVIOUS MENU");

					System.out.print("\nEnter a choice (1-6):  ");
					choice1 = Integer.parseInt(inputUser.nextLine());
				}
				catch (Exception localException)
				{
				}
			}
			while (((choice2 < 1) || (choice2 > 2)) && (choice1 != 6))
			{
				try
				{
					System.out.println("\nWould you like to see:");
					System.out.println("   1) The results of each pass");
					System.out.println("   2) Just the number of passes");

					System.out.print("\nEnter a choice (1-2):  ");
					choice2 = Integer.parseInt(inputUser.nextLine());
				}
				catch (Exception localException1)
				{
				}
			}
			if (choice1 != 6)
			{
				System.out.print("\nOriginal List:    " + list);
				if (choice2 == 1)
				{
					System.out.print("     Press ENTER to continue...\n");
					inputUser.nextLine();
				}
			}
			if (choice1 == 1)
			{
				BubbleSort(list);
			}
			if (choice1 == 2)
			{
				SelectionSort(list);
			}
			if (choice1 == 3)
			{
				InsertionSort(list);
			}
			if (choice1 == 4)
			{
				Quicksort(list, 0, list.size() - 1);
			}
			if (choice1 == 5)
			{
				Mergesort(list, 0, list.size() - 1);
			}
			if (choice1 != 6)
			{
				System.out.println("\nSorted List:      " + list);
				System.out.println("Number of Swaps:  " + swaps);
				System.out.println("Number of Steps:  " + steps);

				choice1 = 0;
				choice2 = 0;

				list.clear();
				for (Comparable i : original)
				{
					list.add(i);
				}
			}
		}
	}

	public static int DetermineElementType(String element)
	{
		try
		{
			Integer.parseInt(element);
			return 1;
		}
		catch (NumberFormatException localNumberFormatException)
		{
			try
			{
				Double.parseDouble(element);
				return 2;
			}
			catch (NumberFormatException localNumberFormatException1)
			{
			}
		}
		return 3;
	}

	public static void Swap(ArrayList<Comparable> list, int spotA, int spotB)
	{
		Comparable spotC = (Comparable) list.get(spotA);
		list.set(spotA, (Comparable) list.get(spotB));
		list.set(spotB, spotC);
	}

	public static void BubbleSort(ArrayList<Comparable> list)
	{
		for (int i = list.size() - 1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				steps += 3;
				if (((Comparable) list.get(j)).compareTo(list.get(j + 1)) > 0)
				{
					steps += 4;
					swaps += 1;
					Swap(list, j, j + 1);
					if (choice2 == 1)
					{
						System.out.print("Revised List:     " + list + "     Swapped the '" + list.get(j + 1)
									+ "' with the '" + list.get(j) + "':  Press ENTER...");
						inputUser.nextLine();
					}
				}
			}
		}
	}

	public static void SelectionSort(ArrayList<Comparable> list)
	{
		for (int i = list.size(); i >= 2; i--)
		{
			int max = 0;
			for (int j = 1; j < i; j++)
			{
				steps += 3;
				if (((Comparable) list.get(j)).compareTo(list.get(max)) > 0)
				{
					max = j;
				}
			}
			steps += 4;
			swaps += 1;
			Swap(list, max, i - 1);
			if (choice2 == 1)
			{
				System.out.print("Revised List:     " + list + "     Swapped largest unsorted element ('" + list.get(i - 1)
							+ "') into correct spot:  Press ENTER...");
				inputUser.nextLine();
			}
		}
	}

	public static void InsertionSort(ArrayList<Comparable> list)
	{
		for (int i = 1; i < list.size(); i++)
		{
			steps += 1;
			Comparable hold = (Comparable) list.get(i);
			int position = i;
			while ((position > 0) && (((Comparable) list.get(position - 1)).compareTo(hold) > 0))
			{
				steps += 4;
				list.set(position, (Comparable) list.get(position - 1));
				position--;
				if (choice2 == 1)
				{
					System.out.print("Revised List:     " + list + "     Holding the '" + hold + "'; Shifted the '"
								+ list.get(position) + "' to spot '" + (position + 1) + "':  Press ENTER...");
					inputUser.nextLine();
				}
			}
			steps += 1;
			list.set(position, hold);
			if (choice2 == 1)
			{
				System.out.print("Revised List:     " + list);
				System.out.print("     Inserted the '" + hold + "' in spot '" + position + "':  Press ENTER...");
				inputUser.nextLine();
			}
		}
	}

	public static void Quicksort(ArrayList<Comparable> list, int first, int last)
	{
		int low = first;
		int high = last;
		int midIndex = (first + last) / 2;
		Comparable midValue = (Comparable) list.get(midIndex);
		do
		{
			while (((Comparable) list.get(low)).compareTo(midValue) < 0)
			{
				steps += 2;
				low++;
			}
			while (((Comparable) list.get(high)).compareTo(midValue) > 0)
			{
				steps += 2;
				high--;
			}
			steps += 1;
			if (low <= high)
			{
				steps += 4;
				swaps += 1;
				Swap(list, low, high);
				low++;
				high--;
				if (choice2 == 1)
				{
					System.out.print("Revised List:     " + list + "     First = '" + first + "'; Last = '" + last
								+ "':  Press ENTER...");
					inputUser.nextLine();
				}
			}
			steps += 1;
		} while (

		low < high);
		steps += 2;
		if (high > first)
		{
			Quicksort(list, first, high);
		}
		if (low < last)
		{
			Quicksort(list, low, last);
		}
	}

	public static void Merge(ArrayList<Comparable> list, int first, int mid, int last)
	{
		int a = first;
		int b = mid + 1;
		int c = first;
		int total = last - first + 1;
		ArrayList<Comparable> newList = new ArrayList(list);
		for (int loop = 1; loop <= total; loop++)
		{
			steps += 1;
			if (a > mid)
			{
				steps += 2;
				newList.set(c, (Comparable) list.get(b++));
			}
			else
			{
				steps += 1;
				if (b > last)
				{
					steps += 2;
					newList.set(c, (Comparable) list.get(a++));
				}
				else
				{
					steps += 3;
					if (((Comparable) list.get(a)).compareTo(list.get(b)) < 0)
					{
						steps += 2;
						newList.set(c, (Comparable) list.get(a++));
					}
					else
					{
						steps += 2;
						newList.set(c, (Comparable) list.get(b++));
					}
				}
			}
			c++;
			if (choice2 == 1)
			{
				System.out.print("Revised List:     " + newList + "     Temp List in Merge:  Press ENTER...");
				inputUser.nextLine();
			}
		}
		for (int loop = first; loop <= last; loop++)
		{
			steps += 2;
			list.set(loop, (Comparable) newList.get(loop));
		}
	}

	public static void Mergesort(ArrayList<Comparable> list, int first, int last)
	{
		steps += 1;
		if (first != last)
		{
			if (first + 1 == last)
			{
				steps += 3;
				if (((Comparable) list.get(first)).compareTo(list.get(last)) > 0)
				{
					steps += 4;
					swaps += 1;
					Swap(list, first, last);
					if (choice2 == 1)
					{
						System.out.print("Revised List:     " + list + "     Just Swapped:  First = '" + first
									+ "'; Last = '" + last + "':  Press ENTER...");
						inputUser.nextLine();
					}
				}
			}
			else
			{
				int mid = (first + last) / 2;
				if (choice2 == 1)
				{
					System.out.print("Revised List:     " + list + "     Splitting Left:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					inputUser.nextLine();
				}
				Mergesort(list, first, mid);
				if (choice2 == 1)
				{
					System.out.print("Revised List:     " + list + "     Splitting Right:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					inputUser.nextLine();
				}
				Mergesort(list, mid + 1, last);
				if (choice2 == 1)
				{
					System.out.print("Revised List:     " + list + "     Calling Merge:  First = '" + first + "'; Mid = '"
								+ mid + "'; Last = '" + last + "':  Press ENTER...");
					inputUser.nextLine();
				}
				Merge(list, first, mid, last);
			}
		}
	}
}