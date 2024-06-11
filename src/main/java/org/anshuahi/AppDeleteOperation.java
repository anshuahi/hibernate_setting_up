package org.anshuahi;

import org.anshuahi.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppDeleteOperation {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// getting all users
			session.beginTransaction();
			Users user = new Users();
			user = session.get(Users.class, 3);
			
			session.delete(user);
//			List<Users> users = session.createQuery("from users ").getResultList();

//			for(Users user: users) {
//				System.out.println(user.toString());
//			}
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// TODO: handle exception
			session.close();
			factory.close();
		}

	}

}
