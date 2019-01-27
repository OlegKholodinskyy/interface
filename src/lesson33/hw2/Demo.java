package lesson33.hw2;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        try {
            ReadFileByConsole.readFileByConsolePath();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
