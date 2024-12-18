package lab3;

public class Geometric extends Series {

    // Конструктор
    public Geometric(double startNumber, double increase) {
        super(startNumber, increase);
    }

    // Перевизначення методу для обчислення i-го члена
    @Override
    public void calculateTerm(int i) {
        double term = startNumber * Math.pow(increase, i - 1);
        System.out.println("i-й член геометричної прогресії: " + term);
    }

    // Перевизначення методу для обчислення суми прогресії
    @Override
    public void calculateSum(int n) {
        double sum;
        if (increase == 1) {
            sum = startNumber * n;
        } else {
            sum = startNumber * (1 - Math.pow(increase, n)) / (1 - increase);
        }
        System.out.println("Сума перших " + n + " елементів геометричної прогресії: " + sum);
    
    }
}
