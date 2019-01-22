package lesson32.homeWork2_2;

import lesson32.homeWork2.BadInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int counter = 3;


    public static int readNumbers() throws IOException, BadInputException {
        int res = 0;
        while (counter > 0) {
            res = checker();
            break;
        }
        if (counter == 0) {
            System.out.println("error");
        }
        return res;
    }

    private static int checker() throws IOException, BadInputException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        System.out.println("Input 10 digit : ");
        String line = bufferedReader.readLine();

        String[] arrWords = line.split(" ");


        if (arrWords.length != 10 || !checkDigit(arrWords)) {
            counter--;
            throw new BadInputException("Your numbers are wrong. You have " + counter + " attempts to try again.");
        }

        int sum = 0;

        for (String s : arrWords) {
            sum = sum + Integer.parseInt(s);
        }

        return sum;


    }

    private static boolean checkDigit(String[] arrWords) throws BadInputException {
        for (String str : arrWords) {
            if (str == null || str.isEmpty())
                return false;

            try {
                Integer.parseInt(str);
            } catch (Exception e) {
                return false;
            }
        }
        return true;

    }


}
