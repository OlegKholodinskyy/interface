package lesson30.hw2;

import java.util.ArrayList;

public class Department {

    private long id;
    private DepartmentType type;
    private ArrayList<Employee> employees;

    public Department(long id, DepartmentType type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public DepartmentType getType() {
        return type;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        if (employees== null)
            employees = new ArrayList<>();

        employees.add(employee);
    }


    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", id=" + id +
                '}';
    }
}
