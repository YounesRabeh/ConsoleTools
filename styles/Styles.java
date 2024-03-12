package styles;

import static colors.Colors.RESET;

public final class Styles {
    public static String _GLOBAL_COLOR_ = RESET;
    public static void setText_color(String color){
        _GLOBAL_COLOR_ = color;
    }

    public static void resetText_color(){
        _GLOBAL_COLOR_ = RESET;
    }

    public static boolean isGlobalColorSet(){
        return _GLOBAL_COLOR_ != RESET;
    }
}
