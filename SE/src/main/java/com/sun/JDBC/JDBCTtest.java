package com.sun.JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		       
		        //1.注册数据库驱动
		        Class.forName("com.mysql.jdbc.Driver");
		        //2.获取数据库的连接 
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
		        //3.创建传输器对象
		        Statement  stat = conn.createStatement();
		        //4.利用传输器对象传输sql语句到数据库中执行操作，将结果用结果集返回
		        ResultSet rs =  stat.executeQuery("select * from book");
		        //5.遍历结果集，并获取查询结果
	            while(rs.next()) {
		             String name = rs.getString("name");
		             System.out.println(name);
		        }
		         //6.关闭连接（后开先关）
		        rs.close(); 
		        stat.close();
		        conn.close();
	}
	
	 public void main() throws ClassNotFoundException, SQLException{
		    //注册数据库驱动
		    Class.forName("com.mysql.jdbc.Driver");
		    //获取数据库连接
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
		    //获取传输器对象
		    Statement stat = conn.createStatement();
		    //4.利用传输器对象传输sql语句到数据库中执行操作，将结果用结果集返回/
		    ResultSet rs = stat.executeQuery("select * from book");
		    //5.遍历结果集，并获取查询结果
		    while(rs.next()){
		    	 String name = rs.getString("name");
	             System.out.println(name);
		    }
		     //6.关闭连接（后开先关）
	        rs.close(); 
	        stat.close();
	        conn.close();
	 }
}
