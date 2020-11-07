package File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program1 
{
	static Scanner sc=new Scanner(System.in);
	
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

		try(BufferedOutputStream buffoutputstream=new BufferedOutputStream( new FileOutputStream(new File(pathname))))
		{
			
			for(char ch='A';ch<='Z';ch++)
			{
				buffoutputstream.write(ch);
			}
		} 	
	}
	private static void readRecord(String pathname)throws IOException 
	{
			try(BufferedInputStream buffinputstream=new BufferedInputStream(new FileInputStream(new File(pathname))))
			{
				int data;
				while((data=buffinputstream.read())!=-1)
				{
					System.out.println((char)data+" ");	
				}	
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
		
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}

	}
	

}
