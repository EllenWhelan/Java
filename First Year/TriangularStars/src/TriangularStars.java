/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:   5      Comment: The names are formatted correctly and make the code easier to understand.
 2. Did I indent the code appropriately?
        Mark out of 5:  5       Comment: The code is indented correctly making the structure very clear.
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body)
  and invoke it correctly?
       Mark out of 20:    20      Comment:The  function is correctly written with the function header, body and return.
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:     20     Comment:The function is also formatted correctly with parameters, return type and function body.
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15:   15       Comment:The triangle numbers are correctly calculated within the determineTriangleNumber function.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10:    10      Comment: I looped through all the triangle numbers from 1 to the max value of int by creating
        a constant called max value.
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20:    20    Comment:It prints out the five numbers that are triangular stars.
 8. How well did I complete this self-assessment?
        Mark out of 5:    4    Comment: Probably a little generous to be honest.
 Total Mark out of 100 (Add all the previous marks):
*/ 

public class TriangularStars {
	public static final int MAX_VALUE = Integer.MAX_VALUE;
	
	public static int determineTriangleNumber (int triangleIndex)
	{
		int n = triangleIndex;
		int triangleNumber = 0;
		while (n!= 0)
		{
			triangleNumber += n;
			n--;
		}
		return triangleNumber;
	}
	
	public static boolean isStarNumber (int triangleNumber, int triangleIndex)
	{
		int starIndex = 0;
		while (starIndex <= triangleIndex && triangleNumber != ( (6 * starIndex) * (starIndex -1) + 1))
		{
			starIndex++;
		}
		if (triangleNumber == ( (6 * starIndex) * (starIndex -1) + 1))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public static void main(String[] args) {
		int triangleIndex = 0;
		System.out.print("The triangular stars are : ");
		while ( determineTriangleNumber(triangleIndex) < MAX_VALUE)
		{
			if (isStarNumber(determineTriangleNumber(triangleIndex), triangleIndex))
			{
				System.out.println(determineTriangleNumber(triangleIndex));
			}
			triangleIndex++;
		}
		
		
	
		// TODO Auto-generated method stub

	}

}
