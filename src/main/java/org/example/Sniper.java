package org.example;

import java.util.ArrayList;

public class Sniper extends NPC {
    public Sniper(ArrayList<NPC> team) {
        super(12, 10, 32, new int[]{8, 10}, 15, 9, false, "");
        super.team = team;

    }

    @Override
    public void step(ArrayList<NPC> team) {

    }
}
