package chars;

import java.util.List;

public class Crossbowman extends Shooter {
    public Crossbowman(List<NPC> team, int x, int y) {
        super(6, 3, new int[]{2, 3}, 10, 4, States.ALIVE, 16);
        super.myTeam = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
