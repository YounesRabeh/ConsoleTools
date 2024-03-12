package src;

import Tests.Test1;
import structures.tables.Table;

import static src.Tools.*;
import static structures.tables.TableTypes.LIGHT;

import colors.Colors;
import static src.Tools.*;
import static styles.Styles.*;
import static input.Input.*;

public class Main {
    public static void main(String[] args) {
        //new Test1();
        String askLength = "Enter the length: ";
        String askRows = "Enter the number row: ";
        print(Colors.CYAN_BRIGHT, askRows);
        int rowNum = Integer.parseInt(getNextLine());

        print(Colors.CYAN_BRIGHT, askLength);
        int lengthNum = Integer.parseInt(getNextLine());
        Table table = new Table(LIGHT, rowNum, 22);

        println(table.draw(lengthNum));
    }
}
