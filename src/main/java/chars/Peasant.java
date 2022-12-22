package chars;

import java.util.List;
public class Peasant extends NPC {
    public Peasant(List<NPC> team, int x, int y) {
        super(1, 1, new int[] {1, 1}, 1, 3, States.ALIVE);
        super.myTeam = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(List<NPC> team) {
        if (getState().equals(States.USED)) {
            setState(States.ALIVE);
        }
    }
}
