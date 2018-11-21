package lesson17_homework;

public class Solution {

    public static void main(String[] args) {
        String[] str = new String[]{
                "fefge",
                "  j  ",
                "   dscs csd  c423r e   ",
                "e e e r   ",
                "fff           d   ",
                null};

        for (String test : str)
            System.out.printf("%-30s contain %d word(s) %n", test, countWords(test) );
    }

    public static int countWords(String input) {

        int result;

        if (input == null || input.trim().isEmpty()) {
            return 0;
        } else {
            char[] chars = input.toCharArray();
            int first = firstNotSpaceCharIndex(chars);
            result = conutingWords(first, chars);
            return result;
        }
    }

    private static int firstNotSpaceCharIndex(char[] chars) {
        int i = 0;
        while (chars[i] == ' ') {
            i++;
        }
        return i;
    }

    private static int conutingWords(int first, char[] chars) {
        int count = 1;
        for (int i = first + 1; i < chars.length; i++) {
            if (chars[i - 1] == ' ' && chars[i] != ' ') {
                count++;
            }
        }
        return count;
    }
}