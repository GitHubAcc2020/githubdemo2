package com.sunbeam.test;

public class Employee implements Comparable<Employee>
{
	String name;
	int empid;
	double salary;
	public Employee() 
	{
		this("",0,0.0);
	}
	public Employee(String name, int empid, double d) 
	{
		super();
		this.name = name;
		this.empid = empid;
		this.salary = d;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", empid=" + empid + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Employee other) 
	{
		
		return this.empid-other.empid;
	}
	
	
	
	

}
