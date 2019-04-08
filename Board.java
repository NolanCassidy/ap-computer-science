import java.util.Random;

public class Board
{
	private int size;
	Tile[][] temp;

	public Board(int size)
	{
		this.size = size;
		temp = new Tile[size + 3][size + 3];
	}

	public void Initialize()
	{
		int placed;

		for (int row = 0; row <= temp.length - 1; row++)
			for (int col = 0; col <= temp.length - 1; col++)
				temp[row][col] = new Tile(" ");

		temp[1][1] = new Tile("┌");
		temp[temp.length - 1][temp.length - 1] = new Tile("┘");
		temp[temp.length - 1][1] = new Tile("└");
		temp[1][temp.length - 1] = new Tile("┐");

		for (int i = 2; i <= temp.length - 2; i++)
		{
			temp[0][i] = new Tile(String.valueOf(i - 1));
			temp[i][0] = new Tile(String.valueOf(i - 1));

			temp[1][i] = new Tile("─");
			temp[i][1] = new Tile("│");

			temp[temp.length - 1][i] = new Tile("─");
			temp[i][temp.length - 1] = new Tile("│");
		}

		for (int i = 97; i < ((size * size) / 2) + 97; i++)
		{
			placed = 0;
			String letter = String.valueOf((char) i);

			do
			{
				Random random = new Random();
				int rand1 = random.nextInt(((temp.length - 1) - 2) + 1) + 2;
				int rand2 = random.nextInt(((temp.length - 1) - 2) + 1) + 2;

				if (temp[rand1][rand2].equals(" "))
				{
					temp[rand1][rand2] = new Tile(letter);
					placed++;
				}
			} while (placed < 2);
		}
		
		for (int row = 2; row <= temp.length - 2; row++)
			for (int col = 2; col <= temp.length - 2; col++)
				temp[row][col].Flip();
	}

	public void Display()
	{
		for (int row = 0; row <= temp.length - 1; row++)
		{
			for (int col = 0; col <= temp.length - 1; col++)
				System.out.print(temp[row][col] + " ");
			System.out.println();
		}
	}
}