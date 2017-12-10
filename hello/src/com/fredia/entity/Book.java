package com.fredia.entity;

import java.sql.Date;

public class Book {
	public String bookid;
	public String name;
	public String author;
	public String publish;
	public int category;
	public float price;
	public Date datein;
	public String dateii;
	public int numin;
	public int numout;
	public int numloss;
	//public String pic;
	public Book()
	{
		super();
	}
	public String getcat()
	{
		String s="";
		if(category==1)
		{
			s="计算机技术";
		}
		else if(category==2)
		{
			s="自然科学";
		}
		else if(category==3)
		{
			s="医学";
		}
		else if(category==4)
		{
			s="农林";
		}
		else if(category==5)
		{
			s="建筑";
		}
		else if(category==6)
		{
			s="科普";
		}
		else if(category==7)
		{
			s="通信";
		}
		else if(category==8)
		{
			s="化学";
		}
		else if(category==9)
		{
			s="物理";
		}
		else if(category==10)
		{
			s="美文";
		}
		return s;
	}
	public void setBookid(String s)
	{
		bookid=s;
	}
	public String getBookid()
	{
		return bookid;
	}
	public String getName()
	{
		return name;
		
	}
	public String getAuthor()
	{
		return author;
	}
	public String getPublish()
	{
		return publish;
	}
	public float getPrice()
	{
		return price;
	}
	public int getNumin()
	{
		return numin;
	}
	public int getNumout()
	{
		return numout;
	}
	public int getNumloss()
	{
		return numloss;
	}
	public String getDateii()
	{
		return dateii;
	}
}
