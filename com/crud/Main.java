package com.crud;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, IOException{	
       
    	Connection con = ConnectionProvider.getConnection();
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int ch;
    	
    	try{
    		do{
    			System.out.println("1 : Insert Records");
    			System.out.println("2 : Delete Record");
    			System.out.println("3 : Display Record");
    			System.out.println("4 : Update Record");
    			System.out.println("0 : EXIT");
    			
    			ch = Integer.parseInt(br.readLine());
    			
    			switch(ch){
    				case 0:
    					System.out.println("------------------------");
    					System.out.println("--- Thank you ---");
    					System.out.println("------------------------");
    					break;
    					
    				case 1:
    					System.out.println("------------------------");
    					System.out.println("--- Insert Records ---");
    					System.out.println("------------------------");
    					
    					System.out.println("Enter Name:");
    					String name = br.readLine();
    					
    					System.out.println("Enter Email:");
    					String email = br.readLine();
    					
    					System.out.println("Enter Salary:");
    					int salary = Integer.parseInt(br.readLine());
    					
    					//create employee object to store details
    					Employee eObj = new Employee(name, email, salary);
    					boolean ans = EmployeeDao.insertEmployee(eObj);
    					
    					if(ans){
    						System.out.println(" Records added successfully.");
    					} else{
    						System.out.println("Error...");
    					}
    					
    					System.out.println("------------------------");

    					break;
    					
    				case 2:
    					System.out.println("------------------------");
    					System.out.println("--- Delete Records ---");
    					System.out.println("------------------------");
    					
    					System.out.println("Enter Employee id: ");
    					int id = Integer.parseInt(br.readLine());
    					
    				    ans = EmployeeDao.deleteEmployee(id);
    					
    					if(ans){
    						System.out.println(" Records deleted successfully.");
    					} else{
    						System.out.println("Error...");
    					}
    					
    					System.out.println("------------------------");
    					break;
    					
    				case 3:
    					System.out.println("------------------------");
    					System.out.println("--- Display Records ---");
    					System.out.println("------------------------");
    					
    					EmployeeDao.showEmployee();
    					break;
    					
    				case 4:
    					System.out.println("------------------------");
    					System.out.println("--- Update Records ---");
    					System.out.println("------------------------");
    					
    					System.out.println("Enter Employee Id: ");
    				    id = Integer.parseInt(br.readLine());
    					
    					ans = EmployeeDao.updateEmployee(id);
    					
    					if(ans){
    						System.out.println("Records Updated Successfully");
    					} else{
    						System.out.println("Error....");
    					}
    					break;
    					
    				default:
    					System.out.println("------------------------");
    					System.out.println("--- Invalid Option ---");
    					System.out.println("------------------------");
    			}
    			
    		}while(ch != 0);
    		
    	} catch(Exception e){
    		e.printStackTrace();
    	} finally{
    		con.close();
    	}
   }
}
