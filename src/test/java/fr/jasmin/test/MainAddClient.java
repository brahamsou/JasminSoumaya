package fr.jasmin.test;


import fr.jasmin.entity.Address;
import fr.jasmin.entity.User;
import fr.jasmin.enums.ProfilUserEnum;
import fr.jasmin.model.dao.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;
import fr.jasmin.utils.Dates;

public class MainAddClient {

	public static void main(String[] args) {
		System.out.println("------------------------------------------debut de test--------------------------------------");
		  IUserDao userDao = new UserDao();

		    try {
		        Address address1 = new Address("12", "Rue Paul Vaillant Couturier", "Paris", "75000");
		        Address address2 = new Address("3", "Avenue Victor Hugo", "Lyon", "69000");

		        User user1 = new User("Emile", "Mohamed");
		        user1.setBirthDate(Dates.convertStringToDate("09/07/1991"));
		        user1.setEmail("emile@gmail.com");
		        user1.setPassword("test12345");
		        user1.setProfil(ProfilUserEnum.CLIENT.getValue());
		        user1.setIsActive(true);
		        user1.setTelephone("0612345678");

		        User user2 = new User("Kaoutar", "Soumaya");
		        user2.setBirthDate(Dates.convertStringToDate("23/08/2007"));
		        user2.setEmail("kaoutar@gmail.com");
		        user2.setPassword("test245678");
		        user2.setProfil(ProfilUserEnum.CLIENT.getValue());
		        user2.setIsActive(true);
		        user2.setTelephone("0033562224123");

		        address1.setUser(user1);
		        address2.setUser(user2);
		        user1.getAddresses().add(address1);
		        user2.getAddresses().add(address2);

		        userDao.addClient(user1);
		        System.out.println(user1);
		        user1.getAddresses().forEach(a -> System.out.println("  -> " + a));

		        userDao.addClient(user2);
		        System.out.println(user2);
		        user2.getAddresses().forEach(a -> System.out.println("  -> " + a));

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
	System.out.println("------------------------------------------fin de test--------------------------------------");
	}
}
