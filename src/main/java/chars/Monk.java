package chars;

import java.util.List;

public class Monk extends NPC {
    public Monk(List<NPC> team, int x, int y) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, "Monk");
        super.myTeam = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(List<NPC> team) {

        NPC minHealth = team.get(0);
        double min = minHealth.getHealth() / minHealth.getMaxHealth();
        double mayBeMin;
        for (int i = 1; i < team.size(); i++) {
            NPC mayBeMinHealth = team.get(i);
            mayBeMin = mayBeMinHealth.getHealth() / mayBeMinHealth.getMaxHealth();
            if (min > mayBeMin) {
                min = mayBeMin;
                minHealth = mayBeMinHealth;
            }
        }

        if (minHealth.getHealth() - getDamage()[0] > minHealth.getMaxHealth()) {
            minHealth.setHealth(minHealth.getMaxHealth());
        } else {
            minHealth.setHealth(minHealth.getHealth() - getDamage()[0]);
        }
    }
}
