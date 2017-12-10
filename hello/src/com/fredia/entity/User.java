package com.fredia.entity;
import com.fredia.entity.Reader;
public class User {

	public String name;
	public String pass;
	public int isma;
	public Reader reader;
	public Manage manage;
	public User()
	{
		super();
	}
	public User(String na,String pa,int ism)
	{
		name=na;
		pass=pa;
		isma=ism;
	}
	public void setReader(Reader read)
	{
		reader = read;
	}
	public Reader getReader()
	{
		return reader;
	}
	public String getName()
	{
		return name;
	}
	public String getPass()
	{
		return pass;
	}
	public int getIsmanage()
	{
		return isma;
	}
}
