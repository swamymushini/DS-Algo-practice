package com.trees.trie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		postgres();
	}

	static void postgres() {
		Connection c = null;
		try {
			
			String sql = "CREATE USER kidd2 PASSWORD 'gopal'";
//			String sql = "SELECT usename FROM pg_catalog.pg_user WHERE usename = 'gopal'";
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/?useSSL=false", "kidd", "gopal");
			Statement stmt = c.createStatement();
			stmt.execute(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				String res = rs.getString(1);
//				System.out.println(res);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
