package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    private String accountNumber;
    private String accountType;
    private double balance;
    private String accountStatus;
    private double interestRate;
    private double minimumBalance;
    private List<Customer> owners;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String accountType, double balance, String accountStatus,
                   double interestRate, double minimumBalance, List<Customer> owners) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.owners = owners;
        for(Customer owner : owners) {
            owner.addAccount(this);
        }
        for (Transaction transaction : transactions) {
            transaction.setSourceAccount(this);
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setOwners(List<Customer> owners) {
        this.owners = owners;
    }

    public List<Customer> getOwners() {
        return owners;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (Objects.equals(transaction.getTransactionType(), "Deposit")) {
            deposit(transaction.getAmount());
        } else if (Objects.equals(transaction.getTransactionType(), "Withdrawal")) {
            withdraw(transaction.getAmount());
        } else if (Objects.equals(transaction.getTransactionType(), "Transfer")) {
            transfer(transaction.getAmount(), transaction.getDestinationAccount());
        }
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void addOwner(Customer owner) {
        owners.add(owner);
    }

    public void removeOwner(Customer owner) {
        owners.remove(owner);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void transfer(double amount, Account destinationAccount) {
        balance -= amount;
        destinationAccount.deposit(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (Double.compare(account.interestRate, interestRate) != 0) return false;
        if (Double.compare(account.minimumBalance, minimumBalance) != 0) return false;
        if (!accountNumber.equals(account.accountNumber)) return false;
        if (!accountType.equals(account.accountType)) return false;
        if (!accountStatus.equals(account.accountStatus)) return false;
        if (!owners.equals(account.owners)) return false;
        return transactions.equals(account.transactions);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber.hashCode();
        result = 31 * result + accountType.hashCode();
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + accountStatus.hashCode();
        temp = Double.doubleToLongBits(interestRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minimumBalance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + owners.hashCode();
        result = 31 * result + transactions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", accountStatus='" + accountStatus + '\'' +
                ", interestRate=" + interestRate +
                ", minimumBalance=" + minimumBalance +
                '}';
    }

}
