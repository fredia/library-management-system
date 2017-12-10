package com.fredia.action;

import java.sql.SQLException;

import com.fredia.entity.Reader;
import com.fredia.entity.Manage;
import com.fredia.entity.User;

public class deletereader {
	public String readerid;
    private Reader read=new Reader();
	
	User u= login.getUser();
	private Manage ma=u.manage;
	public void excute() throws SQLException
	{
		read.id=readerid;
		ma.deletereader(read);
		System.out.println("删除读者成功");
	}
    public void setReaderid(String s)
    {
          readerid=s;
    }
    public String getReaderid()
    {
    	return readerid;
    }

}
