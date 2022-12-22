package chars;

import java.util.List;

public abstract class Healer extends NPC{

    public Healer(int attack, int protection, int[] damage, double health, int speed, States state) {
        super (attack, protection, damage, health, speed, state);
    }
    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step(List<NPC> team) {
        if (getState() == States.DEAD) return;
        setState(States.ATTACK);
        int index = findMinHealth();
        NPC teamMateNeedHealth = getMyTeam().get(index);
        teamMateNeedHealth.setHealth(teamMateNeedHealth.getHealth() - getDamage()[0]);
    }

    private int findMinHealth() {
        double minHealth = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < getMyTeam().size(); i++) {
            if (((getMyTeam().get(i).getHealth() / getMyTeam().get(i).getMaxHealth()) < minHealth) && getMyTeam().get(i).getState() != States.DEAD) {
                minHealth = getMyTeam().get(i).getHealth() / getMyTeam().get(i).getMaxHealth();
                index = i;
            }
        }
        return index;
    }
}
