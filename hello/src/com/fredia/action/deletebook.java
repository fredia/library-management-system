package com.fredia.action;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

import com.fredia.entity.*;

public class deletebook extends ActionSupport{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String bookid;
    private Book book=new Book();
	
	User u= login.getUser();
	private Manage ma=u.manage;
	public void excute() throws SQLException
	{
		book.bookid=bookid;
		ma.deletebook(book);
		System.out.println("删除图书成功");
	}
    public void setBookid(String s)
    {
    	bookid=s;
    }
    public String getBookid()
    {
    	return bookid;
    }
}
