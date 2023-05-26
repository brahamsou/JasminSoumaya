package fr.jasmin.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.jasmin.entity.Category;
import fr.jasmin.entity.Item;
import fr.jasmin.model.connector.HibernateConnector;
import fr.jasmin.model.dao.interfaces.ICategoryDao;

public class CategoryDao implements ICategoryDao {

	@Override
	public void addCategory(Category category) {
		 Session session = HibernateConnector.getSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            session.save(category);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}

	@Override
	public Category getCategoryById(int id) {
		 Session session = HibernateConnector.getSession();
		    try {
		        Query<Category> query = session.createQuery("select c from Category c where c.id = :id", Category.class);
		        query.setParameter("id", id);
		        return query.uniqueResult();
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();
		        }
		    }
	}

	@Override
	public void updateCategory(Category category) {
		Session session = HibernateConnector.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(category); // Utilise la méthode update pour mettre à jour l'item dans la base de données
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

		
	}

	@Override
	public void deleteCategory(Category category) {
		Session session = HibernateConnector.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public List<Category> getAllCategories() {
		 Session session = HibernateConnector.getSession();
		   
		    try {
		        Query<Category> query = session.createQuery("select c from Category c", Category.class); // Utilise une requête HQL pour récupérer tous les items
		        return query.getResultList();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		 
	
	
}
