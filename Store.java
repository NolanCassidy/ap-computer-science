// Nolan Cassidy
// Store.java

import java.util.*;
import java.io.*;

public class Store
{
	private ArrayList<Item> myStore = new ArrayList<Item>();

	private boolean badFile = false;

	public Store(String fName)
	{
		LoadFile(fName);
	}

	public Store()
	{
		this("file50.txt");
	}

	private void LoadFile(String inFileName)
	{
		int id = 0;
		int inv = 0;
		int mandingo;
		String line;

		try
		{
			Scanner fileScanner = new Scanner(new File(inFileName));

			while (fileScanner.hasNext())
			{
				mandingo = 0;
				line = fileScanner.nextLine().trim();

				while (line.charAt(mandingo) != ' ')
					mandingo++;
				id = Integer.valueOf(line.substring(0, mandingo));

				while (line.charAt(mandingo) == ' ')
					mandingo++;
				inv = Integer.valueOf(line.substring(mandingo, line.length()));

				myStore.add(new Item(id, inv));
			}

			if (myStore.size() == 0)
			{
				System.out.print("File " + inFileName + " is empty.");
				badFile = true;
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File " + inFileName + " not found.");
			badFile = true;
		}
	}

	public void DisplayStore()
	{
		if (badFile)
			return;

		Mergesort(myStore, 0, myStore.size() - 1);

		for (int i = 0; i < myStore.size(); i++)
		{
			if (i % 10 == 0)
				System.out.println();

			if (i == 0)
			{
				System.out.printf("%12s %6s", "ID", "INV");
				System.out.printf("%n%12s %6s", "--", "---");
				System.out.println();
			}

			System.out.printf("%2s %9s %6s", i + 1, myStore.get(i).getId(), myStore.get(i).getInv());
			System.out.println();
		}
	}

	private void Merge(ArrayList<Item> list, int first, int mid, int last)
	{
		int a = first;
		int b = mid + 1;
		int c = first;
		int total = last - first + 1;
		ArrayList<Item> newList = new ArrayList(list);

		for (int i = 1; i <= total; i++)
		{
			if (a > mid)
				newList.set(c, list.get(b++));
			else if (b > last)
				newList.set(c, list.get(a++));
			else if (list.get(a).compareTo(list.get(b)) < 0)
				newList.set(c, list.get(a++));
			else
				newList.set(c, list.get(b++));
			c++;
		}

		for (int j = 0; j < newList.size(); j++)
			list.set(j, newList.get(j));
	}

	private void Mergesort(ArrayList<Item> list, int first, int last)
	{
		int mid;

		if (first != last)
			if ((first + 1) == last)
			{
				if (list.get(first).compareTo(list.get(last)) > 0)
					Swap(list, (first), (last));
			}
			else
			{
				mid = (first + last) / 2;
				Mergesort(list, first, mid);
				Mergesort(list, mid + 1, last);
				Merge(list, first, mid, last);
			}
	}

	private void Swap(ArrayList<Item> list, int spotA, int spotB)
	{
		Item temp = list.get(spotB);
		list.set(spotB, list.get(spotA));
		list.set(spotA, temp);
	}

	public void ItemSearch()
	{
		Scanner input = new Scanner(System.in);
		int desiredId = 0;
		String desiredIdString = "";

		if (badFile)
			return;

		do
		{
			System.out.print("\nEnter the ID of the item to find (ENTER by itself to quit): ");
			desiredIdString = input.nextLine();
			if (!desiredIdString.equals(""))
			{
				desiredId = Integer.valueOf(desiredIdString);

				int position = BinarySearch(new Item(desiredId, 0), 0, myStore.size() - 1);

				if (position == -1)
					System.out.println("ID # " + desiredId + ": No such part in stock");
				else
					System.out.println(myStore.get(position));
			}
		} while (!desiredIdString.equals(""));
	}

	private int BinarySearch(Item idToSearch, int first, int last)
	{
		if (first > last)
			return -1;

		int middle = (first + last) / 2;

		if (idToSearch.compareTo(myStore.get(middle)) > 0)
			return BinarySearch(idToSearch, middle + 1, last);
		else if (idToSearch.compareTo(myStore.get(middle)) < 0)
			return BinarySearch(idToSearch, first, middle - 1);
		else
			return middle;
	}
}
