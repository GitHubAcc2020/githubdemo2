package Pojo;

public class Employee 
{
	private int id;
	private float salary;
	private String name,mailid;
	
	public Employee() 
	{
		
	}
	
	
	public Employee(int id,String name,float salary, String mailid) 
	{
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.mailid = mailid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	@Override
	public String toString() 
	{
		return String.format("%-10d%-20s%-20f%-10s\n",id,name,salary,mailid);
	} 
	
	

}
