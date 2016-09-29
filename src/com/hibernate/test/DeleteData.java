package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {

		try(
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Person.class)
										.buildSessionFactory();
		   ) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			int PersonId = 5;
			
			System.out.println("Now getting Person who have ID number "+PersonId);
			Person person = session.get(Person.class, PersonId);
			
			System.out.println("Deleting Person : " + person.getID());
			//session.delete(person);
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			//Another way to delete from tables...
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			int personId2 = 6;
			session.createQuery("delete from Person where id="+personId2)
			.executeUpdate();
			
			session.getTransaction().commit();
		}
	}

}
