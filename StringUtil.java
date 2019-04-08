public class StringUtil
{
	private static final String CHARS_TO_REMOVE = " \'\".,!?;:-";
	private static final String VOWELS_TO_USE = "aAeEiIoOuU";

	public static String Reverse(String phrase)
	{
		String reversedPhrase = "";

		for (int i = phrase.length() - 1; i >= 0; i--)
			reversedPhrase += phrase.charAt(i);

		return reversedPhrase;
	}

	public static boolean Palindrome(String phrase)
	{
		phrase = CleanUp(phrase);
		String reversedPhrase = Reverse(phrase);

		if (phrase.equals(reversedPhrase))
			return true;
		else
			return false;
	}

	public static String PigLatin(String phrase)
	{
		return Separate(phrase);
	}

	public static String Shorthand(String phrase)
	{
		phrase = Replace("and", "&", phrase);
		phrase = Replace("to", "2", phrase);
		phrase = Replace("you", "U", phrase);
		phrase = Replace("for", "4", phrase);
		
		phrase = Replace("And", "&", phrase);
		phrase = Replace("To", "2", phrase);
		phrase = Replace("You", "U", phrase);
		phrase = Replace("For", "4", phrase);

		for (int i = 0; i < VOWELS_TO_USE.length(); i++)
			for (int j = 0; j < phrase.length(); j++)
				if (VOWELS_TO_USE.charAt(i) == phrase.charAt(j) && phrase.charAt(j) != 'U')
					phrase = phrase.substring(0, j) + phrase.substring(j + 1);
		
		return phrase;
	}

	private static String Latinate(String word)
	{
		boolean first = true, second = false;

		for (int i = VOWELS_TO_USE.length() - 1; i >= 0; i--)
			for (int j = word.length() - 1; j >= 0; j--)
				if (VOWELS_TO_USE.charAt(i) == word.charAt(j))
					first = false;
		
		if (first == false)
			for (int i = VOWELS_TO_USE.length() - 1; i >= 0; i--)
				if (VOWELS_TO_USE.charAt(i) == word.charAt(0))
					second = true;

		if (!first && !second)
			for (int i = 0; i < VOWELS_TO_USE.length(); i++)
				for (int j = 0; j < word.length(); j++)
					if (word.charAt(j) == VOWELS_TO_USE.charAt(i))
						if (word.substring(0, 1).equals(word.substring(0, 1).toUpperCase()))
							word = word.substring(j, j + 1).toUpperCase() + word.substring(j + 1) + word.substring(0, j).toLowerCase();
						else
						{
							word = word.substring(j) + word.substring(0, j);
							return word + "ay";
						}

		if (second)
			word += "yay";
		else
			word += "ay";

		return word;
	}

	private static String Separate(String phrase)
	{
		if (phrase.indexOf(" ") >= 0)
			return (Latinate(phrase.substring(0, phrase.indexOf(" "))) + " " + Separate(phrase.substring(phrase.indexOf(" ") + 1)));
		else
			return Latinate(phrase);
	}

	private static String CleanUp(String phrase)
	{
		phrase = phrase.toLowerCase();

		for (int i = 0; i < CHARS_TO_REMOVE.length(); i++)
			for (int j = 0; j < phrase.length(); j++)
				if (CHARS_TO_REMOVE.charAt(i) == phrase.charAt(j))
					phrase = phrase.substring(0, j) + phrase.substring(j + 1);

		return phrase;
	}

	private static String Replace(String x, String y, String phrase)
	{
		while (phrase.indexOf(x) >= 0)
			phrase = phrase.substring(0, phrase.indexOf(x)) + y + phrase.substring(phrase.indexOf(x) + x.length());

		return phrase;
	}
}