package structures.tables;

import java.util.*;

import static styles.TableStyleComponents.*;
import static styles.TableStyles.getTableStyle;

public class Table {
    String[] SELECTED_STYLE;
    int rows, columns;
    int length = 3; int depth = 3;
    Hashtable<Object, LinkedList<Object>> table = new Hashtable<>();

    public Table(TableTypes type, int rows, int columns){
        SELECTED_STYLE = getTableStyle(type);
        this.rows = rows; this.columns = columns;
        table.put(0, new LinkedList<Object>());
    }

    public String draw(){
        StringBuilder tableBuilder = new StringBuilder();
        final int SIZE = table.size();
        final int lengthLimit = getRowLength(0);
        depth = this.rows*3 - (rows - 1);
        int drawnRows = 0;
        int indrexParsing = 0;

        for (int i = 0; i < depth; i++){

            String boxData = getField(0);

            for (int j = 0; j < lengthLimit; j++){
                if (i == 0) {
                    if (j == 0){ tableBuilder.append(SELECTED_STYLE[UPPER_LEFT_INTERSECTION.ordinal()]);}
                    tableBuilder.append(SELECTED_STYLE[LINE.ordinal()]);
                    if (j == lengthLimit - 1){ tableBuilder.append(SELECTED_STYLE[UPPER_RIGHT_INTERSECTION.ordinal()]);}
                    continue;
                }
                if (i < depth - 1 && i % 2 == 0 && drawnRows < rows) {
                    indrexParsing = 0;
                    if (j == 0){ tableBuilder.append(SELECTED_STYLE[MIDDLE_LEFT_INTERSECTION.ordinal()]); drawnRows++;}
                    tableBuilder.append(SELECTED_STYLE[LINE.ordinal()]);
                    if (j == lengthLimit -1 ){ tableBuilder.append(SELECTED_STYLE[MIDDLE_RIGHT_INTERSECTION.ordinal()]);}
                    continue;
                }
                if (i < depth-1){
                    if (j == 0){ tableBuilder.append(SELECTED_STYLE[WALL.ordinal()]);}
                    tableBuilder.append(boxData.charAt(indrexParsing++));
                    if (j == lengthLimit - 1){ tableBuilder.append(SELECTED_STYLE[WALL.ordinal()]); tableBuilder.append("\n");}
                    continue;
                }

                if (i == depth - 1) {
                    if (j == 0){ tableBuilder.append(SELECTED_STYLE[LOWER_LEFT_INTERSECTION.ordinal()]);}
                    tableBuilder.append(SELECTED_STYLE[LINE.ordinal()]);
                    if (j == lengthLimit -1){ tableBuilder.append(SELECTED_STYLE[LOWER_RIGHT_INTERSECTION.ordinal()]);}
                }

            }
        }

        return tableBuilder.toString();
    }

    public void setField(int row, int column, Object element){
        LinkedList<Object> dataRow = table.get(row);
        if (!dataRow.isEmpty()) {
            dataRow.set(column, element);
        } else {
            dataRow.add(element);
        }
    }

    private int getRowLength(int row){
        LinkedList<Object> dataRow = table.get(row);
        int totalLength = 0;
        for (int i = 0; i < dataRow.size(); i++) {
            String data = (String) dataRow.get(i);
            totalLength += data.length();
        }
        return totalLength;
    }

    private String getField(int row){
        LinkedList<Object> dataRow = table.get(row);
        return  (String) dataRow.get(row);
    }
}
