package com.hibernate.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertData {

	public static void main(String[] args) {

		String time = addTime();
		LocalDate today = addDate();
		
		try(
			SessionFactory factory = new Configuration().
											configure("hibernate.cfg.xml").
											addAnnotatedClass(Person.class).
											buildSessionFactory();	 	
			) {
			
			Session session = factory.getCurrentSession();
			
			Person test = new Person("Acelya","Dilek","dilek_kelebek@hotmail.com",today.toString(),time);

			
			System.out.println("Getting informations..");
			session.beginTransaction();
			
			System.out.println("Saving to database");
			session.save(test);

			System.out.println("Done!!");
			session.getTransaction().commit();
			System.out.println("Saved object with ID : " + test.getID());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Person person1 = session.get(Person.class, test.getID());
			System.out.println(person1);
			session.getTransaction().commit();
		}
		
	}
	private static LocalDate addDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		LocalDate today = LocalDate.parse(text,formatter);
		return today;
	}

	private static String addTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		return time;
	}

}
