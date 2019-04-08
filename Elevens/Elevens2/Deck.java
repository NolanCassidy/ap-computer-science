package Elevens2;

import java.util.List;
import java.util.ArrayList;

public class Deck
{
	private List<Card> cards = new ArrayList<Card>();
	private int size;

	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values)
	{		
		for (String suit : suits)
			for (String rank : ranks)
				for (int value : values)
					cards.add(new Card(rank, suit, value));
		
		size = cards.size();
		
		shuffle();
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int size()
	{
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle()
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal()
	{
		size--;
		return cards.get(size);
	}
	
	public String toString()
	{
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--)
		{
			rtn = rtn + cards.get(k);
			if (k != 0)
			{
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0)
			{
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--)
		{
			rtn = rtn + cards.get(k);
			if (k != size)
			{
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0)
			{
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
