package SetPkg;

import java.util.TreeSet;

public class Program 
{

	public static void main (String[] args) 
	{
		TreeSet<Integer>tr=new TreeSet<Integer>();
		tr.add(50);
		tr.add(20);
		tr.add(20);
		tr.add(10);
	
		
		Integer element=null;
		for (Integer integer : tr)
		{
		System.out.println(integer);	
		}
		

	}
	public static void main1(String[]args) 
	{
		TreeSet<Integer>tr=new TreeSet<Integer>();
		tr.add(null);
		
		Integer element=null;
		for (Integer integer : tr)
		{
			System.out.println(integer);
		}
	}

}
