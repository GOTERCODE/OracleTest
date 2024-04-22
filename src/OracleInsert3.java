import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class OracleInsert3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost : 데이터베이스의 주소 (현재 내 PC의 IP 주소)
		String user = "C##GREEN"; // 1521 : 오라클 전용 포트 | xe : 서비스명
		String password = "GREEN1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String i = "1";

			String ideptno = i, sdname = "IT", sloc = "SEOUL";
			if(i == ideptno) {
			int number = Integer.parseInt(i);
			number++;
			i = Integer.toString(number);}
			

			String sql = "INSERT INTO dept VALUES ('" + ideptno + "','" + sdname + "','" + sloc + "')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}
			// String sql = "SELECT * FROM dept";
			String sql2 = "SELECT deptno, dname, loc FROM dept";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			// System.out.println(e);
			e.printStackTrace();
		}

	}

}
