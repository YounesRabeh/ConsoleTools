package styles;

import static colors.Colors.RESET;

public final class Styles {
    public static void setText_color(String color){
        System.out.print(color);
    }

    public static void resetText_color(){
        System.out.print(RESET);
    }
}
