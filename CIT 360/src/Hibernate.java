package test.M;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Hibernate 
{
	public static void main(String[] args)
	{
		Person decker = new Person();
		decker.setID(101);
		decker.setFname("Peter");
		decker.setLname("Decker");
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(decker);
		
		tx.commit();
		
	}
	
}