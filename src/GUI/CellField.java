package GUI;

/**
 * Created by Mostafa ACHRAF on 12/23/2016.
 */
public class CellField {

    private static StringBuffer text = new StringBuffer("");

    public static String getText() {
        return text.toString();
    }

    public static void setText(String text) {
        CellField.text = new StringBuffer(text);
    }

    //true, if the length of more than one character
    public static boolean isLessOrEqualOneSym() {
        return CellField.text.length() <= 1;
    }

    //add character to the end of line
    public static void addSymbol(String symbol) {
        text.append(symbol);
    }

    public static void clearText() {
        setText("");
    }
}
