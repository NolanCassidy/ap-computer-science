public class Board implements Grid
{
	private Square[][] board;
	int size, selectedRow = 1, selectedCol = 1;
	
	public Board(int size)
	{
		this.size = size;
		board = new Square[size][size];
	}
	
	public void initialize()
	{
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
			{
				board[i][j] = new Square(size);
				board[i][j].initialize();
			}
	}
	
	public void printBoard()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int k = 0; k < size; k++)
			{
				System.out.print(" " + board[i][0].getRow(k) + " | " + board[i][1].getRow(k) 
							+ " | " + board[i][2].getRow(k) + "\n");
				
				if (k < size - 1)
					System.out.println(" ---+---+--- | ---+---+--- | ---+---+---");
			}
			
			if (i < board.length - 1)
				System.out.println(" ------------+-------------+------------");
		}
		
		String temp = "";
		
		if (selectedRow == 0)
			temp += "TOP ";
		else if (selectedRow == 1)
			temp += "CENTER ";
		else if (selectedRow == 2)
			temp += "BOTTOM ";
		
		if (selectedCol == 0)
			temp += "LEFT";
		else if (selectedCol == 1)
			temp += "CENTER";
		else if (selectedCol == 2)
			temp += "RIGHT";
		
		if (temp.equals("CENTER CENTER"))
			temp = "CENTER";
		
		System.out.print("\nSELECTED SQUARE: " + temp + "\n\n");
	}

	public char winner()
	{
		int tempCount;
		
		// Check first diagonal
		if (board[0][0].winner() == 'x' && board[1][1].winner() == 'x' && board[2][2].winner() == 'x')
			return 'x';
		else if (board[0][0].winner() == 'o' && board[1][1].winner() == 'o' && board[2][2].winner() == 'o')
			return 'o';
		
		// Check second diagonal
		if (board[2][0].winner() == 'x' && board[1][1].winner() == 'x' && board[0][2].winner() == 'x')
			return 'x';
		else if (board[2][0].winner() == 'o' && board[1][1].winner() == 'o' && board[0][2].winner() == 'o')
			return 'o';
		
		// Check rows
		for (int i = 0; i < board.length; i++)
		{
			tempCount = 0;
			for (int j = 0; j < board[i].length - 1; j++)
			{
				if (board[i][j].winner() == board[i][j+1].winner())
					tempCount++;
			}
			if (tempCount == board[i].length - 1)
				return board[i][0].winner();
		}
		
		// Check rows
		for (int i = 0; i < board[0].length; i++)
		{
			tempCount = 0;
			for (int j = 0; j < board.length - 1; j++)
			{
				if (board[j][i].winner() == board[j+1][i].winner())
					tempCount++;
			}
			if (tempCount == board[i].length - 1)
				return board[0][i].winner();
		}
		
		return ' ';
	}
	
	public void setSelectedSquare(int row, int col)
	{
		selectedRow = row;
		selectedCol = col;
	}

	public void setBox(int row, int column, char player)
	{
		board[selectedRow][selectedCol].setBox(row, column, player);
	}
}