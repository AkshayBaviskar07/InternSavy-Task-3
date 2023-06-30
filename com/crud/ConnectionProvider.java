package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection con;
	
	public static Connection getConnection(){
		try{
			
			if(con == null){
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients", "root", "akshay");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return con;
	}
}
