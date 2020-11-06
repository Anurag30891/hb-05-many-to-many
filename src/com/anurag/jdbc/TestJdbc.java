package com.anurag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String username = "hbstudent";
		String password = "hbstudent";
		
		try {
			
			Connection myConn = DriverManager.getConnection(jdbcurl, username, password);
			System.out.println("Connection Successfull!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
