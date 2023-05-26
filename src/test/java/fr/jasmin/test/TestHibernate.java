package fr.jasmin.test;

import org.hibernate.Session;

import fr.jasmin.model.connector.HibernateConnector;



public class TestHibernate {

	public static void main(String[] args) {

		try {
			Session session = HibernateConnector.getSession();
			System.out.println(session);
			if (session != null && session.isOpen()) {
				session.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
