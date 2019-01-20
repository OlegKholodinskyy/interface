package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        try {
            readKeyboardWithIOStream();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            readKeyboardWithScanner();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readKeyboardWithScanner() throws IOException {
        /**
         * using scanner
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = sc.nextLine();
        if (isValidName(name)) {
            System.out.println("Hello " + name + " !");
        }
        sc.close();
    }

    public static void readKeyboardWithIOStream() throws IOException {
        /**
         * using io stream
         */
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println("Enter your name : ");
        String name = bufferedReader.readLine();
        if (isValidName(name))
            System.out.println("Hello " + name + " !");
    }

    private static boolean isValidName(String name) throws IOException {

        if (name == null || name.isEmpty()) {
            throw new IOException("You did not enter nothing");
        } else {
            String[] oneName = name.trim().split(" ");

            if (oneName.length != 1) {
                throw new IOException(" Name must contains only one word ");
            } else {
                char[] arrayCharsInOneWord = oneName[0].toCharArray();

                for (char ch : arrayCharsInOneWord) {
                    if (!Character.isLetter(ch)) {
                        throw new IOException(" Name must contains only letters ");
                    }
                }
                return true;
            }
        }
    }
}
