public class YahtzeeSortDice
{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int die1, int die2, int die3, int die4, int die5)
	{

		String allNums = "" + die1 + die2 + die3 + die4 + die5;
while(!((allNums.charAt(4)>=allNums.charAt(3))&&(allNums.charAt(3)>=allNums.charAt(2)) &&
		(allNums.charAt(2)>=allNums.charAt(1))&&(allNums.charAt(1)>=allNums.charAt(0)))){
	if(allNums.charAt(4)<allNums.charAt(3)){
		allNums = allNums.substring(0,3) + allNums.substring(4) + allNums.substring(3,4);
	}if(allNums.charAt(3)<allNums.charAt(2)){
		allNums = allNums.substring(0,2) + allNums.substring(3) + allNums.substring(2,3);
	}if(allNums.charAt(2)<allNums.charAt(1)){
		allNums = allNums.substring(0,1) + allNums.substring(2) + allNums.substring(1,2);
	}if(allNums.charAt(1)<allNums.charAt(0)){
		allNums = allNums.substring(0,0) + allNums.substring(1) + allNums.substring(0,1);
	}
first = allNums.charAt(0);
second = allNums.charAt(1);
third = allNums.charAt(2);
fourth = allNums.charAt(3);
fifth = allNums.charAt(4);

}
	}

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five number */
	public int getSecond()
	{
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		return third;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		return fifth;
	}
}
