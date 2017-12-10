package com.fredia.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fredia.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class updatepass extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String oldpass;
	public String newpass1;
	public String newpass2;
	public String ret;
	User u= login.getUser();
	public String excute() throws SQLException{
		if(!oldpass.equals(u.getPass()))
		{
			System.out.println("旧密码错误");
			setRet("旧密码错误");
		}
		else {
			u.pass=newpass1;
			sqlconnect.Connet();
			Connection con = sqlconnect.getCon();
			String ssql = "update user set password=? where userid=?";
			PreparedStatement pst = con.prepareStatement(ssql); 
			pst.setString(1, u.pass);
			pst.setString(2, u.name);
			pst.executeUpdate();
			pst.close();
			ret="修改密码成功";
			System.out.println("修改密码成功");
		}
		return SUCCESS;
	}
	public void setOldpass(String s)
	{
		oldpass=s;
	}
	public void setNewpass1(String s)
	{
		newpass1=s;
	}
	public void setNewpass2(String s)
	{
		newpass2=s;
	}
	public void setRet(String s)
	{
		ret=s;
	}
	public String getRet()
	{
		return ret;
	}

}
