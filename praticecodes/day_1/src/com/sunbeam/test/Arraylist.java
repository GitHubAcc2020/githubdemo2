package com.sunbeam.test;
import java.util.*;

public class Arraylist {

	public static void main(String[] args) 
	{
		ArrayList<Integer>list1=new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		
		ListIterator<Integer>ltr=list1.listIterator(0);

		Integer element=null;
		while (ltr.hasNext()) 
		{
		 element=ltr.next();
		 System.out.print(element+ "  ");
		}
		System.out.println();
		while (ltr.hasPrevious())
		{
		 element=ltr.previous();
		 System.out.print(element+ "  ");
		}
		
	}
	public static void main4(String[] args) 
	{
		
		ArrayList<Integer>list1=new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		ArrayList<Integer>list2=new ArrayList<Integer>();
		
		list2.add(40);
		list2.add(50);
		list2.add(60);
		list1.addAll(list2);
		
		for (Integer integer : list1) 
		{
			System.out.println(integer);
		}
		if(list1.containsAll(list2))
		{
			//int index=list.indexOf(key);
			//System.out.println("index of "+ key +"="+index);
			list1.removeAll(list2);
			System.out.println("list2 removed");
		}
		
		for (Integer integer : list1) {
			System.out.println(integer);
		}
		
	}
	public static void main3(String[] args) 
	{
		
		Collection<Integer>c=new LinkedList<Integer>();
		c.add(10);
		c.add(20);
		Iterator<Integer>itr1=c.iterator();
		while (itr1.hasNext())
		{
		Integer element=itr1.next();
		System.out.println(element);
		}
		
	System.out.println("******************************");
		ArrayList<Integer>list=new ArrayList<Integer>(c);
		
		Iterator<Integer>itr2=list.iterator();
		while (itr2.hasNext())
		{
		Integer element=itr2.next();
		System.out.println(element);
		}
	}
	public static void main2(String[] args) 
	{
		int initialcapacity=10;
		ArrayList<Integer>list=new ArrayList<Integer>(initialcapacity);
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		for (Integer integer : list)
		{
			System.out.println(integer);
		}
	}
	public static void main1(String[] args) 
	{
		ArrayList<Integer>list1=new ArrayList<Integer>();
		List<Integer>list2=new ArrayList<Integer>();
		Collection<Integer>list3=new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		
		for (Integer integer : list2)
		{
			System.out.println(integer);
		}
	}

}
