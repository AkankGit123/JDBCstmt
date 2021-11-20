package com.rays.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementQueryInVariable {
	
	public static void main(String[] args) throws Exception {
		
		//getInsertVar();
		getUpdateMet();
		
	}
	
	
	public static void getUpdateMet() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		Statement stmt = conn.createStatement();
		
		int ROLLNO = 1114;
		String FIRSTNAME = "jugal";
		String LASTNAME = "Rathor";
		int PHYSICS = 2;
		int CHEMISTRY = 2;
		int MATHS = 100;
		int ID = 14;
		String sql = "UPDATE MARKSHEET SET ("+ROLLNO+", '"+FIRSTNAME+"', LASTNAME=?, PHYSICS=?, CHEMISTRY=?, MATHS=? WHERE ID = ?";
		int i = stmt.executeUpdate(sql);
		
		System.out.println(i+ "updated");
	}


	public static void getInsertVar() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		Statement stmt = conn.createStatement();
		int ID = 14;
		int ROLLNO = 1014;
		String FIRSTNAME = "Man";
		String LASTNAME = "Rathor";
		int PHYSICS = 99;
		int CHEMISTRY = 98;
		int MATHS = 100;
		
		String sql = "INSERT INTO MARKSHEET VALUES("+ID+", "+ROLLNO+",'"+FIRSTNAME+"','"+LASTNAME+"',"+PHYSICS+","+CHEMISTRY+","+MATHS+")";
		int i = stmt.executeUpdate(sql);
		
		System.out.println("inserted");
	}

}
