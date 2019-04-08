import java.util.Scanner;

public class ConnectFour
{
	private static char board[][];
	private static final int BOARD_WIDTH = 7;
	private static final int BOARD_HEIGHT = 6;

	public static void main(String[] args)
	{
		board = new char[BOARD_HEIGHT + 1][BOARD_WIDTH + 1];
		Scanner input = new Scanner(System.in);
		char turn = 'x';
		InitializeBoard();
		DisplayBoard();

		do
		{
			if (DropChecker(turn, GetDropColumn(turn, input)))
				if (turn == 'x')
					turn = 'o';
				else
					turn = 'x';
		} while (!CheckForLineOfFour());

	}

	private static void InitializeBoard()
	{
		for (int row = 1; row <= BOARD_HEIGHT; row++)
			for (int col = 1; col <= BOARD_WIDTH; col++)
				board[row][col] = ' ';
	}

	private static void DisplayBoard()
	{
		for (int row = 1; row <= BOARD_HEIGHT; row++)
		{
			System.out.print("| ");
			for (int col = 1; col <= BOARD_WIDTH; col++)
				System.out.print(board[row][col] + " | ");
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	private static int GetDropColumn(char turn, Scanner input)
	{
		int dropCol = 0;
		String in;

		System.out.print("Player " + turn + "'s turn: In which column would you like to drop a checker (1 - 7)? ");
		in = input.nextLine().toString();

		do
		{
			try
			{
				dropCol = Integer.valueOf(Integer.parseInt(in));
			}
			catch (Exception error)
			{
				System.out.println("ERROR: Invalid Input Data!");
			}

			if (dropCol < 1 || dropCol > BOARD_WIDTH)
			{
				System.out.println("Column # " + in + " does not exist.");
				GetDropColumn(turn, input);
			}
		} while (dropCol < 1 || dropCol > BOARD_WIDTH);

		return dropCol;

		/*
		 * int dropCol = 0;
		boolean exists;

		do
		{
			System.out.print("Player " + turn + "'s turn: In which column would you like to drop a checker (1 - 7)? ");
			String in = input.nextLine().toString();
			
			do
			{
				try
				{
					dropCol = Integer.valueOf(Integer.parseInt(in));
				}
				catch (Exception error)
				{
					System.out.println("ERROR: Invalid Input Data!");
				}
			} while (dropCol < 1 || dropCol > BOARD_WIDTH);
			
			System.out.println("Out Of Do-While");
			
			if (dropCol < 1 || dropCol > BOARD_WIDTH)
			{
				System.out.println("Column # " + in + " does not exist.");
				System.out.println("Exists = false");
				exists = false;
			}
			else
			{
				System.out.println("Exists = true");
				exists = true;
			}
		} while (!exists);

		return dropCol;
		*/
	}

	private static boolean DropChecker(char turn, int dropColumn)
	{
		int i;

		if (board[1][dropColumn] != ' ')
			return false;
		else
		{
			for (i = 1; i <= BOARD_HEIGHT; i++)
				if (board[i][dropColumn] != ' ')
					break;

			board[i - 1][dropColumn] = turn;
			DisplayBoard();

			return true;
		}
	}

	private static boolean CheckForLineOfFour()
	{
		int count;

		// Check for ROW of checkers
		for (int row = 1; row <= BOARD_HEIGHT; row++)
			for (int col = 1; col <= BOARD_WIDTH - 3; col++)
				if (board[row][col] != ' ' && board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3])
					return true;

		for (int col = 1; col <= BOARD_WIDTH; col++)
			for (int row = 1; row <= BOARD_HEIGHT - 3; row++)
				if (board[row][col] != ' ' && board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3])
					return true;
		
		return false;
	}
}