package chars;

import java.util.List;
public class Robber extends NPC {
    public Robber(List<NPC> team, int x, int y) {

        super(8, 3, 0, new int[]{2, 4}, 10, 6, false, "Robber");
        super.team = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(List<NPC> team) {

    }
}
