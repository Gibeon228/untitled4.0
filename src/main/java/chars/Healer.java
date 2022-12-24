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
        int index = findMinHealthEnemy(team);
        if (index < getDamage()[0]) {
            team.get(index).setState(States.DEAD);
            return;
        }
        index = findMinHealth();
        NPC teamMateNeedHealth = getMyTeam().get(index);
        if (teamMateNeedHealth.getHealth() / teamMateNeedHealth.getMaxHealth() < 0.75) {
            teamMateNeedHealth.setHealth(teamMateNeedHealth.getHealth() - getDamage()[0]);
        } else if (revive() > -1) {
            revive();
        } else  if (teamMateNeedHealth.getHealth() / teamMateNeedHealth.getMaxHealth() < 1) {
            teamMateNeedHealth.setHealth(teamMateNeedHealth.getHealth() - getDamage()[0]);
        } else  {
            team.get(findMinHealthEnemy(team)).setHealth(teamMateNeedHealth.getHealth() + getDamage()[0]);
        }

    }

    private int revive() {
        for (NPC teamMate : getMyTeam()) {
            if (teamMate.getState() == States.DEAD && !teamMate.getClass().toString().contains("Peasant"))
            {
                teamMate.setHealth(1);
                teamMate.setState(States.ALIVE);
                return 0;
            }
        }
        return -1;
    }

    private int findMinHealthEnemy(List<NPC> team) {
        double minHealth = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < getMyTeam().size(); i++) {
            if ((team.get(i).getHealth() < minHealth) && team.get(i).getState() != States.DEAD) {
                minHealth = team.get(i).getHealth();
                index = i;
            }
        }
        return index;
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
