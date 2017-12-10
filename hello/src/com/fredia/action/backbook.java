package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.sql.SQLException;

import com.fredia.entity.*;

public class backbook extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Record backrec=new Record();
	User u= login.getUser();
	private Manage ma=u.manage;
	public String bookid;
	public String readerid;
	public Date day;
	public int loss;
	public String ret;
	public String excute() throws SQLException
	{
		backrec.bookid=bookid;
		backrec.readerid=readerid;
		backrec.datereturn=day;
		backrec.loss=loss;
		if(loss==0)
		{
			backrec.isback=1;
		}
		ret=ma.backbook(backrec);
		System.out.println("还书成功");
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
	public void setLoss(int x)
	{
		loss=x;
	}
	public String getRet()
	{
		return ret;
	}
	public void setBackrec(Record re)
	{
		backrec=re;
	}
	public Record getBackrec()
	{
		return backrec;
	}

}
