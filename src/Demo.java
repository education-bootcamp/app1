import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Demo {
    public static void main(String[] args) {
        // savCustomer();
        // getCustomer("C01");
         updateCustomer("C01");
    }

    private static void updateCustomer(String id) {
        Configuration configuration= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer tempCustomer = session.get(Customer.class,id);
        System.out.println("before update : "+tempCustomer);

        tempCustomer.setName("Jayantha");
        tempCustomer.setAddress("Bandaragama");
        tempCustomer.setSalary(45000);

        Transaction transaction = session.beginTransaction();
        session.update(tempCustomer);
        transaction.commit();

        Customer newCustomer = session.get(Customer.class, id);
        System.out.println("after update :"+newCustomer);
    }

    private static void getCustomer(String id) {
        Configuration configuration= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer c1 = session.get(Customer.class,id);
        System.out.println(c1);
    }

    private static void saveCustomer(){
        Customer c1= new Customer("C01","Nimal","Colombo",2000);
        Configuration configuration= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c1);
        transaction.commit();
    }
}
