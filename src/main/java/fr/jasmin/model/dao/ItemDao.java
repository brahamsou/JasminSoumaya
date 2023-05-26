package fr.jasmin.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.jasmin.entity.Item;
import fr.jasmin.model.connector.HibernateConnector;
import fr.jasmin.model.dao.interfaces.IItemDao;

public class ItemDao implements IItemDao {

	@Override
	public void addItem(Item item) {
		// Ajoute un nouvel item à la base de données

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(item); // Utilise la méthode save pour ajouter l'item à la base de données
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback(); // En cas d'erreur, effectue un rollback pour annuler la transaction
			}
			e.printStackTrace();
		} finally {
			session.close(); // Ferme la session Hibernate
		}
	}

	@Override
	public Item getItemById(int id) {
		  Session session = HibernateConnector.getSession();
		    try {
		        Query<Item> query = session.createQuery("select i from Item i where i.id = :id", Item.class);
		        query.setParameter("id", id);
		        return query.uniqueResult();
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();
		        }
		    }
	}

	@Override
	public void updateItem(Item item) {
		Session session = HibernateConnector.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(item); // Utilise la méthode update pour mettre à jour l'item dans la base de données
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
	public void deleteItem(Item item) {
		 Session session = HibernateConnector.getSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            session.delete(item); // Utilise la méthode delete pour supprimer l'item de la base de données
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
	public List<Item> getAllItems() {
		
	    Session session = HibernateConnector.getSession();
	    try {
	        Query<Item> query = session.createQuery("select i from Item i", Item.class); // Utilise une requête HQL pour récupérer tous les items
	        return query.getResultList();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}
		
		
		
		
		/*
		 * Session session = HibernateConnector.getSession(); List<Item> items = null;
		 * try { Query<Item> query = session.createQuery("from Item", Item.class); //Utilise une requête HQL pour récupérer tous les items
		 *  items = query.list(); }
		 * catch (Exception e) { e.printStackTrace(); } finally { session.close(); }
		 * return items;
		 */
    }


