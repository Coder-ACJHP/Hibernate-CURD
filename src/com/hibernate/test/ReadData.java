package com.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadData {


	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {


		try(
			SessionFactory factory = new Configuration().
										configure("hibernate.cfg.xml").
										addAnnotatedClass(Person.class).
										buildSessionFactory();	
					
			) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Person> person = session.createQuery("from Person").list();
			displayPersons(person);
			
			person = session.createQuery("from Person s where s.LASTNAME='Kucuk'").list();
			System.out.println("\n\nPerson who have lastname Kucuk");
			displayPersons(person);
			
			person = session.createQuery("from Person s where s.LASTNAME='Nasry' OR s.FIRSTNAME='Asala'").list();
			System.out.println("\n\nPerson who have lastname Nasry or firstname Asala");
			displayPersons(person);
			
			person = session.createQuery("from Person s where s.EMAIL LIKE '%hotmail.com'").list();
			System.out.println("\n\n Person who have email from hotmail domain");
			displayPersons(person);
			
			session.getTransaction().commit();
		}
	}

	private static void displayPersons(List<Person> person) {
		for (Person person2 : person) {
			System.out.print(person2 +"\n");
		}
	}

}
