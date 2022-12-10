import java.util.Collection;
import java.util.Collections;

public class ConsoleView {

    public static final String top10 = formatDiv("a")
            + String.join("", Collections.nCopies(9, formatDiv("-d")))
            + formatDiv("c");

    private static String formatDiv(String str) {
        return str
                .replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

}