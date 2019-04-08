import java.util.Scanner;

public class CarCalling
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Starting Odometer Value: ");
		int odometer = Integer.parseInt(input.nextLine());
		System.out.println();
		Car auto = new Car(odometer);
		
		auto.FillUp(150,8);
		System.out.println("Miles per gallon: " + auto.CalculateMPG());
		System.out.println("Miles per gallon: " + auto.CalculateMPG());
		auto.ResetMPG();
		auto.FillUp(350, 10);
		auto.FillUp(450, 20);
		System.out.println("Miles per gallon: " + auto.CalculateMPG());
		auto.ResetMPG();
		auto.FillUp(603, 25.5);
		System.out.println("Miles per gallon: " + auto.CalculateMPG());
	}
}