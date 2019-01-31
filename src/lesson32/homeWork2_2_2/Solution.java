package lesson32.homeWork2_2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int readNumbers() throws IOException, BadInputException {

        System.out.println("Input 10 digit separated space :");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int count = 3;
        while (count > 0) {
            String input = bufferedReader.readLine();
            String[] arrWords = input.split(" ");


            if (arrWords.length != 10 || !checkDigit(arrWords)) {
                count--;
                System.out.println("Your numbers are wrong. you have " + count + " attempts to try again.");
            } else {
                int sum = 0;

                for (String s : arrWords) {
                    sum = sum + Integer.parseInt(s);
                }

                return sum;
            }
        }

        throw new BadInputException("Your numbers are wrong. Number of attempts exeeded.");
    }

    private static boolean checkDigit (String[] arrWords) {
        for (String str : arrWords) {
            if (str == null || str.isEmpty())
                return false;
            try {
                Integer i = Integer.parseInt(str);
                if (i > 100 || i < 0)
                    return false;
            } catch (NumberFormatException E) {
                return false;
            }
        }
        return true;
    }

}
