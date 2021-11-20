package com.rays.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement {
	public static void main(String[] args) throws Exception {
			getInsertPrep();
			//getUpdatePrep();
		//getDeleteMeth();
	//getSelectMet();
		//selectParticularRow();
		
	}

	public static void selectParticularRow() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root","root");
		int ID = 5;
		PreparedStatement ps = conn.prepareStatement("SELECT FIRSTNAME FROM MARKSHEET WHERE ID = ?");
		ps.setInt(1, ID);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		ps.close();
		conn.close();
	}

	public static void getSelectMet() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root","root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("	\t" +rs.getInt(2));
			System.out.print("	\t" +rs.getString(3));
			System.out.print("	\t" +rs.getString(4));
			System.out.print("	\t" +rs.getInt(5));
			System.out.print("	\t" +rs.getInt(6));
			System.out.println(" \t" +rs.getInt(7));
		}
		
		rs.close();
		conn.close();
	}

	public static void getDeleteMeth() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		int ID = 4;
		PreparedStatement ps = conn.prepareStatement("DELETE FROM MARKSHEET WHERE ID = ?");
		ps.setInt(1, ID);
		int rs=ps.executeUpdate();
		System.out.println(rs + "Deleted");
		ps.close();
		conn.close();
	}

	public static void getUpdatePrep() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		int ID = 1;
		int ROLLNO = 1111;
		String FIRSTNAME = "harsh";
		String LASTNAME = "MANDLOI";
		int PHYSICS = 34;
		int CHEMISTRY = 23;
		int MATHS = 33;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE MARKSHEET SET ROLLNO = ?, FIRSTNAME = ?, LASTNAME=?, PHYSICS=?, CHEMISTRY=?, MATHS=? WHERE ID = ?");
	
		ps.setInt(1, ROLLNO);
		ps.setString(2, FIRSTNAME);
		ps.setString(3, LASTNAME);
		ps.setInt(4,PHYSICS );
		ps.setInt(5, CHEMISTRY);
		ps.setInt(6, MATHS);
		ps.setInt(7, ID);
		
		int i = ps.executeUpdate();
		System.out.println(i+ "Updated");
	}

	public static void getInsertPrep() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/sunraystech","root","root");
		int ID = 15;
		int ROLLNO = 1015;
		String FIRSTNAME = "Jagadish";
		String LASTNAME = "Mandloi";
		int PHYSICS = 3;
		int CHEMISTRY = 2;
		int MATHS = 3;
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");
		
		ps.setInt(1, ID);
		ps.setInt(2, ROLLNO);
		ps.setString(3, FIRSTNAME);
		ps.setString(4, LASTNAME);
		ps.setInt(5, PHYSICS);
		ps.setInt(6, CHEMISTRY);
		ps.setInt(7, MATHS);
		
		int i = ps.executeUpdate();
		
		System.out.println(i+ "Inserted");
	}

}
