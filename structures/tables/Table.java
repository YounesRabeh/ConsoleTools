package structures.tables;

import styles.TableStyleComponents;

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
        setupTable();
    }

    private void setupTable(){
        LinkedList<Object> newRow = new LinkedList<>();
        for (int i = 0; i < columns; i++) {
            newRow.add(null);
        }
        for (int i = 0; i < rows; i++) {
           table.put(i, newRow);
        }

    }

    public String draw(){
        StringBuilder tableBuilder = new StringBuilder();

        final int SIZE = table.size();
        final int lengthLimit = (getMaxRowLength() + 4);
        final int rowLength = lengthLimit*columns + (columns+1);
        depth = this.rows*3 - (rows - 1);
        int drawnRows = 0;
        int indrexParsing = 0;

        for (int row = 0; row < rows; row++){
            StringBuilder rowBuilder = new StringBuilder();
            LinkedList<Object> rowData = table.get(row);

            if (row == 0){
                attach(rowBuilder, UPPER_LEFT_INTERSECTION);
                for (int i = 0; i < columns; i++){
                    rowBuilder.append(buildRepeatedString(SELECTED_STYLE[LINE.ordinal()], lengthLimit));
                    if (i < columns-1){attach(rowBuilder, UPPER_CENTER_INTERSECTION);}
                } attach(rowBuilder, UPPER_RIGHT_INTERSECTION);

                attach(rowBuilder, WALL);
                for (int i = 0; i < columns; i++){
                    String columnData = (String) rowData.get(i);

                    if (columnData != null) {rowBuilder.append(correctColumnDataLength(columnData, lengthLimit));}
                    else {rowBuilder.append(buildRepeatedString(" ", lengthLimit));}
                    if (i < columns-1){attach(rowBuilder, WALL);}
                } attach(rowBuilder, WALL); rowBuilder.append("\n");

                if (rows != 1){
                    attach(rowBuilder, MIDDLE_LEFT_INTERSECTION);
                    for (int i = 0; i < columns; i++){
                        rowBuilder.append(buildRepeatedString(SELECTED_STYLE[LINE.ordinal()], lengthLimit));
                        if (i < columns-1){attach(rowBuilder, MIDDLE_CENTER_INTERSECTION);}
                    } attach(rowBuilder, MIDDLE_RIGHT_INTERSECTION);
                    tableBuilder.append(rowBuilder); continue;
                } else {
                    attach(rowBuilder, LOWER_LEFT_INTERSECTION);
                    for (int i = 0; i < columns; i++){
                        rowBuilder.append(buildRepeatedString(SELECTED_STYLE[LINE.ordinal()], lengthLimit));
                        if (i < columns-1){attach(rowBuilder, LOWER_CENTER_INTERSECTION);}
                    } attach(rowBuilder, LOWER_RIGHT_INTERSECTION);
                    tableBuilder.append(rowBuilder); continue;
                }
            }
            if (row < rows-1){
                attach(rowBuilder, WALL);
                for (int i = 0; i < columns; i++){
                    String columnData = (String) rowData.get(i);

                    if (columnData != null) {rowBuilder.append(correctColumnDataLength(columnData, lengthLimit));}
                    else {rowBuilder.append(buildRepeatedString(" ", lengthLimit));}
                    if (i < columns-1){attach(rowBuilder, WALL);}
                } attach(rowBuilder, WALL); rowBuilder.append("\n");

                attach(rowBuilder, MIDDLE_LEFT_INTERSECTION);
                for (int i = 0; i < columns; i++){
                    rowBuilder.append(buildRepeatedString(SELECTED_STYLE[LINE.ordinal()], lengthLimit));
                    if (i < columns-1){attach(rowBuilder, MIDDLE_CENTER_INTERSECTION);}
                } attach(rowBuilder, MIDDLE_RIGHT_INTERSECTION);
                tableBuilder.append(rowBuilder); continue;
            }
            if (row == rows-1){
                attach(rowBuilder, WALL);
                for (int i = 0; i < columns; i++){
                    String columnData = (String) rowData.get(i);

                    if (columnData != null) {rowBuilder.append(correctColumnDataLength(columnData, lengthLimit));}
                    else {rowBuilder.append(buildRepeatedString(" ", lengthLimit));}
                    if (i < columns-1){attach(rowBuilder, WALL);}
                } attach(rowBuilder, WALL); rowBuilder.append("\n");

                attach(rowBuilder, LOWER_LEFT_INTERSECTION);
                for (int i = 0; i < columns; i++){
                    rowBuilder.append(buildRepeatedString(SELECTED_STYLE[LINE.ordinal()], lengthLimit));
                    if (i < columns-1){attach(rowBuilder, LOWER_CENTER_INTERSECTION);}
                } attach(rowBuilder, LOWER_RIGHT_INTERSECTION);

            }
            tableBuilder.append(rowBuilder);
        }
        return tableBuilder.toString();
    }

    private String correctColumnDataLength(String data, int columnLength){
        String dataString = data;
        int diff = columnLength - dataString.length();
        if (diff > 0) {
            dataString += buildRepeatedString(" ", diff);
        }
        return dataString;
    }
    private void attach(StringBuilder sb, TableStyleComponents tsc){
        sb.append(SELECTED_STYLE[tsc.ordinal()]);
    }


    public void setField(int row, int column, Object element){
        LinkedList<Object> dataRow = table.get(row);
        if (!dataRow.isEmpty()) {
            dataRow.set(column, element);
        } else {
            dataRow.add(element);
        }
    }

    public static String buildRepeatedString(String ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private int getMaxRowLength(){
        int max = 0;
        for (int i = 0; i < table.size(); i++){
            int rowLength = getRowLength(i);
            if (rowLength > max) max = rowLength;
        }
        return max;
    }

    private int getRowLength(int row){
        LinkedList<Object> dataRow = table.get(row);
        int totalLength = 0;
        for (int i = 0; i < dataRow.size(); i++) {
            String data = (String) dataRow.get(i);
            if (data == null) return totalLength;
            totalLength += data.length();
        }
        return totalLength;
    }

    private String getField(int row){
        LinkedList<Object> dataRow = table.get(row);
        return  (String) dataRow.get(row);
    }
}
