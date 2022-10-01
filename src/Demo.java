import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Demo {
    public static void main(String[] args) {
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
