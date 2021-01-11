import java.util.Scanner;
import java.text.DecimalFormat;

public class AdGenerator {
	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat(".00");
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to AdGenerator!");
		System.out.println("Please enter your profile information.");
		System.out.println("======================================\n");
		
		System.out.println("first name: ");
		String firstName = input.nextLine();

		System.out.println("middle name: ");
		String middleName = input.nextLine();
		
		System.out.println("last name: ");
		String lastName = input.nextLine();
		
		System.out.println("job title: ");
		String jobTitle = input.nextLine();
		
		System.out.println("phone number (10 digit): ");
		String phoneNumber = input.nextLine();
		
		System.out.println("hourly rate: ");
		double hourlyRate = input.nextDouble();
		
		input.close();
		
		System.out.println("======================================");
		System.out.println("Need a "+jobTitle+"?");
		System.out.println("Call now! "+"("+phoneNumber.substring(0,3)+")-"+phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6,10));
		System.out.println("Ask for "+firstName+" "+middleName.charAt(0)+". "+lastName);
		System.out.println("Hourly rate: "+df.format(hourlyRate));
		System.out.println("======================================");
		
	}
}
