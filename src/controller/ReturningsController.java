package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Books;
import model.Returnings;

public class ReturningsController {
    public Connection conn = null;
    
    public ReturningsController() {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			System.out.println("Ket noi thanh cong");
		} catch(Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace(); 
		}
    }
    
	public boolean addTrasach(Returnings s) {
		Connection conn;
		String sql = "INSERT INTO Chitiet_Muon_XD3901(Ma_muon_tra,Ma_sach,Ngay_tra,Trang_thai_sach,Tien_phat,Ghi_chu)" +""
				+ "VALUES(?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getMamt());
			ps.setString(2, s.getMasach());
			ps.setDate(3, new Date(s.getNgaytra().getTime()));
			ps.setString(4, s.getTrangthai());
			ps.setInt(5, s.getTienphat());
			ps.setString(6, s.getGhichu());
			
			return ps.executeUpdate() > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}} catch(SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Returnings> getListMuontra(){
		ArrayList<Returnings> list = new ArrayList<>();
		String sql = "SELECT * FROM Chitiet_Muon_XD3901";
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Returnings s = new Returnings();
				s.setMamt(rs.getString("Ma_muon_tra"));
				s.setMasach(rs.getString("Ma_sach"));
				s.setNgaytra(rs.getDate("Ngay_tra"));
				s.setTrangthai(rs.getString("Trang_thai_sach"));
				s.setTienphat(rs.getInt("Tien_phat"));
				s.setGhichu(rs.getString("Ghi_chu"));
			    
			    list.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list;
	}
}
