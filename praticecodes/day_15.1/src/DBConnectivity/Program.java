package DBConnectivity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//0.add mysql connector in build path/class path
public class Program {
	//for future use in query
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/company";
	public static final String USERNAME="root";
	public static final String PASSWORD="Mysql@2020";
	public static void main(String[] args)
	{
		Connection connection=null;
		//Statement statement=null;
		//PreparedStatement stmt=null;
		CallableStatement stmt=null;
		try {
			//1.load and register driver
			Class.forName(DRIVER);
			//2.establish the connection using user credentials
			 connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    //3.prepare statement(using statement)
			/* statement=connection.createStatement();
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
			 }*/
			// (using preparedStatement)
			 /*String sql="insert into employee values(?,?,?,?)";
			//stmt=connection.prepareStatement(sql);
			
			//stmt.setString(2,"gayatri's");
			//stmt.setFloat(3,45700);
			//stmt.setString(4,"gf@gmail.com");
			//stmt.executeUpdate();*/
			// (using CallableStatement)
			 String sql="{call spro_insert_employee(?,?,?,?)}";
			 stmt=connection.prepareCall(sql);
			 stmt.setInt(1, 80);
			 stmt.setString(2,"rohit");
			 stmt.setFloat(3,3300);
			 stmt.setString(4,"rk@gmail.com");
			 if(!stmt.execute())
			 {
				 System.out.println(stmt.getUpdateCount()+" record inserted");
			 }
			 
			 
			
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.close the resources
			try {
				if(stmt!=null)
				   stmt.close();
				if(connection!=null)
				   connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}
