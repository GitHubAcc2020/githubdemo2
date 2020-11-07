package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Scanner;
class Employee implements Serializable
{
	private static final long serialVersionUID = -2458307777961334564L;
	private String name;
	private transient int empid;
	private float salary;
 
public Employee() 
{
	
}
public Employee(String name, int empid, float salary)
{
	super();
	this.name = name;
	this.empid = empid;
	this.salary = salary;
}
@Override
public String toString() 
{
	return "Employee [name=" + name + ", empid=" + empid + ", salary=" + salary + "]";
}
 

}
public class Program1 
{
	static Scanner sc =new Scanner(System.in);
	
	static int menuList()
	{
		System.out.println("0.exit");
		System.out.println("1.write record");
		System.out.println("2.read record");
		System.out.println("enter choice : ");
		return sc.nextInt();
		
	}
	private static void writeRecord(String pathname)throws Exception
	{
		
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(new File(pathname))))
		{
			
			writer.write("hello");
			writer.newLine();
			writer.write("good morning");
			writer.newLine();
			
		} 	
	}
	private static void readRecord(String pathname)throws Exception 
	{
			try(BufferedReader reader=new BufferedReader(new FileReader(new File(pathname))))
			{
				
				/*int data;
				while((data=reader.read())!=-1)
				{
					System.out.println((char)data);
					
				}*/
				
				String line=null;
				while ((line=reader.readLine())!=null)
				{
				System.out.println(line);	
				}
			} 
				
	}
	
	public static void main(String[] args) 
	{
		int choice;
		String pathname="File.txt";
		while((choice=Program1.menuList())!=0)
		{
			try
			{
				switch (choice) 
				{
				case 1:
					Program1.writeRecord(pathname);
					
					break;
					
				case 2:
					
					Program1.readRecord(pathname);
					
					break;	
	
				default:
					break;
				}
			
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
	

}
