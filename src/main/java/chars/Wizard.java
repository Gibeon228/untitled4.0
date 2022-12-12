package chars;

import java.util.List;
public class Wizard extends NPC {
    public Wizard(List<NPC> team, int x, int y) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, false, "Wizard");
        super.team = team;
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
