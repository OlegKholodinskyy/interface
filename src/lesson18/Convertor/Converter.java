package lesson18.Convertor;

public class Converter {
    public static void main(String[] args) {
        System.out.println(stringToInt("32"));
        System.out.println(stringToInt("33"));
        System.out.println(stringToInt("test"));
        System.out.println(intToString(32));
        System.out.println(intToString(0));
    }

    public static int stringToInt(String input) {
        int i;
        try {
            i = Integer.valueOf(input);
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static String intToString(int input) {

        try {
            return Integer.toString(input);
        } catch (Exception e) {
            System.err.println(e);
            return  null;
        }
    }
}
