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

            for (int i = 0; i < darkTeam.size(); i++) {
                if (darkTeam.get(i).getName().equals("Spearman")) {
                    darkTeam.get(i).step(whiteTeam);
                }
            }

            for (int i = 0; i < whiteTeam.size(); i++) {
                if (whiteTeam.get(i).getName().equals("Robber")) {
                    whiteTeam.get(i).step(darkTeam);
                }
            }

            for (int i = 0; i < whiteTeam.size(); i++) {
                if (whiteTeam.get(i).getName().equals("Sniper")) {
                    whiteTeam.get(i).step(darkTeam);
                }
            }

            for (int i = 0; i < darkTeam.size(); i++) {
                if (darkTeam.get(i).getName().equals("Crossbowman")) {
                    darkTeam.get(i).step(whiteTeam);
                }
            }

            for (int i = 0; i < darkTeam.size(); i++) {
                if (darkTeam.get(i).getName().equals("Wizard")) {
                    darkTeam.get(i).step(darkTeam);
                }
            }

            for (int i = 0; i < whiteTeam.size(); i++) {
                if (whiteTeam.get(i).getName().equals("Monk")) {
                    whiteTeam.get(i).step(whiteTeam);
                }
            }
            for (int i = 0; i < darkTeam.size(); i++) {
                if (darkTeam.get(i).getName().equals("Peasant")) {
                    darkTeam.get(i).step(whiteTeam);
                }
            }
            for (int i = 0; i < whiteTeam.size(); i++) {
                if (whiteTeam.get(i).getName().equals("Peasant")) {
                    whiteTeam.get(i).step(darkTeam);
                }
            }
        }
    }

    private static void init() {
        whiteTeam = new ArrayList<>();
        darkTeam = new ArrayList<>();

        int[] array = new int[2]; // подсчёт кол-ва магов и крестьян

        int x = 1, y = 1;
        for (int i = 0; i < GANG_SIZE; i++)
        {
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
        x = 1;
        y = 10;
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

