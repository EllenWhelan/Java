import java.util.Scanner;
/* SELF ASSESSMENT
1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5:  5
       all the variable names are easy to understand and help the reader to understand what the code does.
2. Did I indent the code appropriately?
       Mark out of 5: 5
       the code is indented to indicate the structure of the code and make it easier to understand 
3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 15:  15
      the function is invoked properly and is written properly with a correct function header to initialize
       an array of the correct length as defined by the user.
4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 15:  12
      The function to print out the high scores is also written correct;y and  invoked correctly n the main line 
      to print out correctly on the console. However it will print out zeros when the array is not full.
5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 15: 15
       This function runs through all the current high scores and compares the new score to all the scores.
       If the new score is higher than any of the existing scores then a true is returned.
6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20:  17
      The function is written correctly to correctly input the new high score and update the array accordingly. It may
       be a bit inefficient as I had many different for loops an if statements to ensure the index stayed within the array.
7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
      Mark out of 20:  20
      I used a while loop to continue asking for new scores after obtaining the length of the array from the user. I also allowed the user 
      to quit by entering exit and if they entered anything other than a number or exit I sent an error message to the console.
8. How well did I complete this self-assessment?
       Mark out of 5:4
       Probably way to nice to myself.
Total Mark out of 100 (Add all the previous marks):93
*/ 

public class HighScores {
	
	public static int [] initialiseHighScores ( int scoresToMaintain)
	{
		int [] highScores = new int [scoresToMaintain];
		for (int index =0; index< highScores.length ; index++)
		{
			highScores[index]= 0;
		}
		return highScores;
	}
	
	public static String printHighScores ( int[] highScores)
	{
		String output = "The high scores are";
		for (int index = 0 ; index < highScores.length ; index++)
		{
			output+= highScores[index] + ", ";
		}
		output+= ".";
		return output;
	}
	
	public static boolean higherThan (int [] highScores, int newScore)
	{
		int index = 0;
		boolean higher = false;
		for (index=0 ; index < highScores.length && higher == false; index++)
		{
			if (newScore > highScores[index]) higher= true;	
		}
		if (index >= highScores.length) higher = false;
		return higher;
		
	}
	
	public static int [] insertScore (int [] highScores, int newScore)
	{
		int index = (highScores.length -1);
		int position = 0;
		boolean finished = false;
		while (index>=0 && finished == false )
		{ 
			if (newScore > highScores[index] && index !=0) index--;
			else finished = true;
		}
		
		if(index ==0) position = index;
		else position = index +1;
		
		
		int [] tempHighScores = new int [highScores.length];
		index = 0;
		if (position == (highScores.length -1)) tempHighScores [position] =newScore;
		else if(position ==0) 
		{
			for (index=0; index < (highScores.length -1) ; index ++)
			{
				tempHighScores [index+1] = highScores [index];
			}
			tempHighScores [position] = newScore;
		}
		else 
		{
			for (index =0 ; index < position ; index++)
			{
				tempHighScores[index] = highScores[index];

			}
			tempHighScores [position] = newScore;
			finished = false;
			index = position +1 ;
			while(index > position && index < highScores.length && finished==false)
			{
				if (index != highScores.length -1) 
				{
						tempHighScores[index] = highScores[index-1];
						index++;
				}
				else 
				{ 
					tempHighScores[index] =highScores[index-1];
					finished = true;
				}
			}
		}
		
		highScores = tempHighScores;
		return highScores;
				
				
	}

	public static void main(String[] args) {
		
		System.out.print("How many high scores do you wish to maintain in the leader board?");
		Scanner input1 = new Scanner (System.in);
		int scoresToMaintain = input1.nextInt();
		int [] highScores = initialiseHighScores (scoresToMaintain);
		System.out.println("Enter a new score or type 'exit' to quit the program.");
		input1 = new Scanner (System.in);
	
		
		while (input1.hasNextInt())
		{
		    int newScore = input1.nextInt();
		    /*System.out.print(newScore);*/
			if (higherThan(highScores, newScore))
			{
			  highScores= insertScore(highScores, newScore);
			}
			System.out.println (printHighScores(highScores));
			System.out.println ("Enter another score or type 'exit' to quit the program.");
			input1 = new Scanner (System.in);
		}
		if (input1.hasNext("exit"))
			System.out.println ("Goodbye.");
		else 
			System.out.println ("Error: Please enter a number or type 'exit' to quit the program.");
		// TODO Auto-generated method stub

	}

}
