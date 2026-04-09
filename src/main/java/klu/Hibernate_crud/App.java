package klu.Hibernate_crud;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // ✅ TURN OFF HIBERNATE LOGS (JUL)
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        
    	
        System.out.println("Hello World!");
        
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        
        SessionFactory factory = config.buildSessionFactory();
        
        // ================= INSERT PART =================
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();   // ✅ REQUIRED
        
        /*
        Transaction tx = session.beginTransaction();

        Employee existing = session.find(Employee.class, 3);

        Employee e = new Employee();
        // e.setID(3);  // ❌ commented because ID is AUTO GENERATED
        e.setID(5);
        e.setFn("Aman");
        e.setLn("Agarwal");
        e.setSal(11.25);
        session.save(e);
        System.out.println("Record inserted");

        Employee e1 = session.find(Employee.class, 3);
        if (e1 != null) {
            System.out.println("Record retrived successfully " + e1.getSal());
        }

        tx.commit();
        */
        
        // 3. Write HQL queries to retrieve all Employees sorted by fn:
        // a. Ascending order
        // b. Descending order
        
        String hqlasc = "From Employee e ORDER BY e.fn ASC"; // for descending DESC
        List<Employee> empasc = session.createQuery(hqlasc, Employee.class).list();

        for (Employee emp : empasc)
        {
            System.out.println(emp.getID() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getSal());
        }
        
        tx.commit();        // ✅ REQUIRED
        session.close();
    }
}
