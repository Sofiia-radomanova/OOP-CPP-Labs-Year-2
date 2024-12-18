package robots1;

public class Action {
    private ActionType actionType; // Тип дії
    private int stepCount; // Кількість кроків для даної дії

    // Конструктор
    public Action(ActionType actionType, int stepCount) {
        this.actionType = actionType;
        this.stepCount = stepCount;
    }

    // Метод для отримання типу дії
    public ActionType getActionType() {
        return actionType;
    }

    // Метод для встановлення типу дії
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    // Метод для отримання кількості кроків
    public int getStepCount() {
        return stepCount;
    }

    // Метод для встановлення кількості кроків
    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public static enum ActionType {
        RotF, RotB, ShiftF, ShiftB, DoSomething
    }
}


