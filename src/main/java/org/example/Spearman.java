package org.example;

import java.util.ArrayList;

public class Spearman extends NPC{
    public Spearman(ArrayList<NPC> team) {
        super(4, 5, 0, new int[]{1, 3}, 10, 4, false, "");
        super.team = team;
    }


    @Override
    public void step(ArrayList<NPC> team) {

    }
}
