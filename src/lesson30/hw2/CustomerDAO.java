package lesson30.hw2;

import java.util.ArrayList;
import java.util.HashSet;

public class CustomerDAO {
    static HashSet<Customer> customers = new HashSet<>();

    public static Customer add(Customer customer){
        customers.add(customer);
        return customer;
    }

    public static Customer update(Customer customer) throws IllegalArgumentException{
        if (customers.contains(customer)){
        customers.remove(customer);
        customers.add(customer);
        return customer;}
        else{
            throw new IllegalArgumentException("Customer not found. Update fail. Customer id: " + customer.getId());
        }
    }

    public static Customer delete (Customer customer){
        customers.remove(customer);
        return customer;
    }

public static HashSet<Customer> getCustomers(){
        return customers;
}

}
