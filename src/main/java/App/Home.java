package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Home extends JFrame {
    private JPanel panel1;
    private JButton newCustomerButton;
    private JButton newAccountButton;
    private JButton newTransactionButton;
    private JButton newEmployeeButton;
    private JButton newBranchButton;
    private JButton newServiceButton;
    private JButton query1Button;
    private JButton query2Button;
    private JButton query3Button;
    private JButton query4Button;
    private JButton query5Button;
    public EntityManagerFactory emf;
    public EntityManager em;

    public Home() {
        // Initialize the UI components
        initComponents();

        // Set the size and visibility of the frame
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Don't exit immediately

        this.setVisible(true);

        this.emf = Persistence.createEntityManagerFactory("$objectdb/db/Bank.odb");
        this.em = emf.createEntityManager();
        em.getTransaction().begin();

        // Add window listener to perform operation before exit
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                performExitOperation();
            }
        });
    }



    public Home(EntityManagerFactory emf, EntityManager em){
        initComponents();

        // Set the size and visibility of the frame
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

        this.emf = emf;
        this.em = em;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                performExitOperation();
            }
        });
    }

    private void performExitOperation() {
        // Add your operation here before exit
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Close the EntityManager
            em.close();
            emf.close();
            // Exit the application
            System.exit(0);
        }
    }
    private void initComponents() {
        // Initialize the panel
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2)); // Set layout for the panel

        // Initialize the buttons
        newCustomerButton = new JButton("New Customer");
        newAccountButton = new JButton("New Account");
        newTransactionButton = new JButton("New Transaction");
        newEmployeeButton = new JButton("New Employee");
        newBranchButton = new JButton("New Branch");
        newServiceButton = new JButton("New Service");
        query1Button = new JButton("Query 1");
        query2Button = new JButton("Query 2");
        query3Button = new JButton("Query 3");
        query4Button = new JButton("Query 4");
        query5Button = new JButton("Query 5");

        // Add buttons to the panel
        panel1.add(newCustomerButton);
        panel1.add(newAccountButton);
        panel1.add(newTransactionButton);
        panel1.add(newEmployeeButton);
        panel1.add(newBranchButton);
        panel1.add(newServiceButton);
        panel1.add(query1Button);
        panel1.add(query2Button);
        panel1.add(query3Button);
        panel1.add(query4Button);
        panel1.add(query5Button);

        // Add panel to the frame
        this.add(panel1);

        // Add action listeners for the buttons
        query1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
                JOptionPane.showMessageDialog(null, "Total Customers: " + q1.getSingleResult());
            }
        });


        query2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Query q2 = em.createQuery("SELECT AVG(c.creditScore) FROM Customer c");
                JOptionPane.showMessageDialog(null, "Average Credit Score: " + q2.getSingleResult());
            }
        });

        newCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of the new form
                newCustomer newForm = new newCustomer(emf, em);

                // Set the new form to be visible
                newForm.setVisible(true);
            }
        });



        // Add more action listeners for other buttons as needed
    }

//    public static void main(String[] args) {
//        // Use SwingUtilities.invokeLater to ensure GUI creation is done on the Event Dispatch Thread
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                // Create an instance of the Home form
//                Home homeForm = new Home();
//
//                // Set the Home form to be visible
//                homeForm.setVisible(true);
//            }
//        });
//    }
}
