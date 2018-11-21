package lesson17LongShort;

public class Solution {
    /**
     * пошук самого короткого та самогодовгого слова в стрінгу
     * minWord (String input);
     * maxWord (String input);
     */

    private static String minWord(String input) {
        if (check(input)) {
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
            return null;
        }
    }

    private static String maxWord(String input) {
        if (check(input)) {
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
            return null;
        }
    }

    private static boolean check(String input) {
        return  !(input == null || input.equals(null) || input.trim().isEmpty() || input.length() ==0);
    }

    public static void main(String[] args) {

        String str = "The word is beautiful";
        String str2 = null;
        System.out.printf("in %-20s the longest word is : %s %n", str, maxWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str, minWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str2, minWord(str2));
    }
}
