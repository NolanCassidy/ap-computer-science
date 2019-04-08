import java.text.DecimalFormat;

public class Taxes
{
	final double FED_TAX_RATE = 0.154;
	final double FICA_TAX_RATE = 0.0775;
	final double STATE_TAX_RATE = 0.04;
	private double myHours;
	private double myRate;
	private double myGrossPay;

	public Taxes(double hours, double rate)
	{
		myHours = hours;
		myRate = rate;
		myGrossPay = myRate * myHours;
	}
	
	public void DisplayPaycheckInfo()
	{
		System.out.println("Hours Worked: ......... " + CustomFormat("0.00", myHours));
		System.out.println("Hourly Rate: .......... " + CustomFormat("$0.00", myRate));
		System.out.println("Gross Pay: ............ " + CustomFormat("$0.00", myGrossPay));
		System.out.println("Federal Tax (" + CustomFormat("0.00%", FED_TAX_RATE) + "): . " + CustomFormat("$0.00", myGrossPay * FED_TAX_RATE));
		System.out.println("FICA Tax (" + CustomFormat("0.00%", FICA_TAX_RATE) + "): ..... " + CustomFormat("$0.00", myGrossPay * FICA_TAX_RATE));
		System.out.println("State Tax (4%): ....... " + CustomFormat("$0.00", myGrossPay * STATE_TAX_RATE));
		System.out.println("Net Pay: .............. " + CustomFormat("$0.00", myGrossPay - myGrossPay * FED_TAX_RATE - myGrossPay * FICA_TAX_RATE - myGrossPay * STATE_TAX_RATE));
	}
	
	private String CustomFormat(String pattern, double value)
	{
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		return (myFormatter.format(value));
	}
}
