package com.fredia.entity;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Statistics {
	public Date begin;
	public Reader reader=new Reader();
	public int[] arr=new int[10];
	public Map<Date,Integer> map= new HashMap<Date,Integer>();
	private List<Record> reclist=new ArrayList<Record>();
	public Statistics()
	{
		super();
	}
	public void setDate(Date date)
	{
		begin=date;
	}
	public void getArr(Reader rea) throws SQLException
	{
		System.out.println("getArr"+begin);
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(begin);
		Date tdate;
		map.put(begin, 0);
		for(int i=0;i<9;i++)
		{
			gc.add(5,+1);
			gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
			java.util.Date ddd = gc.getTime();
			tdate = new Date(ddd.getTime());
			map.put(tdate,0);
		}
		reader=rea;
		System.out.println("getArr"+rea.id);
		reader.getrecord(reclist);
		System.out.println("getArr"+reclist.size());
		for(int i=0;i<reclist.size();i++)
		{
			 Record rec1=reclist.get(i);
			 int tmp=rec1.book.category;
			 arr[tmp-1]++;
			 Date temp=rec1.dateborrow;
			 if(map.get(temp)!=null)
			 {
				 int v=map.get(temp);
				 map.put(temp,v+1 );
			 }
			
			 
		}
	
	}
}
