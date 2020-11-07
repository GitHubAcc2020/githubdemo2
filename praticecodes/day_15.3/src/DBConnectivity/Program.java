package DBConnectivity;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Utils.DBUtils;



//0.add mysql connector in build path/class path
public class Program {
	//for future use in query
	
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		try {
			connection=DBUtils.getConnection();
			//3.prepare statement
			 statement=connection.createStatement();
			//4.prepare and execute query
			 String sql="select * from employee";
			 ResultSet rs=statement.executeQuery(sql);
			 while(rs.next())
			 {
				 int id=rs.getInt(1);
				 String name=rs.getString(2);
				 Float salary=rs.getFloat(3);
				 String mailid=rs.getString(4);
				 System.out.printf("%-10d%-20s%-20f%-10s\n",id,name,salary,mailid);
			 }
			 
			
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.close the resources
			try {
				if(statement!=null)
				   statement.close();
				if(connection!=null)
				   connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}
