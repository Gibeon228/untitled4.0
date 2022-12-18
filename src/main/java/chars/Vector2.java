package chars;

public class Vector2 {
    public int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public double getDistance (Vector2 pos) {
        return Math.sqrt((x - pos.x) * (x - pos.x) + (y = pos.y) * (y - pos.y));
    }

    public boolean isEqual(Vector2 pos) {
        if (pos.y == y & pos.x == x) return true;
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
