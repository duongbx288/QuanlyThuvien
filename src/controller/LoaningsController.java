package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Loanings;

public class LoaningsController {
	public Connection conn = null;
	
	public ArrayList<Loanings> getListMuontra(){
		ArrayList<Loanings> list1 = new ArrayList<>();
		String sql = "SELECT * FROM Muontra_XD3901";
		Connection conn;
		try { 
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Loanings d = new Loanings();
				d.setmamt1(rs.getString("Ma_muon_tra"));
				d.setmadg1(rs.getString("Ma_doc_gia"));
				d.setmatt1(rs.getString("Ma_thu_thu"));
				d.setnmuon(rs.getDate("Ngay_muon"));
			    d.setnhentra(rs.getDate("Ngay_hen_tra"));	
			    d.settiencoc(rs.getString("Tien_coc"));
			    list1.add(d);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list1;
	}
	
	public boolean addDonmuontra(Loanings s) {
		Connection conn;
		String sql = "INSERT INTO Muontra_XD3901(Ma_muon_tra,Ma_doc_gia,Ma_thu_thu,Ngay_muon,Ngay_hen_tra,Tien_coc)" +""
				+ "VALUES(?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getmamt1());
			ps.setString(2, s.getmadg1());
			ps.setString(3, s.getmatt1());
			ps.setDate(4, new Date(s.getnmuon().getTime()));
			ps.setDate(5, new Date(s.getnhentra().getTime()));
			ps.setString(6, s.gettiencoc());

			return ps.executeUpdate() > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}} catch(SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
}
