import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleInsert2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//localhost : 데이터베이스의 주소 (현재 내 PC의 IP 주소)
		String user = "C##GREEN";							//1521 : 오라클 전용 포트 | xe : 서비스명
		String password = "GREEN1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			
			Statement stmt = conn.createStatement();
					
			String sql = "SELECT * FROM emp";		
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString("empno") + " ");
				System.out.print(rs.getString("ename") + " ");
				System.out.print(rs.getString("sal") + " ");
				System.out.println(rs.getString("job") + " ");
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
		}catch (SQLException e) {
			System.out.println("oracle connection fail.");
		}
	}

}
