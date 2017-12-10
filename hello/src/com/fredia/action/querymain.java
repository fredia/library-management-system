package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;
import java.sql.*;
import com.fredia.action.sqlconnect;
import com.fredia.entity.Book;


public class querymain extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static List<Book> booklist;
	private String mh;
	private int type;
	private Book book;
	private String input;
	public  List<String> lis;
	public String excute() throws Exception
	{	
		booklist = new ArrayList<Book>();
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String sql="select * from books where ";
		type=getType();
		mh=getMh();
		System.out.println(mh);
	   if("ok".equals(mh))
		{
			if(type==0)
			{
				sql =sql+"bookname like '%"+getInput()+"%';";
			}
			else if(type==1)
			{
				sql=sql+"author like '%"+getInput()+"%';";
			}
			else if(type==2)
			{
				sql=sql+"publishing like '%"+getInput()+"%';";
			}
			System.out.println(sql);
		}
	   else {
			if(type==0)
			{
				sql =sql+"bookname='"+getInput()+"';";
			}
			else if(type==1)
			{
				sql=sql+"author='"+getInput()+"';";
			}
			else if(type==2)
			{
				sql=sql+"publishing='"+getInput()+"';";
			}
			System.out.println(sql);
			}
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			book = new Book();
			book.bookid = rs.getString("bookid");
			
			book.name=rs.getString("bookname");
			//String na = book.name;
			//book.name="<a data-toggle=\"modal\" data-target=\"#myModal\" class=\"lj\">"+na+"</a>";
			
			book.author=rs.getString("author");
			book.publish=rs.getString("publishing");
			book.category =rs.getInt("categoryid");
			book.price=rs.getFloat("price");
			book.numin=rs.getInt("quantity_in");
			book.numloss=rs.getInt("quantity_loss");
			book.numout=rs.getInt("quantity_out");
			book.datein=rs.getDate("datein");
			System.out.println("ok");
			booklist.add(book);
			
		}
		
		return "results";
		
		
	}
	public void setType(int s)
	{
	   type=s;
	}
	public int getType()
	{
		return type;
	}
	public void setInput(String s)
	{
		input=s;
	}
	public String getInput()
	{
		return input;
	}
	public void setMh(String x)
	{
		mh=x;
	}
	public String getMh()
	{
		return mh;
	}

	public List<String> getLis()
	{
		return lis;
	}
	public void setLis(List<String> li)
	{
		lis=li;
	}
	public List<Book> getBooklist()
	{
		return booklist;
	}
	public void setBooklist(List<Book> li)
	{
		booklist=li;
	}
	public String display()
	{
		return "query";
	}
	


}
