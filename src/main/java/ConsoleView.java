import chars.NPC;
import chars.Vector2;
import chars.States;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Arrays;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = "\u256d\u2500" + String.join("\u2500", Collections.nCopies(9, " ")) + "\u2500\u256E";
    private static final String bottom10 = "\u2570\u2500" + String.join("\u2500", Collections.nCopies(9, " ")) + "\u2500\u256F";

    public static void viewTop() {
        System.out.println(ConsoleView.top10);
    }

    public static void viewBottom() {
        System.out.println(ConsoleView.bottom10);
    }

    public static void view() {
        if (step++ == 0) {
            System.out.println(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
        }
        viewTop();
        for (int i = 1; i < Main.GANG_SIZE; i++) {
            System.out.println("|");
            for (int j = 1; j < Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(i, j)));
            }
            System.out.println("|");
            String str1 = "  " + Main.whiteTeam.get(i).getInfo();
            String str2 = progressBar((int)Main.whiteTeam.get(i).getHealth(), (int)Main.whiteTeam.get(i).getMaxHealth());
            String str3 = "  " + Main.darkTeam.get(i).getInfo();
            String str4 = progressBar((int)Main.darkTeam.get(i).getHealth(), (int)Main.darkTeam.get(i).getMaxHealth());

            System.out.format("%-26s %20s %26s %20s \n", str1, str2, str3, str4);
        }
        viewBottom();
    }

    public static String getFirstLetter(NPC hero) {
        return hero.getClass().getSimpleName().charAt(0) + "";
    }

    public static String getChar(Vector2 position) {
        String str = "  ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            boolean alive = true;
            if (Main.whiteTeam.get(i).getPosition().isEqual(position)) {
                if (Main.whiteTeam.get(i).getState() == States.DEAD) {
                    alive = false;
                    str = AnsiColors.ANSI_RED + getFirstLetter(Main.whiteTeam.get(i)) + AnsiColors.ANSI_RESET;
                } else str = AnsiColors.ANSI_BLUE + getFirstLetter(Main.whiteTeam.get(i)) + AnsiColors.ANSI_RESET;
            }
            if (Main.darkTeam.get(i).getPosition().isEqual(position) && alive) {
                if (Main.darkTeam.get(i).getState().equals(States.DEAD))
                    str = " " + AnsiColors.ANSI_RED + getFirstLetter(Main.darkTeam.get(i)) + AnsiColors.ANSI_RESET;
                else str = " " + AnsiColors.ANSI_GREEN + getFirstLetter(Main.darkTeam.get(i)) + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String progressBar(int remain, int total) {
        int maxBarSize = 10;
        int remainPercent = ((100 * remain) / total / maxBarSize);
        char defaultChar = '-';
        String icon = "*";
        String bar = new String(new char[maxBarSize]).replace('\0', defaultChar) + "]";
        String barDone = "[" + icon.repeat(Math.max(0, remainPercent));
        String barRemain = bar.substring((remainPercent));
        return barDone + barRemain + "" + remainPercent * 10 + "%";
    }
}


//
//
//import chars.NPC;
//import chars.Vector2;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Formatter;
//import java.util.List;
//import java.util.Arrays;
//
//public class ConsoleView {
//    public static int step = 0;
//    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
//    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
//    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
//
//    public static void view() {
//        if (step++ == 0) {
//            System.out.println(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
//        } else {
//            System.out.println(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
//        }
//
//        System.out.println(ConsoleView.top10);
//
//        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
//            for (int j = 1; j <= Main.GANG_SIZE; j++) {
//                System.out.print(getChar(new Vector2(i, j)));
//            }
//            System.out.println("|");
//            System.out.println(ConsoleView.mid10);
//        }
//
//        for (int j = 1; j <= Main.GANG_SIZE; j++) {
//            System.out.print(getChar(new Vector2(10, j)));
//        }
//        System.out.println("|");
//        System.out.println(ConsoleView.bottom10);
//    }
//
//    private static String getChar(Vector2 position) {
//        String str = "| ";
//        for (int i = 0; i < Main.GANG_SIZE; i++) {
//            if (Main.darkTeam.get(i).getPosition().isEqual(position))
//                str = "|" + AnsiColors.ANSI_GREEN + Main.darkTeam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
//            if (Main.whiteTeam.get(i).getPosition().isEqual(position))
//                str = "|" + AnsiColors.ANSI_BLUE + Main.whiteTeam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
//        }
//        return str;
//    }
//
////    public static String progressBar(int remain, int total) {
////        int maxBarSize = 10;
////        int remainProcent = ((100 * remain) / total / maxBarSize);
////        char defaultChar = '-';
////        String icon = "*";
////        String bar = new String(new char[maxBarSize]).replace('\0', defaultChar) + "]";
////        StringBuilder barDone = new StringBuilder();
////        barDone.append("[");
////        for (int i = 0; i < remainProcent; i++) {
////            barDone.append(icon);
////        }
////        String barRemain = bar.substring(remainProcent, bar.length());
////        return barDone + barRemain + " " + remainProcent * 10 + "%";
////    }
//
//    private static String formatDiv(String str) {
//        return str.replace('a', '\u250c')
//                .replace('b', '\u252c')
//                .replace('c', '\u2510')
//                .replace('d', '\u251c')
//                .replace('e', '\u253c')
//                .replace('f', '\u2524')
//                .replace('g', '\u2514')
//                .replace('h', '\u2534')
//                .replace('i', '\u2518')
//                .replace('-', '\u2500')
//                .replace("s", "...")
//                .replace("o", "___");
//    }
//}

