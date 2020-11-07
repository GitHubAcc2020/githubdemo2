package com.sunbeam.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ListTest
{
	private List<Employee>list;
	public void setList(List<Employee> list)
	{
		this.list = list;
	}
	public void addEmployee(Employee[] emp) 
	{
		if(emp!=null && list!=null)
		{
			for(Employee employee : emp)
			{
				list.add(employee);
			}
		}
		
	}
	public void printEmployee(Comparator<Employee> comparator)
	{
		if(list!=null && comparator!=null)
		{
			Collections.sort(list,comparator);
			for (Employee employee : list) 
			{
				
				System.out.println(employee.toString());
				
			}
		}
		
	}
	public Employee findEmployee(int empid) 
	{
		if(this.list!=null)
		{
			for (Employee employee : list) 
			{
				if(employee.getEmpid()==empid)
					return employee;
			}
		}
		return null;
	}
	public boolean removeEmployee(int empid) 
	{
		if(this.list!=null)
		{
			for (Employee employee : list)
			{
				if(employee.getEmpid()==empid)
				{
					this.list.remove(employee);
					return true;
				}
					
			}
		}
		return false;
	}
	public boolean updateEmployee(int empid, float salary) 
	{
		if(this.list!=null)
		{
			Employee emp=this.findEmployee(empid);
			if(emp!=null)
			emp.setSalary(salary);
			return true;
		}
		return false;
	}
	
}
class SortByName implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2)
	{
		
		return e1.getName().compareTo(e2.getName());
	}
	
}
class SortByEmpId implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2)
	{
		
		return e1.getEmpid()-e2.getEmpid();
	}
	
}
class SortBySalary implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2)
	{
		
		return (int) (e1.getSalary()-e2.getSalary());
	}
}	
public class Program 
{
	static Scanner sc=new Scanner(System.in);
	public static Employee[] getEmployees()
	{
		Employee[]arr=new Employee[5];
		
		arr[0]=new Employee("manisha",13,1100);
		arr[1]=new Employee("nisha",12,1200);
		arr[2]=new Employee("raj",10,1300);
		arr[3]=new Employee("jenny",14,1400);
		arr[4]=new Employee("jay",22,1500);
		return arr;
	}
	private static void printEmployees(Employee[] emp)
	{
		if(emp!=null)
		{
			for (Employee employee : emp) 
			{
				System.out.println(employee.toString());
			}
		}	
	}

	public static int menuList()
	{
		System.out.println("0.exit");
		System.out.println("1.add record");
		System.out.println("2.find record ");
		System.out.println("3.delete record");
		System.out.println("4.update Record");
		System.out.println("5.print Record");
		return sc.nextInt();
	}
	public static int subMenuList()
	{
		System.out.println("0.exit");
		System.out.println("1.sort by name");
		System.out.println("2.sort by empid ");
		System.out.println("3.sort by salary");
		return sc.nextInt();
	}
	private static void acceptInputForSearch(int[] arr) 
	{
		System.out.println("enter empid  to serach the record :");
		arr[0]=sc.nextInt();
		
	}
	private static void printRecord(Employee value) 
	{
		if(value!=null)
		{
			System.out.println(value.toString());
		}
		else
		{
		System.out.println("employee not found");	
		}
		
	}
	
	private static void printRecord(boolean removeStatus)
	{
		if(removeStatus)
		{
			System.out.println("employee is removed");
		}
		else
		{
			System.out.println("employee not found");
		}
		
	}
	
	public static void main(String[] args) 
	{
		int choice;
		int[]arr=new int[1];
		Employee[]emp=Program.getEmployees();
		
		//Program.printEmployees(emp);
		
		ListTest test=new ListTest();
		test.setList(new ArrayList<Employee>());
			
		while((choice=Program.menuList())!=0)
		{
			switch (choice) 
			{
			case 1:
				test.addEmployee(emp);
				break;
			case 2:
				Program.acceptInputForSearch(arr);
				Employee value=test.findEmployee(arr[0]);
				Program.printRecord(value);
				break;
			case 3:
				Program.acceptInputForSearch(arr);
				boolean removeStatus=test.removeEmployee(arr[0]);
				Program.printRecord(removeStatus);
	
				break;
			case 4:
				Program.acceptInputForSearch(arr);
				boolean updateStatus=test.updateEmployee(arr[0],3500);
				
	
				break;
			case 5:
				int choice1;
				Comparator<Employee>comparator=null;
				while ((choice1=Program.subMenuList())!=0)
				{
					switch (choice1) 
					{
					case 1:
						comparator=new SortByName();
						break;
					case 2:
						comparator=new SortByEmpId();
						break;
					case 3:
						comparator=new SortBySalary();
						break;

					default:
						break;
					}
					
					test.printEmployee(comparator);
				}
				
				break;
			}
		}
		
		
		
		
	
		
		
		

	}
	
	
	
}
