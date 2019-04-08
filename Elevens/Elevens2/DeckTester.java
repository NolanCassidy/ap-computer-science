package Elevens2;

public class DeckTester
{
	public static void main(String[] args)
	{
		String[] ranks = {"jack", "queen", "queen"};
		String[] suits = {"red", "blue"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);
		
		System.out.println("Empty: " + d.isEmpty());
		System.out.println(d.size());
		System.out.println(d.toString());
		
		System.out.println("Deal: " + d.deal());
		System.out.println("Deal: " + d.deal());
		System.out.println("Deal: " + d.deal());
		
		System.out.println("Empty: " + d.isEmpty());
		System.out.println(d.size());
		System.out.println(d.toString());
	}
}
