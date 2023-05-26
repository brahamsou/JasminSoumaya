package fr.jasmin.test;


import fr.jasmin.entity.User;
import fr.jasmin.model.dao.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class MainDeleteClient {

	public static void main(String[] args) {

		IUserDao clientDao = new UserDao();

		try {
			
			// Récupérer le client avec l'ID 2
			User client = clientDao.getClient(2);
			
			// Afficher les informations du client
			System.out.println(client);
			System.out.println("---------------------------------------------------------------------------------");
			
			// Afficher l'ID du client
			System.out.println(client.getId());
			
			// Supprimer le client avec l'ID 2
			clientDao.removeClient(2);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
