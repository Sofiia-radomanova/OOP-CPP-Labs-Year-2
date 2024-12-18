package lab3;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void foo(Series obj, int i, int n) {
        obj.getInfo(i, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перший член прогресії: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Введіть різницю/знаменник прогресії: ");
        double increase = scanner.nextDouble();

        System.out.print("Введіть номер i члена прогресії: ");
        int i = scanner.nextInt();

        System.out.print("Введіть кількість членів прогресії: ");
        int n = scanner.nextInt();

        System.out.println();

        // Створення екземплярів класів
        Arithmetic arithmetic = new Arithmetic(firstNumber, increase);
        Geometric geometric = new Geometric(firstNumber, increase);

        // Виклик методів
        arithmetic.getInfo(i, n);
        geometric.getInfo(i, n);

        System.out.println("\nСтворення масиву класів-нащадків:");

        // Створення масиву з випадковими прогресіями
        Random random = new Random();
        Series[] seriesArray = new Series[5];

        for (int j = 0; j < seriesArray.length; j++) {
            double first = random.nextInt(10) + 1;
            double step = random.nextInt(5) + 1;

            if (random.nextInt(2) == 0) {
                seriesArray[j] = new Arithmetic(first, step);
            } else {
                seriesArray[j] = new Geometric(first, step);
            }
        }

        // Виклик методів getInfo для кожного елемента масиву
        System.out.print("Введіть номер i члена прогресії для всіх прогресій: ");
        int i_1 = scanner.nextInt();

        System.out.print("Введіть кількість перших членів прогресії для обчислення суми: ");
        int n_1 = scanner.nextInt();

        for (Series series : seriesArray) {
            series.getInfo(i_1, n_1);
            System.out.println("--------------------------");
        }

        scanner.close();

       
    }
}
