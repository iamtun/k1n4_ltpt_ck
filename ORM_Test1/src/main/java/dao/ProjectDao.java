package dao;

import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Project;
import services.ProjectService;
import utils.HibernateUtil;

public class ProjectDao extends UnicastRemoteObject implements ProjectService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SessionFactory factory;

	public ProjectDao() throws Exception {
		factory = HibernateUtil.getInstance().getsSessionFactory();
	}

	@Override
	public boolean addProject(Project project) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.persist(project);
			transaction.commit();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Project finProjectById(String id) throws Exception {
		Session session = factory.openSession();
		Project project = session.find(Project.class, id);
		return project;
	}

	@Override
	public Project findProjectByName(String name) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			Project project = session.createNativeQuery("select * from projects where project_name =:name", Project.class)
					.setParameter("name", name).getSingleResult();
			transaction.commit();

			return project;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean upateProject(Project project) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(project);
			transaction.commit();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProject(String id) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Project project = session.find(Project.class, id);
			session.remove(project);
			transaction.commit();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
