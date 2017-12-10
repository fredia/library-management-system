package com.fredia.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fredia.action.sqlconnect;

public class Reader {
	public String id;
	public String name;
	public Date birth;
	public int sex;
	public String phone;
	public String email;
	public int cardid;
	public Date day;
	public int level;
	public String dayii;
	public String birthii;

	public Reader()
	{
		super();
	}
	public Reader(String i,String na,Date birt,int se,String ph,String mo,int cardi,Date da,int le) {
		id=i;
		name=na;
		birth=birt;
		sex=se;
		phone=ph;
		email=mo;
		cardid=cardi;
		day=da;
		level=le;
		
	}
	public void getrecord(List<Record> rl) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "select * from borrow where readerid=?";
		PreparedStatement pst = con.prepareStatement(ssql); 
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Record rec;
		while(rs.next())
		{
		   rec = new Record();
		   rec.readerid=id;
		   rec.bookid=rs.getString("bookid");
		   rec.dateborrow = rs.getDate("date_borrow");
		   rec.datereturn=rs.getDate("date_return");
		   rec.isback = rs.getInt("isback");
		   rec.loss = rs.getInt("loss");
		   rl.add(rec);
		}
		PreparedStatement ppst;
		for(int i=0;i<rl.size();i++)
		{
			   Record rec1=rl.get(i);
			   ssql = "select * from books where bookid=?";
			   Connection con1 = sqlconnect.getCon();
			   ppst = con1.prepareStatement(ssql); 
			   ppst.setString(1, rec1.bookid);
			   //System.out.println(ssql);
			   ResultSet rss =ppst.executeQuery();
			   if(rss.next())
			   {
				   //System.out.println(rss.getString("bookname"));
				   
				   rec1.book.name=rss.getString("bookname");
				   rec1.book.author=rss.getString("author");
				   rec1.book.publish=rss.getString("publishing");
				   rec1.book.category=rss.getInt("categoryid");
				   
			   }
			   rl.set(i, rec1);
			   ppst.close();
		}
		System.out.println("记录查询成功");
		
	}
	public void getnow(List<Record> rl) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "select * from borrow where readerid=? and isback=0";
		PreparedStatement ppst;
		PreparedStatement pst = con.prepareStatement(ssql); 
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Record rec;
		while(rs.next())
		{
		   rec = new Record();
		   rec.readerid=id;
		   rec.bookid=rs.getString("bookid");
		   rec.dateborrow = rs.getDate("date_borrow");
		   rec.datereturn=rs.getDate("date_return");
		   rec.dateback = rs.getDate("date_back");
		   rec.isback = rs.getInt("isback");
		   rec.loss = rs.getInt("loss");
		  
		   rl.add(rec);
		}
		for(int i=0;i<rl.size();i++)
		{
			   Record rec1=rl.get(i);
			   ssql = "select * from books where bookid=?";
			   Connection con1 = sqlconnect.getCon();
			   ppst = con1.prepareStatement(ssql); 
			   ppst.setString(1, rec1.bookid);
			   System.out.println(rec1.dateborrow);
			   ResultSet rss =ppst.executeQuery();
			   if(rss.next())
			   {
				   //System.out.println(rss.getString("bookname"));
				   
				   rec1.book.name=rss.getString("bookname");
				   rec1.book.author=rss.getString("author");
				   rec1.book.publish=rss.getString("publishing");
				   
			   }
			   rl.set(i, rec1);
			   ppst.close();
		}
		pst.close();
		System.out.println("在借记录查询成功");
	}

	public String getReaderid()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}

	public Date getBirth()
	{
		return birth;
	}
	public String getBirthii()
	{
		return birthii;
	}
	public int getSex()
	{
		return sex;
	}

	public String getPhone()
	{
		return phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public int getCardid()
	{
		return cardid;
	}
	
	public Date getDay()
	{
		return day;
	}
	public String getDayii()
	{
		return dayii;
	}
	public int getLevel()
	{
		return level;
	}
	

}
