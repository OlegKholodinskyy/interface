package lesson30.hw2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        managementFirm();
    }

    private static void managementFirm() {
        Customer customer1 = new Customer(1001, "Ivan", "USA", 1000);
        Customer customer2 = new Customer(1002, "Stepan", "Ukraine", 500);
        Customer customer3 = new Customer(1003, "Haints", "Germeny", 800);


        Department departmentDevelopers = new Department(1001, DepartmentType.DEVELOPERS);
        Department departmentDesigners = new Department(1002, DepartmentType.DESIGNERS);
        Department departmentFinances = new Department(1003, DepartmentType.FINANCES);

        Employee employee1 = new Employee(1001, "Oleg", "SecondNameOleg", new Date(), Position.DESIGNER, departmentDesigners);
        Employee employee2 = new Employee(1002, "Ivan", "SecondNameIvan", new Date(), Position.DEVELOPER, departmentDevelopers);
        Employee employee3 = new Employee(1003, "Danilo", "SecondNameDanilo", new Date(), Position.DESIGNER, departmentDevelopers);
        Employee employee4 = new Employee(1004, "Stepan", "SecondNameStepan", new Date(), Position.DESIGNER, departmentDevelopers);
        Employee employee5 = new Employee(1005, "Volodimir", "SecondNameVolodimir", new Date(), Position.FINANCE, departmentFinances);
        Employee employee6 = new Employee(1006, "Vlad", "SecondNameVlad", new Date(), Position.FINANCE, departmentFinances);
        Employee employee7 = new Employee(1007, "Olga", "SecondNameOlga", new Date(), Position.DEVELOPER, departmentFinances);


        Controller controller = Controller.getInstance();
        controller.addCustomer(customer1);
        controller.addCustomer(customer2);
        controller.addCustomer(customer3);

        controller.addEmployee(employee1);
        controller.addEmployee(employee2);
        controller.addEmployee(employee3);
        controller.addEmployee(employee4);
        controller.addEmployee(employee5);
        controller.addEmployee(employee6);
        controller.addEmployee(employee7);

        departmentDesigners.addEmployee(employee1);
        departmentDevelopers.addEmployee(employee2);
        departmentDevelopers.addEmployee(employee3);
        departmentDevelopers.addEmployee(employee4);
        departmentFinances.addEmployee(employee5);

        Project project1 = new Project(1001, "FirstProject", customer1, employee2);
        Project project2 = new Project(1002, "SecondProject", customer1, employee2);
        Project project3 = new Project(1003, "ThirdProject", customer2, employee4);
        Project project4 = new Project(1004, "FourProject", customer2, employee5);
        Project project5 = new Project(1005, "FiveProject", customer2, employee1);

        controller.addProject(project1);
        controller.addProject(project2);
        controller.addProject(project3);
        controller.addProject(project4);
        controller.addProject(project5);


        employee2.addProject(project1);
        employee2.addProject(project2);
        employee2.addProject(project3);
        employee1.addProject(project2);
        employee4.addProject(project2);
        employee1.addProject(project4);
        employee2.addProject(project4);
        employee3.addProject(project3);
        employee5.addProject(project3);

        Firm firm = new Firm(new Date());

        firm.addCustomerToFirm(customer1);
        firm.addCustomerToFirm(customer2);
        firm.addCustomerToFirm(customer3);
        firm.addDepartmentToFirm(departmentDesigners);
        firm.addDepartmentToFirm(departmentDevelopers);
        firm.addDepartmentToFirm(departmentFinances);


        System.out.println("***Test CustomerDAO***");
        for (Customer customer : controller.getCustomers())
            System.out.println(customer);

        controller.deleteCustomer(customer2);
        customer3.setMonthlyPay(2000);
        controller.updateCustomer(customer3);
        System.out.println();
        for (Customer customer : controller.getCustomers())
            System.out.println(customer);

        System.out.println("\n"+ "***Test employeesByProject***");
        System.out.println(controller.employeesByProject(project2.getName()));
        System.out.println("\n"+ "***Test projectsByEmployy***");
        System.out.println(controller.projectsByEmployy(employee2));
        System.out.println("\n"+ "***Test employeesByDepartmentWithoutProject***");
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.FINANCES));
        System.out.println("\n" + "***Test employeesWithoutProject***");
        System.out.println(controller.employeesWithoutProject());
        System.out.println("\n" + "***Test employeesByTeamLead***");
        System.out.println(controller.employeesByTeamLead(employee2));
        System.out.println("\n" + "***Test  teamLeadsByEmployee***");
        System.out.println(controller.teamLeadsByEmployee(employee4));
        System.out.println("\n" + "***Test employeesByProjectEmployee");
        System.out.println(controller.employeesByProjectEmployee(employee3));
        System.out.println("\n" + "***TEST projectsByCustomer***");
        System.out.println(controller.projectsByCustomer(customer1));
        System.out.println("\n" + "*** employeesByCustomerProjects ***");
        System.out.println("Customer 1");
        System.out.println(controller.employeesByCustomerProjects(customer1));
        System.out.println("Customer 3");
        System.out.println(controller.employeesByCustomerProjects(customer3));
        System.out.println("Customer 2");
        System.out.println(controller.employeesByCustomerProjects(customer2));
    }
}
