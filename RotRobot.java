package robots1;

public class RotRobot extends Robot implements Rotetable {
    private int start_angle = 0;
    private int end_angle = 0;
    private RotationDirection direction; // внутрішній клас для напрямку обертання

    // Внутрішній клас для відстеження напрямку обертання (завдання 4)
    private class RotationDirection {
        private boolean movingForward = true; // Логічна змінна для напряму

        public boolean isMovingForward() {
            return movingForward;
        }

        public void reverse() {
            movingForward = !movingForward; // Змінює напрямок на протилежний
        }
    }
    
    
 // Конструктор з параметрами
    public RotRobot(int startAngle, int endAngle) {
        this.start_angle = startAngle;
        this.end_angle = endAngle;
        this.course = startAngle; // Ініціалізуємо course початковим кутом
        this.direction = new RotationDirection(); // Створюємо екземпляр внутрішнього класу
    }

    // Гетери
    public int getStartAngle() {
        return start_angle;
    }

    public int getEndAngle() {
        return end_angle;
    }

    // Сетери
    public void setStartAngle(int startAngle) {
        this.start_angle = startAngle;
    }

    public void setEndAngle(int endAngle) {
        this.end_angle = endAngle;
    }
    
   
    public void move() {
        if (direction.isMovingForward()) { // Перевіряємо напрямок обертання
            rotateForward();
            if (course >= end_angle) {
                direction.reverse(); // Змінюємо напрямок, якщо досягли межі
            }
        } else {
            rotateBackward();
            if (course <= start_angle) {
                direction.reverse(); // Змінюємо напрямок, якщо досягли початку
            }
        }
    }

    @Override
    public void rotateForward() {
        if (course + step_angle <= end_angle) {
            course += step_angle;
        } else {
            course = end_angle; // course не може перевищувати end_angle
        }
        System.out.println("Робот повернувся вперед до кута: " + course);
        doSomething();
    }

    @Override
    public void rotateBackward() {
        if (course - step_angle >= start_angle) {
            course -= step_angle;
        } else {
            course = start_angle; // course не може бути меншим за start_angle
        }
        System.out.println("Робот повернувся назад до кута: " + course);
        doSomething();
    }

   
}