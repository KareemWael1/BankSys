import javax.persistence.*;
import java.util.*;
import Model.*;

public class Bank {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/Bank.odb");
        EntityManager em = emf.createEntityManager();

        // Store 10 Customer objects in the database:
        em.getTransaction().begin();
        Name name1 = new Name("John", "Q", "Doe");
        Name name2 = new Name("Jane", "", "Smith");
        Name name3 = new Name("Alice", "R", "Johnson");
        Name name4 = new Name("Michael", "A", "Johnson");
        Name name5 = new Name("Emily", "B", "Williams");
        Name name6 = new Name("David", "C", "Brown");
        Name name7 = new Name("Sarah", "D", "Miller");
        Name name8 = new Name("James", "E", "Davis");
        Name name9 = new Name("Mary", "F", "Wilson");
        Name name10 = new Name("Robert", "G", "Martinez");
        em.persist(name1);
        em.persist(name2);
        em.persist(name3);
        em.persist(name4);
        em.persist(name5);
        em.persist(name6);
        em.persist(name7);
        em.persist(name8);
        em.persist(name9);
        em.persist(name10);
        Customer customer1 = new Customer("123-45-6789", name1, "123 Main St", "john@example.com", new String[]{"1234567890"}, 750, "Premium", "Email, SMS");
        Customer customer2 = new Customer("987-65-4321", name2, "456 Elm St", "jane@example.com", new String[]{"0987654321"}, 700, "Gold", "Email");
        Customer customer3 = new Customer("543-21-9876", name3, "789 Oak St", "alice@example.com", new String[]{"5551234567", "5559876543"}, 800, "Platinum", "SMS");
        Customer customer4 = new Customer("111-22-3333", name4, "555 Pine St", "michael@example.com", new String[]{"1112223333"}, 720, "Gold", "Email");
        Customer customer5 = new Customer("444-55-6666", name5, "777 Cedar St", "emily@example.com", new String[]{"4445556666"}, 690, "Silver", "SMS");
        Customer customer6 = new Customer("777-88-9999", name6, "999 Maple St", "david@example.com", new String[]{"7778889999"}, 780, "Platinum", "Email, SMS");
        Customer customer7 = new Customer("000-11-2222", name7, "111 Walnut St", "jessica@example.com", new String[]{"0001112222"}, 700, "Gold", "SMS");
        Customer customer8 = new Customer("333-44-5555", name8, "222 Birch St", "ryan@example.com", new String[]{"3334445555"}, 760, "Premium", "Email");
        Customer customer9 = new Customer("666-77-8888", name9, "333 Oak St", "sophia@example.com", new String[]{"6667778888"}, 730, "Gold", "SMS");
        Customer customer10 = new Customer("999-00-1111", name10, "444 Elm St", "matthew@example.com", new String[]{"9990011111"}, 710, "Silver", "Email");
        em.persist(customer1);
        em.persist(customer2);
        em.persist(customer3);
        em.persist(customer4);
        em.persist(customer5);
        em.persist(customer6);
        em.persist(customer7);
        em.persist(customer8);
        em.persist(customer9);
        em.persist(customer10);
        em.getTransaction().commit();

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
}