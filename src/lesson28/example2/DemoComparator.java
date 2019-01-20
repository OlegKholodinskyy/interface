package lesson28.example2;

import lesson28.example2.DateComparator;
import lesson28.example2.Capability;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "aaa", "aa", true, new Date(2018,11,2));
        Capability capability2 = new Capability(1005, "bbb", "fff", false, new Date(2019,9,2));
        Capability capability3 = new Capability(900, null, "bb", false, new Date(2019,1,1));
        Capability capability4 = new Capability(1041, "ccc", "fff", true, new Date(2018,11,2));
        Capability capability5 = new Capability(900, "aaa", null, true, new Date(2017,10,30));

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);
  //      System.out.println(capabilities);
   //     capabilities.sort(new IsActiveComparator());
   //     System.out.println(capabilities);
/*
        System.out.println();
        System.out.println("DateComparator");
        capabilities.sort(new DateComparator());
        System.out.println(capabilities);

        System.out.println();
        System.out.println("FullComparator");
        capabilities.sort(new FullComparator());
        System.out.println(capabilities);
/*
        Comparator<Capability> comparator = new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {
                   якщо сhanelName не ріне то порівнюємо по ньому в першу чергу
                   якщо рівне - то переходимо до порівняння по fingerprint
                   якщо fingerprint не рівне - то порівнюю по ньому
                   якщо рівне - то порівнюю по dateCreated
                   якщо і це поле рівне - то  обєкти рівні

                if (!o1.getChannelName().equals(o2.getChannelName()))
                    return o1.getChannelName().compareTo(o2.getChannelName());
            }
        };
*/
    }
}