package Map;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program {

	private static Map<Integer, String>getMap() 
	{
		Map<Integer,String>map=new Hashtable<Integer,String>();
		map.put(1,"manisha");
		map.put(2,"nisha");
		map.put(3,"isha");
		map.put(4,"raj");
		return map;	
	}
	private static void printKeys(Map<Integer, String> map) 
	{
		if(map!=null)
		{
			Set<Integer>keys=map.keySet();
			for (Integer key : keys)
			{
				System.out.println(key);
				
			}
			
		}
		
	}
	private static void printValues(Map<Integer, String> map)
	{
		if(map!=null)
		{
			Collection<String>values=map.values();
			for (String value : values) 
			{
				System.out.println(value);
			}
		
		}
		
	}
	private static void printMap(Map<Integer, String> map) 
	{
		if(map!=null)
		{
			Set<Map.Entry<Integer,String>>entries=map.entrySet();
			for (Entry<Integer, String> entry : entries) 
			{
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
		}
		
	}
	private static String findValue(Map<Integer, String> map, int id)
	{
		Integer key=new Integer(id);
		if(map!=null)
		{
			if(map.containsKey(key))
				return map.get(key);
		}
		return null;
	}
	private static void remove(Map<Integer, String> map, int id) 
	{
		Integer key=new Integer(id);
		if(map!=null)
		{
			if(map.containsKey(key))
			{
				map.remove(key);
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Map<Integer,String>map=Program.getMap();
		Program.printKeys(map);
		System.out.println();
		Program.printValues(map);
		System.out.println();
		Program.printMap(map);
		String value=Program.findValue(map,3);
		System.out.println();
		System.out.println(value);
		System.out.println();
		Program.remove(map,4);
		Program.printMap(map);
		
		
		

	}
	
	
	
	
	
	

}
