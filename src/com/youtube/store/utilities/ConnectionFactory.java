package com.youtube.store.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Connection createConnection()
	{
		String url=null;
		String user=null;
		String password=null;
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataSource dataSource=new DataSource(url, user, password);
		Connection connection=new Connection();
		connection.setDataSource(dataSource);
		connection.connect();
		return connection;
	}
	
	

}
