package DBConnectivity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.EmployeeDao;
import Pojo.Employee;

public class Program 
{
	static Scanner sc=new Scanner(System.in);
	public static int  menuList()
	{
		System.out.println("0.exit");
		System.out.println("1.insert/add employee");
		System.out.println("2.delete/remove employee");
		System.out.println("3.update/modify employee");
		System.out.println("4.select/print all employees");
		System.out.println("5.find specific employee");
		System.out.print("enter your choice : ");
		return sc.nextInt();
		
		
	}
	private static void acceptRecord(Employee emp) 
	{
		if(emp!=null)
		{
			System.out.print("empid : ");
			emp.setId(sc.nextInt());
			System.out.print("name : ");
			sc.nextLine();
			emp.setName(sc.nextLine());
			System.out.print("salary : ");
			emp.setSalary(sc.nextFloat());
			System.out.print("mail id : ");
			sc.nextLine();
			emp.setMailid(sc.nextLine());
		}
		
	}
	private static void acceptRecord(int[] arr) 
	{
		if(arr!=null)
		{
			System.out.print("enter emp id : ");	
			arr[0]=sc.nextInt();
		}	
	}
	private static void printRecord(List<Employee> emplist)
	{
		if(emplist!=null)
		{
			//System.out.println(emplist.toString());
			emplist.forEach(System.out::println);
		}
		
	}

	private static void printRecord(Employee emp)
	{
		if(emp!=null)
		{
			System.out.println(emp.toString());
		}
		System.out.println("employee not found");
		
	}
public static void main(String[]args)
{
	int choice;
	int[]arr=new int[1];
	try {
			while((choice=Program.menuList())!=0) 
			{
				
					EmployeeDao empdao=new EmployeeDao();
					Employee emp=null;
				
				switch(choice) 
				{
				case 1:
					emp=new Employee();
					Program.acceptRecord(emp);
					empdao.insert(emp);
					break;
				case 2:
					Program.acceptRecord(arr);
					empdao.delete(arr[0]);
					break;
				case 3:
					Program.acceptRecord(arr);
					empdao.update(70000,arr[0]);
					break;
				case 4:
					List<Employee>emplist=empdao.getEmployees();
					Program.printRecord(emplist);
					break;
				case 5:
					Program.acceptRecord(arr);
					Employee employee=empdao.findEmployee(arr[0]);
					Program.printRecord(employee);
					break;
		
				}
				
			}
		}
	catch (SQLException e)
	{
		e.printStackTrace();
	}

}



	
	
	
	

}
