package lesson30.ex1;

import lesson29.File;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetIntro{
    public static void main(String[] args) {
        Set<File> files = new TreeSet<>();
        File file1 = new File("pic.txt" , 90);
        File file2 = new File("home.txt" , 170);
        File file3 = new File("home3.txt" , 270);

        files.add(file1);
        files.add(file2);
        files.add(file3);
        System.out.println(files);
    }
}
