public class A10_StringUtil
{
	public static void main(String[] args)
	{
		System.out.println(StringUtil.Reverse("I like computers!"));
		System.out.println(StringUtil.Palindrome("radar"));
		System.out.println(StringUtil.Palindrome("J"));
		System.out.println(StringUtil.Palindrome("Lewd did I live, & evil I did dwel."));
		System.out.println(StringUtil.Palindrome("I like Java"));
		System.out.println(StringUtil.Palindrome("Straw? No, too stupid a fad, I put soot on warts."));
		System.out.println(StringUtil.PigLatin("Why do they think you and Sheena should return immediately?"));
		System.out.println(StringUtil.Shorthand("You and she should not go to the party, for you will be bored!"));
	}
}