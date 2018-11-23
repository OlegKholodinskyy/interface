package lesson18.digitInWords;

public class Solution {
    public static void main(String[] args) {
        String text = "Get got 55 got5 0 null";
        String text2 = null;
        findNumbers(text);

    }


    private static int[] findNumbers(String text) {
        if (!(text==null) && text.length() != 0 ) {
            String[] input = text.split(" ");
            int[] intArr = new int[input.length];

            int i = 0;
            for (String str : input) {
                try {
                    intArr[i] = Integer.valueOf(str);
                    System.out.println(intArr[i]);
                    i++;

                } catch (Exception e) {
                    System.out.println("not a number");
                }
            }
            return intArr;
        } else {
            System.out.println("null");
            return null;
        }
    }
}
