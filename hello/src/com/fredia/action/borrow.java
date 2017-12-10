package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.sql.Date;

import com.fredia.entity.*;

public class borrow extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Record rec=new Record();
	public String bookid;
	public String readerid;
	public Date day;
	public String ret;
	User u= login.getUser();
	private Manage ma=u.manage;
	public String excute() throws SQLException
	{
		rec.bookid=bookid;
		rec.readerid=readerid;
		rec.dateborrow=day;
		ret=ma.borrowbook(rec);
		System.out.println("借出成功");
		return SUCCESS;
	}
	public void setReaderid(String s)
	{
		readerid=s;
	}
	public void setBookid(String s)
	{
		bookid=s;
	}
	public void setDay(Date d)
	{
		day=d;
	}
	public String getRet()
	{
		return ret;
	}
	public void setRec(Record re)
	{
		rec=re;
	}
	public Record getRec()
	{
		return rec;
	}
    
}
