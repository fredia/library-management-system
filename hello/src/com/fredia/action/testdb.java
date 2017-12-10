package com.fredia.action;
import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class testdb extends ActionSupport{
	    public void excute(){
	        try {
	          Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	          System.out.println("Success loading Mysql Driver!");
	        }
	        catch (Exception e) {
	          System.out.print("Error loading Mysql Driver!");
	          e.printStackTrace();
	        }
	        try {
	          Connection connect = DriverManager.getConnection(
	              "jdbc:mysql://localhost:3306/bookadmin","root","206167");
	          System.out.println("Success connect Mysql server!");

	          //select code
	          Statement stmt = connect.createStatement();
	          ResultSet rs = stmt.executeQuery("select * from books");
	           while (rs.next()) {
	            System.out.println(rs.getString("bookid"));

	          }
	        }
	        catch (Exception e) {
	          System.out.print("get data error!");
	          e.printStackTrace();
	        }
	      }
}
