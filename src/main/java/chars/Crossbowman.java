package chars;

import java.util.List;

public class Crossbowman extends NPC{
    public Crossbowman(List<NPC> team) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, "");
        super.team = team;


    }

    @Override
    public void step(List<NPC> team) {

    }
}
