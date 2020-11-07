package DAO;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojo.Employee;
import Utils.DBUtils;

public class EmployeeDao implements Closeable
{
	private Statement statement;
	private Connection connection;
	
	public EmployeeDao() throws SQLException 
	{
		 connection=DBUtils.getConnection();
		//3.prepare statement
		 statement=connection.createStatement();
		
	}

	public int insert(Employee emp) throws SQLException
	{
		//4.prepare and execute query(insert)
		 String sql="insert into employee values("+emp.getId()+",'"+emp.getName()+"',"+emp.getSalary()+",'"+emp.getMailid()+"')";
		 int count = statement.executeUpdate(sql);
		 
		 System.out.println(count+" row updated");
		 
		return count;
		
	}
	public int update(float esalary,int eid) throws SQLException
	{
		//4.prepare and execute query(update)
		 String sql="update employee set salary="+esalary+" where id="+eid+"";
		 int count = statement.executeUpdate(sql);
		 
		 System.out.println(count+" row updated");
		return count;
		
	}
	public int delete(int eid) throws SQLException
	{
		//4.prepare and execute query(delete)
		 String sql="delete from employee where id="+eid+"";
		 int count = statement.executeUpdate(sql);
		 
		 System.out.println(count+" row updated");
		 
		return count;
		
	}
	public List<Employee> getEmployees() throws SQLException 
	{
		String sql="select * from employee";
		 try(ResultSet rs=statement.executeQuery(sql))
		 {
		 
		 List<Employee> emplist=new ArrayList<Employee>();
		 while(rs.next())
		 {
			 Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
			 
			 emplist.add(emp);
			 
		 }
		 //emplist.forEach(System.out::println);
		 return emplist;
		 }
		
		
	}
	public Employee findEmployee(int eid) throws SQLException
	{
		String sql="select * from Employee where id="+eid+"";
		try(ResultSet rs=statement.executeQuery(sql))
		{
		if(rs.next())
		{
			return new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
		}
		}
		return null;	
	}
	@Override
	public void close() throws IOException 
	{
		try {
			this.statement.close();
			this.connection.close();
			} 
		catch(SQLException e) 
			{
			throw new IOException(e);
			}
		
		
	}

	
	

}
