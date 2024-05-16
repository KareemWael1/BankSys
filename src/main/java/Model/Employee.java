package Model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

@Entity
public class Employee extends Person{
    private String jobTitle;
    private String departmentName;
    private double salary;
    private Date hireDate;
    private Branch branch;
    private Employee manager;
    private List<Employee> managedEmployees;

    public Employee(String ssn, Name name, String address, String email, String[] phoneNumber, String jobTitle,
                    String departmentName, double salary, Date hireDate, Branch branch, Employee manager,
                    List<Employee> managedEmployees) {
        super(ssn, name, address, email, phoneNumber);
        this.jobTitle = jobTitle;
        this.departmentName = departmentName;
        this.salary = salary;
        this.hireDate = hireDate;
        this.branch = branch;
        this.manager = manager;
        this.managedEmployees = managedEmployees;
        for (Employee employee: managedEmployees){
            employee.setManager(this);
        }
        manager.addManagedEmployee(this);
    }

    public Employee(String ssn, Name name, String address, String email, String[] phoneNumber, String jobTitle,
                    String departmentName, double salary, Date hireDate, Branch branch, Employee manager) {
        this(ssn, name, address, email, phoneNumber, jobTitle, departmentName, salary, hireDate, branch,
                manager, new ArrayList<Employee>());

    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(List<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void addManagedEmployee(Employee employee) {
        managedEmployees.add(employee);
    }

    public void removeManagedEmployee(Employee employee) {
        managedEmployees.remove(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        if (!jobTitle.equals(employee.jobTitle)) return false;
        if (!departmentName.equals(employee.departmentName)) return false;
        if (!hireDate.equals(employee.hireDate)) return false;
        if (!branch.equals(employee.branch)) return false;
        if (!Objects.equals(manager, employee.manager)) return false;
        return managedEmployees.equals(employee.managedEmployees);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = jobTitle.hashCode();
        result = 31 * result + departmentName.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + branch.hashCode();
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + managedEmployees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn='" + ssn + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + Arrays.toString(phoneNumber) +
                ", jobTitle='" + jobTitle + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", branch=" + branch +
                ", manager=" + manager +
                ", managedEmployees=" + managedEmployees +
                '}';
    }

}
