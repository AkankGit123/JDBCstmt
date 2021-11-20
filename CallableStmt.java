package com.rays.JDBCConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class CallableStmt {
	
	public static void main(String[] args) throws Exception {
		storedproc();
		//storedFunc();
	}
	
	public static void storedFunc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
		CallableStatement call = conn.prepareCall("{CALL mkCount(?)}");
		call.registerOutParameter(1, Types.INTEGER);
		call.execute();
		System.out.println(call.getInt(1));
		
	}

	public static void storedproc() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	CallableStatement call = conn.prepareCall("{CALL MARKcount(?)}");
	call.registerOutParameter(1, Types.INTEGER);
	call.execute();
	int count = call.getInt(1);
	System.out.println(count);
	}

}