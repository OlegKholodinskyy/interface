package lesson29;

import java.util.HashSet;
import java.util.Set;

public class SetIntro {
    public static void main(String[] args) {
        Set <String> set = new HashSet<>();
        set.add("test");
        set.add("111");
        set.add("aaa");
        System.out.println(set);

        set.add("aaa");
        System.out.println(set);


        Set<File> files = new HashSet<>();
        File file1 = new File("pic.txt" , 100);
        File file2 = new File("home.txt" , 170);
        File file3 = new File("home.txt" , 170);

        files.add(file1);
        files.add(file2);
        files.add(file3);

        System.out.println(files);
    }
}
