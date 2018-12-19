import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	YahtzeeDie d = new YahtzeeDie(6);
	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private YahtzeeScorecard scoreBoard;
	private static final int NUM_SIDES = 6;
	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3 = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5 = new YahtzeeDie(NUM_SIDES);
		scoreBoard = new YahtzeeScorecard();

	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int x = 0; x<13; x++){
			takeTurn();
		}
		scoreBoard.printScoreCard();
		return scoreBoard.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Your first roll");
		rollDice();
		printDice();
		System.out.println("Are you satisfied with your roll(s), if not chose the numbers you want to keep and re-roll(r): ");
		char userInput = s.nextLine().charAt(0);
		if(userInput == 'r'){
			chooseFrozen();
			System.out.println("Your second roll");
			rollDice();
			printDice();
			System.out.println("Are you satisfied with your roll(s), if not chose the numbers you want to keep and re-roll(r): ");
			char userInput2 = s.nextLine().charAt(0);
			if(userInput2 == 'r'){
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}else{
				markScore();
			}
		}else{
			markScore();
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!(die1.isFrozen())){
			die1.rollDie();
		}
		if(!(die2.isFrozen())){
			die2.rollDie();
		}
		if(!(die3.isFrozen())){
			die3.rollDie();
		}
		if(!(die4.isFrozen())){
			die4.rollDie();
		}
		if(!(die5.isFrozen())){
			die5.rollDie();
		}
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();

	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Which die do you want to keep(enter numbers 1-5): ");
		String lineOfNums = s.nextLine();
		if(lineOfNums.indexOf("1")>=0 ){
			die1.freezeDie();
		}
		if(lineOfNums.indexOf("2")>= 0){
			die2.freezeDie();
		}
		if(lineOfNums.indexOf("3")>= 0){
			die3.freezeDie();
		}
		if(lineOfNums.indexOf("4")>= 0){
			die4.freezeDie();
		}
		if(lineOfNums.indexOf("5")>= 0){
			die5.freezeDie();

		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue()+"\t"+die2.getValue()+"\t"+ die3.getValue()+"\t"+ die4.getValue()+"\t"+ die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		Scanner s = new Scanner(System.in);
		scoreBoard.printScoreCard();
		int scoreLocation = 0;
		String allNums = "0";
		System.out.println("Ones = 1, twos = 2, threes = 3, fours = 4, fives = 5, sixes = 6, 3 of Kind = 7,\n4 of Kind = " +
				"8, Full House = 9, Sm Straight = 10, Lg Straight = 11, Yahtzee = 12, Chance = 13 ");

		boolean isGood = false;
	while(scoreLocation<=0 || scoreLocation>=14 || !isGood) {
		System.out.println("Where would you like to place your score?(enter a number 1-13): ");
		scoreLocation = s.nextInt();
		s.nextLine();
		allNums += scoreLocation;
		switch (scoreLocation) {
			case 1:
				isGood = scoreBoard.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 2:
				isGood = scoreBoard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 3:
				isGood = scoreBoard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 4:
				isGood = scoreBoard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 5:
				isGood = scoreBoard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 6:
				isGood = scoreBoard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 7:
				isGood = scoreBoard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 8:
				isGood = scoreBoard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 9:
				isGood = scoreBoard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 10:
				isGood = scoreBoard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 11:
				isGood = scoreBoard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 12:
				isGood = scoreBoard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
			case 13:
				isGood = scoreBoard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
				break;
		}

	}
	}
}