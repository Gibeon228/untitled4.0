package chars;

import java.util.List;
import java.util.ArrayList;

public class Crossbowman extends NPC {
    public Crossbowman(List<NPC> team, int x, int y) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, "Crossbowman");
        super.myTeam = team;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(List<NPC> team) {
        if (getStatus() == "dead") return;
        for (NPC h : this.myTeam) {
            if (h.getName().equals("Peasant") && (h.status.equals("stand"))) {
                this.shots++;
                h.status = "used";
                break;
            }
        }

        if (this.shots < 1) return;
        double nearest = getPosition().getDistance(team.get(0).position);
        int idNearest = 0;
        //nearest = team.get(0).getPosition().getDistance(team.get(0));
        for (int i = 1; i < team.size(); i++) {
            if (team.get(i).status.equals("dead")) {
                if (getPosition().getDistance(team.get(i).position) < nearest) {
                    nearest = getPosition().getDistance(team.get(i).position);
                    idNearest = i;
                }
            }
        }
        team.get(idNearest).damage(nearest < this.getSpeed() ?
                super.damageValue(team.get(idNearest)) :
                super.damageValue(team.get(idNearest)) / 2);
        this.shots--;
    }
}
