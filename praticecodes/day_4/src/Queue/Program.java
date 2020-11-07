package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Program
{
	public static void main(String[] args)
	{
		Deque<Integer>que=new ArrayDeque<Integer>();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		que.offer(40);
		que.offer(50);
		
		que.addFirst(5);
		que.addLast(60);
		que.removeFirst();
		que.removeLast();
		
		Integer element=null;
		/*while (!que.isEmpty())
		{
			element=que.getFirst();
			System.out.println(element);
			que.removeFirst();
		}*/
		while (!que.isEmpty())
		{
			element=que.getLast();
			System.out.println(element);
			que.removeLast();
		}
		

	}
	public static void main2(String[] args)
	{
		Queue<Integer>que=new ArrayDeque<Integer>();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		que.offer(40);
		que.offer(50);
		
		Integer element=null;
		while (!que.isEmpty())
		{
			element=que.peek();
			System.out.println(element);
			que.poll();
		}
		

	}
	public static void main1(String[] args)
	{
		Queue<Integer>que=new ArrayDeque<Integer>();
		que.add(10);
		que.add(20);
		que.add(30);
		que.add(40);
		que.add(50);
		
		Integer element=null;
		while (!que.isEmpty())
		{
			element=que.element();
			System.out.println(element);
			que.remove();
		}
		

	}

}
