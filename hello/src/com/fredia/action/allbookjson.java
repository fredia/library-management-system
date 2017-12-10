package com.fredia.action;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fredia.entity.*;


import com.opensymphony.xwork2.ActionSupport;


public class allbookjson extends ActionSupport{
	private static final long serialVersionUID = 7443363719737618408L;
	private int total=2;
	private List<Book> rows=new ArrayList<Book>();
	public String execute() throws SQLException
	{ 
		rows = new ArrayList<Book>();
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String sql="select * from books";
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		Book book=new Book();
		while(rs.next())
		{
			book = new Book();
			book.bookid = rs.getString("bookid");
			
			book.name=rs.getString("bookname");
			
			book.author=rs.getString("author");
			book.publish=rs.getString("publishing");
			book.category =rs.getInt("categoryid");
			book.price=rs.getFloat("price");
			book.numin=rs.getInt("quantity_in");
			book.numloss=rs.getInt("quantity_loss");
			book.numout=rs.getInt("quantity_out");
			book.datein=rs.getDate("datein");
			if(book.datein!=null)
			   book.dateii = book.datein.toString().substring(0, 10);
			//System.out.println("ok");
			rows.add(book);
			
		}
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
