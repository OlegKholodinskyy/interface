package lesson30.hw2;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private Collection departments;
    private Collection customers;

    public Firm(Date dateFounded, Collection departments, Collection customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection getDepartments() {
        return departments;
    }

    public Collection getCustomers() {
        return customers;
    }
}
