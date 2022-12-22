package chars;

import java.util.List;

public abstract class Shooter extends NPC {
    int shoots;

    public Shooter(int attack, int protection, int[] damage, double health, int speed, States state, int shoots) {
        super(attack, protection, damage, health, speed, state);
        this.shoots = shoots;
    }

    @Override
    public void step(List<NPC> team) {
        if (getState() == States.DEAD) return;
        for (int i = 0; i < getMyTeam().size(); i++) {
            if (getMyTeam().get(i).getClass().getSimpleName().equals("Peasant") && getMyTeam().get(i).getState().equals(States.ALIVE)) {
                shoots++;
                getMyTeam().get(i).setState(States.USED);
                break;
            }
        }
        if (shoots <= 0) return;
        shoots--;
        NPC target = findTarget(team);
        getAttack(target);
    }

    private NPC findTarget(List<NPC> team) {
        float minDistance = Float.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getState() == States.DEAD) continue;
            if (minDistance > getPosition().getDistance(team.get(i).getPosition())) {
                minDistance = getPosition().getDistance(team.get(i).getPosition());
                index = i;
            }
        }
        return team.get(index);
    }
}
