package App;

import Model.Branch;
import Model.Customer;
import Model.Employee;
import Model.Name;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

public class newEmployee extends JFrame {
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
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JButton submitButton;
    public EntityManagerFactory emf;
    public EntityManager em;

    public newEmployee(EntityManagerFactory emf, EntityManager em) {
        // Set the title of the form
        setTitle("New Employee Form");

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
        panel1.setLayout(new GridLayout(15, 4)); // 11 rows, 2 columns layout

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
        textField11 = new JTextField();
        textField12 = new JTextField();
        textField13 = new JTextField();

        // Initialize the submit button
        submitButton = new JButton("Submit");

        // Add components to the panel
        panel1.add(new JLabel("Job Title:"));
        panel1.add(textField1);
        panel1.add(new JLabel("Department Name:"));
        panel1.add(textField2);
        panel1.add(new JLabel("Salary:"));
        panel1.add(textField3);
        panel1.add(new JLabel("BranchID:"));
        panel1.add(textField5);
        panel1.add(new JLabel("ManagerSSN:"));
        panel1.add(textField6);
//------------------
        panel1.add(new JLabel("SSN:"));
        panel1.add(textField7);
        panel1.add(new JLabel("First Name:"));
        panel1.add(textField8);
        panel1.add(new JLabel("Middle Name:"));
        panel1.add(textField9);
        panel1.add(new JLabel("Last Name:"));
        panel1.add(textField10);
        panel1.add(new JLabel("Address:"));
        panel1.add(textField11);
        panel1.add(new JLabel("Email Address:"));
        panel1.add(textField12);
        panel1.add(new JLabel("Phone Number:"));
        panel1.add(textField13);

        // Add the submit button
        panel1.add(submitButton);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the form submission here
                em.getTransaction().begin();
                Branch branch = em.find(Branch.class, Long.parseLong(textField5.getText()));
                Employee manger = em.find(Employee.class,textField6.getText());
                Date d = new Date(System.currentTimeMillis());
                Name name = new Name(textField8.getText(),
                        textField9.getText(),textField10.getText());

                em.persist(name);
                Employee employee = new Employee(textField7.getText(),name,textField11.getText(),
                        textField12.getText(),new String[]{textField13.getText()}
                        ,textField1.getText(),textField2.getText(), Double.parseDouble(textField3.getText()),d,
                        branch , manger);

                em.persist(employee);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Form submitted!");
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of the newCustomer form

    }
}
