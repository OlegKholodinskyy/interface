package lesson17LongShort;

public class Solution {
    /**
     * пошук самого короткого та самогодовгого слова в стрінгу
     * minWord (String input);
     * maxWord (String input);
     */

    private static String minWord(String input) {
        if (!checkNullOREmpty(input)) {
            String[] arrString = input.split(" ");
            int minSize = arrString[0].length();
            int index = 0;
            boolean flag = false;
            for (int i = 0; i < arrString.length; i++) {
                if (checkLetter(arrString[i])&& arrString[i].length()!=0) {
                    flag = true;
                    if (arrString[i].length() < minSize) {
                        minSize = arrString[i].length();
                        index = i;
                    }
                }else{continue;}
            }
            if (flag) return arrString[index];
            else return  null;
        } else {
            return null;
        }
    }


    private static String maxWord(String input) {
        if (!checkNullOREmpty(input)) {
            String[] arrString = input.split(" ");
            int maxSize = 0;
            boolean flag = false;
            int index = 0;
            for (int i = 0; i < arrString.length; i++) {
                if (checkLetter(arrString[i])&& arrString[i].length()!=0) {
                    flag = true;
                    if (arrString[i].length() >= maxSize) {
                        maxSize = arrString[i].length();
                        index = i;
                    }
                }else{
                    continue;}
            }
            if (flag) return arrString[index];
            else return  null;
        } else {
            return null;
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
        return (input == null || input.equals(null) || input.trim().isEmpty() || input.length() == 0);
    }

    public static void main(String[] args) {

        String str1 = "@jhkgk";
        String str2 = null;
        String str3 = "";
        String str4 = "jhkbgjkl re fr44 fvyttrvvtrfr cccccccccccccccccccc45";
        System.out.printf("in %-20s the longest word is : %s %n", str4, maxWord(str4));
        System.out.printf("in %-20s the shortest word is  : %s %n", str4, minWord(str4));
        System.out.printf("in %-20s the shortest word is  : %s %n", str1, maxWord(str1));
        System.out.printf("in %-20s the shortest word is  : %s %n", str3, maxWord(str3));
    }
}
