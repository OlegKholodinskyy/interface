package lesson17LongShort;

public class Solution {
    /**
     * пошук самого короткого та самогодовгого слова в стрінгу
     * minWord (String input);
     * maxWord (String input);
     */

    private static String minWord(String input) {
        if (checkNullOREmpty(input)) {
            String[] arrString = input.split(" ");
            int minSize = arrString[0].length();
            int index = 0;
            for (int i = 1; i < arrString.length; i++) {
                if (checkLetter(arrString[i])) {
                    if (arrString[i].length() < minSize) {
                        minSize = arrString[i].length();
                        index = i;
                    }
                }
            }
            return arrString[index];
        } else {
            return "empty";
        }
    }


    private static String maxWord(String input) {

        if (checkNullOREmpty(input)) {
            String[] arrString = input.split(" ");


            int maxSize = arrString[0].length();
            int index = 0;
            for (int i = 1; i < arrString.length; i++) {
                if (checkLetter(arrString[i])) {
                    if (arrString[i].length() > maxSize) {
                        maxSize = arrString[i].length();
                        index = i;
                    }
                }
            }
            return arrString[index];
        } else {
            return "empty";
        }
    }

    private static boolean checkLetter(String s) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                continue;
            } else {
                flag = false;
            }
        }
        return flag;
    }


    private static boolean checkNullOREmpty(String input) {
        return !(input == null || input.equals(null) || input.trim().isEmpty() || input.length() == 0);
    }

    public static void main(String[] args) {

        String str = "The word is beauti435ful o";
        String str2 = null;
        String str3 = "";
        System.out.printf("in %-20s the longest word is : %s %n", str, maxWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str, minWord(str));
        System.out.printf("in %-20s the shortest word is  : %s %n", str2, maxWord(str2));
        System.out.printf("in %-20s the shortest word is  : %s %n", str3, maxWord(str3));
    }
}
