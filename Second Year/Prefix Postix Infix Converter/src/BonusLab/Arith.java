

import java.util.Stack;

public class Arith {
	// -------------------------------------------------------------------------
	/**
	 * Utility class containing validation/evaluation/conversion operations for
	 * prefix and postfix arithmetic expressions.
	 *
	 * @author
	 * @version 1/12/15 13:03:48
	 */

	// ~ Validation methods
	// ..........................................................

	/**
	 * Validation method for prefix notation.
	 *
	 * @param prefixLiterals
	 *            : an array containing the string literals hopefully in prefix
	 *            order. The method assumes that each of these literals can be one
	 *            of: - "+", "-", "*", or "/" - or a valid string representation of
	 *            an integer.
	 *
	 * @return true if the parameter is indeed in prefix notation, and false
	 *         otherwise.
	 *         
 *       Q6: The run time is theta(N) where N is the number of strings in the array prefixLiterals as the for loop iterates N times
 *       Q7: limited variabe names mean optimal memory sage and a run time of theta(N)
	 **/
	public static boolean validatePrefixOrder(String prefixLiterals[]) {
		int count = 1;
		boolean returnVal = true;
		for (int i = 0; i < prefixLiterals.length; i++) {
			if (prefixLiterals[i].equals("+") || prefixLiterals[i].equals("-") || prefixLiterals[i].equals("*")
					|| prefixLiterals[i].equals("/")) {
				count++;
			} else
				count--;
			if (count <= 0 && i != prefixLiterals.length - 1)
				returnVal = false;
		}
		if (count == 0 && returnVal == true)
			return true;
		else
			return false;
		// TODO
	}

	/**
	 * Validation method for postfix notation.
	 *
	 * @param postfixLiterals
	 *            : an array containing the string literals hopefully in postfix
	 *            order. The method assumes that each of these literals can be one
	 *            of: - "+", "-", "*", or "/" - or a valid string representation of
	 *            an integer.
	 *
	 * @return true if the parameter is indeed in postfix notation, and false
	 *         otherwise.
	 *         Q6: The run time is theta(N) where N is the number of strings in the array postfixLiterals as the for loop iterates N times
	 **/
	public static boolean validatePostfixOrder(String postfixLiterals[]) {
		int count = 1;
		boolean returnVal = true;
		for (int i = 0; i < postfixLiterals.length; i++) {
			if (postfixLiterals[i].equals("+") || postfixLiterals[i].equals("-") || postfixLiterals[i].equals("*")
					|| postfixLiterals[i].equals("/")) {
				count++;
			} else
				count--;
			if (count > 0)
				returnVal = false;
		}
		if (count == 0 && returnVal == true)
			return true;
		else
			return false;
	}

	// ~ Evaluation methods
	// ..........................................................

	/**
	 * Evaluation method for prefix notation.
	 *
	 * @param prefixLiterals
	 *            : an array containing the string literals in prefix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 * Q6: The run time is theta(N) where N is the number of strings in the array prefixLiterals as the for loop iterates N times  everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 * Q7: the ints x,y,result are only crated once and then overwritten each time. no variabke is used as a return val
	 **/
	public static int evaluatePrefixOrder(String prefixLiterals[]) {
		Stack<Integer> stack = new Stack<>();
		int x, y, result;
		for (int i = prefixLiterals.length - 1; i >= 0; i--) {
			if (prefixLiterals[i].equals("+") || prefixLiterals[i].equals("-") || prefixLiterals[i].equals("*")
					|| prefixLiterals[i].equals("/")) {
				x = stack.pop();
				y = stack.pop();
				
				if (prefixLiterals[i].equals("+"))
					result = x + y;
				else if (prefixLiterals[i].equals("-"))
					result = x - y;
				else if (prefixLiterals[i].equals("*"))
					result = x * y;
				else
					result = x / y; // if(prefixLiterals[i].equals("/"))

				stack.push(result);
			} else {
				stack.push(Integer.parseInt(prefixLiterals[i]));
			}
		}
		return stack.pop();
	}

	/**
	 * Evaluation method for postfix notation.
	 *
	 * @param postfixLiterals
	 *            : an array containing the string literals in postfix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 * Q6: The run time is theta(N) where N is the number of strings in the array postfixLiterals as the for loop iterates N times  everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 *Q7:no uneccessary duplicatin of variables makes good use of mempry space
	 **/
	public static int evaluatePostfixOrder(String postfixLiterals[]) {
		Stack<Integer> stack = new Stack<>();
		int x,y,result;
		for (int i = 0; i < postfixLiterals.length; i++) {
			if (postfixLiterals[i].equals("+") || postfixLiterals[i].equals("-") || postfixLiterals[i].equals("*")
					|| postfixLiterals[i].equals("/")) {
				// pop pff prev two and
				y = stack.pop();
				x = stack.pop();
				
				if (postfixLiterals[i].equals("+"))
					result = x + y;
				else if (postfixLiterals[i].equals("-"))
					result = x - y;
				else if (postfixLiterals[i].equals("*"))
					result = x * y;
				else
					result = x / y; // if(postfixLiterals[i].equals("/"))

				stack.push(result);

			} else {
				stack.push(Integer.parseInt(postfixLiterals[i]));
			}
		}
		return stack.pop();
	}

	// ~ Conversion methods
	// ..........................................................

	/**
	 * Converts prefix to postfix.
	 *
	 * @param prefixLiterals
	 *            : an array containing the string literals in prefix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the expression in postfix order.
	 * Q6: The run time is theta(N) where N is the number of strings in the array prefixLiterals as the for loop iterates N times everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 *Q7:limited amount of variabkes stored to reduce memory usage
	 **/
	public static String[] convertPrefixToPostfix(String prefixLiterals[]) {
		
		Stack<String> stack = new Stack<>();
		for (int i = prefixLiterals.length - 1; i >= 0; i--) {
			if (prefixLiterals[i].equals("+") || prefixLiterals[i].equals("-") || prefixLiterals[i].equals("*")
					|| prefixLiterals[i].equals("/")) {
				String x = stack.pop();
				String y = stack.pop();
				String result = x + " " + y + " " + prefixLiterals[i];
				stack.push(result);

			} else {
				stack.push(prefixLiterals[i]);
			}
		}
		
		return stack.pop().split(" ");
	}

	/**
	 * Converts postfix to prefix.
	 *
	 * @param prefixLiterals
	 *            : an array containing the string literals in postfix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the expression in prefix order.
	 * Q6: The run time is theta(N) where N is the number of strings in the array posstfixLiterals as the for loop iterates N times everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 **/
	public static String[] convertPostfixToPrefix(String postfixLiterals[]) {
		String[] preFixResult = new String[postfixLiterals.length];
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < postfixLiterals.length; i++) {
			if (postfixLiterals[i].equals("+") || postfixLiterals[i].equals("-") || postfixLiterals[i].equals("*")
					|| postfixLiterals[i].equals("/")) {
				String y = stack.pop();
				String x = stack.pop();
				String result = postfixLiterals[i] + " " + x + " " + y;
				stack.push(result);
			} else {
				stack.push(postfixLiterals[i]);
			}
		}
		preFixResult=stack.pop().split(" ");
		 return preFixResult;
	}

	/**
	 * Converts prefix to infix.
	 *
	 * @param infixLiterals
	 *            : an array containing the string literals in prefix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 * Q6: The run time is theta(N) where N is the number of strings in the array prefixLiterals as the for loop iterates N times everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 *Q7: limite nmber of duplicate varoables
	 **/
	public static String[] convertPrefixToInfix(String prefixLiterals[]) {
		Stack<String> stack = new Stack<>();
		String x,y,result;
		for(int i=prefixLiterals.length-1; i>=0;i--) {
			if (prefixLiterals[i].equals("+") || prefixLiterals[i].equals("-") || prefixLiterals[i].equals("*")
					|| prefixLiterals[i].equals("/")) {
				x=stack.pop();
				y=stack.pop();
				result= "(" + " "+ x + " " + prefixLiterals[i] + " " +y + " " + ")";
				stack.push(result);
			}
			else {
				stack.push(prefixLiterals[i]);
			}
		}
		
		return stack.pop().split(" ");
	}

	/**
	 * Converts postfix to infix.
	 *
	 * @param infixLiterals
	 *            : an array containing the string literals in postfix order. The
	 *            method assumes that each of these literals can be one of: - "+",
	 *            "-", "*", or "/" - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 * Q6: The run time is theta(N) where N is the number of strings in the array postfixLiterals as the for loop iterates N times. everything else in the method
	 * has a runtime of theta(1) as it is all just assignments and comstant. As in asymptotiv notation onky the highest order is counted the runtime is N.
	 *Q7:
	 **/
	public static String[] convertPostfixToInfix(String postfixLiterals[]) {
		Stack<String> stack=new Stack<>();
		for(int i=0; i<postfixLiterals.length;i++) {
			if (postfixLiterals[i].equals("+") || postfixLiterals[i].equals("-") || postfixLiterals[i].equals("*")
					|| postfixLiterals[i].equals("/")) {
				String y=stack.pop();
				String x=stack.pop();
				String result= "(" + " " + x + " " + postfixLiterals[i] + " " + y + " " + ")";
				stack.push(result);
			}
			else {
				stack.push(postfixLiterals[i]);
			}
		}
		String [] infixResult = stack.pop().split(" ");
		return infixResult;
	}

	
	//DATA TYPES USED: QUESTION 5
	/* java stack is used and the methods pop and push both of which involve little processing and have Asymptotic run time of O(1). The mthod contains is not 
	 *  used in this program but that has a run time of O(N) where N is the number of items in the stack.
	 *  
	 *  arrays of strings are also used in this program. The string methods length which has a consant run time of O(1) as the jva class string
	 *  holds the length as an attribute. the string method split it's run time will be O(N) where N is the number of characters in the input String.
	 */
	
	
}
