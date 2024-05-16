package App;

import Model.Account;
import Model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newAccount extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton submitButton;
    public EntityManagerFactory emf;
    public EntityManager em;

    public newAccount(EntityManagerFactory emf, EntityManager em) {
        // Set the title of the form
        setTitle("New Account Form");

        // Set the size of the form
        setSize(400, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize the UI components
        initComponents();

        // Add the panel to the frame
        add(panel1);

        // Center the form on the screen
        setLocationRelativeTo(null);

        // Set the form to be visible
        setVisible(true);
        this.emf = emf;
        this.em = em;
    }

    private void initComponents() {
        // Initialize the panel with a layout manager
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(11, 2)); // 11 rows, 2 columns layout

        // Initialize the text fields
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        textField10 = new JTextField();

        // Initialize the submit button
        submitButton = new JButton("Submit");

        // Add components to the panel
        panel1.add(new JLabel("Account Number:"));
        panel1.add(textField1);
        panel1.add(new JLabel("Account Type:"));
        panel1.add(textField2);
        panel1.add(new JLabel("Balance:"));
        panel1.add(textField3);
        panel1.add(new JLabel("Account Status:"));
        panel1.add(textField4);
        panel1.add(new JLabel("Interest Rate:"));
        panel1.add(textField5);
        panel1.add(new JLabel("Minimum Balance:"));
        panel1.add(textField6);
        panel1.add(new JLabel("Owners SSN:"));
        panel1.add(textField7);
        panel1.add(textField8);

        // Add the submit button
        panel1.add(submitButton);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the form submission here
                em.getTransaction().begin();
                String customerSSN = textField7.getText();
                String customer2SSN = textField8.getText();
                Customer c =  em.find(Customer.class,customerSSN);
                Customer c2 = em.find(Customer.class,customer2SSN);
                ArrayList<Customer> customerList = new ArrayList<Customer>();
                if(c!=null)
                    customerList.add(c);
                if(c2!=null)
                    customerList.add(c2);
                //ToDo check if the text box empty to handle the error
                Account account = new Account(textField1.getText(),textField2.getText() , Double.parseDouble(textField3.getText()), textField4.getText(),
                        Double.parseDouble(textField5.getText()), Double.parseDouble(textField6.getText()), customerList);

                em.persist(account);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Form submitted!");
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of the newCustomer form

    }
}
