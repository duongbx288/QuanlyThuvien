package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatisticController {
    
    public StatisticController() {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void getInfoSach() {
    	Connection conn ;
    	try {	
    		String query = "SELECT COUNT(Masach_20183901 AS so_sach FROM Sach_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
             
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
    }
}
