package lesson29.hw;

import java.util.HashSet;

public class HashSetTest {
    public static void useHashSet(){
        HashSet<Order> orderHashSet = new HashSet();
        Order order1 = new Order(111, 1000, "usd","name111", "ATB" );
        Order order2 = new Order(112, 1000, "usd","name112", "ATB1" );
        Order order3 = new Order(113, 1000, "uan","name113", "ATB2" );
        Order order4 = new Order(114, 1000, "usd","name114", "ATB4" );
        Order order5 = new Order(115, 1000, "usd","name115", "ATB" );
        Order order6 = new Order(113, 1000, "eur","name113", "ATB5" );
        Order order7 = new Order(112, 1000, "usd","name112", "ATB" );

    }
}
