package org.jdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleCreation {
	public static void main(String[] args) {
		Connection connect = null;
		// 1.load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.connect the database
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"hr", "admin");
			// 3.Write a sql query
			String SltQ = "select*from student";
			// 4.prepare the statement
			PreparedStatement prestate = connect.prepareStatement(SltQ);
			// 5.Execute Query
			ResultSet set = prestate.executeQuery();
			// 6.Iterate the result
			while (set.next()) {
				int stuid = set.getInt("sid");
				System.out.println(stuid);
				String stuname = set.getString("sname");
				System.out.println(stuname);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			// 7.close the database connection
			try {
				connect.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
