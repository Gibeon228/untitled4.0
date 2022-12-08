package org.example;

import java.util.ArrayList;

public class Crossbowman extends NPC{
    public Crossbowman(ArrayList<NPC> team) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, "");
        super.team = team;


    }

    @Override
    public void step(ArrayList<NPC> team) {

    }
}
