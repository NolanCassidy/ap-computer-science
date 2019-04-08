public class Square implements Grid
{
	private char[][] square;
	
	public Square(int size)
	{
		square = new char[size][size];
	}
	
	public void initialize()
	{
		for (int i = 0; i < square.length; i++)
			for (int j = 0; j < square[i].length; j++)
				square[i][j] = ' ';
	}
	
	public String getRow(int row)
	{
		String line = "";
		
		for (int i = 0; i < square[row].length; i++)
		{
			if (i < square[row].length - 1)
				line += " " + square[row][i] + " |";
			else
				line += " " + square[row][i] + " ";
		}
		
		return line;
	}
	
	public char winner()
	{
		int tempCount;
		
		// Check first diagonal
		if (square[0][0] == 'x' && square[1][1] == 'x' && square[2][2] == 'x')
			return 'x';
		else if (square[0][0] == 'o' && square[1][1] == 'o' && square[2][2] == 'o')
			return 'o';
		
		// Check second diagonal
		if (square[2][0] == 'x' && square[1][1] == 'x' && square[0][2] == 'x')
			return 'x';
		else if (square[2][0] == 'o' && square[1][1] == 'o' && square[0][2] == 'o')
			return 'o';
		
		// Check rows
		for (int i = 0; i < square.length; i++)
		{
			tempCount = 0;
			for (int j = 0; j < square[i].length - 1; j++)
			{
				if (square[i][j] == square[i][j+1])
					tempCount++;
			}
			if (tempCount == square[i].length - 1)
				return square[i][0];
		}
		
		// Check rows
		for (int i = 0; i < square[0].length; i++)
		{
			tempCount = 0;
			for (int j = 0; j < square.length - 1; j++)
			{
				if (square[j][i] == square[j+1][i])
					tempCount++;
			}
			if (tempCount == square[i].length - 1)
				return square[0][i];
		}
		
		return ' ';
	}
	
	public void setBox(int row, int column, char player)
	{
		square[row][column] = player;
	}
}