package com.rays.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataStmt {
	
	public static void main(String[] args) throws Exception {
		
		getMatadata();
	}

	public static void getMatadata() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root","root");
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM MARKSHEET");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("DataBaseName:" +rsmd.getCatalogName(1));
		System.out.println("TableName:" +rsmd.getTableName(1));
		int colCount = rsmd.getColumnCount();
		System.out.println("Column count:"+colCount);
		
		
		
	}

}
