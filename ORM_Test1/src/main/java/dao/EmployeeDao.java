package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import services.EmployeeService;
import utils.HibernateUtil;

public class EmployeeDao extends UnicastRemoteObject implements EmployeeService{
	SessionFactory factory;
	
	public EmployeeDao() throws Exception{
		factory = HibernateUtil.getInstance().getsSessionFactory();
	}
	
	@Override
	public boolean addEmployee(Employee employee) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.persist(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.merge(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		Session session = factory.openSession();
		return session.createNativeQuery("select * from employees", Employee.class).getResultList();
	}

	@Override
	public Employee findEmployeeById(String id) throws Exception {
		Session session = factory.openSession();
		return session.find(Employee.class, id);
	}
	
	

}
