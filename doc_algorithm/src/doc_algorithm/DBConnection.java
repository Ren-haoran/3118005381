package doc_algorithm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public DBConnection(){
		this.getConection();
	}
	
	private String driver;
	private String url;
	private String dbusername;
	private String dbpassword;
	private Connection con;
	private Statement sta;
	
	public Connection getConection(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,dbusername,dbpassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	

	public Statement getStatement(){
		try {
			sta=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sta;
	}
}
