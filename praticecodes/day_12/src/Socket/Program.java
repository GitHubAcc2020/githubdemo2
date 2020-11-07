package Socket;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Program {

	public static void main(String[] args) throws Exception
	{
		InetAddress localhost=Inet4Address.getLocalHost();
		String Address=localhost.getHostAddress();
		String HostName=localhost.getHostName();
		System.out.println(Address+" "+HostName);

	}

}
