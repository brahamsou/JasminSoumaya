package fr.jasmin.test;




import fr.jasmin.entity.User;

import fr.jasmin.model.dao.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;


public class MainGetClient {

	public static void main(String[] args) {

		IUserDao clientDao = new UserDao();
		
		  try {
	            User client1 = clientDao.getClient(1);
	            System.out.println(client1);
	            client1.getAddresses().forEach(a -> System.out.println("  -> " + a));

	            System.out.println("==========================================");

	            User client2 = clientDao.getClient(2);
	            System.out.println(client2);
	            client2.getAddresses().forEach(a -> System.out.println("  -> " + a));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	



