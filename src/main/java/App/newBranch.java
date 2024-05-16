package App;

import Model.Branch;
import Model.Customer;
import Model.Name;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newBranch extends JFrame {
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

    public newBranch(EntityManagerFactory emf, EntityManager em) {
        // Set the title of the form
        setTitle("New Branch Form");

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

        panel1.add(new JLabel("Branch Name:"));
        panel1.add(textField2);
        panel1.add(new JLabel("Branch Address:"));
        panel1.add(textField3);
        panel1.add(new JLabel("Opening Hours:"));
        panel1.add(textField4);



        // Add the submit button
        panel1.add(submitButton);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the form submission here
                em.getTransaction().begin();
                Branch branch = new Branch(textField2.getText() , textField3.getText(), textField4.getText());

                em.persist(branch);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Form submitted!");
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of the newCustomer form

    }
}
