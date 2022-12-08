package org.example;

import java.util.ArrayList;

public class Wizard extends NPC {
    public Wizard(ArrayList<NPC> team) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, false, "");
        super.team = team;
    }

    @Override
    public void step(ArrayList<NPC> team) {

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
