package org.example;

import java.util.ArrayList;

public class Monk extends NPC {
    public Monk(ArrayList<NPC> team) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, "");
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
