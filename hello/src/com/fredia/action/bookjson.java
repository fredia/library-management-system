package com.fredia.action;

import java.util.ArrayList;
import java.util.List;
import com.fredia.entity.*;


import com.opensymphony.xwork2.ActionSupport;


public class bookjson extends ActionSupport{
	private static final long serialVersionUID = 7443363719737618408L;
	private int total=2;
	private List<Book> rows=new ArrayList<Book>();
	public String execute()
	{ 
		querymain qm = new querymain();
		rows = qm.booklist;
		return SUCCESS;
	}
	public int getTotal()
	{
		return total;
	}
	public List<Book> getRows()
	{
		return rows;
	}

}
