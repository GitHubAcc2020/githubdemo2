package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
class Employee implements Serializable
{
 
	/**
	 * 
	 */
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
	private static void writeRecord(String pathname)throws IOException
	{

		try(ObjectOutputStream objbuffoutputstream=new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream(new File(pathname)))))
		{
			Employee emp=new Employee("manisha",10,5500);
			objbuffoutputstream.writeObject(emp);
			
		} 	
	}
	private static void readRecord(String pathname)throws Exception 
	{
			try(ObjectInputStream objbuffinputstream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(pathname)))))
			{
				Employee emp=(Employee) objbuffinputstream.readObject();
				System.out.println(emp.toString());
			
			} 
				
	}
	
	public static void main(String[] args) 
	{
		int choice;
		String pathname="File.dat";
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
