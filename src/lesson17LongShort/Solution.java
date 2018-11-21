package lesson17LongShort;

public class Solution {
    /**
     * пошук самого короткого та самогодовгого слова в стрінгу
     * minWord (String input);
     * maxWord (String input);
     */

    private static String minWord(String input) {
        if (checkNull(input)) {
            if (checkEmpty(input)) {
                String[] arrString = input.split(" ");
                int minSize = arrString[0].length();
                int index = 0;
                for (int i = 1; i < arrString.length; i++) {
                    if (arrString[i].length() < minSize) {
                        minSize = arrString[i].length();
                        index = i;
                    }
                }
                return arrString[index];
            } else {
                return "empty";
            }
        } else {
            return null;
        }

    }

    private static boolean checkEmpty(String input) {
        return !(input.trim().isEmpty() || input.length() == 0);
    }

    private static String maxWord(String input) {
        if (checkNull(input)) {
            if (checkEmpty(input)) {
            String[] arrString = input.split(" ");
            int maxSize = arrString[0].length();
            int index = 0;
            for (int i = 1; i < arrString.length; i++) {
                if (arrString[i].length() > maxSize) {
                    maxSize = arrString[i].length();
                    index = i;
                }
            }
            return arrString[index];
        } else {
            return "empty";
        }
        } else {
            return null;
        }
    }

    private static boolean checkNull(String input) {
        return !(input == null || input.equals(null) );
    }

    public static void main(String[] args) {

        String str = "The word is beautiful o";
        String str2 = null;
        String str3 = "";
        System.out.printf("in %-20s the longest word is : %s %n", str, maxWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str, minWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str2, maxWord(str2));
        System.out.printf("in %-20s the shortest word is  : %s %n", str3, maxWord(str3));
    }
}
