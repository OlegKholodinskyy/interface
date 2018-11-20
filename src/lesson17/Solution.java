package lesson17;

public class Solution {

    public static void main(String[] args) {
        String str1 = "He rf ";
        String str2 = "     ";
        String str3 = " f  ";
        String str4 = null;


        System.out.println(countWords(str1));
        System.out.println(countWords(str2));
        System.out.println(countWords(str3));
        System.out.println(countWords(str4));
    }

    public static int countWords(String input) {

        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        char[] chars = input.toCharArray();
        int res = 1;
        int first = 0;
        int end = 0;

        while (chars[first] == ' ') {
            first++;
        }
//        System.out.println("first = " + first);

        for (int i = first + 1; i < chars.length; i++) {
            if (chars[i - 1] == ' ' && chars[i] != ' ') {
                res++;
            }
        }

        return res;
    }
}
