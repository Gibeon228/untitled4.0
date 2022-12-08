package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<NPC> whiteTeam = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int randomNum = (int) (Math.random() * 4);
            switch (randomNum) {
                case 0 -> whiteTeam.add(new Monk(whiteTeam));
                case 1 -> whiteTeam.add(new Peasant(whiteTeam));
                case 2 -> whiteTeam.add(new Robber(whiteTeam));
                default -> whiteTeam.add(new Sniper(whiteTeam));
            }
        }

        ArrayList<NPC> darkTeam = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomNum = (int) (Math.random() * 4);
            switch (randomNum) {
                case 0 -> darkTeam.add(new Spearman(darkTeam));
                case 1 -> darkTeam.add(new Peasant(darkTeam));
                case 2 -> darkTeam.add(new Wizard(darkTeam));
                default -> darkTeam.add(new Crossbowman(darkTeam));
            }
            //  list.add(new Monk());
            // list.add(new Peasant());
            //  list.add(new Robber());
            // list.add(new Sniper());
            // list.add(new Spearman());
            // list.add(new Wizard());
            //list.add(new Crossbowman());

            // list.forEach(n -> System.out.println(n));

            //NPC monk00 = new Monk();
            //   System.out.println(monk00.getInfo());

        }


        whiteTeam.forEach(n -> System.out.println(n.getInfo()));
    }
}