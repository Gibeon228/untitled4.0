import chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int GANG_SIZE = 10;

    public static List<NPC> whiteTeam;

    public static List<NPC> darkTeam;

    public static void main(String[] args) {

        init();
        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
        }



//        whiteTeam.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("------------------------------------");
//        darkTeam.forEach(n -> System.out.println(n.getInfo()));
    }

    private static void init() {
        whiteTeam = new ArrayList<>();
        darkTeam = new ArrayList<>();

        int x = 1, y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: whiteTeam.add(new Peasant(whiteTeam, x++, y)); break;
                case 1: whiteTeam.add(new Robber(whiteTeam, x++, y)); break;
                case 2: whiteTeam.add(new Sniper(whiteTeam, x++, y)); break;
                default: whiteTeam.add(new Monk(whiteTeam, x++, y));
            }
        }
        x=1;
        y=10;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: darkTeam.add(new Peasant(darkTeam, x++, y)); break;
                case 1: darkTeam.add(new Spearman(darkTeam, x++, y)); break;
                case 2: darkTeam.add(new Crossbowman(darkTeam, x++, y)); break;
                default: darkTeam.add(new Wizard(darkTeam, x++, y));
            }
        }
    }
}

