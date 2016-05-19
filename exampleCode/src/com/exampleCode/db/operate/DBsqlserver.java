package com.exampleCode.db.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBsqlserver {
	// oracle数据库
		private static String url = "jdbc:sqlserver://114.55.29.104:1433;DatabaseName=zjcodeTest"; // 云服务器sqlserver数据库
		private static String username = "zjcode"; // 用户名
		private static String password = "zjcode"; // 密码
		private static String classURL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		private static String classURL = "com.mysql.jdbc.Driver";

		private DBsqlserver() {

		}

		static {
			try {
				Class.forName(classURL);
			} catch (ClassNotFoundException e) {
				System.out.println("驱动加载失败!");
			}
		}

		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(url, username, password);
		}
		
		public static void free(ResultSet rs, PreparedStatement st, Connection conn) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
