import java.util.Random;
import java.util.Scanner;

/*1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5 The variable names are easy to understand and are formatted as per coding conventions.

 2. Did I indent the code appropriately?

        Mark out of 5: 5 The code is indented correctly as per
         the coding standard to indicate the structure of my code which makes it easier for others to understand the code.

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20 the function is correctly written and invoked in the main line to create the cipher mapping.

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  18 The function works okay but perhaps it should have a void return instead of returning an array reference.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  18 again the function works okay but perhaps should have a void return instead of the return of an array reference.

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25  : 23 The mainline functions correctly obtaining, encrypting and decrypting strings repeatedly. The while loop operates on the basis that the string is not null which perhaps is nto the best condition to use.

 7. How well did I complete this self-assessment?

        Mark out of 5:4 Probably a bit too nice to myself

 Total Mark out of 100 (Add all the previous marks):93 */

public class Cipher {
	
	public static void createCipher (char[] cipherArray, char[] alphabetArray)
	{
		Random generator = new Random();
		char [] tempAlphabetArray = new char [alphabetArray.length];
		System.arraycopy (alphabetArray, 0, tempAlphabetArray, 0, alphabetArray.length);
		for (int index=0; index< cipherArray.length ; index++)
		{
			int otherIndex = generator.nextInt(tempAlphabetArray.length);
			if (tempAlphabetArray[otherIndex] != 0)
			{
				cipherArray[index] = tempAlphabetArray[otherIndex];
				tempAlphabetArray[otherIndex] = 0;
			}
			else index--;
		}
		
	}
	
	
	public static char[] encrypt (char[] plainTextArray, char [] cipherArray, char [] alphabetArray)
	{
		int index =0 ;
		int index2 = 0;
		char [] encryptedTextArray = new char[plainTextArray.length];
		for (index =0; index< plainTextArray.length ; index++)
		{
			while (plainTextArray[index] != alphabetArray [index2])
			{
				index2++;
			}
			encryptedTextArray [index]= cipherArray[index2]; 
			index2= 0;
		}
		
		return encryptedTextArray;
	}
	
	public static char [] decrypt (char[] encryptedTextArray, char [] cipherArray, char[] alphabetArray)
	{
		int index = 0 ;
		int index2 = 0;
		char [] decryptedTextArray = new char [encryptedTextArray.length];
		for (index =0 ; index < encryptedTextArray.length ; index++)
		{
			while (encryptedTextArray[index] != cipherArray[index2])
			{
				index2 ++;
			}
			decryptedTextArray[index] = alphabetArray[index2];
			index2 =0 ;
			
		}
		return decryptedTextArray;
	}

	public static void main(String[] args) {
		char [] cipherArray = new char [27];
		char [] alphabetArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };
		createCipher(cipherArray, alphabetArray);
	
		
		System.out.print("Please enter text to encrypt. The text should be lower case letters.");
		Scanner input = new Scanner (System.in);
		try
		{
			String plainText = input.next();
			while (plainText != null)
			{
				
				char [] plainTextArray = plainText.toCharArray();
				char [] encryptedTextArray = encrypt(plainTextArray, cipherArray,  alphabetArray);
				String encryptedText = new String(encryptedTextArray);
				System.out.println("The encryption of the text is " + encryptedText + ".");
		
				char[] decryptedTextArray = decrypt (encryptedTextArray, cipherArray, alphabetArray);
				String decryptedText = new String (decryptedTextArray);
				System.out.println("The decryption of the text is " + decryptedText + ".");
				System.out.println("Please enter more text to encrypt. The text should be lower case letters.");
				input = new Scanner(System.in);
				plainText = input.next();
			}
			input.close();
		}
		catch (java.lang.ArrayIndexOutOfBoundsException exception)
		{
			System.out.println ("Error. You must enter lower case letters only.");
		}
	}

}
