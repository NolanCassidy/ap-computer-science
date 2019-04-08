// Nolan Cassidy

public class Card
{
	int rank;
	String suit, holder;

	public Card(String inSuit, int inRank)
	{
		suit = inSuit;
		rank = inRank;
	}

	public String getSuit()
	{
		return suit;
	}

	public int getRank()
	{
		return rank;
	}

	public String toString()
	{
		if (rank == 1)
			return "Ace of " + suit;
		else if (rank == 11)
			return "Jack of " + suit;
		else if (rank == 12)
			return "Queen of " + suit;
		else if (rank == 13)
			return "King of " + suit;
		else
			return rank + " of " + suit;
	}
}
