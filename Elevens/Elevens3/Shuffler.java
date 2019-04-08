package Elevens3;

public class Shuffler
{
	private static final int SHUFFLE_COUNT = 3;
	private static final int VALUE_COUNT = 52;
	static int[] shuffled;

	public static void main(String[] args)
	{
		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++)
		{
			values1[i] = i;
		}
		for (int j = 1; j <= SHUFFLE_COUNT; j++)
		{
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < shuffled.length; k++)
			{
				System.out.print(" " + shuffled[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++)
		{
			values2[i] = i;
		}
		for (int j = 1; j <= SHUFFLE_COUNT; j++)
		{
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < shuffled.length; k++)
			{
				System.out.print(" " + shuffled[k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void perfectShuffle(int[] values)
	{
		shuffled = new int[VALUE_COUNT];

		int k = 0;
		for (int j = 0; j < shuffled.length / 2; j++)
		{
			shuffled[k] = values[j];
			k += 2;
		}
		k = 1;
		for (int j = shuffled.length / 2; j < shuffled.length; j++)
		{
			shuffled[k] = values[j];
			k += 2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values)
	{
		for (int i = values.length - 1; i > 0; i--)
		{
			int rand = (int) (Math.random() * (i + 1));
			int temp = values[i];
			values[i] = values[rand];
			values[rand] = temp;
		}
		shuffled = values;
	}
}
