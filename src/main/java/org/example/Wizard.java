package org.example;

import java.util.ArrayList;

public class Wizard extends NPC{
    public Wizard(ArrayList<NPC> team) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, false, "");
        super.team = team;
    }

    @Override
    public void step(ArrayList<NPC> team) {

    }

}
