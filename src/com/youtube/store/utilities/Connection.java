package com.youtube.store.utilities;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connection {
	
	 java.sql.Connection cnx;
	 Statement st;
	
	private DataSource dataSource;
	private Logger logger=new Logger();
	
	public void connect()
	{
		 try {
			cnx=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUser(), dataSource.getPassword());
			logger.information(" connected...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(" connection issues..");
		}
	}
	public void disconnect()
	{
		try {
			cnx.close();
			logger.information(" disconnected...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.information(" not able to disconnect...");
		}
	}
	public void executeUpdate(String sql)
	{
		Statement st;
		try {
			st = cnx.createStatement();
			st.executeUpdate(sql);
			logger.information(" this sql : << "+sql+" >> is executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(" this sql : << "+sql+" >> can't be executed");
		}
	}
		public ResultSet executeQuery(String sql)
		{
			Statement st;
			try {
				st = cnx.createStatement();
				ResultSet res=st.executeQuery(sql);
				logger.information(" this sql : << "+sql+" >> is executed");
				return res;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(" this sql : << "+sql+" >> can't be executed");
			}
			return null;
			
	}
		
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

}
