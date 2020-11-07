package DAO;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojo.Employee;
import Utils.DBUtils;

public class EmployeeDao implements Closeable
{
	private PreparedStatement stmtInsert,stmtDelete,stmtUpdate,stmtSelect,stmtFind;
	private Connection connection;
	
	public EmployeeDao() throws SQLException 
	{
		 connection=DBUtils.getConnection();
		//3.prepare statement
		 this.stmtInsert=connection.prepareStatement("insert into employee values(?,?,?,?)");
		 this.stmtDelete=connection.prepareStatement("delete from employee where id=?");
		 this.stmtUpdate=connection.prepareStatement("update employee set salary=? where id=?");
		 this.stmtSelect=connection.prepareStatement("select * from employee");
		 this.stmtFind=connection.prepareStatement("select * from employee where id=?");
	}

	public int insert(Employee emp) throws SQLException
	{
		//4.prepare and execute query(insert)
		this.stmtInsert.setInt(1, 70);
		this.stmtInsert.setString(2,"arya");
		this.stmtInsert.setFloat(3, 6700);
		this.stmtInsert.setString(4,"ak@gmail.com");
		
		 int count = this.stmtInsert.executeUpdate();
		 
		 System.out.println(count+" row updated");
		 
		return count;
		
	}
	public int update(float esalary,int eid) throws SQLException
	{
		//4.prepare and execute query(update)
		this.stmtUpdate.setFloat(1, esalary);
		this.stmtUpdate.setInt(2,eid);
	
		 int count = this.stmtUpdate.executeUpdate();
		 
		 System.out.println(count+" row updated");
		return count;
		
	}
	public int delete(int eid) throws SQLException
	{
		//4.prepare and execute query(delete)
		this.stmtDelete.setInt(1, eid);
		 
		 int count =this.stmtDelete.executeUpdate();
		 
		 System.out.println(count+" row updated");
		 
		return count;
		
	}
	public List<Employee> getEmployees() throws SQLException 
	{
		
		
		 try(ResultSet rs=this.stmtSelect.executeQuery())
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
		this.stmtFind.setInt(1, eid);
		
		try(ResultSet rs=this.stmtFind.executeQuery())
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
			this.stmtInsert.close();
			this.stmtDelete.close();
			this.stmtUpdate.close();
			this.stmtSelect.close();
			this.stmtFind.close();
			this.connection.close();
			} 
		catch(SQLException e) 
			{
			throw new IOException(e);
			}
		
		
	}

	
	

}
