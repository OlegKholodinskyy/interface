package lesson30.hw2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {


    private CustomerDAO customerDAO = new CustomerDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private ProjectDAO projectDAO = new ProjectDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private static Controller instatce;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instatce == null)
            instatce = new Controller();
        return instatce;
    }

    //customer
    public Customer addCustomer(Customer customer) {
        customerDAO.add(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        customerDAO.update(customer);
        return customer;
    }

    public Customer deleteCustomer(Customer customer) {
        customerDAO.delete(customer);
        return customer;
    }

    public HashSet<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    // department
    public Department addDepartment(Department department) {
        departmentDAO.add(department);
        return department;
    }

    public Department updateDepartment(Department department) {
        departmentDAO.update(department);
        return department;
    }

    public Department deleteDepartment(Department department) {
        departmentDAO.delete(department);
        return department;
    }

    public HashSet<Department> getDepartment() {
        return departmentDAO.getDepartments();
    }

    //project
    public Project addProject(Project project) {
        projectDAO.add(project);
        return project;
    }

    public Project updateProject(Project project) {
        projectDAO.update(project);
        return project;
    }

    public Project deleteProject(Project project) {
        projectDAO.delete(project);
        return project;
    }

    public HashSet<Project> getProjects() {
        return projectDAO.getProjects();
    }

    //employee
    public Employee addEmployee(Employee employee) {
        employeeDAO.add(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        employeeDAO.update(employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
        return employee;
    }

    public HashSet<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    public Employee getEmployee(long id) {
        for (Employee employee : employeeDAO.getEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    /**
     * список працівників над проектом
     * шукати по всіх  співробітниках і вибрати тих в кого назва проекту співпадає
     **/
    public static HashSet<Employee> employeesByProject(String projectName) {

        HashSet<Employee> employeesByProject = new HashSet<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getProjects() != null) {
                for (Project project : employee.getProjects()) {
                    if (project.getName().equals(projectName)) {
                        employeesByProject.add(employee);
                    }
                }
            }
        }
        return employeesByProject;
    }

    /**
     * список проектів над якими працює данний працівник
     * вивести колекцію проетів на консоль
     **/
    public HashSet<Project> projectsByEmployy(Employee employee) {
        return employee.getProjects();
    }

    /**
     * список працівників відділу які не приймають участі в проектах
     * пройтися по всіх працівниках і вибрати тих які належать до данного
     * відділу і в яких нема проектів
     **/
    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> listEmployeesByDepartmentWithoutProject = new ArrayList<>();
        for (Employee employee : employeeDAO.getEmployees()) {
            if (employee.getDepartment().getType() == departmentType && employee.getProjects() == null)
                listEmployeesByDepartmentWithoutProject.add(employee);
        }
        return listEmployeesByDepartmentWithoutProject;
    }


    /**
     * список працывникыв без жодного проекту
     */

    public ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> listEmployeesWithoutProject = new ArrayList<>();
        for (Employee employee : employeeDAO.getEmployees()) {
            if (employee.getProjects() == null)
                listEmployeesWithoutProject.add(employee);
        }
        return listEmployeesWithoutProject;
    }

    /**
     * список підлеглих керівника по всіх проектах
     * створити список проектів де він керівник
     * пройти по всіх праціниках що працюють на проектах і додавати всіх в Сет крім лідера
     * має бути SET  бо будуть дублі
     */
    public HashSet<Employee> employeesByTeamLead(Employee lead) {
        HashSet<Employee> setEmployeesByTeamLead = new HashSet<>();
        ArrayList<Project> arrayListProjectByLead = new ArrayList<>();

        for (Project project : projectDAO.getProjects()) {
            if (project.getLieader().equals(lead)) {
                arrayListProjectByLead.add(project);
            }
        }

        for (Project project : arrayListProjectByLead) {
            HashSet<Employee> tpmList = employeesByProject(project.getName());
            for (Employee employee : tpmList) {
                if (!employee.equals(lead)) {
                    setEmployeesByTeamLead.add(employee);
                }
            }
        }
        return setEmployeesByTeamLead;
    }


    /**
     * список темлідів праціника
     * пройти по всіх проектах де задіяно працівника
     * з кожного проекту взяти темліда і кинути в СЕТ
     * виключаючи ті проекти де він сам темлідер
     */

    public HashSet<Employee> teamLeadsByEmployee(Employee employee) {

        HashSet<Employee> setTeamLeadsByEmployee = new HashSet<>();
        HashSet<Project> setProjectsByEmployy = projectsByEmployy(employee);
        for (Project project : setProjectsByEmployy) {
            if (!project.getLieader().equals(employee))
                setTeamLeadsByEmployee.add(project.getLieader());
        }
        return setTeamLeadsByEmployee;
    }


    /**
     * спсиок праціників які приймають участь в тих же проектах
     * біжимо по  списоку проектів всіх працівників
     * звіряємо по контейнс
     * !!!!!!!!!!!   НЕ проходить contains ....  хоча проект з setProjectsEmployee фактично міститься в empl.getProjects()
     */
    public HashSet<Employee> employeesByProjectEmployee(Employee employee) {

        HashSet<Employee> setEmployeesByProjectEmployee = new HashSet<>();
        HashSet<Project> setProjectsEmployee = projectsByEmployy(employee);

        for (Employee empl : employeeDAO.getEmployees()) {
            if (empl.getProjects() != null && empl.getProjects().contains(setProjectsEmployee) && !empl.equals(employee)) {
                setEmployeesByProjectEmployee.add(empl);
            }
        }
        return setEmployeesByProjectEmployee;
    }

    /**
     * список проектів заданного замовника
     */

    public HashSet<Project> projectsByCustomer(Customer customer) {
        HashSet<Project> setProjectsByCustomer = new HashSet<>();
        for (Project project : projectDAO.getProjects()) {
            if (project.getCustomer().equals(customer))
                setProjectsByCustomer.add(project);
        }
        return setProjectsByCustomer;
    }

    public HashSet<Employee> employeesByCustomerProjects(Customer customer) {
        HashSet<Project> projectByCustomer = projectsByCustomer(customer);
        HashSet<Employee> setEmployeesByCustomerProjects = new HashSet<>();

        for (Project project : projectByCustomer){
            HashSet<Employee> setEmployeeByProject = employeesByProject(project.getName());
            setEmployeesByCustomerProjects.addAll(setEmployeeByProject);
        }
        return setEmployeesByCustomerProjects;
    }
}
