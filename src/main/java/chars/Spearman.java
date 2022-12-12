package chars;

import java.util.List;
public class Spearman extends NPC{
    public Spearman(List<NPC> team, int x, int y) {
        super(4, 5, 0, new int[]{1, 3}, 10, 4, false, "Spearman");
        super.team = team;
        super.position = new Vector2(x, y);
    }


    @Override
    public void step(List<NPC> team) {

    }
}
