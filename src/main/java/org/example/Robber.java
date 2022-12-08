package org.example;

import java.util.ArrayList;

public class Robber extends NPC {
    public Robber(ArrayList<NPC> team) {
        super(8, 3, 0, new int[]{2, 4}, 10, 6, false, "");
    }

    @Override
    public void step(ArrayList<NPC> team) {

    }
}
