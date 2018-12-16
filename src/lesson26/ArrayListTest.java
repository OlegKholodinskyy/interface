package lesson26;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static ArrayList useList() {
        Order orderTest = new Order(100, "ua", "Name1", "Eldorado");

/*
Add (E e)
*/
        ArrayList<Order> orderArrayList = new ArrayList<>();
        orderArrayList.add(orderTest);
        orderArrayList.add(new Order(100, "ua", "Name1", "Eldorado"));
        orderArrayList.add(null);
        orderArrayList.add(new Order(200, "usd", "Name5", "ATB"));

/*
Add (int index, E element)
 */

        orderArrayList.add(2, new Order(500, "euro", "Name2", "Epitsenrt"));
        orderArrayList.add(2, new Order(400, "euro", "Name4", "Shop"));
/*
remove (int index);
 */
        orderArrayList.remove(4);

/*
remove (Object o)
*/
        orderArrayList.remove(orderTest);

/*
addAll (Collection c)
 */
        ArrayList<Order> orderArrayList12 = new ArrayList<>();
        orderArrayList.add(orderTest);
        orderArrayList.add(new Order(150, "euro", "Name7", "Collection2"));
        orderArrayList12.addAll(orderArrayList);
        orderArrayList.addAll(orderArrayList12);
/*
clear
 */
        orderArrayList12.clear();
 /*
subList(int fromIndex, int toIndex)
 */
        ArrayList<Order> orderArrayListSubList = new ArrayList<Order>(orderArrayList.subList(1, 6));
        orderArrayList = orderArrayListSubList;
/*
set  (int index, E element)
 */
        orderArrayList.set(0, new Order(999, "btc", "NameBtc", "TradeOrg"));
/*
boolean contains(Object o)
*/
        System.out.println("contains : " + orderArrayList.contains(orderTest));
/*
        Object[] toArray();
*/
        Order[] orderArray = new Order[orderArrayList.size()];
        orderArray = orderArrayList.toArray(orderArray);
        System.out.println("To array");
        for (Order o : orderArray) {
            if (o != null)
                System.out.println(o);
        }
        System.out.println("END - To array");
        System.out.println();

        Object[] obArray = orderArrayList.toArray();
        for (Object o : obArray) {
            if (o != null)
                System.out.println(o);
        }
        System.out.println("END 2 - To array");
        System.out.println();
        return orderArrayList;
    }


    public static void main(String[] args) throws IllegalArgumentException {

        ArrayList<Order> testArrayList = useList();

        if (testArrayList == null || testArrayList.isEmpty())
            throw new IllegalArgumentException("Collearion is empty");

        for (Order order : testArrayList) {
            if (order == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(order.toString());
        }
    }
}