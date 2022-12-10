package chars;

import java.util.List;
public class Spearman extends NPC{
    public Spearman(List<NPC> team) {
        super(4, 5, 0, new int[]{1, 3}, 10, 4, false, "");
        super.team = team;
    }


    @Override
    public void step(List<NPC> team) {

    }
}
