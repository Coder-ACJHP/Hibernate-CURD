package com.coder.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test_jdbc {

	public static void main(String[] args) {

		String host = "jdbc:mysql://localhost/onurDB";
		String user = "onur";
		String pass = "onurdb958";
		
		System.out.println("Trying to connecting database"+host);
		
		try (Connection conn = DriverManager.getConnection(host,user,pass);){

			System.out.println("Connection Success!!");
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String time = sdf.format(cal.getTime());
			System.out.println(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
