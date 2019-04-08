// Nolan Cassidy

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck
{
	int cardLoc;
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Player> player = new ArrayList<Player>();
	private Dealer dealer;
	private Scanner input = new Scanner(System.in);

	public Deck(int numberOfDecks)
	{
		InitializeDecks(numberOfDecks);
	}

	public void InitializeDecks(int numberOfDecks)
	{
		String suit;
		for (int i = 0; i < numberOfDecks; i++)
			for (int suits = 1; suits <= 4; suits++)
			{
				if (suits == 1)
					suit = "Clubs";
				else if (suits == 2)
					suit = "Diamonds";
				else if (suits == 3)
					suit = "Hearts";
				else
					suit = "Spades";

				for (int rank = 1; rank <= 13; rank++)
					deck.add(new Card(suit, rank));
			}
	}

	public void DisplayDeck()
	{
		for (int i = 0; i < deck.size(); i++)
			System.out.println(i + "   " + deck.get(i).toString());
	}

	public void Shuffle()
	{
		int swap;
		Random random = new Random();

		for (int i = 0; i < 52; i++)
		{
			swap = random.nextInt(52);

			Card temp = deck.get(i);
			deck.set(i, deck.get(swap));
			deck.set(swap, temp);
		}
	}

	public void Deal(ArrayList players)
	{
		player.clear();
		for (int i = 0; i <= players.size(); i++)
		{
			if (i == players.size())
				dealer = new Dealer(deck.get(i), deck.get(i + players.size() + 1));
			else
				player.add(new Player(players.get(i).toString(), deck.get(i), deck.get(i + players.size() + 1)));
		}
	}

	public void Play(ArrayList players)
	{
		cardLoc = (players.size() * 2) + 2;
		boolean stay1 = false, stay2 = false, stay3 = false, stay4 = false;

		do
		{
			if (players.size() >= 1 && !stay1)
			{
				if (player.get(0).score() > 21)
				{
					System.out.println("\n" + player.get(0).name + " busted with " + player.get(0).score());
					stay1 = true;
				}
				else
				{
					player.get(0).Hand();
					dealer.HiddenHand();
					System.out.print("Do you want to hit? (Y/N) ");
					if (input.nextLine().toUpperCase().equals("N"))
						stay1 = true;
					else
					{
						player.get(0).Add(deck.get(cardLoc));
						cardLoc++;
					}
				}
			}
			else
				stay1 = true;

			if (players.size() >= 2 && !stay2)
			{
				if (player.get(1).score() > 21)
				{
					System.out.println(player.get(1).name + " busted with " + player.get(1).score());
					stay2 = true;
				}
				else
				{
					player.get(1).Hand();
					dealer.HiddenHand();
					System.out.print("Do you want to hit? (Y/N) ");
					if (input.nextLine().toUpperCase().equals("N"))
						stay2 = true;
					else
					{
						player.get(1).Add(deck.get(cardLoc));
						cardLoc++;
					}
				}
			}
			else
				stay2 = true;

			if (players.size() >= 3 && !stay3)
			{
				if (player.get(2).score() > 21)
				{
					System.out.println(player.get(2).name + " busted with " + player.get(2).score());
					stay3 = true;
				}
				else
				{
					player.get(2).Hand();
					dealer.HiddenHand();
					System.out.print("Do you want to hit? (Y/N) ");
					if (input.nextLine().toUpperCase().equals("N"))
						stay3 = true;
					else
					{
						player.get(2).Add(deck.get(cardLoc));
						cardLoc++;
					}
				}
			}
			else
				stay3 = true;

			if (players.size() >= 4 && !stay4)
			{
				if (player.get(3).score() > 21)
				{
					System.out.println(player.get(3).name + " busted with " + player.get(3).score());
					stay4 = true;
				}
				else
				{
					player.get(3).Hand();
					dealer.HiddenHand();
					System.out.print("Do you want to hit? (Y/N) ");
					if (input.nextLine().toUpperCase().equals("N"))
						stay4 = true;
					else
					{
						player.get(3).Add(deck.get(cardLoc));
						cardLoc++;
					}
				}
			}
			else
				stay4 = true;
		} while (!stay1 || !stay2 || !stay3 || !stay4);
	}

	public void FillDealer()
	{
		while (dealer.score() < 17)
		{
			dealer.Add(deck.get(cardLoc));
			cardLoc++;
		}

		dealer.Hand();
	}

	public void DetectWinner()
	{
		int i = 0;

		do
		{
			if (player.get(i).score() > 21)
				player.remove(i);
			else
				i++;
		} while (i < player.size());

		if (player.size() == 0)
			System.out.println("Every player busted.");
		else
		{
			int j = 0;

			while (j < player.size() - 1)
			{
				if (player.get(j).score() > player.get(j + 1).score())
					player.remove(j + 1);
				else if (player.get(j).score() < player.get(j + 1).score())
				{
					player.remove(j);
					j++;
				}
				else
					j++;
			}

			if (dealer.score() <= 21 && dealer.score() >= player.get(0).score())
				System.out.println("\nThe winner is the dealer with " + dealer.score());
			else
			{
				System.out.println("\nWinner(s):");
				for (int k = 0; k < player.size(); k++)
					System.out.println("   " + player.get(k).name + " with " + player.get(k).score());
			}
		}
	}
}
