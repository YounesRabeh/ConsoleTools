package src;

import Tests.Test1;
import structures.tables.Table;

import static src.Tools.*;
import static structures.tables.TableTypes.LIGHT;

import colors.Colors;
import static input.Input.*;

public class Main {
    public static void main(String[] args) {
        //new Test1();
        String askLength = "Enter data:  ";
        String askRows = "Enter the number of row: ";
        String askColumns = "Enter the number of columns: ";
        print(Colors.CYAN_BRIGHT, askRows);
        int rowNum = Integer.parseInt(getNextLine());
        print(Colors.CYAN_BRIGHT, askColumns);
        int colNum = Integer.parseInt(getNextLine());
        print(Colors.RED_BRIGHT, askLength);
        Object data = getNextLine();
        Table table = new Table(LIGHT, rowNum, colNum);
        table.setField(0, 0,data);
        table.setField(0, 1, askLength);

        println(table.draw());
    }
}
