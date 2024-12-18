package lab3;

public abstract class Series {
    protected double startNumber;  // Перший член прогресії
    protected double increase;     // Різниця або знаменник прогресії

    // Конструктор
    public Series(double startNumber, double increase) {
        this.startNumber = startNumber;
        this.increase = increase;
    }

    // Чистий віртуальний метод для обчислення i-го члена прогресії
    public abstract void calculateTerm(int i);

    // Чистий віртуальний метод для обчислення суми прогресії
    public abstract void calculateSum(int n);

    // Метод для виведення інформації про прогресію
    public void getInfo(int i, int n) {
        System.out.println("Інформація про прогресію:");
        calculateTerm(i);
        calculateSum(n);
    }

    
}
