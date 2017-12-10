package com.fredia.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fredia.entity.*;
import com.opensymphony.xwork2.ActionSupport;

public class everybook extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String bookid;
    public Book everybook=new Book();
    public String execute() throws SQLException
    {
    	System.out.println(bookid);
    	sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String ssql="select * from books where bookid=?";
		PreparedStatement pst = con.prepareStatement(ssql); 
		pst.setString(1, bookid);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			everybook.bookid=bookid;
			everybook.name=rs.getString("bookname");
			everybook.author=rs.getString("author");
			everybook.publish=rs.getString("publishing");
			everybook.category =rs.getInt("categoryid");
			everybook.price=rs.getFloat("price");
			everybook.numin=rs.getInt("quantity_in");
			everybook.numloss=rs.getInt("quantity_loss");
			everybook.numout=rs.getInt("quantity_out");
			everybook.datein=rs.getDate("datein");
			if(everybook.datein!=null)
			{
				everybook.dateii=everybook.datein.toString().substring(0, 10);
			}
		}
    	return SUCCESS;
    }
    public void setBookid(String s)
    {
    	bookid=s;
    }
    public Book getEverybook()
    {
    	return everybook;
    }
}
