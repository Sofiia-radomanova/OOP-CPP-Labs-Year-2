package robots1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalkRobot extends Robot implements Rotetable, Shiftable {
    private List<Action> actionList;
    
 // Конструктор за замовчуванням
    public WalkRobot() {
        this.actionList = new ArrayList<>();
    }

    // Гетер для списку дій
    public List<Action> getActionList() {
        return actionList;
    }
   
    
    // Сетер для списку дій, який заповнюється користувачем
    public void setActionList() {
        Scanner scanner = new Scanner(System.in);
        List<Action> actions = new ArrayList<>();
        boolean addMoreActions = true;

        System.out.println("Створюємо список дій для робота");

        // Додавання дій користувачем
        while (addMoreActions) {
            System.out.println("Виберіть тип дії:");
            System.out.println("1 - Зміщення вперед (ShiftF)");
            System.out.println("2 - Зміщення назад (ShiftB)");
            System.out.println("3 - Поворот вперед (RotF)");
            System.out.println("4 - Поворот назад (RotB)");
            System.out.println("5 - Виконання місії (DoSomething)");

            int actionChoice = scanner.nextInt();
            Action.ActionType actionType = null;

            switch (actionChoice) {
                case 1 -> actionType = Action.ActionType.ShiftF;
                case 2 -> actionType = Action.ActionType.ShiftB;
                case 3 -> actionType = Action.ActionType.RotF;
                case 4 -> actionType = Action.ActionType.RotB;
                case 5 -> actionType = Action.ActionType.DoSomething;
                default -> {
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    continue;
                }
            }
    
            System.out.println("Введіть кількість кроків для обраної дії:");
            int stepCount = scanner.nextInt();

            // Додавання дії до списку
            actions.add(new Action(actionType, stepCount));

            // Запит на продовження додавання дій
            System.out.println("Бажаєте додати ще одну дію? (так/ні)");
            String userResponse = scanner.next();

            if (!userResponse.equalsIgnoreCase("так")) {
                addMoreActions = false;
            }
        }

        this.actionList = actions; // Присвоєння списку дій об'єкту робота
        scanner.close(); 
    }
    
    // Метод для перегляду списку дій
    public void viewActionList() {
        for (Action action : actionList) {
            System.out.println(action.getActionType() + " з кількістю кроків: " + action.getStepCount());
        }
    }

    @Override
    public void shiftForward() {
        switch (course) {
            case 0 -> y += step_shift;
            case 90 -> x += step_shift;
            case 180 -> y -= step_shift;
            case 270 -> x -= step_shift;
        }
    }

    @Override
    public void shiftBackward() {
        switch (course) {
            case 0 -> y -= step_shift;
            case 90 -> x -= step_shift;
            case 180 -> y += step_shift;
            case 270 -> x += step_shift;
        }
    }

    @Override
    public void rotateForward() {
        course = (course + step_angle) % 360;
    }

    @Override
    public void rotateBackward() {
        course = (course - step_angle + 360) % 360;
    }

    @Override
    public void move() {
        for (Action action : actionList) {
            for (int i = 0; i < action.getStepCount(); i++) {
                switch (action.getActionType()) {
                    case RotF -> rotateForward();
                    case RotB -> rotateBackward();
                    case ShiftF -> shiftForward();
                    case ShiftB -> shiftBackward();
                    case DoSomething -> doSomething();
                }
            }
            // Вивід позиції після кожної дії
            System.out.println("Позиція: (" + x + ", " + y + "), Напрямок: " + course);
        }
    }
 
}