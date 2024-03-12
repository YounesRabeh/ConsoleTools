package src;

import colors.Colors;
import static src.Tools.*;
import static styles.Styles.*;

public class Main {
    public static void main(String[] args) {
        printText(Colors.CYAN_BRIGHT, "Demetrio ::");
        printText(Colors.CYAN_BRIGHT, "un uomo ");
        setText_color(Colors.BLUE_BOLD);
        printlnText("Demetrio -_-");
        printlnText(Colors.BLACK_BACKGROUND_BRIGHT, "E");
    }
}
