package com.broadway.dbtest1.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.broadway.dbtest1.model.Data;
import com.broadway.dbtest1.service.*;

import java.sql.*;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String connection = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/broadway";
		String username = "root";
		String password = "";

		Class.forName(connection);
		Connection con = DriverManager.getConnection(url, username, password);
//		String sql = "insert into table2 (name , password) values ('ram' , 'ram12@')";
//		Statement stmt = con.createStatement();
//		stmt.execute(sql);
//		System.out.println("insert successful");
		String sql2 = "select * from table2";
		Statement stmt1 = con.createStatement();
		ResultSet r1 = stmt1.executeQuery(sql2);

		StudentInfo si = new StudentInfoImpl();

		while (r1.next()) {
			Data d = new Data();
			d.setId(r1.getInt("id"));
			d.setName(r1.getString("name"));
			d.setPassword(r1.getString("password"));
			si.add(d);

		}
		List<Data> list1 = si.showAll();
		for (Data d : list1) {
			System.out.println("id: " + d.getId());
			System.out.println("Name: " + d.getName());
			System.out.println("Password: " + d.getPassword());
			System.out.println("======================");
		}

		con.close();
	}
}
