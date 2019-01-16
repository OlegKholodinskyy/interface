package lesson30.hw2;

import java.util.HashSet;

public class EmployeeDAO {

    static HashSet<Employee> employees = new HashSet<>();

    public static Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public static Employee update(Employee employee) throws IllegalArgumentException{
        if (employees.contains(employee)){
            employees.remove(employee);
            employees.add(employee);
            return employee;}
        else{
            throw new IllegalArgumentException("employee not found. Update fail. De id: " + employee.getId());
        }
    }

    public static Employee delete (Employee employee){
        employees.remove(employee);
        return employee;
    }

    public static HashSet<Employee> getEmployees(){
        return employees;
    }

}
