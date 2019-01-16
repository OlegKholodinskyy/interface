package lesson30.hw2;

import java.util.HashSet;

public class DepartmentDAO {

    static HashSet<Department> departments = new HashSet<>();

    public static Department add(Department department){
        departments.add(department);
        return department;
    }

    public static Department update(Department department) throws IllegalArgumentException{
        if (departments.contains(department)){
            departments.remove(department);
            departments.add(department);
            return department;}
        else{
            throw new IllegalArgumentException("department not found. Update fail. De id: " + department.getId());
        }
    }

    public static Department delete (Department department){
        departments.remove(department);
        return department;
    }

    public static HashSet<Department> getDepartments(){
        return departments;
    }

}
