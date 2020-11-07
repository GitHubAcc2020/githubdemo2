package com.thread.test;
class Test
{
public Test() 
{
	System.out.println("inside constructor\n");
}	
public void print()
{
System.out.println("inside print");	
}
@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("inside finalize\n");
		Thread thread=Thread.currentThread();
		System.out.println(thread.toString());
		boolean type=thread.isDaemon();
		System.out.println("type :"+ (type ? "Daemon thread":"User thread"));
		String state=thread.getState().name();
		System.out.println("state :"+state);
		boolean status=thread.isAlive();
		System.out.println("status :"+(status ?"Alive":"Dead"));
	}

}

public class Program 
{
	public static void main(String args[])
	{
		Test test=new Test();
		test.print();
		test=null;
		System.gc();
		
	}

	public static void main1(String[] args) 
	{
		Thread thread=Thread.currentThread();
		System.out.println(thread.toString());
		boolean type=thread.isDaemon();
		System.out.println("type :"+ (type ? "Daemon thread":"User thread"));
		String state=thread.getState().name();
		System.out.println("state :"+state);
		boolean status=thread.isAlive();
		System.out.println("status :"+(status ?"Alive":"Dead"));

	}

}
