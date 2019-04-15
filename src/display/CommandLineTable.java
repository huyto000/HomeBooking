package display;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandLineTable {
    private static final String HORIZONTAL_SEP = "-";
    private static String verticalSep = "|";
    private static String joinSep ="+";
    private static String[] headers;
    private static List<String[]> rows = new ArrayList<>();
    private static boolean rightAlign;

    public CommandLineTable() {

    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }


    public static void setHeaders(String... newHeaders) {
        headers = newHeaders;
    }

    public static void addRow(String... cells) {
        rows.add(cells);
    }
    public static void removeRow(){
        rows.clear();
    }

    public static void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private static void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private static void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //test code

        //st.setRightAlign(true);//if true then cell text is right aligned
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("one", "two", "three");//optional - if not used then there will be no header and horizontal lines
        CommandLineTable.addRow("super", "broccoli", "flexible");
        CommandLineTable.addRow("assumption", "announcement", "reflection");
        CommandLineTable.addRow("logic", "pleasant", "wild");
        CommandLineTable.print();
    }
}
