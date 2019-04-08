import java.io.*;
import java.util.*;

public class Test2
{
	public A17_18_SortAnalysis()
	{
	}

	public static void main(String args[])
	{
		Start();
	}

	public static void Start()
	{
		String enter = "";
		do
		{
			System.out.println("Welcome to Kevin's Super Duper Incredible Uber-Amazing Awe-Inspiring Sorting Program!");
			System.out.println("\nChoose the source for your sort data: ");
			System.out.println("1> Disk Text File");
			System.out.println("2> Enter Data Manually");
			System.out.println("3> Computer Populates List (with Integers)");
			System.out.println("4> QUIT PROGRAM");
			System.out.println("\nEnter Your Choice Here (1-4): ");
			enter = input.nextLine();
		} while (!enter.equals("1") && !enter.equals("2") && !enter.equals("3") && !enter.equals("4"));
		if (enter.equals("1"))
			GetFromDisk();
		else if (enter.equals("2"))
			EnterManually();
		else if (enter.equals("3"))
		{
			ComputerPopulate();
		}
		else
		{
			System.out.println("\nGoodbye!");
			system.exit(0);
		}
	}

	public static void EnterManually() { String element = ""; int num = 1; int tempFileType = 0; try { System.out.println("Enter your own elements (press ENTER by itself to return to the previous menu): "); do { System.out.print((new StringBuilder("\nElement #")).append(num).append(": ").toString()); element = input.nextLine(); if(listComp.size() == 0) finalFileType = integer.parseInt(CheckArray(element)); tempFileType = integer.parseInt(CheckArray(element)); if(tempFileType == finalFileType && !element.equals("")) { if(finalFileType == 0) listComp.add(element); else if(finalFileType == 1) listComp.add(integer.valueOf(integer.parseInt(element))); else listComp.add(double.valueOf(double.parseDouble(element))); } else if(!element.equals("") && tempFileType != finalFileType) { System.out.println("Invalid Data Entry... Please Enter a New Value with the Correct File Type."); num--; } num++; } while(!element.equals("")); if(listComp.size() - 1 == 0) { System.out.println(); Start(); } else { ChooseSort(); } } catch(numberformatexception e) { System.out.println(e.getMessage()); } }	public static void ComputerPopulate()
	{
		random random = new random();
		System.out
					.println("\nHow many unique positive integers should the computer randomly place in the list to be sorted (press ENTER by itself or type '0' to return to the previous menu)? ");
		try
		{
			String element = input.nextLine();
			if (!element.equals("") && !element.equals("0"))
			{
				arraylist newList = new arraylist();
				for (int i = 1; i <= integer.parseInt(element); i++)
					newList.add(integer.valueOf(i));
				for (int j = 1; j <= integer.parseInt(element); j++)
					listComp.add((comparable) newList.remove(random.nextInt(newList.size())));
				ChooseSort();
			}
			else
			{
				System.out.println();
				Start();
			}
		}
		catch (exception e)
		{
			System.out.println("\nINVALID ENTRY. RETURNING TO MAIN MENU...");
			System.out.println();
			Start();
		}
	}

	public static void GetFromDisk() { boolean badFilename = false; boolean inputError = false; do { System.out.println("\nEnter the name of the disk text file containing elements to be added to the list (press ENTER by itself to return to the previous menu): "); String fileName = input.nextLine(); if(!fileName.equals("")) try { for(Scanner inputFile = new Scanner(new file(fileName)); inputFile.hasNext();) { String element = inputFile.next(); if(listComp.size() == 0) finalFileType = integer.parseInt(CheckArray(element)); try { if(finalFileType == 1) listComp.add(integer.valueOf(integer.parseInt(element))); else if(finalFileType == 2) listComp.add(double.valueOf(double.parseDouble(element))); else listComp.add(element); } catch(exception e) { inputError = true; } }   } catch(ioexception error) { badFilename = true; System.out.println("\nERROR: The disk text file cannot be found."); } else Start(); } while(badFilename); if(inputError) { System.out.println("\nNOTE: Some data with an INVALID FILE TYPE in the file was skipped over."); ChooseSort(); } else { ChooseSort(); } }	public static String CheckArray(String element) { try { integer.parseInt(element); } catch(numberformatexception localNumberFormatException) { try { double.parseDouble(element); } catch(numberformatexception numberformatexception) { return "0"; } return "2"; } return "1"; }	public static void ChooseSort()
	{
		arraylist original = new arraylist(listComp);
		for (int userInput1 = 0; userInput1 != 6;)
		{
			swaps = 0;
			steps = 0;
			while (userInput1 < 1 || userInput1 > 6)
				try
				{
					System.out.println("\nChoose which type of sort you would like to use:");
					System.out.println(" 1) Bubble Sort");
					System.out.println(" 2) Selection Sort");
					System.out.println(" 3) Insertion Sort");
					System.out.println(" 4) Quicksort");
					System.out.println(" 5) Mergesort");
					System.out.println(" 6) RETURN TO PREVIOUS MENU");
					System.out.print("\nEnter a choice (1-6): ");
					userInput1 = integer.parseInt(input.nextLine());
				}
				catch (exception exception)
				{
				}
			while (userInput1 != 6 && (userInput2 < 1 || userInput2 > 2))
				try
				{
					System.out.println("\nWould you like to see:");
					System.out.println(" 1) The results of each pass");
					System.out.println(" 2) Just the number of passes");
					System.out.print("\nEnter a choice (1-2): ");
					userInput2 = integer.parseInt(input.nextLine());
				}
				catch (exception exception1)
				{
				}
			if (userInput1 != 6)
			{
				System.out.print((new StringBuilder("\nOriginal List: ")).append(listComp).toString());
				if (userInput2 == 1)
				{
					System.out.print(" Press ENTER to continue...\n");
					input.nextLine();
				}
			}
			if (userInput1 == 1)
				Bubble();
			if (userInput1 == 2)
				Selection();
			if (userInput1 == 3)
				Insertion();
			if (userInput1 == 4)
				Quicksort(0, listComp.size() - 1);
			if (userInput1 == 5)
				Mergesort(0, listComp.size() - 1);
			if (userInput1 == 6)
			{
				System.out.println();
				finalFileType = 0;
				listComp.clear();
				Start();
			}
			if (userInput1 != 6)
			{
				System.out.println((new StringBuilder("\nSorted List: ")).append(listComp).toString());
				System.out.println((new StringBuilder("Number of Swaps: ")).append(swaps).toString());
				System.out.println((new StringBuilder("Number of Steps: ")).append(steps).toString());
				userInput1 = 0;
				userInput2 = 0;
				listComp.clear();
				comparable i;
				for (iterator iterator = original.iterator(); iterator.hasNext(); listComp.add(i))
					i = (comparable) iterator.next();
			}
		}
	}

	public static void Bubble()
	{
		for (int i = listComp.size() - 1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				steps += 3;
				if (((comparable) listComp.get(j)).compareTo(listComp.get(j + 1)) > 0)
				{
					steps += 4;
					swaps++;
					Swap(j, j + 1);
					if (userInput2 == 1)
					{
						System.out.print((new StringBuilder("Revised List: ")).append(listComp).append(" Swapped the '")
									.append(listComp.get(j + 1)).append("' with the '").append(listComp.get(j))
									.append("': Press ENTER...").toString());
						input.nextLine();
					}
				}
			}
		}
	}

	public static void Swap(int spot1, int spot2)
	{
		comparable spot3 = (comparable) listComp.get(spot1);
		listComp.set(spot1, (comparable) listComp.get(spot2));
		listComp.set(spot2, spot3);
	}

	public static void Selection()
	{
		for (int i = listComp.size(); i >= 2; i--)
		{
			int max = 0;
			for (int j = 1; j < i; j++)
			{
				steps += 3;
				if (((comparable) listComp.get(j)).compareTo(listComp.get(max)) > 0)
					max = j;
			}
			steps += 4;
			swaps++;
			Swap(max, i - 1);
			if (userInput2 == 1)
			{
				System.out.print((new StringBuilder("Revised List: ")).append(listComp)
							.append(" Swapped largest unsorted element ('").append(listComp.get(i - 1))
							.append("') into correct spot: Press ENTER...").toString());
				input.nextLine();
			}
		}
	}

	public static void Insertion()
	{
		for (int i = 1; i < listComp.size(); i++)
		{
			steps++;
			comparable hold = (comparable) listComp.get(i);
			int position;
			for (position = i; position > 0 && ((comparable) listComp.get(position - 1)).compareTo(hold) > 0;)
			{
				steps += 4;
				listComp.set(position, (comparable) listComp.get(position - 1));
				position--;
				if (userInput2 == 1)
				{
					System.out.print((new StringBuilder("Revised List: ")).append(listComp).append(" Holding the '")
								.append(hold).append("'; Shifted the '").append(listComp.get(position)).append("' to spot '")
								.append(position + 1).append("': Press ENTER...").toString());
					input.nextLine();
				}
			}
			steps++;
			listComp.set(position, hold);
			if (userInput2 == 1)
			{
				System.out.print((new StringBuilder("Revised List: ")).append(listComp).toString());
				System.out.print((new StringBuilder("Inserted the '")).append(hold).append("' in spot '").append(position)
							.append("': Press ENTER...").toString());
				input.nextLine();
			}
		}
	}

	public static void Quicksort(int first, int last)
	{
		int low = first;
		int middle = (first + last) / 2;
		int high = last;
		comparable midValue = (comparable) listComp.get(middle);
		do
		{
			while (((comparable) listComp.get(low)).compareTo(midValue) < 0)
			{
				steps += 2;
				low++;
			}
			for (; ((comparable) listComp.get(high)).compareTo(midValue) > 0; high--)
				steps += 2;
			steps++;
			if (low <= high)
			{
				steps += 4;
				swaps++;
				Swap(low, high);
				low++;
				high--;
				if (userInput2 == 1)
				{
					System.out.print((new StringBuilder("Revised List: ")).append(listComp).append(" First = '")
								.append(first).append("'; Last = '").append(last).append("': Press ENTER...").toString());
					input.nextLine();
				}
			}
			steps++;
		} while (low < high);
		steps += 2;
		if (high > first)
			Quicksort(first, high);
		if (low < last)
			Quicksort(low, last);
	}

	public static void Merge(int first, int mid, int last)
	{
		int total = (last - first) + 1;
		int a = first;
		int b = mid + 1;
		int c = first;
		arraylist newlistComp = new arraylist(listComp);
		for (int loop = 1; loop <= total; loop++)
		{
			steps++;
			if (a > mid)
			{
				steps += 2;
				newlistComp.set(c, (comparable) listComp.get(b++));
			}
			else
			{
				steps++;
				if (b > last)
				{
					steps += 2;
					newlistComp.set(c, (comparable) listComp.get(a++));
				}
				else
				{
					steps += 3;
					if (((comparable) listComp.get(a)).compareTo(listComp.get(b)) < 0)
					{
						steps += 2;
						newlistComp.set(c, (comparable) listComp.get(a++));
					}
					else
					{
						steps += 2;
						newlistComp.set(c, (comparable) listComp.get(b++));
					}
				}
			}
			c++;
			if (userInput2 == 1)
			{
				System.out.print((new StringBuilder("Revised List: ")).append(newlistComp)
							.append(" Temporary list in Merge: Press ENTER...").toString());
				input.nextLine();
			}
		}
		for (int loop = first; loop <= last; loop++)
		{
			steps += 2;
			listComp.set(loop, (comparable) newlistComp.get(loop));
		}
	}

	public static void Mergesort(int first, int last)
	{
		steps++;
		if (first != last)
			if (first + 1 == last)
			{
				steps += 3;
				if (((comparable) listComp.get(first)).compareTo(listComp.get(last)) > 0)
				{
					steps += 4;
					swaps++;
					Swap(first, last);
					if (userInput2 == 1)
					{
						System.out.print((new StringBuilder("Revised List: ")).append(listComp)
									.append(" Just Swapped: First = '").append(first).append("'; Last = '").append(last)
									.append("': Press ENTER...").toString());
						input.nextLine();
					}
				}
			}
			else
			{
				int mid = (first + last) / 2;
				if (userInput2 == 1)
				{
					System.out.print((new StringBuilder("Revised List: ")).append(listComp)
								.append(" Splitting Left: First = '").append(first).append("'; Mid = '").append(mid)
								.append("'; Last = '").append(last).append("': Press ENTER...").toString());
					input.nextLine();
				}
				Mergesort(first, mid);
				if (userInput2 == 1)
				{
					System.out.print((new StringBuilder("Revised List: ")).append(listComp)
								.append(" Splitting Right: First = '").append(first).append("'; Mid = '").append(mid)
								.append("'; Last = '").append(last).append("': Press ENTER...").toString());
					input.nextLine();
				}
				Mergesort(mid + 1, last);
				if (userInput2 == 1)
				{
					System.out.print((new StringBuilder("Revised List: ")).append(listComp)
								.append(" Calling Merge: First = '").append(first).append("'; Mid = '").append(mid)
								.append("'; Last = '").append(last).append("': Press ENTER...").toString());
					input.nextLine();
				}
				Merge(first, mid, last);
			}
	}

	static Scanner input;
	static int finalFileType = 0;
	static int steps = 0;
	static int swaps = 0;
	static int userInput2 = 0;
	static arraylist listComp = new arraylist();
	static
	{
		input = new Scanner(system.in);
	}
}
