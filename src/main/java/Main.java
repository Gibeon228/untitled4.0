import chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int GANG_SIZE = 10;

    private static List<NPC> whiteTeam;

    private static List<NPC> darkTeam;

    public static void main(String[] args) {

        init();

        System.out.println(ConsoleView.top10);

//        whiteTeam.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("------------------------------------");
//        darkTeam.forEach(n -> System.out.println(n.getInfo()));
    }

    private static void init() {
        whiteTeam = new ArrayList<>();
        darkTeam = new ArrayList<>();

        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteTeam.add(new Monk(whiteTeam));
                    break;
                case 1:
                    whiteTeam.add(new Peasant(whiteTeam));
                    break;
                case 2:
                    whiteTeam.add(new Robber(whiteTeam));
                    break;
                default:
                    whiteTeam.add(new Sniper(whiteTeam));
                    break;
            }

            switch (new Random().nextInt(4)) {
                case 0:
                    whiteTeam.add(new Spearman(darkTeam));
                    break;
                case 1:
                    whiteTeam.add(new Peasant(darkTeam));
                    break;
                case 2:
                    whiteTeam.add(new Wizard(darkTeam));
                    break;
                default:
                    whiteTeam.add(new Crossbowman(darkTeam));
                    break;
            }
        }
    }
}

