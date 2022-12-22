package chars;

public class Vector2 {
    public int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public float getDistance (Vector2 pos) {
        return (float) Math.sqrt((x - pos.x) * (x - pos.x) + (y - pos.y) * (y - pos.y));
    }



    public boolean isEqual(Vector2 pos) {
        return (pos.y == y & pos.x == x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
