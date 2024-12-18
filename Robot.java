package robots1;

public class Robot {
    protected int x;
    protected int y;
    protected int course;


    // Гетери і сетери
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x_val) {
        this.x = x_val;
    }

    public void setY(int y_val) {
        this.y = y_val;
    }

    public void doSomething(){
        System.out.println("Робот виконав міссію!");
    }
}
