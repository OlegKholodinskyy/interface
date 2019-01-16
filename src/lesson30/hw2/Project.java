package lesson30.hw2;

import java.util.Objects;

public class Project {
    private long id;
    private String name;
    private Customer customer;
    private Employee lieader;

    public Project(long id, String name, Customer customer, Employee lieader) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.lieader = lieader;
        // добавити до темліда поточний проект
        Controller.getInstance().getEmployee(lieader.getId()).addProject(this);
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getLieader() {
        return lieader;
    }

    @Override
    public String toString() {
        return "\n"+ "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer=" + customer +
                ", lieader = ID : " + lieader.getId() + " FirstName : " + lieader.getFirstName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(name, project.name) &&
                Objects.equals(customer, project.customer) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, customer, lieader);
    }
}
