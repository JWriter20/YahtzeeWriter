import java.util.Scanner;
import java.util.Random;
public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		char wantToPlay = 'y';
		int highScore = 0;
		int sum = 0;
		int lowScore = 999;
		int z = 0;
		while(wantToPlay == 'y') {
			int score;
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Jake's APCSA Yahtzee Game!");
			score = myGame.playGame();
			if(score> highScore)highScore = score;
			if(score< lowScore)lowScore = score;
			sum+= score;
			z++;
			System.out.println("Do you want to play another game of Yahtezee(y or n): ");
			wantToPlay = s.nextLine().charAt(0);
		}
		System.out.print("High score: ");
		System.out.println(highScore);
		System.out.print("Low score: ");
		System.out.println(lowScore);
		System.out.print("Average score: ");
		System.out.println(sum*1.0/z);
	}
}
