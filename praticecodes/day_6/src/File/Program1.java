package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

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
	private static void readRecord(String pathname) 
	{
		FileInputStream inputstream=null;
		try
		{
			inputstream=new FileInputStream(new File(pathname));
			try 
			{
				int data=inputstream.read();
				System.out.println((char)data);
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		finally {
				try {
					inputstream.close();
					} 
				catch (IOException e)
					{
						
						e.printStackTrace();
					}
				}
		
	}
	private static void writeRecord(String pathname)
	{
		FileOutputStream outputstream=null;
		try {
			outputstream=new FileOutputStream(new File(pathname));
			outputstream.write(65);
			} 
		catch (Exception e) 
			{
			
			e.printStackTrace();
			}
		finally {
			try 
			{
				outputstream.close();
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) 
	{
		int choice;
		String pathname="File.dat";
		while((choice=Program1.menuList())!=0)
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

	}
	

}
