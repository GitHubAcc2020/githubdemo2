package DBConnectivity;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Pojo.Employee;
import Utils.DBUtils;



//0.add mysql connector in build path/class path
public class Program {
	//for future use in query
	
	public static void main(String[] args)
	{
		
		
		try(Connection connection=DBUtils.getConnection();
				//3.prepare statement
			Statement statement=connection.createStatement();) 
		{
			//4.prepare and execute query
			 String sql="select * from employee";
			 ResultSet rs=statement.executeQuery(sql);
			 
			 List<Employee> emplist=new ArrayList<Employee>();
			 while(rs.next())
			 {
				 /*Employee emp=new Employee();
				 int id=rs.getInt(1);
				 emp.setId(id);
				 String name=rs.getString(2);
				 emp.setName(name);
				 Float salary=rs.getFloat(3);
				 emp.setSalary(salary);
				 String mailid=rs.getString(4);
				 emp.setMailid(mailid);
				 //System.out.println(emp.toString());
				 emplist.add(emp);*/
				 Employee emp=new Employee(rs.getInt(1),rs.getFloat(3),rs.getString(2),rs.getString(4));
				 
				 emplist.add(emp);
				 
			 }
			 emplist.forEach(System.out::println);
			 
			
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
