package lesson30.hw2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private static ArrayList<Department> departments;
    private static ArrayList<Customer> customers;

    public Firm(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public void addCustomerToFirm (Customer customer){
        if (customers==null)
            customers = new ArrayList<>();

        customers.add(customer);
    }
    public void addDepartmentToFirm(Department department){
        if (departments == null)
            departments = new ArrayList<>();

        departments.add(department);
    }


    public Date getDateFounded() {
        return dateFounded;
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
