package org.anshuahi;

import org.anshuahi.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Users.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Users user = new Users();
			
			//create object of entity class type
			
			// start transaction
			session.beginTransaction();
			
			// perform operation
			user = session.get(Users.class, 4);
//			user.setFirstname("john");
//			user.setLastname("snow");
//			session.save(user);
			session.delete(user);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("get a row " + user.toString());
			
//			System.out.println("user: " + user.getUsername());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// TODO: handle exception
			factory.close();
			session.close();
		}
		
//		factory.close();
//		session.close();

	}

}
