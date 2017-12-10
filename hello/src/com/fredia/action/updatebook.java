package com.fredia.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.sql.SQLException;

import com.fredia.entity.*;

public class updatebook extends ActionSupport{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String bookid;
	public String name;
	public String author;
	public String publish;
	public String cat;
	public float price;
	public Date datein;
	public int numin;
	public int numout;
	public int numloss;
	private Book book=new Book();
	
	User u= login.getUser();
	private Manage ma=u.manage;
	public void excute() throws SQLException
	{
		book.bookid=bookid;
		book.name=name;
		book.author=author;
	    book.category=getCat(cat);
		book.price=price;
		book.numloss=numloss;
		book.numout=numout;
		book.numin=numin;
		book.datein=datein;
		if(book.datein==null)
		{
			book.datein=new Date(2000, 1, 1);
		}
		ma.updatebook(book);
		System.out.println("修改图书成功");
		
	}
	public int getCat(String s)
	{
		int t=0;
		if("计算机技术".equals(s))
		{
			t=1;
		}
		else if("自然科学".equals(s))
		{
			t=2;
		}
		else if("医学".equals(s))
		{
			t=3;
		}
		else if("农林".equals(s))
		{
			t=4;
		}
		else if("建筑".equals(s))
		{
			t=5;
		}
		else if("科普".equals(s))
		{
			t=6;
		}
		else if("通信".equals(s))
		{
			t=7;
		}
		else if("化学".equals(s))
		{
			t=8;
		}
		else if("物理".equals(s))
		{
			t=9;
		}
		else if("美文".equals(s))
		{
			t=10;
		}
		return t;
	}
	public void setBook(Book bo)
	{
		book=bo;
	}
	public Book getBook()
	{
		return book;
	}
	public void setCat(String s)
	{
		cat=s;
	}
	public void setBookid(String s)
	{
		bookid=s;
	}
	public void setName(String s)
	{
		name=s;
		
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String s)
	{
	     author=s;	
	}
	public String getPublish()
	{
		return publish;
	}
	public void setPublish(String s)
	{
		publish=s;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float p)
	{
		price=p;
	}
	public int getNumin()
	{
		return numin;
	}
	public void setNumin(int t)
	{
		numin=t;
	}
	public int getNumout()
	{
		return numout;
	}
	public void setNumout(int t)
	{
		numout=t;
	}
	public int getNumloss()
	{
		return numloss;
	}
	public void setNumloss(int t)
	{
		numloss=t;
	}
	public void setDatein(Date da)
	{
		datein=da;
	}
}