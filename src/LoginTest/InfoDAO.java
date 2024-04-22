package LoginTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;

public class InfoDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "C##GREEN";
	String password = "GREEN1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<InfoVo> list(String pid) {
		ArrayList<InfoVo> list = new ArrayList<InfoVo>();

		try {
			connDB();

			String query = "SELECT * FROM login";
			if (pid != null) {
				query += " where id='" + pid.toUpperCase() + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
										
					
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");
		

					InfoVo data = new InfoVo(id, pwd);
					list.add(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			// stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}