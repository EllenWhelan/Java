import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: I have the return type as an array list of strings which will be the dictionary collection and i pass in no parameters.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: i use a buffered reader and the readLine() function to read each word in the dictionary into the list
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: it returns ecah line from the text file into the array list 

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: i have the return type as a array of strings and i pass in the user input as a string
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: I use the split() method to take each word separated by commas and place them in the array and then i return that array to the mainline

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: i set a boolean as a return type and i pass in the user input array of string values as a parameter
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: i use two for loops to check each words in the list to every other word in the list 
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment:my loop exits once the no unique owrd is found
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: My method returns a true value if there is only unique words in the array

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: i set a boolean return type to say true if the word checked is in the dictionary. I pass in the dictionary array list and the string owrd to be checked in.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: I first cast my array list to an array dictionary in order to use the arrays binarySearch method. I then use the word string as a key and look for it. If the value returned is a negative number then the return is flase and vice versa.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: if the value returned is minus and if statement is employed to return false else a true is retrned.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: I return a boolean value to the isWordChain method and i pass in two words at a time as a parameter to compare against eachother
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: I use the word.length function to check they are the same length and then as a for loop condition. I then use an int index to check the char at the same position in each word using the charAt() fucntion.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: I set a boolean return type and take in the dictionary array list and the word list array.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: I call those three methods in various if statements in the method and then return a boolean value to the  main.If the value is true a statement is printed to the console to say it is a vlaid word list

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: I create a dictionary array list and call the readDictionary function from the mainline where the full file is read in and placed in an array list using a buffered reader readLine() function
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: I ask the user for input continously until they enter an empty list and call isWordChain before displaying the correct message depending on the boolean value of isWordChain

 Total Mark out of 100 (Add all the previous marks):97
*/

public class WordLinks {

	public static void main(String[] args) {
		ArrayList<String> dictionaryList = readDictionary();
		
		System.out.print(
				"Welcome to word links! Please enter a list of words seperated by commas or press enter to quit.");
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			
				String userInput = input.nextLine();
				String[] wordList = readWordList(userInput);
				/*for (int i = 0; i < wordList.length; i++) {
					System.out.println(wordList[i]);
				}*/
				if (isWordChain(wordList, dictionaryList))
					System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				else
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			

		}
		input.close();
		System.out.println("Thank you for playing!");

	}

	public static ArrayList<String> readDictionary() {
		ArrayList<String> dictionaryList = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader("words.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String temp = bufferedReader.readLine();
			while (temp != null) {
				dictionaryList.add(temp);
				temp = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dictionaryList;
	}

	public static String[] readWordList(String input) {
		String wordInput = input;
		String[] wordList = wordInput.split(",");
		return wordList;
	}

	public static boolean isEnglishWord(ArrayList<String> dictionaryList, String word) {
		String[] dictionary = dictionaryList.toArray(new String[dictionaryList.size()]);
		int temp = Arrays.binarySearch(dictionary, word);
		if (temp >= 0) {
			// System.out.println(temp);
			return true;
		} else {
			System.out.println("This word is not english");
			// System.out.println(temp);
			return false;
		}

	}

	public static boolean isUnique(String[] wordList) {
		boolean isUnique = true;
		int count = 0;
		for (int i = 0; i < wordList.length-1; i++) {
			for (int ind =i+1; ind < wordList.length; ind++) {
				if (wordList[i] == wordList[ind]) {
					System.out.println("The list contains non-unique words.");
					return false;
				}
			}
		}
		/*if (count == wordList.length) {
			isUnique = true;
		} else {
			System.out.println("The list is not unique");
			isUnique = false;
		}*/
		return true;

	}

	public static boolean isDifferentByOne(String currentWord, String nextWord) {
		if (currentWord.length() == nextWord.length()) {
			int oneDifference = 0;
			for (int i = 0; i < currentWord.length(); i++) {
				if (currentWord.charAt(i) != nextWord.charAt(i)) {
					oneDifference++;
				}

			}
			if (oneDifference > 1 || oneDifference < 1) {
				System.out.println("These words don't differ by one.");
				return false;
			} else if (oneDifference == 1)
				return true;

		}
		System.out.println("The words are not the same length.");
		return false;
	}

	public static boolean isWordChain(String[] wordList, ArrayList<String> dictionaryList) {

		String currentWord;
		String nextWord;

		if (isUnique(wordList)) {
			for (int i = 0; i < wordList.length - 1; i++) {
				currentWord = wordList[i];
				// System.out.println(currentWord + "helo");
				nextWord = wordList[i + 1];
				// System.out.println(nextWord + "hiy");
				if (isEnglishWord(dictionaryList, currentWord) && isEnglishWord(dictionaryList, nextWord)) {
					if (!isDifferentByOne(currentWord, nextWord))
						return false;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;

	}
}
