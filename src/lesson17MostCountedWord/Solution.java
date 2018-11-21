package lesson17MostCountedWord;

public class Solution {
    /**
     * mostCountedWord(String input)
     */
    private static String mostCountedWord(String input) {
        if (check(input)) {
            int count = 1;
            int maxCount = 1;
            int index = 0;
            String[] arr = input.split(" ");

            for (int i = 0; i < arr.length; i++) {
                for (int k = arr.length - 1; k > i; k--) {
                    if (arr[i].equals(arr[k])) {
                        count++;
                    }
                    if (maxCount < count) {
                        maxCount = count;
                        index = i;
                    }
                }
            }
            if (maxCount == 1) {
                return null;
            } else {
                return arr[index];
            }
        } else {
            return null;
        }
    }

    private static boolean check(String input) {
        return !(input == null || input.equals(null) || input.trim().isEmpty() || input.length() == 0);
    }

    public static void main(String[] args) {
        String str = "The history first is that the first first";
        String str2 = "";
        String str3 = "The history is ";
        String str4 = "one one";
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str, mostCountedWord(str));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str2, mostCountedWord(str2));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str3, mostCountedWord(str3));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str4, mostCountedWord(str4));

    }
}