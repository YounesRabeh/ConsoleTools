package src;

import static colors.Colors.RESET;

public final class Tools {
    public static void printText(String color, String text){
        System.out.print(color + text + RESET);
    }
    public static void printText(String text){
        System.out.print(text);
    }
    public static void printlnText(String color, String text){
        System.out.println(color + text + RESET);
    }
    public static void printlnText(String text){
        System.out.println(text);
    }
}
