package com.hibernate.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateData {


	public static void main(String[] args) {


		try(
			SessionFactory factory = new Configuration().
										configure("hibernate.cfg.xml").
										addAnnotatedClass(Person.class).
										buildSessionFactory();	
					
			) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			int PersonId = 2;
			Person person = session.get(Person.class,PersonId);
			person.setLASTNAME("Acjhp");
			
			System.out.println("Updating Object that Id number : "+ PersonId);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			System.out.println("Now Chancing all emails in Personal table to 'coder@acjhp.com'");
//			session.createQuery("update Person set EMAIL='coder@acjhp.com'")
//			.executeUpdate();
			
			String time = addTime();
			System.out.println("Now Chancing all Persons log time to " + time);	
			session.createQuery("update Person set TIME='"+time+"'")
			.executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
	
	}
	private static String addTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		return time;
	}

}
