package com.fredia.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fredia.entity.Reader;
import com.opensymphony.xwork2.ActionSupport;

public class allreaderjson extends ActionSupport{
	private static final long serialVersionUID = 7443363719737618408L;
	private int total=2;
	private List<Reader> rows=new ArrayList<Reader>();
	public String execute() throws SQLException
	{ 
		sqlconnect.Connet();
		Connection con = sqlconnect.getCon();
		String sql="select * from readers";
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		Reader read=new Reader();
		while(rs.next())
		{
			read=new Reader();
			read.id=rs.getString("readerid");
			read.name=rs.getString("readername");
			read.sex=rs.getInt("sex");
			read.birth=rs.getDate("birthday");
			if(read.birth!=null)
			{
				read.birthii=read.birth.toString().substring(0, 10);
			}
			read.phone=rs.getString("phone");
			read.email=rs.getString("email");
			read.cardid=rs.getInt("cardid");
			read.day=rs.getDate("day");
			
			if(read.day!=null)
			{
				read.dayii=read.day.toString().substring(0, 10);
			}
			read.level=rs.getInt("level");
			rows.add(read);
			
		}
		return SUCCESS;
	}
	public int getTotal()
	{
		return total;
	}
	public List<Reader> getRows()
	{
		return rows;
	}

}
