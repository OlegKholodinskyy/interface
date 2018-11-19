package lesson17;

public class Solution {

    public static void main(String[] args) {
        String str1 = "Hello word";
        String str2 = " Hello ";
        String str3 = "";

        System.out.println(countWords(str1));
        System.out.println(countWords(str2));
        System.out.println(countWords(str3));


    }

    public static int countWords(String input) {

        char[] chars = input.toCharArray();
        String[] arraySeparatedWords;
        int res = 0;

        if (input.isEmpty()){
            return 0;
        }

        if (!(countingSpaces(chars) == 0)) {
            arraySeparatedWords = new String[countingSpaces(chars) + 1];
            makeArrayWords(chars, arraySeparatedWords);
            res = countingSeparatedWords(arraySeparatedWords);
            return res;
        }
        return 1;
    }

    private static void makeArrayWords(char[] chars, String[] arraySeparatedWords) {
        String tmp = "";
      //  System.out.println(arraySeparatedWords.length);
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] == ' ')) {
                tmp += chars[i];
            }
            else {
                arraySeparatedWords[count] = tmp;
                count++;
                tmp = "";
            }
        }
        arraySeparatedWords[count] = tmp;
    }



    public static int countingSeparatedWords(String[] arraySeparatedWords) {
        int res = 0;
        for (String word : arraySeparatedWords) {
            if (!word.isEmpty())
                res++;
        }
        return res;
    }

    public static int countingSpaces(char[] chars) {

            int countOfSpace = 0;
            for (char i : chars) {
                if (i == ' ') {
                    countOfSpace++;
                }
            }
            return countOfSpace;

    }
}
