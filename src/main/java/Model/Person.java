package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    protected String ssn;

    protected Name name;
    protected String address;
    protected String emailAddress;
    protected String[] phoneNumber;

    Person(String ssn, Name name, String address, String emailAddress, String[] phoneNumber) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}