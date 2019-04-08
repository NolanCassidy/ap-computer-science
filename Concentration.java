import java.util.Scanner;

public class Concentration
{
	static int size;
	static boolean again;
	static Scanner input = new Scanner(System.in);
	static Board board;

	public static void main(String[] args)
	{
		do
		{
			size = GetSize();
			board = new Board(size);
			board.Initialize();
			board.Display();
			Play();
		} while (again());
	}

	public static void Play()
	{
		int row1, col1, row2, col2, found = 0, tries = 1;

		do
		{
			do
			{
				row1 = getRow();
				col1 = getCol();
			} while (board.temp[row1][col1].up);
			board.temp[row1][col1].Flip();
			board.Display();

			do
			{
				row2 = getRow();
				col2 = getCol();
			} while (board.temp[row2][col2].up);
			board.temp[row2][col2].Flip();

			if (board.temp[row1][col1].toString() == (board.temp[row2][col2].toString()))
			{
				board.temp[row1][col1].Found();
				board.temp[row2][col2].Found();
				board.Display();
				found++;
			}
			else
			{
				board.Display();
				board.temp[row1][col1].Flip();
				board.temp[row2][col2].Flip();
			}

			System.out.println("Found: " + found + "\nTries: " + tries++);

		} while (found < (size * size) / 2);

	}

	public static int GetSize()
	{
		int size;

		do
			size = returnInt("Enter the size of the game board (2, 4, or 6): ");
		while (size != 2 && size != 4 && size != 6);

		return size;
	}

	public static int getRow()
	{
		int row;

		do
			row = returnInt("Enter a row: ");
		while (row < 1 || row > size);

		return row + 1;
	}

	public static int getCol()
	{
		int col;

		do
			col = returnInt("Enter a column: ");
		while (col < 1 || col > size);

		return col + 1;
	}

	public static boolean again()
	{
		String in;

		do
		{
			System.out.print("Would you like to play again? ");
			in = input.next();
		} while (!in.equals("n") && !in.equals("no") && !in.equals("y") && !in.equals("yes"));

		if (in.equals("y") || in.equals("yes"))
			return true;
		else
			return false;
	}

	public static int returnInt(String declare)
	{
		System.out.print(declare);

		Scanner intIn = new Scanner(System.in);
		int num;
		String in = intIn.nextLine();

		try
		{
			num = Integer.parseInt(in);
			return num;
		}
		catch (NumberFormatException e)
		{
			return -1;
		}
	}
}