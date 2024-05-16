package App;

import javax.persistence.*;
import javax.swing.*;
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

//        DatabaseUtils.populateDatabase(); // commment again after run
        //DatabaseUtils.populateDatabase2();
        // Find the number of Customer objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
        System.out.println("Total Customers: " + q1.getSingleResult());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of the Home form
                Home homeForm = new Home(emf, em);

                // Set the Home form to be visible
                homeForm.setVisible(true);
            }
        });
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}