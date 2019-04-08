// Nolan Cassidy

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack
{
	static Scanner input = new Scanner(System.in);
	static ArrayList players = new ArrayList<String>();
	static Deck deck1 = new Deck(1);

	public static void main(String[] args)
	{
		boolean playAgain = true;

		GetUsers();

		do
		{
			deck1.Shuffle();
			deck1.Deal(players);
			deck1.Play(players);
			deck1.FillDealer();
			deck1.DetectWinner();

			System.out.print("\nWould you like to play again (Y/N) ");

			if (input.nextLine().toUpperCase().equals("N"))
				playAgain = false;
		} while (playAgain);
	}

	public static void GetUsers()
	{
		String name;

		do
		{
			System.out.print("Enter the names of up to four players (Enter to continue): ");
			name = input.nextLine();
			if (!name.equals(""))
				players.add(name);
		} while (!name.equals("") && players.size() < 4);
	}
}
