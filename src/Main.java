package src;

import colors.Colors;
import static src.Tools.*;
import static styles.Styles.*;
import static input.Input.*;

public class Main {
    public static void main(String[] args) {
        print(Colors.CYAN_BRIGHT, "Demetrio ::");
        print(Colors.CYAN_BRIGHT, "un uomo ");
        setText_color(Colors.BLUE_BOLD);
        println("Demetrio -_-");
        println(Colors.RED_BACKGROUND_BRIGHT, "Ekavkavdfhad aiyfa");
        print(getNextLine());
        print(Colors.RED, "wwwww ");
        println("io sono blu ");
        println(Colors.GREEN_BOLD, "sssss");
        resetText_color();
        println("io sono normale");
    }

}
