import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String newGame;
		do 
		{
			final int MAX = 10;
			int answer;
			int guess;
			
			
			Random random = new Random();
			
			answer = random.nextInt(MAX) + 1;
			System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
			System.out.print("Guess what it is: ");
			
			do
			{	
				guess = scan.nextInt();
				if(guess < 0 || guess > MAX)
				{
					System.out.println("Your guess is out of range. Guess again: "+ guess);
				} 
				else
				{
					if(guess < answer)
					{
						System.out.println("You need to guess higher.");
					}
					else if(guess > answer)
					{
						System.out.println("You need to guess lower.");
					}
					
				}
			} while(guess != answer); 
				
		
			System.out.println("You guessed correctly!");
			
			
			System.out.println("Would you like to play a new game? (Y/N)");
			newGame = scan.next().toUpperCase();
		}while(newGame.equals("Y"));
		System.out.println("Thanks for playing!");
		scan.close();
		

		
		
	}
}