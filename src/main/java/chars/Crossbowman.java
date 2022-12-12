package chars;

import java.util.List;

public class Crossbowman extends NPC{
    public Crossbowman(List<NPC> team, int x, int y) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, "Crossbowman");
        super.team = team;
        super.position = new Vector2(x, y);


    }

    @Override
    public void step(List<NPC> team) {

    }
}
