package Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import App.Bank;

@Entity
public class Transaction {
    @Id @GeneratedValue
    private Long transactionID;
    private String transactionType;
    private double amount;
    private Date date;
    private String destinationAccountNumber;
    private Account sourceAccount;

    public Transaction(String transactionType, double amount, Date date, String destinationAccountNumber, Account sourceAccount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.destinationAccountNumber = destinationAccountNumber;
        this.sourceAccount = sourceAccount;
        if (sourceAccount != null) {
            sourceAccount.addTransaction(this);
        }
        if (destinationAccountNumber != null) {
            getDestinationAccount().deposit(amount);
        }
    }

    public Transaction(String transactionType, double amount, Date date, Account sourceAccount){
        this(transactionType, amount, date, null, sourceAccount);
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!Objects.equals(transactionID, that.transactionID))
            return false;
        if (!Objects.equals(transactionType, that.transactionType))
            return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(destinationAccountNumber, that.destinationAccountNumber))
            return false;
        return Objects.equals(sourceAccount, that.sourceAccount);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = transactionID != null ? transactionID.hashCode() : 0;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (destinationAccountNumber != null ? destinationAccountNumber.hashCode() : 0);
        result = 31 * result + (sourceAccount != null ? sourceAccount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", destinationAccountNumber='" + destinationAccountNumber + '\'' +
                ", sourceAccount=" + sourceAccount +
                '}';
    }

    public Account getDestinationAccount() {
        // Find the account with the destination account number
        EntityManager em = Bank.getEntityManager();
        return em.find(Account.class, destinationAccountNumber);
    }

}
