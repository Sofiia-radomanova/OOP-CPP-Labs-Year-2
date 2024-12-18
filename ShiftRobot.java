package robots1;

public class ShiftRobot extends Robot implements Shiftable{
	
	// Вкладений клас для представлення позицій з координатами x та y(завдання 4)
    protected static class ShiftPosition {
        int x;
        int y;

        public ShiftPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    protected ShiftPosition start_shift; // Початкова позиція
    protected ShiftPosition end_shift;   // Кінцева позиція
    protected boolean movingToEnd = true; // Напрямок руху: true - до кінцевої позиції, false - до початкової

    // Конструктор
    public ShiftRobot(int startX, int startY, int endX, int endY, int initialCourse) {
        this.start_shift = new ShiftPosition(startX, startY);
        this.end_shift = new ShiftPosition(endX, endY);
        this.course = initialCourse;
    }

    // Гетери і сетери для start_shift і end_shift
    public ShiftPosition getStartShift() {
        return start_shift;
    }

    public ShiftPosition getEndShift() {
        return end_shift;
    }

    public void setStartShift(int x, int y) {
        this.start_shift.setX(x);
        this.start_shift.setY(y);
    }

    public void setEndShift(int x, int y) {
        this.end_shift.setX(x);
        this.end_shift.setY(y);
    }

    @Override
    public void move() {
        // Рух між початковою та кінцевою позиціями
        if (movingToEnd) {
            shiftForward(); // Рух вперед
            if (this.x == end_shift.getX() && this.y == end_shift.getY()) {
                movingToEnd = false; // Зміна напрямку на зворотний
            }
        } else {
            shiftBackward(); // Рух назад
            if (this.x == start_shift.getX() && this.y == start_shift.getY()) {
                movingToEnd = true; // Зміна напрямку на вперед
            }
        }
    }

    @Override
    public void shiftForward() {
        // Рух у напрямку поточної орієнтації
        switch (course) {
            case 0: // Північ
                y += step_shift;
                break;
            case 90: // Схід
                x += step_shift;
                break;
            case 180: // Південь
                y -= step_shift;
                break;
            case 270: // Захід
                x -= step_shift;
                break;
            default:
                System.out.println("Неправильна орієнтація. Орієнтація повинна бути кратною 90 градусам.");
                return;
        }
        System.out.println("Зсунувся вперед до позиції: (" + x + ", " + y + ")");
        doSomething();
    }

    @Override
    public void shiftBackward() {
        // Рух у протилежному напрямку поточної орієнтації
        switch (course) {
            case 0: // Південь
                y -= step_shift;
                break;
            case 90: // Захід
                x -= step_shift;
                break;
            case 180: // Північ
                y += step_shift;
                break;
            case 270: // Схід
                x += step_shift;
                break;
            default:
                System.out.println("Неправильна орієнтація. Орієнтація повинна бути кратною 90 градусам.");
                return;
        }
        System.out.println("Зсунувся назад до позиції: (" + x + ", " + y + ")");
        doSomething();
    }
}