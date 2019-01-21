package lesson32.homeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int countExceptions = 3;
    private static String line;
    static int res = 0;


    public static int readNumbers() throws IOException, BadInputException {
        if (countExceptions >= 0) {

            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            System.out.println("Input 10 digit : ");
            Solution.line = bufferedReader.readLine();

            String[] arrWords = line.split(" ");


            if (arrWords.length != 10 || !checkDigit(arrWords)) {
                countExceptions--;
                throw new BadInputException("Your numbers are wrong. You have " + Solution.countExceptions + " attempts to try again.");
            }

            int sum = 0;

            for (String s : arrWords) {
                sum = sum + Integer.parseInt(s);
            }

            Solution.res = sum;

        } else {
            System.out.println("You numbers are wrong. Number of attempts exceeded");
            System.exit(0);
        }

        return res;

    }

    private static boolean checkDigit(String[] arrWords) throws BadInputException {


        for (String str : arrWords) {
            if (str == null || str.isEmpty())
                return false;

            try {
                Integer.parseInt(str);
            } catch (Exception e) {
                countExceptions--;
                throw new BadInputException("Your numbers are wrong. You have " + Solution.countExceptions + " attempts to try again.");
            }
        }
        return true;

    }
}
