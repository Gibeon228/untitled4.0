package chars;

import java.util.List;

public class Robber extends Warrior {
    public Robber(List<NPC> team, int x, int y) {

        super(8, 3, new int[]{2, 4}, 10, 6, States.ALIVE);
        super.myTeam = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
