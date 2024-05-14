package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Entity
public class Customer extends Person implements Serializable {
    private int creditScore;
    private String customerSegment;
    private String marketingPreferences;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String ssn, Name name, String address, String emailAddress, String[] phoneNumber, int creditScore, String customerSegment, String marketingPreferences) {
        super(ssn, name, address, emailAddress, phoneNumber);
        this.creditScore = creditScore;
        this.customerSegment = customerSegment;
        this.marketingPreferences = marketingPreferences;
        for (Account account: accounts){
            account.addOwner(this);
        }
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (creditScore != customer.creditScore) return false;
        if (!customerSegment.equals(customer.customerSegment)) return false;
        if (!marketingPreferences.equals(customer.marketingPreferences)) return false;
        return Objects.equals(accounts, customer.accounts);
    }

    @Override
    public int hashCode() {
        int result = creditScore;
        result = 31 * result + customerSegment.hashCode();
        result = 31 * result + marketingPreferences.hashCode();
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ssn='" + ssn + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + Arrays.toString(phoneNumber) +
                ", creditScore=" + creditScore +
                ", customerSegment='" + customerSegment + '\'' +
                ", marketingPreferences='" + marketingPreferences + '\'' +
                ", accounts=" + accounts +
                '}';
    }

}
