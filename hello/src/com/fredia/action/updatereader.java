package com.fredia.action;

import java.sql.Date;
import java.sql.SQLException;

import com.fredia.entity.Reader;
import com.fredia.entity.User;
import com.fredia.entity.Manage;

import com.opensymphony.xwork2.ActionSupport;

public class updatereader extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String readerid;
	public String name;
	public Date birth;
	public int sex;
	public String phone;
	public String email;
	public int cardid;
	public Date day;
	public int level;
	
	private Reader read=new Reader();
	User u= login.getUser();
	private Manage ma=u.manage;
	public void excute() throws SQLException
	{
		read.id=readerid;
		read.name=name;
		read.birth=birth;
		System.out.print(birth);
		read.cardid=cardid;
		read.day=day;
		read.email=email;
		read.level=level;
		read.phone=phone;
		read.sex=sex;
		if(read.birth==null)
		{
			read.birth=new Date(2000, 1, 1);
		}
		if(read.day==null)
		{
			read.day=new Date(2000, 1, 1);
		}
		ma.updatereader(read);
		System.out.println("修改读者成功");
	}
	public void setRead(Reader rea)
	{
		read=rea;
	}
	public Reader getRead()
	{
		return read;
	}
	
	public void setReaderid(String s)
	{
		readerid=s;
	}
	
	public void setName(String s)
	{
		name=s;
		
	}

	public void setBirth(Date d)
	{
		birth=d;
	}
	
	public void setSex(int x)
	{
		sex=x;
	}

	public void setPhone(String s)
	{
		phone=s;
	}
	
	public void setEmail(String s)
	{
		email=s;
	}
	
	public void setCardid(int x)
	{
		cardid=x;
	}
	
	public void setDay(Date d)
	{
		day=d;
	}
	public void setLevel(int x)
	{
		level=x;
	}
}
