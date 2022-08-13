package com.sgtesting.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ReadRecordsUsingPreparedStatementDemo {

	public static void main(String[] args) {
	//	readRecords();
		insertRecords();
	}

	private static void readRecords()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			
			String sql="select * from dept2";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData rsdata=rs.getMetaData();
			String col1=rsdata.getColumnName(1);
			String col2=rsdata.getColumnName(2);
			String col3=rsdata.getColumnName(3);
			System.out.printf("%-12s",col1);
			System.out.printf("%-12s",col2);
			System.out.printf("%-12s",col3);
			System.out.printf("\n");
		
			while(rs.next()==true)
			{
				String dno=rs.getString("DEPTNO");
				String deptname=rs.getString("DNAME");
				String place=rs.getString("LOC");
				System.out.printf("%-12s",dno);
				System.out.printf("%-12s",deptname);
				System.out.printf("%-12s",place);
				System.out.printf("\n");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void insertRecords()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			
			String sql="insert into dept2 values(90,'MEDICAL','RPC Layout')";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
