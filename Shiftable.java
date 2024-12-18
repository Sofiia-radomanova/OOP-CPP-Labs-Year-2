package robots1;

public interface Shiftable extends Movable {
    int step_shift = 1; 
    void shiftForward();
    void shiftBackward();

}

