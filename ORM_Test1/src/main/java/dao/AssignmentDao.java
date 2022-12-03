package dao;

import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Assignment;
import services.AssignmentService;
import utils.HibernateUtil;

public class AssignmentDao extends UnicastRemoteObject implements AssignmentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public AssignmentDao() throws Exception {
		factory = HibernateUtil.getInstance().getsSessionFactory();
	}

	@Override
	public boolean addAssignMent(Assignment assignment) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			session.merge(assignment);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
