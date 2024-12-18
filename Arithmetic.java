package lab3;

public class Arithmetic extends Series {

    // Конструктор
    public Arithmetic(double startNumber, double increase) {
        super(startNumber, increase);
    }

    // Перевизначення методу для обчислення i-го члена
    @Override
    public void calculateTerm(int i) {
        double term = startNumber + (i - 1) * increase;
        System.out.println("i-й член арифметичної прогресії: " + term);
    }

    // Перевизначення методу для обчислення суми прогресії
    @Override
    public void calculateSum(int n) {
        double sum = (n / 2.0) * (2 * startNumber + (n - 1) * increase);
        System.out.println("Сума перших " + n + " елементів арифметичної прогресії: " + sum);
    }

    // finalize метод для симуляції деструктора
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Видалення об'єкта класу Arithmetic");
    }
}
