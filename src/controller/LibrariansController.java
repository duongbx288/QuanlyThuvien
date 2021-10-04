package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Librarians;

public class LibrariansController {
	Connection conn = null;
	
	public ArrayList<Librarians> getListThuthu(){
		ArrayList<Librarians> list1 = new ArrayList<>();
		String sql = "SELECT * FROM Thuthu_XD3901";
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Librarians d = new Librarians();
				d.setmatt(rs.getString("Ma_thu_thu"));
				d.settentt(rs.getString("Ten_thu_thu"));
				d.setgttt(rs.getString("Gioi_tinh"));
				d.setngaysinhtt(rs.getDate("Ngay_sinh"));
			    d.setcmndtt(rs.getString("CMND"));	
			    d.setemailtt(rs.getString("Email"));
			    d.setsdtt(rs.getString("Dien_thoai"));
			    
			    list1.add(d);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list1;
	}
	
	public boolean addThuthu(Librarians s) {
		
		Connection conn;
		String sql = "INSERT INTO Thuthu_XD3901(Ma_thu_thu,Ten_thu_thu,Gioi_tinh,Ngay_sinh,CMND,Email,Dien_thoai)" +""
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getmatt());
			ps.setString(2, s.gettentt());
			ps.setString(3, s.getgttt());
			ps.setDate(4, new Date(s.getngaysinhtt().getTime()));
			ps.setString(5, s.getcmndtt());
			ps.setString(6, s.getemailtt());
			ps.setString(7, s.getsdttt());
			
			return ps.executeUpdate() > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
    }

}
