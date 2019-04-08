package Elevens1;

public class CardTester
{
	public static void main(String[] args)
	{
		Card card1 = new Card("three", "diamonds", 3);
		Card card2 = new Card("three", "diamonds", 3);
		Card card3 = new Card("eight", "diamonds", 8);
		
		System.out.println(card1.rank());
		System.out.println(card2.rank());
		System.out.println(card3.rank());
		
		System.out.println(card1.suit());
		System.out.println(card2.suit());
		System.out.println(card3.suit());
		
		System.out.println(card1.pointValue());
		System.out.println(card2.pointValue());
		System.out.println(card3.pointValue());
		
		System.out.println(card1.matches(card2));
		System.out.println(card1.matches(card3));
		System.out.println(card2.matches(card3));
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
	}
}
