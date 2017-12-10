package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import com.fredia.action.sqlconnect;
import com.fredia.entity.*;

public class login extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name="1234";
	private String pass="1234";
	private int ism=0;
	private static User user=new User();
	public String excute() throws Exception
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
	
		Statement stmt = con.createStatement();
		String sql ="select * from user where userid="+name+";";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("login test"+ism);
		if(rs.next())
		{
			
			
			String tmp=rs.getString("userid");
			String tmp1=rs.getString("password");
			if(tmp.equals(name)&&tmp1.equals(pass)&&ism==rs.getInt("isadmin"))
			{
				user.isma=ism;
				user.name=name;
				user.pass=pass;
				if(ism==0) {
				user.reader = new Reader();
				user.reader.id=name;}
				else if(ism==1)
				{
					user.manage = new Manage();
				}
				stmt.close();
				con.close();
				if(ism==0)
				   return "query";
				else if(ism==1)
					return "manage";
					
			}
			else
			{
				stmt.close();
				con.close();
				return "error";
			}
		}
		stmt.close();
		con.close();
		return "error";
	}
	public String display()
	{
		return "login";
	}
	public void setName(String s)
	{
		name=s;
	}
	public String getName()
	{
		return name;
	}
	public void setPass(String s)
	{
		pass=s;
	}
	public String getPass()
	{
		return pass;
	}
	public void setIsm(int s)
	{
		ism=s;
	}
	public int getIsm()
	{
		return ism;
	}
	public void setUser(User u)
	{
		user = u;
	}
	public static User getUser()
	{
		return user;
	}
	

}
