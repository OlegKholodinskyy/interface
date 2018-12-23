package lesson29.hw;

import com.sun.deploy.util.OrderedHashSet;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        useHashSet();
    }


    public static void useHashSet() throws IllegalArgumentException {
        HashSet<Order> orderHashSet = new HashSet();
        Order order1 = new Order(111, 1000, "usd", "name111", "ATB");
        Order order2 = new Order(112, 1000, "usd", "name112", "ATB1");
        Order order3 = new Order(113, 1000, "uan", "name113", "ATB2");
        Order order4 = new Order(114, 1000, "usd", "name114", "ATB4");
        Order order5 = new Order(115, 1000, "usd", "name115", "ATB");
        Order order6 = new Order(113, 1000, "eur", "name113", "ATB2");
        Order order7 = new Order(112, 1000, "usd", "name112", "ATB1");
        /*
         * add (Element e)
         * remove (Element e)
         * retailAll (Collection c)
         * Object[] toArray()
         * size()
         * */
        /*
         * add (Element e)
         */
        System.out.println("Add merthod: ");
        orderHashSet.add(order1);
        orderHashSet.add(order2);
        orderHashSet.add(order3);
        orderHashSet.add(order4);
        orderHashSet.add(order5);
        orderHashSet.add(order6);
        orderHashSet.add(order7);

        Iterator<Order> orderIterator = orderHashSet.iterator();
        while (orderIterator.hasNext()) {
            System.out.println(orderIterator.next());
        }
/*
remove(Element e using iterator)
 */
        System.out.println("Remove method whith iterator");
        Iterator<Order> iterator = orderHashSet.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId() == 113)
                iterator.remove();
        }

        for (Order order : orderHashSet)
            System.out.println(order);
    /*
remove(Element e )
 */
        System.out.println("Remove method");
        orderHashSet.remove(order1);
        orderHashSet.remove(order4);
        System.out.println("Remove not present element :  " + orderHashSet.remove(order3));
        for (Order o : orderHashSet)
            System.out.println(o);

        /*
         * Object[] toArray()
         */
        System.out.println("Object[] toArray()");
        System.out.println("Some fields");
        Object[] array = orderHashSet.toArray();
        for (Object o : array) {
            if(o instanceof Order) {
                Order ord = (Order) o;
                System.out.println("       Id: " + ord.getId() + "itemName : " + ord.getItemName());
            }
            else{
                throw new IllegalArgumentException("Object is not Order");
            }
        }
        System.out.println("Other");
        for (Object o : array) {
            System.out.println(o);
        }
        /*
        size
         */
        System.out.println("size :  size HashSet : " + orderHashSet.size());
        /*
        retainAll()
         */
        System.out.println("retainAll");
        HashSet<Order> testHashSet = new HashSet<>();
        testHashSet.add(order1);
        testHashSet.add(order3);
        testHashSet.add(order5);
        testHashSet.add(order6);

        orderHashSet.retainAll(testHashSet);
        for (Order o : orderHashSet)
            System.out.println(o);
        /*
        addAll
         */
        System.out.println("addAll");
        orderHashSet.add(order4);
        orderHashSet.addAll(testHashSet);
        System.out.println(orderHashSet.size());

    }
}