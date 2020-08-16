package pl.wkos.textstats;

public class TextStats {
    public static int numberOfSignsWithoutWhiteSpaces(String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            if (!Character.isWhitespace(sign)) counter++;
        }
        return counter;
    }

    public static int numberOfSignsWithSpaces(String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            if (sign == ' ') counter++;
        }
        return counter + numberOfSignsWithoutWhiteSpaces(text);
    }

    public static int numberOfAllSigns(String text) {
        return text.length();
    }

    public static String replaceWhiteSpacesWithSpaces(String text) {
        char[] whiteSpacesWitoutSpace = {'\n', '\t', '\f', '\r', '\u000B', '\u2007', '\u00A0', '\u202F'};
        for (char item : whiteSpacesWitoutSpace)
            text = text.replace(item, ' ');
        return text;
    }

    public static int numberOfWords(String text) {
        text = replaceWhiteSpacesWithSpaces(text);
        text = removeDoubleSpaces(text);
        text = text.trim();
        int counter = 0;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ') counter++;
        return ++counter;
    }

    public static String removeDoubleSpaces(String text) {
        String newText = "";
        for (int i = 0; i < text.length() - 1; i++) {
            while (i < text.length() && text.charAt(i) == ' ' && text.charAt(i + 1) == ' ') i++;
            newText += text.charAt(i);
        }
        return newText;
    }

    public static boolean palindrom(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
