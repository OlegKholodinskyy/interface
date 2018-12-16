package lesson27.lecture;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerfomance {
    public static void main(String[] args) {
    testAddMethod();
    testRemoveMethod();
    testGetMethod();
    }


    private static void testGetMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0; i<1_00_000; i++){
            arrayList.add(i,String.valueOf(i));
        }
        Date start  = new Date();
        for (int i=0; i<97_000; i++){
            arrayList.get(3000);
        }
        Date finish = new Date();
        System.out.println("ArrayList (Get): " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i=0; i<1_00_000; i++){
            linkedList.add(0,String.valueOf(i));
        }
        Date start1  = new Date();
        for (int i=0; i<100_000; i++){
            linkedList.get(50000);
        }
        Date finish1 = new Date();
        System.out.println("LinkedList (Get): " + (finish1.getTime() - start1.getTime()));
    }

    private static void testAddMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        Date start  = new Date();
        for (int i=0; i<1_00_000; i++){
            arrayList.add(0,String.valueOf(i));
        }

        Date finish = new Date();
        System.out.println("ArrayList (Add) : " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();
        Date start1  = new Date();
        for (int i=0; i<1_00_000; i++){
            linkedList.add(0,String.valueOf(i));
        }

        Date finish1 = new Date();
        System.out.println("LinkedList (Add): " + (finish1.getTime() - start1.getTime()));

    }

    private static void testRemoveMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0; i<1_00_000; i++){
            arrayList.add(i,String.valueOf(i));
        }
        Date start  = new Date();
        for (int i=0; i<97_000; i++){
            arrayList.remove(3000);
        }
        Date finish = new Date();
        System.out.println("ArrayList (Remove): " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i=0; i<1_00_000; i++){
            linkedList.add(0,String.valueOf(i));
        }
        Date start1  = new Date();
        for (int i=0; i<97_000; i++){
            linkedList.remove(3000);
        }
        Date finish1 = new Date();
        System.out.println("LinkedList (Remove): " + (finish1.getTime() - start1.getTime()));
    }
}
