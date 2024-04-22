
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleInsert3re {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##GREEN";
		String password = "GREEN1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();
// ----------------------------------------------------
			String sql1 = "SELECT max(deptno) FROM dept";
			ResultSet rs = stmt.executeQuery(sql1);
			int newnum = 0;
			while (rs.next()) {
				newnum = rs.getInt("max(deptno)");
				System.out.println(rs.getInt("max(deptno)"));
			}
			newnum += 10;

			String ideptno = Integer.toString(newnum), sdname = "IT", sloc = "SEOUL";
			String sql = "INSERT INTO dept VALUES ('" + ideptno + "','" + sdname + "','" + sloc + "')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

			String sql2 = "SELECT deptno, dname, loc FROM dept ORDER by 1";
			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				System.out.print(rs2.getString("deptno") + "\t");
				System.out.print(rs2.getString("dname") + "\t");
				System.out.println(rs2.getString("loc") + "\t");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
//			System.out.println(e);
			e.printStackTrace();
		}
	}

}