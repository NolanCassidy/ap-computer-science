public class A06_Taxes {
	public static void main(String[] args)
	{
		Taxes paycheck1 = new Taxes(30, 12.35);
		paycheck1.DisplayPaycheckInfo();
		Taxes paycheck2 = new Taxes(38.5, 9.50);
		paycheck2.DisplayPaycheckInfo();
		Taxes paycheck3 = new Taxes(110.25, 18.23);
		paycheck3.DisplayPaycheckInfo();
	}
}