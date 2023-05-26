package fr.jasmin.test;


import fr.jasmin.entity.User;
import fr.jasmin.model.dao.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class MainUpdateClient {

	public static void main(String[] args) {


		// Création d'une instance UserDao qui implémente l'interface IUserDao
        IUserDao clientDao = new UserDao();

        try {
            // Récupération de l'utilisateur ayant l'ID 2
            User clientUpdate = clientDao.getClient(2);

            // Mise à jour du nom et du prénom de l'utilisateur
            clientUpdate.setLastName(clientUpdate.getLastName() + "-MAJ");
            clientUpdate.setFirstName(clientUpdate.getFirstName() + "-MAJ");

            // Appel de la méthode pour mettre à jour l'utilisateur dans la base de données
            clientDao.updateClient(clientUpdate);

            // Affichage de l'utilisateur mis à jour
            System.out.println(clientUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}