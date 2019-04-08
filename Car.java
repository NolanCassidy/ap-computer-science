public class Car
{
	static int startMiles, endMiles;
	static double gallonsUsed;
	
	public Car()
	{
		startMiles = 0;
	}

	public Car(int odometerReading)
	{
		startMiles = odometerReading;
	}

	public void FillUp(int odometerReading, double gallons)
	{
		endMiles = odometerReading;
		gallonsUsed += gallons;
	}

	public double CalculateMPG()
	{
		return ((endMiles-startMiles)/gallonsUsed);
	}

	public void ResetMPG()
	{
		startMiles = endMiles;
		gallonsUsed = 0;
	}
}