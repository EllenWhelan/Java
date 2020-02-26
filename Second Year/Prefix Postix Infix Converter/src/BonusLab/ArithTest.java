

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class ArithTest {

	@Test
	public void testingValidatePrefixOrder() {
		String [] prefixLiterals = new String[5];
		//testing with valid prefix string
		
		prefixLiterals[0]="*";
		prefixLiterals[1]="-";
		prefixLiterals[2]="1";
		prefixLiterals[3]="2";
		prefixLiterals[4]="3";
		assertEquals("testing validate prefix should return true", true, Arith.validatePrefixOrder(prefixLiterals));
		
		
		//testing with non valid prefix string : + 2 3 - 4
		prefixLiterals=new String[5];
		prefixLiterals[0]="+";
		prefixLiterals[1]="2";
		prefixLiterals[2]="3";
		prefixLiterals[3]="-";
		prefixLiterals[4]="4";
		assertEquals("testing validate prefix should return false", false, Arith.validatePrefixOrder(prefixLiterals));
	}

	@Test
	public void testingValidatePostfixOrder() {
		String [] postfixLiterals= new String[5];
		//testing with valid post fix expression
		postfixLiterals[0]="3";
		postfixLiterals[1]="1";
		postfixLiterals[2]="2";
		postfixLiterals[3]="-";
		postfixLiterals[4]="*";
		assertEquals("testing validate postfix should return true", true, Arith.validatePostfixOrder(postfixLiterals));
		
		//testing with non valid
		postfixLiterals=new String[5];
		postfixLiterals[0]="+";
		postfixLiterals[1]="2";
		postfixLiterals[2]="3";
		postfixLiterals[3]="-";
		postfixLiterals[4]="4";
		assertEquals("testing validate postfix should return false", false, Arith.validatePostfixOrder(postfixLiterals));
	}
	@Test 
	public void testEvaluatePrefixOrder() {
		
		String [] prefixLiterals = new String[5];
		//testing for * -
		prefixLiterals[0]="*";
		prefixLiterals[1]="-";
		prefixLiterals[2]="1";
		prefixLiterals[3]="2";
		prefixLiterals[4]="3";
		assertEquals("testing evaluate prefix should return -3", -3, Arith.evaluatePrefixOrder(prefixLiterals));
		
		prefixLiterals= new String[5];
		//testing with + and /
		prefixLiterals[0]="/";
		prefixLiterals[1]="+";
		prefixLiterals[2]="1";
		prefixLiterals[3]="2";
		prefixLiterals[4]="3";
		assertEquals("testing validate postfix should return 1", 1, Arith.evaluatePrefixOrder(prefixLiterals));
	}
	@Test
	public void testEvaulatePostfixOrder() {
		String [] postfixLiterals= new String[5];
		//testing with * and -
		postfixLiterals[0]="3";
		postfixLiterals[1]="1";
		postfixLiterals[2]="2";
		postfixLiterals[3]="-";
		postfixLiterals[4]="*";
		assertEquals("testing evaluate postfix should return -3", -3, Arith.evaluatePostfixOrder(postfixLiterals));
		
		postfixLiterals= new String[5];
		//testing with + and /
		postfixLiterals[0]="3";
		postfixLiterals[1]="1";
		postfixLiterals[2]="2";
		postfixLiterals[3]="+";
		postfixLiterals[4]="/";
		assertEquals("testing validate postfix should return 1", 1, Arith.evaluatePostfixOrder(postfixLiterals));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testConvertPrefixtoPostfix() {
		String [] prefixLiterals = new String[5];
		prefixLiterals[0]="*";
		prefixLiterals[1]="-";
		prefixLiterals[2]="1";
		prefixLiterals[3]="2";
		prefixLiterals[4]="3";
		
		String [] expectedExpression = new String[5];
		expectedExpression[0]="1";
		expectedExpression[1]="2";
		expectedExpression[2]="-";
		expectedExpression[3]="3";
		expectedExpression[4]="*";
		
		String [] convertedExpression = Arith.convertPrefixToPostfix(prefixLiterals);
		Boolean converted = true;
		for(int i=0;i<convertedExpression.length; i++) {
			System.out.println(convertedExpression[i]) ;
			if(convertedExpression[i].equals(expectedExpression[i])) converted=true;
			else converted=false;
				
		}
		 
		assertEquals("Testing convert pre to post ",true,converted);
		
	}
	
	@Test
	public void testConvertPostfixtoPrefix() {
		String [] postfixLiterals= new String[5];
		//testing with * and -
		postfixLiterals[0]="1";
		postfixLiterals[1]="2";
		postfixLiterals[2]="-";
		postfixLiterals[3]="3";
		postfixLiterals[4]="*";
		
		String [] expectedExpression = new String[5];
		expectedExpression[0]="*";
		expectedExpression[1]="-";
		expectedExpression[2]="1";
		expectedExpression[3]="2";
		expectedExpression[4]="3";
		
		String [] convertedExpression = Arith.convertPostfixToPrefix(postfixLiterals);
		Boolean converted = true;
		for(int i=0;i<convertedExpression.length; i++) {
			System.out.println(convertedExpression[i]) ;
			if(convertedExpression[i].equals(expectedExpression[i])) converted=true;
			else converted=false;
				
		}
		 
		assertEquals("Testing convert post to pre-expect true ",true,converted);
	}
	
	@Test
	public void testConvertPrefixToInfix() {
		String [] prefixLiterals = new String[7];
		prefixLiterals[0]="*";
		prefixLiterals[1]="+";
		prefixLiterals[2]="1";
		prefixLiterals[3]="2";
		prefixLiterals[4]="-";
		prefixLiterals[5]="3";
		prefixLiterals[6]="4";
		
		String [] expectedExpression = new String[13];
		expectedExpression[0]="(";
		expectedExpression[1]="(";
		expectedExpression[2]="1";
		expectedExpression[3]="+";
		expectedExpression[4]="2";
		expectedExpression[5]=")";
		expectedExpression[6]="*";
		expectedExpression[7]="(";
		expectedExpression[8]="3";
		expectedExpression[9]="-";
		expectedExpression[10]="4";
		expectedExpression[11]=")";
		expectedExpression[12]=")";
		
		String [] convertedExpression = Arith.convertPrefixToInfix(prefixLiterals);
		Boolean converted = true;
		for(int i=0;i<convertedExpression.length; i++) {
			System.out.println(convertedExpression[i]) ;
			if(convertedExpression[i].equals(expectedExpression[i])) converted=true;
			else converted=false;
				
		}
		 
		assertEquals("Testing convert pre to in-expect true ",true,converted);
		
	}
	
	@Test
	public void testConvertPostfixtoInfix() {
		String [] postfixLiterals= new String[5];
		//testing with * and -
		postfixLiterals[0]="1";
		postfixLiterals[1]="2";
		postfixLiterals[2]="3";
		postfixLiterals[3]="+";
		postfixLiterals[4]="+";
		
		String [] expectedExpression = new String[9];
		expectedExpression[0]="(";
		expectedExpression[1]="1";
		expectedExpression[2]="+";
		expectedExpression[3]="(";
		expectedExpression[4]="2";
		expectedExpression[5]="+";
		expectedExpression[6]="3";
		expectedExpression[7]=")";
		expectedExpression[8]=")";
		
		
		String [] convertedExpression = Arith.convertPostfixToInfix(postfixLiterals);
		Boolean converted = true;
		for(int i=0;i<convertedExpression.length; i++) {
			System.out.println(convertedExpression[i]) ;
			if(convertedExpression[i].equals(expectedExpression[i])) converted=true;
			else converted=false;
				
		}
		 
		assertEquals("Testing convert post to in-expect true ",true,converted);

		
		
	}

}
