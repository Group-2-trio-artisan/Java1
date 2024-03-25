package lab5.Exercise2;

public class MovablePoint implements Movable{ // implements kế thừa interface
    int x,y;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }
    @Override
    public String toString() {
        return "MovablePoint{" + "x=" + x + ", y=" + y + '}';
    }
}
