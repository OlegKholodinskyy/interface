package lesson29;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class IteratorIntro {
    public static void main(String[] args) {
        Set<File> files = new LinkedHashSet<>();
        File file1 = new File("pic.txt" , 100);
        File file2 = new File("home.txt" , 170);
        File file3 = new File("home3.txt" , 170);

        files.add(file1);
        files.add(file2);
        files.add(file3);

        Iterator<File> fileIterator = files.iterator();
        while (fileIterator.hasNext()){
            System.out.println(fileIterator.next().getFileName());
        }
    }
}
