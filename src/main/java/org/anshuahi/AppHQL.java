package org.anshuahi;

import java.util.List;

import org.anshuahi.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppHQL {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// getting all users
			session.beginTransaction();
//			List<Users> users = session.createQuery("from users ").getResultList();

			int up = session.createQuery("update users set email='anshu1@anshu.com' " + 
						" where username = 'John'").executeUpdate();
			System.out.println("query update " + up);
			
//			for(Users user: users) {
//				System.out.println(user.toString());
//			}
//			session.
			
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

		//factory.close();
		//session.close();

	}

}
