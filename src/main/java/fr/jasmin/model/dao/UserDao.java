package fr.jasmin.model.dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.jasmin.entity.User;
import fr.jasmin.enums.ProfilUserEnum;
import fr.jasmin.model.connector.HibernateConnector;
import fr.jasmin.model.dao.interfaces.IUserDao;
public class UserDao implements IUserDao {

	@Override
	public void addClient(User user) throws Exception {
		Session session = HibernateConnector.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();

        } catch (RollbackException e) {
            tx.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	@Override
	public User getClient(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
        try {
            Query<User> query = session.createQuery("select u from User u WHERE u.profil = :profil and u.id = :id", User.class);
            query.setParameter("profil", ProfilUserEnum.CLIENT.getValue());
            query.setParameter("id", id);
            return query.uniqueResult();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	@Override
	public void updateClient(User user) throws Exception {
		 Session session = HibernateConnector.getSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            session.update(user);
	            tx.commit();
	        } catch (Exception ex) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            throw ex;
	        } finally {
	            if (session != null && session.isOpen()) {
	                session.close();
	            
	            }}
	}

	@Override
	public void removeClient(Integer id) throws Exception {
		User client = getClient(id);
        if (client != null) {
            removeClient(client);
        }
		
	}

	@Override
	public List<User> getClients() {
		 Session session = HibernateConnector.getSession();
	        try {
	            Query<User> query = session.createQuery("select u from User u WHERE u.profil = :profil", User.class);
	            query.setParameter("profil", ProfilUserEnum.CLIENT.getValue());
	            return query.getResultList();
	        } finally {
	            if (session != null && session.isOpen()) {
	                session.close();
	            }
	        }
	}

	@Override
	public void removeClient(User user) throws Exception {
		Session session = HibernateConnector.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
	
}
