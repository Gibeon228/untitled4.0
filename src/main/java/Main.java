import chars.*;

import java.util.*;


public class Main {
    public static final int GANG_SIZE = 10;
    public static List<NPC> whiteTeam;
    public static List<NPC> darkTeam;


    public static void main(String[] args) {

        init();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
            setPriority();
        }
    }

    public static void setPriority() {
        for (int i = 0; i < 10; i++) {
            String clazz = whiteTeam.get(i).getClass().toString();
            if (clazz.contains("Sniper")) {
                whiteTeam.get(i).step(darkTeam);
            }
            clazz = darkTeam.get(i).getClass().toString();
            if (clazz.contains("Crossbowman")) {
                darkTeam.get(i).step(whiteTeam);
            }
        }

        for (int i = 0; i < 10; i++) {
            String clazz = whiteTeam.get(i).getClass().toString();
            if (clazz.contains("Robber")) {
                whiteTeam.get(i).step(darkTeam);
            }
            clazz = darkTeam.get(i).getClass().toString();
            if (clazz.contains("Spearman")) {
                darkTeam.get(i).step(whiteTeam);
            }
        }

        for (int i = 0; i < 10; i++) {
            String clazz = whiteTeam.get(i).getClass().toString();
            if (clazz.contains("Monk")) {
                whiteTeam.get(i).step(darkTeam);
            }
            clazz = darkTeam.get(i).getClass().toString();
            if (clazz.contains("Wizard")) {
                darkTeam.get(i).step(whiteTeam);
            }
        }

        for (int i = 0; i < 10; i++) {
            String clazz = whiteTeam.get(i).getClass().toString();
            if (clazz.contains("Peasant")) {
                whiteTeam.get(i).step(darkTeam);
            }
            clazz = darkTeam.get(i).getClass().toString();
            if (clazz.contains("Peasant")) {
                darkTeam.get(i).step(whiteTeam);
            }
        }
    }

    private static void init() {
        whiteTeam = new ArrayList<>();
        darkTeam = new ArrayList<>();

        int x = 1, y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteTeam.add(new Peasant(whiteTeam, x++, y));
                    break;
                case 1:
                    whiteTeam.add(new Robber(whiteTeam, x++, y));
                    break;
                case 2:
                    whiteTeam.add(new Sniper(whiteTeam, x++, y));
                    break;
                default:
                    whiteTeam.add(new Monk(whiteTeam, x++, y));
            }
        }
        x = 0;
        y = 9;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    darkTeam.add(new Peasant(darkTeam, x++, y));
                    break;
                case 1:
                    darkTeam.add(new Spearman(darkTeam, x++, y));
                    break;
                case 2:
                    darkTeam.add(new Crossbowman(darkTeam, x++, y));
                    break;
                default:
                    darkTeam.add(new Wizard(darkTeam, x++, y));
            }
        }
    }
}

