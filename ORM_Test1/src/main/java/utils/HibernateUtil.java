package utils;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Assignment;
import entity.AssignmentPK;
import entity.Employee;
import entity.Project;

public class HibernateUtil {
	private static HibernateUtil instance;

	private SessionFactory sessionFactory;

	private HibernateUtil() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Project.class)
				.addAnnotatedClass(Employee.class).addAnnotatedClass(AssignmentPK.class)
				.addAnnotatedClass(Assignment.class).getMetadataBuilder().build();
		
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	
	
	public synchronized static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	
	public SessionFactory getsSessionFactory() {
		return sessionFactory;
	}
}
