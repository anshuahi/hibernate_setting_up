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
		
		Users user = new Users("username", "email", "firstname", "lastname");
		try {
			
			//create object of entity class type
			
			// start transaction
			session.beginTransaction();
			
			// perform operation
			session.save(user);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("added a row");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("user: " + user.getUsername());
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
