package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) {
        readKeyboardWithIOStream2();

    }


    public static void readKeyboardWithIOStream() {
        /**
         * using io stream
         */
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println("Enter your name : ");


        try {
            String name = bufferedReader.readLine();
            if (isValidName(name))
                System.out.println("Hello " + name + " !");
        } catch (IOException e) {
            System.err.print("error reading from keyboard");
        } finally {
            try {
                reader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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

    public static void readKeyboardWithIOStream2() {
        /**
         * using io stream
         */
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println("Enter your name : ");


        try {
            String name = bufferedReader.readLine();
            if (isValidName(name))
                System.out.println("Hello " + name + " !");
        } catch (IOException e) {
            System.err.print("error reading from keyboard");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(bufferedReader);
        }
    }
}
