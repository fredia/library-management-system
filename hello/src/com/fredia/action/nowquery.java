package com.fredia.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fredia.entity.Reader;
import com.fredia.entity.Record;
import com.fredia.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class nowquery extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Record> nowlist=new ArrayList<Record>();
	User u= login.getUser();
	private Reader nowreader=u.reader;
	public String excute() throws SQLException
	{
	    nowreader.getnow(nowlist);
	    return "res";
	}
	public void setNowreader(Reader re)
	{
		nowreader=re;
	}
	public Reader getNowreader()
	{
		return nowreader;
	}
	public void setNowlist(List<Record> li)
	{
		nowlist=li;
	}
	public List<Record> getNowlist()
	{
		return nowlist;
	}

}
