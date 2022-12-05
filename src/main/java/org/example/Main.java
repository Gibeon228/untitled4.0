package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<NPC> list = new ArrayList<>();
        list.add(new Monk());
        list.add(new Peasant());
        list.add(new Robber());
        list.add(new Sniper());
        list.add(new Spearman());
        list.add(new Wizard());
        list.add(new Crossbowman());

        list.forEach(n -> System.out.println(n));
    }
}