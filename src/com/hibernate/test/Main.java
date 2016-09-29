package com.hibernate.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().
						configure("hibernate.cfg.xml").
						addAnnotatedClass(Person.class).
						buildSessionFactory();	
		
		Session session = factory.getCurrentSession();	
		
		LocalDate today = addDate();
		
		String time = addTime();
		
		try {
			
			System.out.println("Creating new object...");
			Person person = new Person("Sedef","Dogan","sedef_dogan@aol.com",today.toString(),time);
			
			session.beginTransaction();
			
			System.out.println("Saving the Person");
			session.save(person);
			
			session.getTransaction().commit();
			System.out.println("Done!!");
		}finally {
			factory.close();
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
