package com.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {
	
	public static boolean insertEmployee(Employee emp)
	{
		boolean ans = false;
		try{
			//jdbc code...
			Connection con = ConnectionProvider.getConnection();
			
			String q = "INSERT INTO users(eName, eEmail, salary) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setInt(3, emp.getSalary());
			
			//execute 
			pstmt.executeUpdate();
			ans = true;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return ans;
	}

	public static boolean deleteEmployee(int id) {
		boolean ans = false;
		try{
			//jdbc code...
			Connection con = ConnectionProvider.getConnection();
			
			String q = "DELETE FROM users where eId = ?";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			
			
			//execute 
			pstmt.executeUpdate();
			ans = true;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return ans;
	}

	public static void showEmployee() {
		
		try{
			//jdbc code...
			Connection con = ConnectionProvider.getConnection();
			
			String q = "SELECT * FROM users;";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			while(set.next()){
				int id = set.getInt("eId");
				String name = set.getString("eName");
				String email = set.getString("eEmail");
				int salary = set.getInt("salary");
				
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Email: "+email);
				System.out.println("Salary: "+salary);
				System.out.println("+++++++++++++++++++++++++");
				
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static boolean updateEmployee(int id) throws IOException {
		boolean ans = false;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//jdbc code...
			Connection con = ConnectionProvider.getConnection();
			
			//querry
			String q = "UPDATE users set eName=?, eEmail=?, salary=? WHERE eId=?";
			
			System.out.println("Enter new name: ");
			String name = br.readLine();
			
			System.out.println("Enter new email: ");
			String email = br.readLine();
			
			System.out.println("Enter new salary: ");
			int salary = Integer.parseInt(br.readLine());
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, salary);
			
			pstmt.setInt(4, id);
			
			//execute 
			pstmt.executeUpdate();
			ans = true;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return ans;
	}
}
