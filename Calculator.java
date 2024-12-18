package tasks;

	public class Calculator {
	    private Fraction fraction1; // Перший дріб
	    private Fraction fraction2; // Другий дріб

	    public Calculator(Fraction fraction1, Fraction fraction2)  // Агрегація: Fraction передається у Calculator
	    {
	        this.fraction1 = fraction1;
	        this.fraction2 = fraction2;
	    }

	    
	 // Метод для додавання дробів
	    public Fraction addFractions() 
	    {
	        return fraction1.add(fraction2);
	    }
	    
	    public Fraction subtractFractions() 
	    {
	        return fraction1.subtract(fraction2);
	    }

	    public Fraction multiplyFractions() 
	    {
	        return fraction1.multiply(fraction2);
	    }

	    public Fraction divideFractions() 
	    {
	        return fraction1.divide(fraction2);
	    }
	    

	    public String toStringFractions() 
	    {
	        return "Calculator working with: " + fraction1 + " and " + fraction2;
	    }
	

}
