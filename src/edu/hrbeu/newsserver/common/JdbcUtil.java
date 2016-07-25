package edu.hrbeu.newsserver.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://220.163.108.218:1433;databaseName=heu_newsserver";
	static final String USER ="sa";
	static final String PWD ="ls18908805728lzx";
	public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER,PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		
	}
	public static void closeResource(ResultSet rs, Statement stm ,Connection con){
		try {
		if(rs!=null)	{rs.close();	}
		if(stm!=null)	{stm.close();	}
		if(con!=null)	{con.close();	}
		} catch (SQLException e) {
			e.printStackTrace();
		}}
}
