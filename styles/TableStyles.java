package styles;

import structures.tables.TableTypes;

public final class TableStyles {
    private static final String[] LIGHT_BORDERS = {"─", "│", "┌", "┬", "┐\n", "├", "┼", "┤\n", "└", "┴", "┘\n"};
    public static String[] getTableStyle(TableTypes type){
        return LIGHT_BORDERS;

    }
}
