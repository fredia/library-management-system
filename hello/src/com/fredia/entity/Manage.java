package com.fredia.entity;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fredia.entity.Reader;
import com.fredia.entity.Record;
import com.fredia.entity.Book;

import com.fredia.action.sqlconnect;
public class Manage {
	public Manage()
	{
		super();
	}
	//读者
	public void addreader(Reader rea) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql="insert into user values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setInt(1, rea.cardid);
		pst.setString(2, "123456");
		pst.setInt(3, 0);
		pst.executeUpdate();
		pst.close();
	    ssql = "insert into readers values(?,?,?,?,?,?,?,?,?)";
		pst = con.prepareStatement(ssql);  
		pst.setString(1,rea.id);
		pst.setString(2, rea.name);
		pst.setInt(3, rea.sex);
		pst.setDate(4, rea.birth);
		pst.setString(5,rea.phone);
		pst.setString(6, rea.email);
		pst.setInt(7,rea.cardid);
		pst.setDate(8,rea.day);
		pst.setInt(9, rea.level);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("加入读者成功");
		
	}
	//读者
	public void updatereader(Reader rea) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "update readers set readername=?,sex=?,birthday=?,phone=?,email=?,cardid=?,day=?,level=? where readerid=?";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setString(1, rea.name);
		pst.setInt(2, rea.sex);
		pst.setDate(3, rea.birth);
		pst.setString(4,rea.phone);
		pst.setString(5, rea.email);
		pst.setInt(6,rea.cardid);
		pst.setDate(7,rea.day);
		pst.setInt(8, rea.level);
		pst.setString(9,rea.id);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("更改读者信息成功");
	} 
	//删除读者
	public void deletereader(Reader rea)throws SQLException {
	
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql="delete from readers where readerid=?";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setString(1, rea.id);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("删除读者信息成功");
		
	}
	//读者
	public void queryrecord(String id,List<Record> re) throws SQLException
	{
		if(id!=null&&id!="")
		{
			sqlconnect.Connet();
			Connection con = sqlconnect.getCon();
		
			Statement stmt = con.createStatement();
			String sql ="select * from reader where readerid="+id+";";
			ResultSet rs = stmt.executeQuery(sql);
			Record rec;
			while(rs.next())
			{
				rec=new Record();
				rec.readerid=rs.getString("readerid");
				rec.bookid=rs.getString("bookid");
				rec.dateborrow=rs.getDate("dateborrow");
				rec.datereturn=rs.getDate("datereturn");
				rec.loss = rs.getInt("loss");
				re.add(rec);
			}
			System.out.println("借阅记录查询成功");
		}
		else
		{
			System.out.println("读者不存在");
		}
		
		
	}
	//图书
	public void addbook(Book book) throws SQLException {
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "insert into books values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setString(1, book.bookid);
		pst.setString(2, book.name);
		pst.setString(3, book.author);
		pst.setString(4, book.publish);
		pst.setInt(5, book.category);
		pst.setFloat(6, book.price);
		pst.setDate(7, book.datein);
		pst.setInt(8, book.numin);
		pst.setInt(9, book.numout);
		pst.setInt(10, book.numloss);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("加入图书成功");
		
	}
	//更新图书
	public void updatebook(Book book) throws SQLException {
	
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "update books set bookname=?,author=?,publishing=?,categoryid=?,price=?,datein=?,quantity_in=?,quantity_out=?,quantity_loss=? where bookid=?";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setString(1, book.name);
		pst.setString(2, book.author);
		pst.setString(3, book.publish);
		pst.setInt(4, book.category);
		pst.setFloat(5, book.price);
		pst.setDate(6, book.datein);
		pst.setInt(7, book.numin);
		pst.setInt(8, book.numout);
		pst.setInt(9, book.numloss);
		pst.setString(10, book.bookid);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("更改图书信息成功");
	}
	//删除图书
	public void deletebook(Book book) throws SQLException {
	
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql="delete from books where bookid=?";
		PreparedStatement pst = con.prepareStatement(ssql);  
		pst.setString(1, book.bookid);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("删除图书信息成功");
		
	}
	
	//借书
	public String borrowbook(Record re) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "select * from books where bookid=?";
		PreparedStatement pst = con.prepareStatement(ssql); 
		pst.setString(1, re.bookid);
		ResultSet rs = pst.executeQuery();
		int ou=0;
		while(rs.next())
		{
			ou=rs.getInt("quantity_out");
		}
		if(ou<=0)
		{
			System.out.println("该书没有库存");
			return "该书没有库存";
			
		}
		pst.close();
		ssql="select * from readers where readerid=?";
		PreparedStatement ppst = con.prepareStatement(ssql); 
		ppst.setString(1, re.readerid);
		rs = ppst.executeQuery();
		int le=0;
		int dday=0;
		while(rs.next())
		{
			le=rs.getInt("level");
		}
		ppst.close();
		if(le==1)
		{
			dday = 10;
		}
		else if(le==2)
		{
			dday=20;
		}
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(re.dateborrow);
		gc.add(5,+dday);
		gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
		java.util.Date ddd = gc.getTime();
		re.dateback=new Date(ddd.getTime());
		System.out.println(re.dateback);
		
		
		ssql = "update books set quantity_out=? where bookid='"+re.bookid+"'";
		PreparedStatement pppst = con.prepareStatement(ssql); 
		pppst.setInt(1, ou+1);
		System.out.println(ssql);
		pppst.executeUpdate();
		pppst.close();
		
		re.loss=0;
		
		ssql="insert into borrow values(?,?,?,?,?,?,?)";
		pst = con.prepareStatement(ssql);
		pst.setString(1, re.readerid);
		pst.setString(2, re.bookid);
		pst.setDate(3, re.datereturn);
		pst.setInt(4, re.loss);
		pst.setDate(5, re.dateborrow);
		pst.setInt(6, 0);
		pst.setDate(7, re.dateback);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("借出成功");
		return "借出成功";
		
	}
	public String backbook(Record re) throws SQLException
	{
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql = "select * from books where bookid="+re.bookid;
		PreparedStatement pst = con.prepareStatement(ssql); 
		ResultSet rs = pst.executeQuery();
		int ou=0;
		while(rs.next())
		{
			ou=rs.getInt("quantity_out");
		}
		pst.close();
		ssql = "update books set quantity_out=? where bookid='"+re.bookid+"'";
		pst = con.prepareStatement(ssql);
		pst.setInt(1, ou-1);
		pst.executeUpdate();
		pst.close();
		ssql="update borrow set loss=?,isback=?,date_return=? where readerid=? and bookid=?";
		pst = con.prepareStatement(ssql);
		pst.setInt(1, re.loss);
		pst.setInt(2, re.isback);
		System.out.println(re.datereturn);
		pst.setDate(3, re.datereturn);
	
		pst.setString(4, re.readerid);
		pst.setString(5, re.bookid);
		pst.executeUpdate();
		pst.close();
		con.close();
		System.out.println("归还成功");
		return "归还成功";
	}
	

}
