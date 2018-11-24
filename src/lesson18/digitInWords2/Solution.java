package lesson18.digitInWords2;

public class Solution {
    public static void main(String[] args) {
        String text = "Get got 55 got5 0 null";
        String text2 = null;
        findNumbers(text);

    }


    private static int[] findNumbers(String text) {
        if (!(text == null) && text.length() != 0) {
            String[] input = text.split(" ");
            int[] intArr = new int[input.length];

            int i = 0;
            for (String str : input) {
                if (check(str)) {
                    intArr[i] = Integer.valueOf(str);
                    System.out.println(intArr[i]);
                    i++;
                }
            }
            return intArr;
        } else {
            System.out.println("null");
            return null;
        }
    }

    private static boolean check(String word) {
        if (!word.matches("([+-]?([0-9])?[0-9]+)")) {
            System.out.println("not a number");
            return false;
        } else {
            return true;
        }
    }
}