package lesson17MostCountedWord;

public class Solution {
    /**
     * mostCountedWord(String input)
     */
    private static String mostCountedWord(String input) {
        if (check(input)) {
            int count = 0;
            int maxCount = 0;
            int index = 0;
            String[] arr = input.split(" ");
            boolean fl=false;

            for (int i = 0; i < arr.length; i++) {
                if (checkLetter(arr[i])) {
                    count = 0;
                    for (int k = arr.length - 1; k >= 0; k--) {
                        if (checkLetter(arr[k]) && arr[k].equals(arr[i])) {
                            count++;
                            fl = true;
                        }
                    }
                    if (maxCount < count) {
                        maxCount = count;
                        index = i;
                    }
                } else {
                    continue;
                }
            }
            if (fl) return arr[index];
            else return null;
        } else {
            return null;
        }
    }

    private static boolean check(String input) {
        return !(input == null || input.equals(null) || input.trim().isEmpty() || input.length() == 0);
    }


    public static void main(String[] args) {
        String str = "The history ";
        String str2 = "@456hh @456hh";
        String str3 = "The history is ";
        String str4 = "one one first is 5 that a the first first";
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str, mostCountedWord(str));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str2, mostCountedWord(str2));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str3, mostCountedWord(str3));
        System.out.printf("in \" %-30s \" the most counted word is : %s %n", str4, mostCountedWord(str4));

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
}