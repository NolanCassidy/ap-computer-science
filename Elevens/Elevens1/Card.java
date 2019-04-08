package Elevens1;

/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card
{
	private String rank;
	private String suit;
	private int pointValue;

	public Card(String cardRank, String cardSuit, int cardPointValue)
	{
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}

	public String rank()
	{
		return rank;
	}

	public String suit()
	{
		return suit;
	}

	public int pointValue()
	{
		return pointValue;
	}

	public boolean matches(Card otherCard)
	{
		return (rank.equals(otherCard.rank()) && suit.equals(otherCard.suit()) && pointValue == otherCard.pointValue());
	}

	public String toString()
	{
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
