package com.sgtesting.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Utilities {

	public static void main(String[] args) {
		int count=getRecordCount("select * from dept2");
		System.out.println("# of Records:"+count);
		System.out.println("++++++++");
		int colcount=getColumnsCount("select * from dept2");
		System.out.println("# of Columns :"+colcount);
		System.out.println("++++++++");
		String sql="Select dname from (select dname from dept2 order by deptno desc) where rownum=1";
		String colData=getColumnData(sql);
		System.out.println(colData);
		System.out.println("++++++++");
		String s[]=getOneColumnData("select loc from dept2");
		for(String zz:s)
		{
			System.out.println(zz);
		}
	}
	
	private static int getRecordCount(String sqlQuery)
	{
		Connection conn=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery);
			while(rs.next()==true)
			{
				recordsCount=recordsCount+1;
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
		return recordsCount;
	}

	private static int getColumnsCount(String sqlQuery)
	{
		Connection conn=null;
		int columnsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery);
			ResultSetMetaData rsdata=rs.getMetaData();
			columnsCount=rsdata.getColumnCount();
			
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
		return columnsCount;
	}
	
	private static String getColumnData(String query)
	{
		Connection conn=null;
		String columnData=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()==true)
			{
				columnData=rs.getString("DNAME");
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
		return columnData;
	}
	
	private static String[] getOneColumnData(String query)
	{
		Connection conn=null;
		String columnData[]=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			columnData=new String[getRecordCount(query)];
			int k=0;
			while(rs.next()==true)
			{
				columnData[k]=rs.getString("LOC");
				k++;
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
		return columnData;
	}
}
