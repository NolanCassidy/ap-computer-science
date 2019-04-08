import java.io.*;
import java.util.*;

public class A16_Statistics
{
	private static int[] inputArray = new int[100];
	private static double average = 0, stdDev = 0;

	public static void main(String[] args)
	{
		try
		{
			Scanner scanner = new Scanner(new FileReader("numbers.txt"));
			LineNumberReader reader = new LineNumberReader(new FileReader(new File("numbers.txt")));
			int i = 0;

			reader.skip(Long.MAX_VALUE);

			inputArray = new int[reader.getLineNumber() + 1];

			while (scanner.hasNext())
			{
				inputArray[i] = scanner.nextInt();
				i++;
			}

			Average();
			StandardDeviation();
			Mode();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public static void Average()
	{
		double sum = 0;

		for (int i = 0; i < inputArray.length; i++)
			sum += inputArray[i];

		System.out.printf("%s%.2f%n", "The average is: ", (sum / inputArray.length));
	}

	public static void StandardDeviation()
	{
		double total = 0;

		for (int i = 0; i < inputArray.length; i++)
		{
			double dif = (average - (inputArray[i]));
			dif = Math.pow(dif, 2);
			total += dif;
		}

		total /= (inputArray.length - 1);
		stdDev = Math.sqrt(total);

		System.out.printf("%s%.2f%n", "The standard deviation is: ", stdDev);
	}

	public static void Mode()
	{
		int[] counts = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++)
			counts[inputArray[i]]++;

		int max = counts[0];
		for (int counter = 1; counter < counts.length; counter++)
			if (counts[counter] > max)
				max = counts[counter];

		int[] modes = new int[inputArray.length];

		int j = 0;
		for (int i = 0; i < counts.length; i++)
			if (counts[i] == max)
				modes[j++] = inputArray[i];

		
		int[] temp = new int[inputArray.length];

		int numberofZeros = 0;

		for (int i = 0; i < inputArray.length; i++)
		{
			if (modes[i] != 0)
			{
				temp[i - numberofZeros] = inputArray[i];
			}
			else
			{
				numberofZeros++;
			}
		}
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		
		
		//		int occurences = 0, mode = 0, currentCount = 0;
		//
		//		for (int outerLoop : inputArray)
		//		{
		//			currentCount = 0;
		//
		//			for (int innerLoop : inputArray)
		//				if (outerLoop == innerLoop)
		//					currentCount++;
		//
		//			if (currentCount > occurences)
		//			{
		//				occurences = currentCount;
		//				mode = outerLoop;
		//			}
		//		}
		//		System.out.println("The following mode(s) occurred " + occurences + " time(s): " + mode + " 48");
	}
}