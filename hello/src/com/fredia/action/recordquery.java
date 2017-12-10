package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fredia.action.login;
import com.fredia.entity.*;

public class recordquery extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Record> reclist=new ArrayList<Record>();
	User u= login.getUser();
	private Reader recreader=u.reader;
	public String excute() throws SQLException
	{
		System.out.println("ab"+recreader.id);
		recreader.getrecord(reclist);
		return "res";
	}
	public void setRecreader(Reader re)
	{
		recreader=re;
	}
	public Reader getRecreader()
	{
		return recreader;
	}
	public void setReclist(List<Record> li)
	{
		reclist=li;
	}
	public List<Record> getReclist()
	{
		return reclist;
	}

}
