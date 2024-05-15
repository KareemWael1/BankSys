package App;

import javax.persistence.*;
import java.util.*;
import Model.*;

public class Bank {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        emf = Persistence.createEntityManagerFactory("$objectdb/db/App.Bank.odb");
        em = emf.createEntityManager();

        // DatabaseUtils.populateDatabase();

        // Find the number of Customer objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
        System.out.println("Total Customers: " + q1.getSingleResult());

        // Find the average Credit Score value:
        Query q2 = em.createQuery("SELECT AVG(c.creditScore) FROM Customer c");
        System.out.println("Average Credit Score: " + q2.getSingleResult());

        // Retrieve all the Customer objects from the database:
        System.out.println("Customers: ");
        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> results = query.getResultList();
        for (Customer c : results) {
            System.out.println(c);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}