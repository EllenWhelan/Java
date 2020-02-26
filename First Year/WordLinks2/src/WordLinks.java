
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLinks {

	public static void main(String[] args) {
		ArrayList<String> dictionaryList = readDictionary();

		System.out.print(
				"Welcome to word links! Please enter a list of words seperated by commas or press enter to quit.");
		Scanner input = new Scanner(System.in);
		while (System.in != null) {
			String userInput = input.nextLine();
			String[] wordList = readWordList(userInput);
			for (int i = 0; i < wordList.length; i++) {
				System.out.println(wordList[i]);
			}
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
		if ( temp >= 0) {
			System.out.println(temp);
			return true;
		}
		else {
			System.out.println("not english");
			System.out.println(temp);
			return false;
		}
		

	}

	public static boolean isUnique(String[] wordList) {
		boolean isUnique = true;
		int count = 0;
		for (int i = 0; i < wordList.length; i++) {
			for (int ind = 0; ind < wordList.length; ind++) {
				if (wordList[i] == wordList[ind])
					count++;
			}
		}
		if (count == wordList.length)
			isUnique = true;
		else {
			System.out.println("not unique");
			isUnique = false;
		}
		return isUnique;
	}

	public static boolean isDifferentByOne(String currentWord, String nextWord) {
		if (currentWord.length() ==nextWord.length())
		{
			boolean oneDifference=false;
			for (int i=0; i<currentWord.length(); i++)
			{
				if (currentWord.charAt(i) != nextWord.charAt(i))
				{
					if (oneDifference) return false;
					else oneDifference = true;
				}
				
			}
			return true;
		}
		return false;
	}
		/*char[] firstWord = currentWord.toCharArray();
		char[] secondWord = nextWord.toCharArray();
		int differenceCount = 0;
		for (int i = 0; i < firstWord.length; i++) {

			if (firstWord[i] != secondWord[i])
				differenceCount++;

		}
		if (differenceCount == 1)
			return true;
		else
			System.out.println("not dff by one");
			return false;*/

	

	public static boolean isWordChain(String[] wordList, ArrayList<String> dictionaryList) {
	
			String currentWord;
			String nextWord;

			if (isUnique(wordList)) {
				for (int i = 0; i < wordList.length - 1; i++) {
					currentWord = wordList[i];
					nextWord = wordList[i + 1];
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