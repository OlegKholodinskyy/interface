package lesson30.hw2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private HashSet<Project> projects;


    public Employee(long id, String firstName, String lastName, Date dateHired, Position position, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void addProject (Project project){
        if (projects==null)
            projects = new HashSet<>();

        projects.add(project);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public HashSet<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "\n" +  "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", department=" + department +
                '}' ;
    }
}
