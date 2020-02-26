
public class Rational {

	int numerator;
	int denominator;

	Rational(int numerator, int denominator) {
		this.numerator = numerator;
		if(denominator!=0)this.denominator = denominator;
		throw new IllegalArgumentException("Error: cannot be zero");
	
	}
	
	Rational(int numerator){
		
		this.numerator = numerator;
		this.denominator = 1;
	}
	

	public Rational add(Rational otherRational) {
		int commonDenom = this.denominator * otherRational.denominator;
		int numeratorThis= (commonDenom /this.denominator) * this.numerator;
		int numeratorOther = (commonDenom/otherRational.denominator) *otherRational.numerator;
		int addNumerator = numeratorOther + numeratorThis;
		Rational add = new Rational(addNumerator, commonDenom);
		Rational addSimp = add.simplify();
		return addSimp;
	}
	public Rational subtract(Rational otherRational)
	{
		int commonDenom = this.denominator * otherRational.denominator;
		int numeratorThis= (commonDenom /this.denominator) * this.numerator;
		int numeratorOther = (commonDenom/otherRational.denominator) *otherRational.numerator;
		int subNumerator = numeratorThis-numeratorOther;
		Rational sub = new Rational(subNumerator, commonDenom);
		Rational subSimp = sub.simplify();
		return subSimp;
	}
	public Rational multiply(Rational otherRational)
	{
		int multNumerator = this.numerator * otherRational.numerator;
		int multDenominator = this.denominator * otherRational.denominator;
		Rational mult = new Rational (multNumerator, multDenominator);
		Rational multSimp = mult.simplify();
		return multSimp;
	}
	public Rational divide(Rational otherRational)
	{
		int otherNumerator = otherRational.denominator;
		int otherDenominator = otherRational.numerator;
		int divNumerator = this.numerator * otherNumerator;
		int divDenominator = this.denominator * otherDenominator;
		Rational div = new Rational (divNumerator, divDenominator);
		Rational divSimp = div.simplify();
		return divSimp;
	}
	public boolean equals(Rational otherRational)
	{
		int commonDenom = this.denominator * otherRational.denominator;
		int numeratorThis= (commonDenom /this.denominator) * this.numerator;
		int numeratorOther = (commonDenom/otherRational.denominator) *otherRational.numerator;
		if(numeratorThis ==numeratorOther) return true;
		else return false;
	}
	
	public boolean isLessThan(Rational otherRational) 
	{
		int commonDenom = this.denominator * otherRational.denominator;
		int numeratorThis= (commonDenom /this.denominator) * this.numerator;
		int numeratorOther = (commonDenom/otherRational.denominator) *otherRational.numerator;
		if(numeratorThis < numeratorOther) return true;
		else return false;
	}
	public Rational simplify()
	{
		int GCD = greatestCommonDivisor(this);
		int numSimp = this.numerator / GCD;
		int denomSimp = this.denominator/ GCD;
		this.numerator = numSimp;
		this.denominator =denomSimp;
		return this;
		
	}
	
	public int greatestCommonDivisor(Rational rational)
	{
		int num = rational.numerator;
		int denom = rational.denominator;
		while(num!=0 && denom!=0)
		{
			int temp = denom;
			denom = num % denom;
			num = temp;
			
		}
		if(num ==0) return denom;
		else return num;
	}
	
	public String toString() {
	
		String temp= this.numerator + "/" + this.denominator;
		return temp;
	}


}
