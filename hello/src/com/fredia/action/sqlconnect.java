package com.fredia.action;
import java.sql.*;
public class sqlconnect {

	 private static Connection con=null;
	 public static void Connet(){
	        try {
	          Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	          System.out.println("Success loading Mysql Driver!");
	        }
	        catch (Exception e) {
	          System.out.print("Error loading Mysql Driver!");
	          e.printStackTrace();
	        }
	        try {
	          con = DriverManager.getConnection(
	              "jdbc:mysql://localhost:3306/bookadmin?useUnicode=true&characterEncoding=UTF-8","root","206167");
	          System.out.println("Success connect Mysql server!");

	         
	        }
	        catch (Exception e) {
	          e.printStackTrace();
	        }
	 }
	 public static Connection getCon()
	 {
		 return con;
	 }
}
