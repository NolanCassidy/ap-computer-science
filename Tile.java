public class Tile
{
	String symbol;
	boolean up = true;

	public Tile(String symbol)
	{
		this.symbol = symbol;
	}
	
	public boolean equals(String compare)
	{
		if (symbol == compare)
			return true;
		else
			return false;
	}

	public void Flip()
	{
		up = !up;
	}
	
	public void Found()
	{
		symbol = symbol.toUpperCase();
	}

	public String toString()
	{
		if (up)
			return String.valueOf(symbol);
		else
			return "■";
	}
}