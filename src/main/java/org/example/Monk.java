package org.example;

import java.util.ArrayList;

public class Monk extends NPC{
    public Monk(ArrayList<NPC> team) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, "");
        super.team = team;
    }

    @Override
    public void step(ArrayList<NPC> team) {
        for (NPC player : team) {

        }

    }
}
