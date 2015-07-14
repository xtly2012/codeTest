import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class JdbcTest {
	private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public static int flag = 0;
	
	public static synchronized void add() {
		flag++;
	}
	
	public static synchronized void println() {
		System.out.println("set time is start");
		for (int i = 0; i < 2; i++) {
			Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
			Iterator<Map.Entry<Integer,Integer>> entryIter = entrySet.iterator();
			while (entryIter.hasNext()) {
				try {
					Map.Entry<Integer,Integer> entry = entryIter.next();
					if (entry.getValue() > 1) {
						System.out.println("key = " +entry.getKey() +" = " +entry.getValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] argus) {
		
		Thread[] threadArr = new Thread[500];
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i] =	new Thread(new Runnable() {
				private Connection con = null;
				
				public void run() {
					for (int i = 0; i< 999; i++) {
						try {
							if (con == null) {
								String url="jdbc:mysql://localhost:3306/saledb?user=8doldev&password=111111";
								con = DriverManager.getConnection(url);
							}
							Statement stmt = con.createStatement();
							String query = "select nextval('seq_test')";
							ResultSet rs=stmt.executeQuery(query);
							if (rs.next()) {
								Integer key = rs.getInt(1);
								String insert = "insert into seq_test(seq_current) values(" +key +")";
								stmt.executeUpdate(insert);
							}
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}
					
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					System.out.println("test is over");
				}
			});
		}
		
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i].start();
		}
		
	}
}
