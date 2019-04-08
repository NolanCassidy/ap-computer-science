// Nolan Cassidy

import java.util.ArrayList;

public class Player
{
	private ArrayList<Card> hand = new ArrayList<Card>();

	String name;

	public Player(String inName, Card card1, Card card2)
	{
		name = inName;
		hand.add(card1);
		hand.add(card2);
	}

	public void Add(Card card)
	{
		hand.add(card);
	}

	public int score()
	{
		int score = 0;

		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getRank() > 10)
				score += 10;
			else if (hand.get(i).getRank() > 1)
				score += hand.get(i).getRank();
			else if (score < 11)
				score += 11;
			else
				score++;
		}

		return score;
	}

	public void Hand()
	{
		System.out.println("\n" + name + "'s Cards:");
		for (int i = 0; i < hand.size(); i++)
		{
			System.out.println("   " + hand.get(i));
		}
	}
}
