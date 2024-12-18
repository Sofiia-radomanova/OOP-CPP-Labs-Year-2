package tasks;
import java.util.Scanner;
public class Fraction {
    private int numerator; // чисельник
    private int denominator; // знаменник

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator)
    {
        // Переносимо знак до чисельника
        if (denominator < 0) 
        {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        simplify();
    }
    

    @Override //перезаписує метод toString() з класу Object, який є суперкласом для всіх класів у Java
    public String toString() {
    	 // Переносимо знак до чисельника
        if (denominator < 0) 
        {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } 
        return numerator + "/" + denominator;
    }

    // Метод для вводу даних користувачем
    public void createFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть чисельник: ");
        this.numerator = scanner.nextInt();

        do {
            System.out.print("Введіть знаменник (не може бути нульовим): ");
            this.denominator = scanner.nextInt();
            if (this.denominator == 0) {
                System.out.println("Помилка: знаменник не може бути нульовим. Спробуйте ще раз.");
            }
        } while (this.denominator == 0);

        simplify(); // Спростити дроб
    }
    
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int dominator) {
        this.denominator = dominator;
        simplify();
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може бути нульовим.");
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    
    public Fraction add(Fraction other) //додавання
    {
        int newNumerator = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result; // Виклик спрощення
    }

    public Fraction subtract(Fraction other) //віднімання
    {
        int newNumerator = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) // множення
    {
        int newNumerator = this.numerator * other.getNumerator();
        int newDenominator = this.denominator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) //ділення
    {
        if (other.getNumerator() == 0)
        {
            throw new IllegalArgumentException("Ділення на нуль недопустиме.");
        }
        int newNumerator = this.numerator * other.getDenominator();
        int newDenominator = this.denominator * other.getNumerator();
        return new Fraction(newNumerator, newDenominator);
    }

    public String compare(Fraction other) {
        // Перевірка на нульовий знаменник
        if (this.denominator == 0 || other.getDenominator() == 0) {
            throw new IllegalArgumentException("Знаменник не може бути нульовим.");
        }
        
        // Зводимо обидва дроби до спільного знаменника
        int firstNumerator = this.numerator * other.getDenominator();
        int secondNumerator = other.getNumerator() * this.denominator;

        // Порівнюємо чисельники
        if (firstNumerator > secondNumerator) {
            return "Перший дріб (" + this + ") більший за другий дріб (" + other + ")";
        } else if (firstNumerator < secondNumerator) {
            return "Перший дріб (" + this + ") менший за другий дріб (" + other + ")";
        } else {
            return "Обидва дроби (" + this + " і " + other + ") рівні";
        }
    }


    

    
    private int findGCD(int a, int b) { // алгоритм Евкліда для пошуку НСД
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    private void simplify() {
        if (denominator != 0) {
            int gcd = findGCD(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
    }
}
