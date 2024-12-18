package robots1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть робота для тестування: ");
        System.out.println("1 - WalkRobot, 2 - ShiftRobot, 3 - RotRobot");
        System.out.println("4 - приклад анонімного розширюючого класу");
        System.out.println("5 - приклад анонімного модифікуючого класу");
        int option = scanner.nextInt();

        switch (option){
            case 1:
                // ТЕСТУВАННЯ РОБОТА WalkRobot

                System.out.println("ТЕСТУВАННЯ РОБОТА WalkRobot");

                // Створення екземпляра WalkRobot
                WalkRobot robot = new WalkRobot();

                System.out.println("Введіть початкові координати робота (x та y): ");

                robot.setX(scanner.nextInt());
                robot.setY(scanner.nextInt());

                // Заповнення списку дій користувачем
                robot.setActionList();

                // Перегляд списку дій
                System.out.println("\nСписок дій робота:");
                robot.viewActionList();

                System.out.println("\nПочаткові координати робота: (" + robot.getX() + ", " + robot.getY() + ")");

                // Виконання руху робота згідно з діями
                System.out.println("\nВиконання дій робота:");
                robot.move();
                break;

            case 2:
                // ТЕСТУВАННЯ РОБОТА ShiftRobot
                System.out.println("\n\nТЕСТУВАННЯ РОБОТА ShiftRobot");

// Отримуємо початкові значення від користувача
                System.out.println("Введіть початкову позицію X (ціле число): ");
                int startX = scanner.nextInt();

                System.out.println("Введіть початкову позицію Y (ціле число): ");
                int startY = scanner.nextInt();

                System.out.println("Введіть кінцеву позицію X (ціле число): ");
                int endX = scanner.nextInt();

                System.out.println("Введіть кінцеву позицію Y (ціле число): ");
                int endY = scanner.nextInt();

                System.out.println("Введіть початкову орієнтацію (0 - північ, 90 - схід, 180 - південь, 270 - захід): ");
                int initialCourse = scanner.nextInt();

                System.out.println("Введіть кількість ітерацій (ціле число): ");
                int iterations = scanner.nextInt();

// Створення екземпляра ShiftRobot із введеними параметрами
                ShiftRobot robot2 = new ShiftRobot(startX, startY, endX, endY, initialCourse);

                System.out.println("\nПочаткові координати робота: (" + robot2.getX() + ", " + robot2.getY() + ")");
                System.out.println("\nПочинаємо рух робота між початковою та кінцевою позиціями...\n");

// Імітуємо кілька кроків руху
                for (int i = 0; i < iterations; i++) {
                    robot2.move();
                }

                System.out.println("\nТестування ShiftRobot завершено.");

                break;

            case 3:
                // ТЕСТУВАННЯ РОБОТА RotRobot

                System.out.println("\n\nТЕСТУВАННЯ РОБОТА RotRobot");

                // Введення початкових значень від користувача
                System.out.println("Введіть початковий кут (кратний 90): ");
                int startAngle = scanner.nextInt();

                System.out.println("Введіть кінцевий кут (кратний 90): ");
                int endAngle = scanner.nextInt();

                System.out.println("Введіть кількість ітерацій (ціле число): ");
                int iterations2 = scanner.nextInt();

                // Створення екземпляра RotRobot із введеними параметрами
                RotRobot robot3 = new RotRobot(startAngle, endAngle);

                System.out.println("\nПочатковий кут робота: " + robot3.getStartAngle());
                System.out.println("\nРобот починає поворот між початковим і кінцевим кутами...\n");

                // Імітуємо кілька кроків повороту
                for (int i = 0; i < iterations2; i++) {
                    robot3.move();
                }

                System.out.println("\nТестування RotRobot завершено.");
                break;

            case 4:

                // ТЕСТУВАННЯ АНОНІМНОГО КЛАСУ З РОЗШИРЕННЯМ
                // НА ПРИКЛАДІ Robot
                Robot robot4 = new Robot();
                System.out.println("Введіть початкові координати робота (x та y): ");

                robot4.setX(scanner.nextInt());
                robot4.setY(scanner.nextInt());

                System.out.println("Robot виконує метод doSomething: ");

                robot4.doSomething();

                Robot robot5 = new Robot(){ //Розширення базового методу doSomething
                    public void doSomething(){
                    System.out.println("Робот виконав місію за допомогою розширеного базового методу!");             
                    }
                };

                System.out.println("Введіть початкові координати робота (x та y): ");

                robot5.setX(scanner.nextInt());
                robot5.setY(scanner.nextInt());

                System.out.println("Robot виконує метод doSomething: ");

                robot5.doSomething();
                break;

            case 5:
                // ТЕСТУВАННЯ МОДИФІКУЮЧОГО АНОНІМНОГО КЛАСУ
                // НА ПРИКЛАДІ ІНТЕРФЕЙСУ Movable
                Movable robot6 = new Movable()  {
                    @Override
                    public void move() {
                        System.out.println("Метод move було викликано!");
                    }
                };

                System.out.println("Тестування методу move для екземпляра інтерфейсу Movable ");
                robot6.move();

            default:
                System.out.println("\nВведено неправильне число");
                break;
        }
    }
}
