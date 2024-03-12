package src;

import colors.Colors;
import static src.Tools.*;
import static styles.Styles.*;
import static input.Input.*;

public class Main {
    public static void main(String[] args) {
        printText(Colors.CYAN_BRIGHT, "Demetrio ::");
        printText(Colors.CYAN_BRIGHT, "un uomo ");
        setText_color(Colors.BLUE_BOLD);
        printlnText("Demetrio -_-");
        printlnText(Colors.RED_BACKGROUND_BRIGHT, "Ekavkavdfhad aiyfa");
        printText(getNextLine());
        printText(Colors.RED, "wwwww ");
        printlnText("io sono blu ");
        printlnText(Colors.GREEN_BOLD, "sssss");
        resetText_color();
        printText("io sono normale");
    }

}
