package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	static Properties p;
	static
	{
		 p=new Properties();
		InputStream inputstream;
		try {
			inputstream = new FileInputStream(new File("config.properties"));
			p.load(inputstream);
			//1.load and register driver
			Class.forName(p.getProperty("DRIVER"));
		} catch (Exception e)
		{
			throw new RuntimeException(e);
			
		}
		
	}
	public static Connection getConnection() throws SQLException
	{
		
		//2.establish the connection using user credentials
		 return DriverManager.getConnection(p.getProperty("URL"),p.getProperty("USERNAME"),p.getProperty("PASSWORD"));
		 
	}

}
