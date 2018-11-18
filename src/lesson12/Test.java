package lesson12;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Currency.values()));
        System.out.println(Currency.valueOf("USD"));
    }
}
