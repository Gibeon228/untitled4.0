package chars;

import java.util.List;

public class Sniper extends NPC {
    public Sniper(List<NPC> team) {
        super(12, 10, 32, new int[]{8, 10}, 15, 9, false, "");
        super.team = team;

    }

    @Override
    public void step(List<NPC> team) {

    }
}
