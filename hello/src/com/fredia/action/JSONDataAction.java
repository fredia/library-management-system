package com.fredia.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class JSONDataAction{

	private String string1 = "A";
	private String[] stringarray1 = {"A1","B1"};
	private int number1 = 123456789;
	private int[] numberarray1 = {1,2,3,4,5,6,7,8,9};
	private List<String> lists = new ArrayList<String>();
	private Map<String, String> maps = new HashMap<String, String>();
	
	//no getter method, will not include in the JSON
	private String string2 = "B";
	
	public JSONDataAction(){
		lists.add("list1");
		lists.add("list2");
		lists.add("list3");
		lists.add("list4");
		lists.add("list5");
		
		maps.put("key1", "value1");
		maps.put("key2", "value2");
		maps.put("key3", "value3");
		maps.put("key4", "value4");
		maps.put("key5", "value5");
	}

	public String execute() {
               return Action.SUCCESS;
        }
	
	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String[] getStringarray1() {
		return stringarray1;
	}

	public void setStringarray1(String[] stringarray1) {
		this.stringarray1 = stringarray1;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int[] getNumberarray1() {
		return numberarray1;
	}

	public void setNumberarray1(int[] numberarray1) {
		this.numberarray1 = numberarray1;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	
}