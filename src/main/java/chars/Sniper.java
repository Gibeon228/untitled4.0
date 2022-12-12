package chars;

import java.util.List;

public class Sniper extends NPC {
    public Sniper(List<NPC> team, int x, int y) {
        super(12, 10, 32, new int[]{8, 10}, 15, 9, false, "Sniper");
        super.team = team;
        super.position = new Vector2(x, y);

    }

    @Override
    public void step(List<NPC> team) {

    }
}
