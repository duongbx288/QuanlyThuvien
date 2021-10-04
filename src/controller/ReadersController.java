package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Readers;

public class ReadersController {
	public Connection conn = null;
	
	public ArrayList<Readers> getListDocgia(){
		ArrayList<Readers> list1 = new ArrayList<>();
		String sql = "SELECT * FROM DocGia_XD3901";
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Readers d = new Readers();
				d.setmadg(rs.getString("Ma_doc_gia"));
				d.settendg(rs.getString("Ten_doc_gia"));
				d.setgioitinhdg(rs.getString("Gioi_tinh"));
				d.setdiachidg(rs.getString("Dia_chi"));
				d.setnsinhdg(rs.getDate("Ngay_sinh"));
			    d.setcmnddg(rs.getString("CMND"));	
			    d.setemaildg(rs.getString("Email"));
			    d.setsdtdg(rs.getString("Dien_thoai"));
			    list1.add(d);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list1;
	}
		
	public boolean addDocgia(Readers s) {
		String sql = "INSERT INTO Docgia_XD3901(Ma_doc_gia,Ten_doc_gia,Gioi_tinh,Dia_chi,Ngay_sinh,CMND,Email,Dien_thoai)" +""
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getmadg());
			ps.setString(2, s.gettendg());
			ps.setString(3, s.getgioitinhdg());
			ps.setString(4, s.getdiachidg());
			ps.setDate(5, new Date(s.getnsinhdg().getTime()));
			ps.setString(6, s.getcmnddg());
			ps.setString(7, s.getemaildg());
			ps.setString(8, s.getsdtdg());
			
			return ps.executeUpdate() > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
