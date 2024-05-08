package Model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Customer extends Person implements Serializable {
    private int creditScore;
    private String customerSegment;
    private String marketingPreferences;

    public Customer(String ssn, Name name, String address, String emailAddress, String[] phoneNumber, int creditScore, String customerSegment, String marketingPreferences) {
        super(ssn, name, address, emailAddress, phoneNumber);
        this.creditScore = creditScore;
        this.customerSegment = customerSegment;
        this.marketingPreferences = marketingPreferences;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getMarketingPreferences() {
        return marketingPreferences;
    }

    public void setMarketingPreferences(String marketingPreferences) {
        this.marketingPreferences = marketingPreferences;
    }
}
