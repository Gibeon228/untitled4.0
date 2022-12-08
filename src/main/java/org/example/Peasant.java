package org.example;

import java.util.ArrayList;

public class Peasant extends NPC {
    public Peasant(ArrayList<NPC> team) {
        super(1, 1, 0, new int[] {1, 1}, 1, 3, true, "");
        super.team = team;

    }

    @Override
    public void step(ArrayList<NPC> team) {

    }
}
