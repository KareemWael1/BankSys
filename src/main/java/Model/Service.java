package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Service {
    @Id @GeneratedValue
    private Long serviceID;
    private String serviceName;
    private double serviceFees;
    private String type;
    private String details;
    private List<Branch> managingBranches;

    public Service(String serviceName, double serviceFees, String type, String details, List<Branch> managingBranches) {
        this.serviceName = serviceName;
        this.serviceFees = serviceFees;
        this.type = type;
        this.details = details;
        this.managingBranches = managingBranches;
        for(Branch branch : managingBranches) {
            branch.addService(this);
        }
    }

    public Service(String serviceName, double serviceFees, String type, String details) {
        this(serviceName, serviceFees, type, details, new ArrayList<Branch>());
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceFees() {
        return serviceFees;
    }

    public void setServiceFees(double serviceFees) {
        this.serviceFees = serviceFees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Branch> getManagingBranches() {
        return managingBranches;
    }

    public void setManagingBranches(List<Branch> managingBranches) {
        this.managingBranches = managingBranches;
    }

    public void addBranch(Branch branch) {
        managingBranches.add(branch);
    }

    public void removeBranch(Branch branch) {
        managingBranches.remove(branch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (Double.compare(service.serviceFees, serviceFees) != 0) return false;
        if (!serviceID.equals(service.serviceID)) return false;
        if (!serviceName.equals(service.serviceName)) return false;
        if (!type.equals(service.type)) return false;
        return details.equals(service.details);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = serviceID.hashCode();
        result = 31 * result + serviceName.hashCode();
        temp = Double.doubleToLongBits(serviceFees);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        result = 31 * result + details.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", serviceFees=" + serviceFees +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
