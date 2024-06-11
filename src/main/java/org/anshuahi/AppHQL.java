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
		//04:19:15	update users set email='password123' where username='John'	
//		Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  
//		To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00038 sec
//		04:41:04	update users set email='john@anshu.com' where username='John'	
//				Error Code: 1046. No database selected Select the default DB to be used by double-clicking its name in the SCHEMAS list in the sidebar.	
//				0.00032 sec

		//factory.close();
		//session.close();

	}

}
