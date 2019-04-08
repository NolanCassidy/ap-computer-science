// Nolan Cassidy

import java.util.ArrayList;

public class Dealer
{
	private ArrayList<Card> hand = new ArrayList<Card>();

	public Dealer(Card card1, Card card2)
	{
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

	public void HiddenHand()
	{
		System.out.println("Dealer's Cards:");
		for (int i = 0; i < hand.size(); i++)
		{
			if (i == 0)
				System.out.println("   HIDDEN");
			else
				System.out.println("   " + hand.get(i));
		}
	}

	public void Hand()
	{
		System.out.println("\nDealer's Cards:");
		for (int i = 0; i < hand.size(); i++)
		{
			System.out.println("   " + hand.get(i));
		}
	}
}
