package styles;

import structures.tables.TableTypes;

public final class TableStyles {
    private static final String[] LIGHT_BORDERS = {"─", "│", "┌", "┬", "┐\n", "├", "┼", "┤\n", "└", "┴", "┘\n"};
    private static final String[] BOLD_BORDERS = {"━", "┃", "┏", "┳", "┓\n", "┣", "╋", "┫\n", "┗", "┻", "┛"};
    private static final String[] DOUBLE_LINED_BORDERS = {"═", "║", "╔", "╦", "╗\n", "╠", "╬", "╣\n", "┗" +
            "╚", "╩", "╝"};

    public static String[] getTableStyle(TableTypes type){
        switch (type){
            case BOLD -> {
                return BOLD_BORDERS;
            }
            case DOUBLE_LINED -> {
                return DOUBLE_LINED_BORDERS;
            }
            default -> {
                return LIGHT_BORDERS;
            }
        }

    }
}
