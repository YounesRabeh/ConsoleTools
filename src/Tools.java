package src;

import static colors.Colors.RESET;
import static styles.Styles.isGlobalColorSet;
import static styles.Styles._GLOBAL_COLOR_;

public final class Tools  {
    public static void print(String color, String text){
        System.out.print(color + text + RESET);
    }
    public static void print(String text){
        if (isGlobalColorSet()) text = _GLOBAL_COLOR_ + text;
        System.out.print(text);
    }

    public static void println(String color, String text){
        System.out.println(color + text + RESET);
    }

    public static void println(String text){
        if (isGlobalColorSet()) text = _GLOBAL_COLOR_ + text;
        System.out.print(text);
    }
}
