package App;

import Model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class DatabaseUtils {
    
    private static EntityManager em;

    // List of first names
    private static final String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy",
            "Kevin", "Laura", "Michael", "Nancy", "Oscar", "Peggy", "Quincy", "Rita", "Steve", "Tina", "Ursula", "Victor", "Wendy", "Xavier",
            "Yvonne", "Zach", "Olivia", "Peter", "Quinn", "Rose", "Sam", "Tara", "Uma", "Violet", "Will", "Xena", "Yara", "Zara" };
    // List of last names
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
            "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez",
            "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams",
            "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans",
            "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera",
            "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James", "Watson", "Brooks", "Kelly",
            "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson", "Cole", "Jenkins", "Perry", "Powell", "Long", "Patterson",
            "Hughes", "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz",
            "Hayes" };
    // List of middle initials
    private static final String[] MIDDLE_INITIALS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};


    // List of addresses
    private static final String[] ADDRESSES = {"123 Main St", "456 Elm St", "789 Oak St", "1011 Pine St", "1213 Maple St", "1415 Cedar St",
            "1617 Birch St", "1819 Spruce St", "2021 Ash St", "2223 Walnut St", "2425 Chestnut St", "2627 Poplar St", "2829 Pineapple St",
            "3031 Orange St", "3233 Banana St", "3435 Grape St", "3637 Cherry St", "3839 Lemon St", "4041 Lime St", "4243 Blueberry St",
            "4445 Raspberry St", "4647 Strawberry St", "4849 Blackberry St", "5051 Raspberry St", "5253 Cranberry St", "5455 Boysenberry St",
            "5657 Gooseberry St", "5859 Elderberry St", "6061 Mulberry St", "6263 Loganberry St", "6465 Dewberry St", "6667 Huckleberry St",
            "6869 Marionberry St", "7071 Tayberry St", "7273 Salmonberry St", "7475 Cloudberry St", "7677 Blackberry St", "7879 Raspberry St",
            "8081 Blueberry St", "8283 Strawberry St", "8485 Raspberry St", "8687 Cranberry St", "8889 Boysenberry St", "9091 Gooseberry St",
            "9293 Elderberry St", "9495 Mulberry St", "9697 Loganberry St", "9899 Dewberry St", "100101 Huckleberry St", "102103 Marionberry St",
            "104105 Tayberry St", "106107 Salmonberry St", "108109 Cloudberry St", "110111 Blackberry St", "112113 Raspberry St", "114115 Blueberry St",
            "116117 Strawberry St", "118119 Raspberry St", "120121 Cranberry St", "122123 Boysenberry St", "124125 Gooseberry St", "126127 Elderberry St",
            "128129 Mulberry St", "130131 Loganberry St", "132133 Dewberry St", "134135 Huckleberry St", "136137 Marionberry St", "138139 Tayberry St",
            "140141 Salmonberry St", "142143 Cloudberry St",
            "144145 Blackberry St", "146147 Raspberry St", "148149 Blueberry St", "150151 Strawberry St", "152153 Raspberry St", "154155 Cranberry St",
            "156157 Boysenberry St", "158159 Gooseberry St", "160161 Elderberry St", "162163 Mulberry St", "164165 Loganberry St", "166167 Dewberry St",
            "168169 Huckleberry St", "170171 Marionberry St", "172173 Tayberry St", "174175 Salmonberry St", "176177 Cloudberry St", "178179 Blackberry St",
            "180181 Raspberry St", "182183 Blueberry St", "184185 Strawberry St", "186187 Raspberry St", "188189 Cranberry St", "190191 Boysenberry St",
            "192193 Gooseberry St", "194195 Elderberry St", "196197 Mulberry St", "198199 Loganberry St", "200201 Dewberry St", "202203 Huckleberry St",
            "204205 Marionberry St", "206207 Tayberry St", "208209 Salmonberry St", "210211 Cloudberry St", "212213 Blackberry St", "214215 Raspberry St"};

    // List of customer segments
    private static final String[] CUSTOMER_SEGMENTS = {"Silver", "Gold", "Platinum", "Premium"};

    // List of marketing preferences
    private static final String[] MARKETING_PREFERENCES = {"Email", "Phone", "Mail", "SMS", "Email, Phone", "Email, Mail", "Email, SMS", "Phone, Mail", "Phone, SMS", "Mail, SMS", "Email, Phone, Mail", "Email, Phone, SMS", "Email, Mail, SMS", "Phone, Mail, SMS", "Email, Phone, Mail, SMS"};


    // List of account types
    private static final String[] ACCOUNT_TYPES = {"Checking", "Savings", "Custodial", "Trust"};

    // List of account statuses
    private static final String[] ACCOUNT_STATUSES = {"Active", "Inactive", "Closed"};

    // List of bank employee job titles
    private static final String[] JOB_TITLES = {"Teller", "Manager", "Engineer", "Analyst", "Technician", "Designer", "Developer", "Accountant", "Administrator", "Consultant"};

    // List of bank employee departments
    private static final String[] DEPARTMENTS = {"Accounting", "Administration", "Customer Service", "Engineering", "Finance", "Human Resources", "IT", "Marketing", "Consulting"};



    // List of transaction types
    private static final String[] TRANSACTION_TYPES = {"Deposit", "Withdrawal", "Transfer"};

    private static final Random random = new Random();

    public static void populateDatabase() {
        em = Bank.getEntityManager();

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

        // Store 10 Account objects in the database:
        em.getTransaction().begin();
        Account account1 = new Account("1234567890", "Checking", 1000.00, "Active", 3.1, 100, List.of(customer1, customer3));
        Account account2 = new Account("0987654321", "Savings", 2000.00, "Active", 3.2, 200, List.of(customer2));
        Account account3 = new Account("5551234567", "Checking", 3000.00, "Active", 3.3, 300, List.of(customer3));
        Account account4 = new Account("5559876543", "Savings", 4000.00, "Active", 3.4, 400, List.of(customer3));
        Account account5 = new Account("1112223333", "Checking", 5000.00, "Active", 3.5, 500, List.of(customer4));
        Account account6 = new Account("4445556666", "Savings", 6000.00, "Active", 3.6, 600, List.of(customer5));
        Account account7 = new Account("7778889999", "Checking", 7000.00, "Active", 3.7, 700, List.of(customer6));
        Account account8 = new Account("0001112222", "Savings", 8000.00, "Active", 3.8, 800, List.of(customer7));
        Account account9 = new Account("3334445555", "Checking", 9000.00, "Active", 3.9, 900, List.of(customer8));
        Account account10 = new Account("6667778888", "Savings", 10000.00, "Active", 4.0, 1000, List.of(customer9));
        em.persist(account1);
        em.persist(account2);
        em.persist(account3);
        em.persist(account4);
        em.persist(account5);
        em.persist(account6);
        em.persist(account7);
        em.persist(account8);
        em.persist(account9);
        em.persist(account10);
        em.getTransaction().commit();

        // Store 10 Transaction objects in the database:
        em.getTransaction().begin();
        Transaction transaction1 = new Transaction("Deposit", 100.00, new Date(2001, 1, 1, 13, 4, 43), null, account1);
        Transaction transaction2 = new Transaction("Withdrawal", 200.00, new Date(2002, 2, 2, 14, 5, 44), null, account2);
        Transaction transaction3 = new Transaction("Deposit", 300.00, new Date(2003, 3, 3, 15, 6, 45), null, account3);
        Transaction transaction4 = new Transaction("Withdrawal", 400.00, new Date(2004, 4, 4, 16, 7, 46), null, account4);
        Transaction transaction5 = new Transaction("Deposit", 500.00, new Date(2005, 5, 5, 17, 8, 47), null, account5);
        Transaction transaction6 = new Transaction("Withdrawal", 600.00, new Date(2006, 6, 6, 18, 9, 48), null, account6);
        Transaction transaction7 = new Transaction("Transfer", 700.00, new Date(2007, 7, 7, 19, 10, 49), account1.getAccountNumber(), account7);
        Transaction transaction8 = new Transaction("Transfer", 800.00, new Date(2008, 8, 8, 20, 11, 50), account2.getAccountNumber(), account8);
        Transaction transaction9 = new Transaction("Transfer", 900.00, new Date(2009, 9, 9, 21, 12, 51), account3.getAccountNumber(), account9);
        Transaction transaction10 = new Transaction("Transfer", 1000.00, new Date(2010, 10, 10, 22, 13, 52), account4.getAccountNumber(), account10);
        em.persist(transaction1);
        em.persist(transaction2);
        em.persist(transaction3);
        em.persist(transaction4);
        em.persist(transaction5);
        em.persist(transaction6);
        em.persist(transaction7);
        em.persist(transaction8);
        em.persist(transaction9);
        em.persist(transaction10);
        em.getTransaction().commit();

        // Store 10 Branch objects in the database:
        em.getTransaction().begin();
        Branch branch1 = new Branch("Main", "111 Main St", "111-222-3333");
        Branch branch2 = new Branch("North", "222 North St", "222-333-4444");
        Branch branch3 = new Branch("South", "333 South St", "333-444-5555");
        Branch branch4 = new Branch("East", "444 East St", "444-555-6666");
        Branch branch5 = new Branch("West", "555 West St", "555-666-7777");
        Branch branch6 = new Branch("Central", "666 Central St", "666-777-8888");
        Branch branch7 = new Branch("Downtown", "777 Downtown St", "777-888-9999");
        Branch branch8 = new Branch("Uptown", "888 Uptown St", "888-999-0000");
        Branch branch9 = new Branch("Midtown", "999 Midtown St", "999-000-1111");
        Branch branch10 = new Branch("Suburb", "000 Suburb St", "000-111-2222");
        em.persist(branch1);
        em.persist(branch2);
        em.persist(branch3);
        em.persist(branch4);
        em.persist(branch5);
        em.persist(branch6);
        em.persist(branch7);
        em.persist(branch8);
        em.persist(branch9);
        em.persist(branch10);

        // Store 10 Service objects in the database:
        Service savingsAccountService = new Service("Savings Account", 5.0, "Account", "Basic savings account service", List.of(branch1, branch2, branch3, branch4, branch5));
        Service checkingAccountService = new Service("Checking Account", 7.5, "Account", "Basic checking account service", List.of(branch6, branch7, branch8, branch9, branch10));
        Service loanService = new Service("Loan", 15.0, "Financial", "Loan service for various purposes", List.of(branch1, branch2, branch3, branch4, branch5));
        Service creditCardService = new Service("Credit Card", 10.0, "Financial", "Credit card service with rewards program", List.of(branch6, branch7, branch8, branch9, branch10));
        Service investmentService = new Service("Investment", 20.0, "Financial", "Investment service for stocks, bonds, etc.", List.of(branch1, branch2, branch3, branch4, branch5));
        Service mortgageService = new Service("Mortgage", 25.0, "Financial", "Mortgage service for buying properties", List.of(branch6, branch7, branch8, branch9, branch10));
        Service onlineBankingService = new Service("Online Banking", 3.0, "Digital", "Online banking service for account management", List.of(branch1, branch2, branch3, branch4, branch5));
        Service mobileBankingService = new Service("Mobile Banking", 3.0, "Digital", "Mobile banking service for on-the-go access", List.of(branch6, branch7, branch8, branch9, branch10));
        Service atmService = new Service("ATM", 1.0, "Physical", "ATM service for cash withdrawals and deposits", List.of(branch1, branch2, branch3, branch4, branch5));
        Service wireTransferService = new Service("Wire Transfer", 12.0, "Financial", "Wire transfer service for sending money domestically and internationally", List.of(branch6, branch7, branch8, branch9, branch10));
        em.persist(savingsAccountService);
        em.persist(checkingAccountService);
        em.persist(loanService);
        em.persist(creditCardService);
        em.persist(investmentService);
        em.persist(mortgageService);
        em.persist(onlineBankingService);
        em.persist(mobileBankingService);
        em.persist(atmService);
        em.persist(wireTransferService);
        em.getTransaction().commit();

        // Store 10 Employee objects in the database:
        em.getTransaction().begin();
        // Create 10 names
        Name name11 = new Name("John", "M", "Doe");
        Name name12 = new Name("Jane", "F", "Smith");
        Name name13 = new Name("James", "M", "Johnson");
        Name name14 = new Name("Jill", "F", "Williams");
        Name name15 = new Name("Jack", "M", "Brown");
        Name name16 = new Name("Jenny", "F", "Davis");
        Name name17 = new Name("Joe", "M", "Miller");
        Name name18 = new Name("Jessica", "F", "Wilson");
        Name name19 = new Name("Jerry", "M", "Moore");
        Name name20 = new Name("Julie", "F", "Taylor");
        em.persist(name11);
        em.persist(name12);
        em.persist(name13);
        em.persist(name14);
        em.persist(name15);
        em.persist(name16);
        em.persist(name17);
        em.persist(name18);
        em.persist(name19);
        em.persist(name20);
        Employee employee1 = new Employee("123-45-6789", name11, "123 Main St", "john@example.com",
                new String[]{"123-456-7890"}, "Manager", "Engineering", 75000.0, new Date(), branch1, null);

        Employee employee2 = new Employee("234-56-7890", name12, "456 Elm St", "jane@example.com",
                new String[]{"234-567-8901"}, "Engineer", "Engineering", 60000.0, new Date(), branch2, employee1);
        Employee employee3 = new Employee("345-67-8901", name13, "789 Oak St", "bob@example.com",
                new String[]{"345-678-9012"}, "Analyst", "Finance", 55000.0, new Date(), branch3, employee1);

        Employee employee4 = new Employee("456-78-9012", name14, "101 Pine St", "mary@example.com",
                new String[]{"456-789-0123"}, "Technician", "IT", 50000.0, new Date(), branch4, employee1);

        Employee employee5 = new Employee("567-89-0123", name15, "202 Cedar St", "david@example.com",
                new String[]{"567-890-1234"}, "Designer", "Marketing", 60000.0, new Date(), branch5, employee1);

        Employee employee6 = new Employee("678-90-1234", name16, "303 Maple St", "sarah@example.com",
                new String[]{"678-901-2345"}, "Developer", "IT", 65000.0, new Date(), branch6, employee1);

        Employee employee7 = new Employee("789-01-2345", name17, "404 Walnut St", "chris@example.com",
                new String[]{"789-012-3456"}, "Accountant", "Finance", 58000.0, new Date(), branch7, employee1);

        Employee employee8 = new Employee("890-12-3456", name18, "505 Cherry St", "lisa@example.com",
                new String[]{"890-123-4567"}, "Administrator", "Administration", 70000.0, new Date(), branch8, employee1);

        Employee employee9 = new Employee("901-23-4567", name19, "606 Spruce St", "jason@example.com",
                new String[]{"901-234-5678"}, "Manager", "Marketing", 75000.0, new Date(), branch9, employee1);

        Employee employee10 = new Employee("012-34-5678", name20, "707 Birch St", "emily@example.com",
                new String[]{"012-345-6789"}, "Consultant", "Consulting", 80000.0, new Date(), branch10, employee1);
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(employee4);
        em.persist(employee5);
        em.persist(employee6);
        em.persist(employee7);
        em.persist(employee8);
        em.persist(employee9);
        em.persist(employee10);
        em.getTransaction().commit();

        // 10000 Customers
        for (int i = 1; i <= 10000; i++) {
            em.getTransaction().begin();
            // Select a random first name and last name and middle initial
            Name name = new Name(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)], MIDDLE_INITIALS[random.nextInt(MIDDLE_INITIALS.length)], LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
            em.persist(name);
            // Generate ssn
            String ssn = String.format("%03d-%02d-%03d", random.nextInt(1000), i/100, i%1000);
            // Generate random address
            String address = ADDRESSES[random.nextInt(ADDRESSES.length)];
            // Generate random email
            String email = String.format("%s%d@gmail.com", name.getFirst().toLowerCase(), i);
            // Generate random phone numbers
            String[] phoneNumbers = new String[]{String.format("%03d%03d%04d", i%1000, i%1000, i%10000)};
            // Generate random credit score
            int creditScore = 300 + random.nextInt(700);
            // Generate random customer segment
            String segment = CUSTOMER_SEGMENTS[random.nextInt(CUSTOMER_SEGMENTS.length)];
            // Generate random marketing preferences
            String marketingPreferences = MARKETING_PREFERENCES[random.nextInt(MARKETING_PREFERENCES.length)];

            Customer customer = new Customer(ssn, name, address, email, phoneNumbers, creditScore, segment, marketingPreferences);
            em.persist(customer);

            // Generate random account number
            String accountNumber = String.format("%09d", i);
            // Generate random account type
            String accountType = ACCOUNT_TYPES[random.nextInt(ACCOUNT_TYPES.length)];
            // Generate random balance
            double balance = 1000 + random.nextInt(1000000);
            // Generate random status
            String status = ACCOUNT_STATUSES[random.nextInt(ACCOUNT_STATUSES.length)];
            // Generate random interest rate
            double interestRate = ((int)((random.nextDouble() * 5 + 2) * 100)) / 100.0;
            // Generate random minimum balance
            double minimumBalance = 100 + random.nextInt(900);
            List<Customer> customers = new java.util.ArrayList<>(List.of(customer));
            if(random.nextBoolean()) {
                // Select a random first name and last name and middle initial
                Name nameS = new Name(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)], MIDDLE_INITIALS[random.nextInt(MIDDLE_INITIALS.length)], LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
                em.persist(nameS);
                // Generate ssn
                String ssn2 = String.format("%03d-%02d-%03d", random.nextInt(1000), i/100, i%1000);
                // Generate random address
                String address2 = ADDRESSES[random.nextInt(ADDRESSES.length)];
                // Generate random email
                String email2 = String.format("%s%d@gmail.com", name.getFirst().toLowerCase(), i);
                // Generate random phone numbers
                String[] phoneNumbers2 = new String[]{String.format("%03d%03d%04d", i%1000, i%1000, i%10000)};
                // Generate random credit score
                int creditScore2 = 300 + random.nextInt(700);
                // Generate random customer segment
                String segment2 = CUSTOMER_SEGMENTS[random.nextInt(CUSTOMER_SEGMENTS.length)];
                // Generate random marketing preferences
                String marketingPreferences2 = MARKETING_PREFERENCES[random.nextInt(MARKETING_PREFERENCES.length)];

                Customer customerS = new Customer(ssn2, nameS, address2, email2, phoneNumbers2, creditScore2, segment2, marketingPreferences2);
                em.persist(customerS);
                customers.add(customerS);
            }
            Account account = new Account(accountNumber, accountType, balance, status, interestRate, minimumBalance, customers);
            em.persist(account);

            // Generate 100 transactions for the account
            for (int j = 1; j <= 10; j++) {
                // Generate random transaction type
                String transactionType = TRANSACTION_TYPES[random.nextInt(TRANSACTION_TYPES.length)];
                // Generate random transaction amount
                double transactionAmount = 1 + random.nextInt(10000);
                // Generate random transaction date
                Date transactionDate = new Date(2000 + random.nextInt(23), random.nextInt(12), random.nextInt(28), random.nextInt(24), random.nextInt(60), random.nextInt(60));
                String destinationAccountNumber = null;
                if (transactionType.equals("Transfer")) {
                    if(i < 10){
                        transactionType = "Deposit";
                    }
                    else {
                        destinationAccountNumber = String.format("%09d", random.nextInt(i - 1) + 1);
                    }
                }
                Transaction transaction = new Transaction(transactionType, transactionAmount, transactionDate, destinationAccountNumber, account);
                em.persist(transaction);
            }
            em.getTransaction().commit();
        }

        ArrayList<Branch> branches = new ArrayList<>();
        branches.add(branch1);
        branches.add(branch2);
        branches.add(branch3);
        branches.add(branch4);
        branches.add(branch5);
        branches.add(branch6);
        branches.add(branch7);
        branches.add(branch8);
        branches.add(branch9);
        branches.add(branch10);

        ArrayList<Employee> managers = new ArrayList<>();
        managers.add(employee1);
        managers.add(employee9);

        // Generate 1000 employees
        for (int i = 1; i <= 1000; i++) {
            em.getTransaction().begin();
            // Select a random first name and last name and middle initial
            Name name = new Name(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)], MIDDLE_INITIALS[random.nextInt(MIDDLE_INITIALS.length)], LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
            em.persist(name);
            // Generate ssn
            String ssn = String.format("%03d-%02d-%03d", (i * 36) % 1000, (i / 2) % 100, (i + 13) % 1000);
            // Generate random address
            String address = ADDRESSES[random.nextInt(ADDRESSES.length)];
            // Generate random email
            String email = String.format("%s%d@gmail.com", name.getFirst().toLowerCase(), i);
            // Generate random phone numbers
            String[] phoneNumbers = new String[]{String.format("%03d%03d%04d", i % 1000, i % 1000, i % 10000)};
            // Generate random job title
            String jobTitle = JOB_TITLES[random.nextInt(JOB_TITLES.length)];
            // Generate random department
            String department = DEPARTMENTS[random.nextInt(DEPARTMENTS.length)];
            // Generate random salary
            double salary = 30000 + random.nextInt(170000);
            // Generate random hire date
            Date hireDate = new Date(2000 + random.nextInt(23), random.nextInt(12), random.nextInt(28), random.nextInt(24), random.nextInt(60), random.nextInt(60));
            // Generate random branch
            Branch branch = branches.get(random.nextInt(branches.size()));
            Employee employee = new Employee(ssn, name, address, email, phoneNumbers, jobTitle, department, salary, hireDate, branch, null);
            if (jobTitle.equals("Manager")) {
                managers.add(employee);
            }
            else {
                Employee manager = managers.get(random.nextInt(managers.size()));
                employee.setManager(manager);
            }
            em.persist(employee);
            em.getTransaction().commit();
        }
    }
}
