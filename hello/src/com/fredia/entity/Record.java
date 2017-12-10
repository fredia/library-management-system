package com.fredia.entity;

import java.sql.Date;
import com.fredia.entity.Book;

public class Record {
	public String readerid;
	public String bookid;
	public Date dateborrow;
	public Date datereturn;
	public Date dateback;
	public int isback;
	public int loss;
	public Book book=new Book();
	public Record()
	{
		super();
	}
	

}
