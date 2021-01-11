import java.util.Scanner;

public class ConvertToHMS 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter seconds as an integer.");
		int input = scanner.nextInt();
		System.out.println(Convert(input));
		scanner.close();
	}
	
	public static String Convert(int inputSeconds) 
	{
		int hours = inputSeconds / 3600;
		int minutes = (inputSeconds % 3600) / 60;
		int seconds = ((inputSeconds % 3600) % 60);
		return "\n" + inputSeconds + " seconds is " + hours + " hours " + minutes + " minutes and " + seconds + " seconds ";
	}
}
