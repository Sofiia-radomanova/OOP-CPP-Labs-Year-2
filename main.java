package tasks;
import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		    	Fraction defaultfraction = new Fraction();
		    	System.out.println("Результат роботи конструктора без параметрів:" + defaultfraction);
		        
		        
		        Fraction frac1 = new Fraction();
		        System.out.println("Введіть дані для дробу 1:");
		        frac1.createFraction();		      
		        
		        Fraction frac2 = new Fraction();		       
		        System.out.println("Введіть дані для дробу 2:");
		        frac2.createFraction();
		        	
		        
		        System.out.println("Результат роботи методів класу Fraction:");
		        		
		        Fraction resultAdd = frac1.add(frac2);
		        System.out.println("Сума: " + resultAdd);

		        Fraction resultSubtract = frac1.subtract(frac2);
		        System.out.println("Різниця: " + resultSubtract);

		        Fraction resultMultiply = frac1.multiply(frac2);
		        System.out.println("Добуток: " + resultMultiply);

		        Fraction resultDivide = frac1.divide(frac2);
		        System.out.println("Частка: " + resultDivide);
		        
		        String resultCompare = frac1.compare(frac2); //Порівняння дробів
		        System.out.println(resultCompare);
		        
		        
		       // створюємо об'єкт класу Calculator, використовуючи конструктор
		        Calculator calculator = new Calculator(frac1, frac2);
		        System.out.println("Результат роботи методів класу Calculator:");
		        
		        Fraction resultAddCalculator = calculator.addFractions();
		        System.out.println("Сума за допомогою калькулятора: " + resultAddCalculator);
		        
		        Fraction resultSubtractCalculator = calculator.subtractFractions();
		        System.out.println("Різниця за допомогою калькулятора: " + resultSubtractCalculator);

		        Fraction resultMultiplyCalculator = calculator.multiplyFractions();
		        System.out.println("Добуток за допомогою калькулятора: " + resultMultiplyCalculator);

		        Fraction resultDivideCalculator = calculator.divideFractions();
		        System.out.println("Частка за допомогою калькулятора: " + resultDivideCalculator);
		        
		        
		    }

	}


