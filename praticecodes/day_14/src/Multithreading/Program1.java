package Multithreading;
class TickTock
{
 public void tick() throws InterruptedException
 {
	 synchronized (this) {
		 System.out.print("tick");
		 this.notify();
		 this.wait(100);
	}
	 
	 
 }
 public void tock() throws InterruptedException
 {
	 synchronized (this) {
		 System.out.println(" tock");
		 this.notify();
		 this.wait(100);
	}
	 
 }


}
class CThread implements Runnable
{
	private Thread thread;
	public CThread(String name)
	{
		this.thread=new Thread(this,name);
		this.thread.start();
	}
static TickTock tt=new TickTock();
	@Override
	public void run() 
	{
		try
		{
		if(Thread.currentThread().getName().equals("tick"))
		{
			
			
				for(int i=0;i<5;i++)
				{
					tt.tick();
					Thread.sleep(250);
				}
				
			
		}
		else
		{
			
			
				for(int i=0;i<5;i++)
				{
					tt.tock();
				Thread.sleep(250);
				}
			
		}
		}
		catch (InterruptedException e) 
		{
			throw new RuntimeException(e);
		}
		
	}
	
}
public class Program1
{

	public static void main(String[] args)throws Exception 
	{
		CThread th1=new CThread("tick");
		CThread th2=new CThread("tock");
		

	}

}
