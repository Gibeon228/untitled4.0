package chars;

import java.util.List;
public class Peasant extends NPC {
    public Peasant(List<NPC> team) {
        super(1, 1, 0, new int[] {1, 1}, 1, 3, true, "");
        super.team = team;

    }

    @Override
    public void step(List<NPC> team) {

    }
}
