import java.util.Scanner;


public class TicTacToe
{
	private Board grid;
	private final int SIZE = 3;
	private int row, col;
	private char currentPlayer = 'x', winner;
	
	public static void main(String[] args)
	{
		new TicTacToe();
	}
	
	public TicTacToe()
	{
		System.out.println("Welcome to Ultimate Tic Tac Toe!\n\n");
	
	   grid = new Board(SIZE);
		grid.initialize();
		
		while (!threeInARow())
		{
			grid.printBoard();
			System.out.println("Player " + currentPlayer + "\'s turn: \n");
			getInput(currentPlayer);
			grid.setBox(row, col, currentPlayer);
			grid.setSelectedSquare(row, col);
			
			if (currentPlayer == 'x')
				currentPlayer = 'o';
			else
				currentPlayer = 'x';
		}
		
		System.out.println("\nGet a life, scrub.");
	}
	
	private void getInput(char current)
	{
		Scanner temp = new Scanner(System.in);
		String input = "";
		boolean badInput;
		int tempIndex = 0;
		
		do
		{
			badInput = false;
			System.out.print("Enter coordinates in the format \"row, column\": ");
			input = temp.nextLine();	
			
			try
			{
				tempIndex = input.indexOf(",");
				row = Integer.parseInt(input.substring(0, tempIndex));
				col = Integer.parseInt(input.substring(tempIndex + 2));
			}
			catch (NumberFormatException e)
			{
				System.out.println("Please contact your local State Farm Agent");
				badInput = true;
			}
		} while ((row < 0 || row > SIZE - 1) || (col < 0 || col > SIZE - 1) || badInput || tempIndex < 0);
	}
	
	private boolean threeInARow()
	{
		winner = grid.winner();
		
		System.out.println(winner);
			
		return (winner == 'x' || winner == 'o');
	}
}
