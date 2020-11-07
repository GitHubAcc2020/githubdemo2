package com.sunbeam.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args)
	{
    List<Integer>list=new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    
    Integer element=null;
    for (Integer integer : list)
    {
		System.out.println(integer);
	}
    
     
	}
	public static void main2(String[] args)
	{
    List<Integer>list=new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    
    Integer element=null;
    Iterator<Integer>itr=list.iterator();
    while(itr.hasNext())
    {
    	element=itr.next();
    	System.out.println(element);
    }
    
     
	}
	public static void main1(String[] args)
	{
    List<Integer>list=new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    
    Integer element=null;
    
    for(int index=0;index<list.size();index++)
    {
    	element=list.get(index);
    	System.out.println(element);
    }
    
     
	}

}
