package Multithreading;

class SumArray
{
	/*public  synchronized int sum(int[]arr) throws InterruptedException
	{
		int result=0;
		for (int i : arr) 
		{
			result=result+i;
			System.out.println("running total for "+Thread.currentThread().getName()+" is "+result);
			Thread.sleep(250);
		}
		return result;	
	}*/
	public int sum(int[]arr) throws InterruptedException
	{
		int result=0;
		synchronized (this) 
		{
			for (int i : arr) 
			{
				result=result+i;
				System.out.println("running total for "+Thread.currentThread().getName()+" is "+result);
				Thread.sleep(250);
			}
			return result;	
			
		}
		
	}

}
/*class CThread implements Runnable
{
	private Thread thread;
	private int []arr;
	
	public CThread(String name,int []arr)
	{
		this.thread=new Thread(this,name);
		this.arr=arr;
		this.thread.start();
	}
	static SumArray sa=new SumArray();
	@Override
	public void run() 
	{
		try {
			/*synchronized (sa)
			{
				System.out.println("result : "+sa.sum(this.arr));
			}*/
			/*System.out.println("result : "+sa.sum(this.arr));
		} catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	
}*/
public class Program 
{

	public static void main(String[] args)
	{
		int []arr1= {1,2,3,4,5};
		CThread th1=new CThread("th1",arr1);
		
		int []arr2= {6,7,3,4,5};
		CThread th2=new CThread("th2",arr2);
		
		int []arr3= {0,2,9,4,8};
		CThread th3=new CThread("th3",arr3);

	}

}
