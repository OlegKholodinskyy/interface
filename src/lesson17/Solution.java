package lesson17;

public class Solution {

    public static void main(String[] args) {
        String str1 = "Hello word I am robot";
        String str2 = "Hello";
        String str3 = "";

        System.out.println(countWords(str1));
        System.out.println(countWords(str2));
        System.out.println(countWords(str3));


    }

    public static int countWords(String input) {
        int res = 0;
        String[] arraySeparatedWords = input.split(" ");
        for (String word : arraySeparatedWords) {
            if (!word.isEmpty())
                res++;
        }
        return res;
    }
}
