package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Books;

public class BooksController {
	public Connection conn = null;
	
	public BooksController() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			System.out.println("Ket noi thanh cong");
		} catch(Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace(); 
		}
	}
	
	public boolean addSach(Books s) {
		Connection conn;
		String sql = "INSERT INTO Sach_XD3901(Ma_sach,Ten_sach,Tac_gia,Nha_XB,Ngay_XB,Don_gia,Gioi_thieu)" +""
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getmasach());
			ps.setString(2, s.gettensach());
			ps.setString(3, s.gettacgia());
			ps.setString(4, s.getnhaxb());
			ps.setDate(5, new Date(s.getngayxb().getTime()));
			ps.setInt(6, s.getdongia());
			ps.setString(7, s.getgthieu());
			
			return ps.executeUpdate() > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}} catch(SQLException e2) {
			
			e2.printStackTrace();
			
		}
		return false;
	}
	
	public ArrayList<Books> getListSach(){
		ArrayList<Books> list = new ArrayList<>();
		String sql = "SELECT * FROM Sach_XD3901";
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Books s = new Books();
				s.setmasach(rs.getString("Ma_sach"));
				s.settensach(rs.getString("Ten_sach"));
				s.settacgia(rs.getString("Tac_gia"));
				s.setnhaxb(rs.getString("Nha_XB"));
				s.setngayxb(rs.getDate("Ngay_XB"));
				s.setdongia(rs.getInt("Don_gia"));
			    s.setgthieu(rs.getString("Gioi_thieu"));	
			    
			    list.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args){
        new BooksController();
	}
}
