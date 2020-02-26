
public class SquareAges {
	
        public static final int MAX_AGE = 123;
        public static final int MIN_AGE = 0; 
		public static final int MIN_YEAR = 1894;
		public static final int MAX_YEAR = 2140;
		public static final int CURRENT_YEAR = 2017;

		public static void main(String[] args) {
		
			int age ;
			int year;
		
			for( age= 0; (age <= MAX_AGE); age++)
			{
				year = age * age;
				if ( year <= MAX_YEAR && year >= MIN_YEAR && (year - age) <= CURRENT_YEAR && (year - age) >= MIN_YEAR)
				{
				System.out.println ("The year " + year + " is the age squared of people aged "
				+ age + " in that year.");
				}
			}
		
		
		}
		
		
}		
				
	


