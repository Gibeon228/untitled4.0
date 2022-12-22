package chars;

import java.util.List;

public abstract class Warrior extends NPC {
    public Warrior(int attack, int protection, int[] damage, double health, int speed, States state) {
        super(attack, protection, damage, health, speed, state);
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
        System.out.println(getClass().getSimpleName() + "->" + team.get(index).getClass().getSimpleName() + team.get(index).getHealth());
        return team.get(index);
    }

    @Override
    public void step(List<NPC> team) {
        if (getState().equals(States.DEAD)) return;

        NPC target = findTarget(team);
        if (getPosition().getDistance(target.getPosition()) <= 1) {
            getAttack(target);
        } else {
            move(team, target);
            setState(States.WALK);
        }
    }

    private void move(List<NPC> team, NPC target) {
        int x = getPosition().x;
        int y = getPosition().y;

        if (target.getDestination().y > y && checkPosition(new Vector2(x, y++))) {
            setDestination(new Vector2(x, y++));
        }
        if (target.getDestination().y < y && checkPosition(new Vector2(x, y--))) {
            setDestination(new Vector2(x, y--));
        }

        if (target.getDestination().x > x && checkPosition(new Vector2(x++, y))) {
            setDestination(new Vector2(x++, y));
        }

        if ((target.getDestination().x < x) && (checkPosition(new Vector2(x--, y)))) {
            setDestination(new Vector2(x--, y));
        }
    }

    private boolean checkPosition(Vector2 pos) {
        for (NPC npc : getMyTeam()) {
            if (pos.isEqual(npc.getPosition()) && npc.getState() != States.DEAD) return false;
        }
        return true;
    }
}
