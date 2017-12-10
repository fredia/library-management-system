package com.fredia.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fredia.entity.Reader;
import com.fredia.entity.User;
import com.fredia.entity.Statistics;
import com.opensymphony.xwork2.ActionSupport;


public class AjaxAction extends ActionSupport {

 /**
  * 
  */
 private static final long serialVersionUID = 7443363719737618408L;
 /**
  * 姓名
  */
 private String name;
 /**
  * ajax返回结果，也可是其他类型的，这里以String类型为例
  */
 private Date begin;
 private int[] arr=new int[10];
 private Map<Date,Integer> mapp= new HashMap<Date,Integer>();
 Map<Date, Integer>  map= new LinkedHashMap<Date, Integer>(); 
 List<Map.Entry<Date, Integer>> infoIds;
 User u= login.getUser();
 private Reader rea=u.reader;
 @Override
 public String execute() throws Exception {
  Statistics sta = new Statistics();
  sta.setDate(begin);
  sta.getArr(rea);
  arr = sta.arr;
  mapp=sta.map;
  infoIds =new ArrayList<Map.Entry<Date, Integer>>(mapp.entrySet());
  Collections.sort(infoIds, new Comparator<Map.Entry<Date, Integer>>() {   
	    public int compare(Map.Entry<Date, Integer> o1, Map.Entry<Date, Integer> o2) {      
	        return (o1.getKey()).toString().compareTo(o2.getKey().toString());
	    }
	});
  for(Entry<Date, Integer> entry: infoIds) { 
      map.put(entry.getKey(),entry.getValue());
  } 

  return SUCCESS;
 }
 
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public void setBegin(Date d)
 {
	 begin=d;
 }
 public Date getBegin()
 {
	 return begin;
 }
 public Map<Date,Integer> getMap()
 {
	 return map;
 }
 public int[] getArr()
 {
	 return arr;
 }
}