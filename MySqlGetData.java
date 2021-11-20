package com.rays.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlGetData {
	
	public static void main(String[] args) throws Exception {
		getSelectmeth();
		//getInsertMeth();
		//getupdateMath();
		//getDeleteMeth();
		
	}

	

	public static void getDeleteMeth() throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("DELETE FROM MARKSHEET WHERE ID = 9");
		
		System.out.println(rs + "Deleted");
		
	}

	public static void getupdateMath() throws Exception {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("UPDATE MARKSHEET SET LASTNAME = 'JOSHI' WHERE ID = 12");
		
		System.out.println(rs + "UPDATED");
	}

	public static void getInsertMeth() throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("INSERT INTO MARKSHEET VALUES(16,1013,'Chaheti','DIWEDI',66,77,78)");
		
		System.out.println(rs + "Inserted");
		conn.commit();
		conn.close();
		stmt.close();
		
	}

	public static void getSelectmeth() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM MARKSHEET");
				
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t	"+rs.getString(2));
			System.out.print("\t	"+rs.getString(3));
			System.out.print("\t	"+rs.getString(4));
			System.out.print("\t	"+rs.getString(5));
			System.out.print("\t	"+rs.getString(6));
			System.out.println("\t	"+rs.getString(7));
		
		}
		
		stmt.close();
		rs.close();
	}
	
	
	

}
