package controller;

import java.io.File;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelController {
	
	public ExcelController() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			System.out.println("Ket noi thanh cong");
		} catch(Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace(); 
		}
	}
	
	   public static void SachExcel() throws Exception {
		      Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD"
		      );
		      
		      Statement statement = connect.createStatement();
		      ResultSet resultSet = statement.executeQuery("select * from Sach_XD3901");
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("Sách");
		      XSSFCreationHelper createHelper = workbook.getCreationHelper();
		      XSSFCellStyle cellStyle         = workbook.createCellStyle();
		      cellStyle.setDataFormat(
		      createHelper.createDataFormat().getFormat("MMMM dd, yyyy")); 
		      spreadsheet.setDefaultColumnWidth(20);
		      XSSFRow row = spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell = row.createCell(1);
		      cell.setCellValue("ID Sách");
		      cell = row.createCell(2);
		      cell.setCellValue("Tên sách");
		      cell = row.createCell(3);
		      cell.setCellValue("Tên tác giả");
		      cell = row.createCell(4);
		      cell.setCellValue("Nhà XB");
		      cell = row.createCell(5);	
		      cell.setCellValue(new Date());
		      cell.setCellValue("Ngày xuất bản sách");
		      cell = row.createCell(6);
		      cell.setCellValue("Đơn giá");
		      cell = row.createCell(7);
		      cell.setCellValue("Giới thiệu");

		      int i = 2;

		      while(resultSet.next()) {
		         row = spreadsheet.createRow(i);
		         cell = row.createCell(1);
		         cell.setCellValue(resultSet.getString("Masach_20183901"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Tensach_20183901"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Tacgia_20183901"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("NhaXB_20183901"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("NamXB_20183901"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getInt("Dongia_20183901"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Gioithieu_20183901"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("Thongtinsach.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("Thongtinsach.xlsx written successfully");
		      workbook.close();
		   }
	   
	   public static void DocgiaExcel() throws Exception {
		      Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD"
		      );
		      
		      Statement statement = connect.createStatement();
		      ResultSet resultSet = statement.executeQuery("select * from DocGia_XD3901");
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("Độc giả của thư viện");
		      XSSFCreationHelper createHelper = workbook.getCreationHelper();
		      XSSFCellStyle cellStyle         = workbook.createCellStyle();
		      cellStyle.setDataFormat(
		      createHelper.createDataFormat().getFormat("MMMM dd, yyyy")); 
		      spreadsheet.setDefaultColumnWidth(20);
		      XSSFRow row = spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell = row.createCell(1);
		      cell.setCellValue("ID Độc giả");
		      cell = row.createCell(2);
		      cell.setCellValue("Tên độc giả");
		      cell = row.createCell(3);
		      cell.setCellValue("Giới tính");
		      cell = row.createCell(4);
		      cell.setCellValue("Địa chỉ");
		      cell = row.createCell(5);	
		      cell.setCellValue("Ngày sinh");
		      cell = row.createCell(6);
		      cell.setCellValue("CMND");
		      cell = row.createCell(7);
		      cell.setCellValue("Email");
		      cell = row.createCell(8);
		      cell.setCellValue("Điện thoại");
		      int i = 2;

		      while(resultSet.next()) {
		         row = spreadsheet.createRow(i);
		         cell = row.createCell(1);
		         cell.setCellValue(resultSet.getString("MaDG_20183901"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("TenDG_20183901"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Gioitinh_20183901"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("Diachi_20183901"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("NSinh_20183901"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("CMND_20183901"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Email_20183901"));
		         cell = row.createCell(8);
		         cell.setCellValue(resultSet.getString("DThoai_20183901"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinDocgia.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinDocgia.xlsx written successfully");
		      workbook.close();
		   }
	   
	   public static void ThuthuExcel() throws Exception {
		      Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD"
		      );
		      
		      Statement statement = connect.createStatement();
		      ResultSet resultSet = statement.executeQuery("select * from Thuthu_XD3901");
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("Thủ thư");
		      XSSFCreationHelper createHelper = workbook.getCreationHelper();
		      XSSFCellStyle cellStyle         = workbook.createCellStyle();
		      cellStyle.setDataFormat(
		      createHelper.createDataFormat().getFormat("MMMM dd, yyyy")); 
		      spreadsheet.setDefaultColumnWidth(20);
		      XSSFRow row = spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell = row.createCell(1);
		      cell.setCellValue("ID Thủ thư");
		      cell = row.createCell(2);
		      cell.setCellValue("Tên thủ thư");
		      cell = row.createCell(3);
		      cell.setCellValue("Giới tính");
		      cell = row.createCell(4);
		      cell.setCellValue("Ngày sinh");
		      cell = row.createCell(5);	
		      cell.setCellValue("CMND");
		      cell = row.createCell(6);
		      cell.setCellValue("Email");
		      cell = row.createCell(7);
		      cell.setCellValue("Điện thoại");
		      int i = 2;

		      while(resultSet.next()) {
		         row = spreadsheet.createRow(i);
		         cell = row.createCell(1);
		         cell.setCellValue(resultSet.getString("MaTT_20183901"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("TenTT_20183901"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Gioitinh_20183901"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getDate("NSinh_20183901"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getString("CMND_20183901"));
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Email_20183901"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Dienthoai_20183901"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinThuthu.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinThuthu.xlsx written successfully");
		      workbook.close();
		   }
	   
	   public static void MuonsachExcel() throws Exception {
		      Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD"
		      );
		      
		      Statement statement = connect.createStatement();
		      ResultSet resultSet = statement.executeQuery("select * from Muontra_XD3901");
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("Đơn mượn sách");
		      XSSFCreationHelper createHelper = workbook.getCreationHelper();
		      XSSFCellStyle cellStyle         = workbook.createCellStyle();
		      cellStyle.setDataFormat(
		      createHelper.createDataFormat().getFormat("MMMM dd, yyyy")); 
		      spreadsheet.setDefaultColumnWidth(20);
		      XSSFRow row = spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell = row.createCell(1);
		      cell.setCellValue("Mã đơn mượn trả");
		      cell = row.createCell(2);
		      cell.setCellValue("Mã độc giả");
		      cell = row.createCell(3);
		      cell.setCellValue("Mã thủ thư");
		      cell = row.createCell(4);
		      cell.setCellValue("Ngày mượn");
		      cell = row.createCell(5);	
		      cell.setCellValue("Ngày hẹn trả");
		      cell = row.createCell(6);
		      cell.setCellValue("Tiền cọc");
		      int i = 2;

		      while(resultSet.next()) {
		         row = spreadsheet.createRow(i);
		         cell = row.createCell(1);
		         cell.setCellValue(resultSet.getString("MaMT_20183901"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("MaDG_20183901"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("MaTT_20183901"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getDate("Ngay_muon"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("Ngay_hentra"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Tiencoc_20183901"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinMuontra.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinMuontra.xlsx written successfully");
		      workbook.close();
		   }
	   
	   public static void TrasachExcel() throws Exception {
		      Connection connect = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD"
		      );
		      
		      Statement statement = connect.createStatement();
		      ResultSet resultSet = statement.executeQuery("select * from Chitiet_Muon_XD3901");
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("Trả sách");
		      XSSFCreationHelper createHelper = workbook.getCreationHelper();
		      XSSFCellStyle cellStyle         = workbook.createCellStyle();
		      cellStyle.setDataFormat(
		      createHelper.createDataFormat().getFormat("MMMM dd, yyyy")); 
		      spreadsheet.setDefaultColumnWidth(20);
		      XSSFRow row = spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell = row.createCell(1);
		      cell.setCellValue("Mã đơn mượn sách");
		      cell = row.createCell(2);
		      cell.setCellValue("Mã sách");
		      cell = row.createCell(3);
		      cell.setCellValue("Ngày trả sách");
		      cell = row.createCell(4);
		      cell.setCellValue("Trạng thái sách");
		      cell = row.createCell(5);	
		      cell.setCellValue("Tiền phạt");
		      cell = row.createCell(6);
		      cell.setCellValue("Ghi chú");
		      int i = 2;

		      while(resultSet.next()) {
		         row = spreadsheet.createRow(i);
		         cell = row.createCell(1);
		         cell.setCellValue(resultSet.getString("MaMT_20183901"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Masach_20183901"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getDate("Ngay_tra_20183901"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("Trang_Thai_sach"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getInt("Tien_phat"));
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Ghi_chu_20183901"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinTrasach.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinTrasach.xlsx written successfully");
		      workbook.close();
		   }
	   
	   public static void main(String[] args) throws Exception{
	        new ExcelController();
	        SachExcel();
	        DocgiaExcel();
	        ThuthuExcel();
	        MuonsachExcel();
	        TrasachExcel();
	        
		}
}
