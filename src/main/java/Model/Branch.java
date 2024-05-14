package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {
    @Id @GeneratedValue
    private Long branchID;
    private String branchName;
    private String branchAddress;
    private String openingHours;
    private List<Employee> employees;
    private List<Service> services;

    public Branch(String branchName, String branchAddress, String openingHours, List<Employee> employees, List<Service> services) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.openingHours = openingHours;
        this.employees = employees;
        this.services = services;
        for(Employee employee : employees) {
            employee.setBranch(this);
        }
        for(Service service : services) {
            service.addBranch(this);
        }
    }

    public Branch(String branchName, String branchAddress, String openingHours) {
        this(branchName, branchAddress, openingHours, new ArrayList<Employee>(), new ArrayList<Service>());
    }

    public Branch(String branchName, String branchAddress, String openingHours, List<Service> services) {
        this(branchName, branchAddress, openingHours, new ArrayList<Employee>(), services);
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return getBranchID().equals(branch.getBranchID());
    }

    @Override
    public int hashCode() {
        return branchID.hashCode();
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", services=" + services +
                '}';
    }
}
