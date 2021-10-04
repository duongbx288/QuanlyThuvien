package view;

import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.BooksController;
import input.InputFrame;
import model.Books;

import javax.swing.UIManager;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class BookFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model;
	public ArrayList<Books> list;
	private JTextField bookID;
	private JTextField bookName;
	private JTextField tacgiaSach;
	private JTextField NXB;

	public void showTable() {
		for (Books s : list) {
			model.addRow(new Object[]{
				s.getmasach(), s.gettensach(), s.gettacgia(), s.getnhaxb(), s.getngayxb(), s.getdongia(), s.getgthieu()
			});
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
		         cell.setCellValue(resultSet.getString("Ma_sach"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Ten_sach"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Tac_gia"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("Nha_XB"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("Ngay_XB"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getInt("Don_gia"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Gioi_thieu"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("Thongtinsach.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("Thongtinsach.xlsx written successfully");
		      workbook.close();
		   }
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookFrame frame = new BookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookFrame() {
		
		setTitle("Sách_XD3901");
		list = new BooksController().getListSach();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 115, 977, 441);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Nh\u00E0 XB", "Ng\u00E0y XB", "\u0110\u01A1n gi\u00E1", "Gi\u1EDBi thi\u1EC7u"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		table.getColumnModel().getColumn(4).setPreferredWidth(78);
		table.getColumnModel().getColumn(5).setPreferredWidth(43);
		table.getColumnModel().getColumn(6).setPreferredWidth(104);
		table.setRowHeight(table.getRowHeight()+20);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputFrame inputfrm = new InputFrame();
				inputfrm.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 69, 115, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {  
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			      String query = "SELECT * FROM Sach_XD3901";
			      PreparedStatement st = conn.prepareStatement(query);
			      ResultSet rs = st.executeQuery();
			      table.setModel(DbUtils.resultSetToTableModel(rs));
					table.getColumnModel().getColumn(0).setPreferredWidth(38);
					table.getColumnModel().getColumn(1).setPreferredWidth(136);
					table.getColumnModel().getColumn(2).setPreferredWidth(111);
					table.getColumnModel().getColumn(3).setPreferredWidth(111);
					table.getColumnModel().getColumn(4).setPreferredWidth(78);
					table.getColumnModel().getColumn(5).setPreferredWidth(43);
					table.getColumnModel().getColumn(6).setPreferredWidth(104);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		btnNewButton_1.setBounds(173, 69, 115, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				if(row1 == -1) {
					
				} else {
				int opt = JOptionPane.showConfirmDialog(null,"Are u sure to delete this book","Xóa thông tin sách",JOptionPane.YES_NO_OPTION);
				if(opt == 0) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value = (table.getModel().getValueAt(row, 0).toString());
				String query = "DELETE  FROM Sach_XD3901 WHERE [Ma_sach] = '"+value+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Sach_XD3901";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(0).setPreferredWidth(38);
				table.getColumnModel().getColumn(1).setPreferredWidth(136);
				table.getColumnModel().getColumn(2).setPreferredWidth(111);
				table.getColumnModel().getColumn(3).setPreferredWidth(111);
				table.getColumnModel().getColumn(4).setPreferredWidth(78);
				table.getColumnModel().getColumn(5).setPreferredWidth(43);
				table.getColumnModel().getColumn(6).setPreferredWidth(104);
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
				}
				}
		});
		btnNewButton_2.setBounds(318, 69, 115, 36);
		contentPane.add(btnNewButton_2);
		
		bookID = new JTextField();
		bookID.setBounds(1101, 178, 115, 36);
		contentPane.add(bookID);
		bookID.setColumns(10);
		
		bookName = new JTextField();
		bookName.setBounds(1101, 239, 115, 36);
		contentPane.add(bookName);
		bookName.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			      String query = "SELECT * FROM Sach_XD3901 WHERE Ma_sach LIKE '%" + bookID.getText() + "%' AND Ten_sach LIKE N\'%" + bookName.getText() + "%' AND Tac_gia LIKE '%" + tacgiaSach.getText() + "%' AND Nha_XB LIKE '%" + NXB.getText() + "%'";
			      PreparedStatement st = conn.prepareStatement(query);
			      ResultSet rs = st.executeQuery();
			      table.setModel(DbUtils.resultSetToTableModel(rs)); 
					table.getColumnModel().getColumn(0).setPreferredWidth(38);
					table.getColumnModel().getColumn(1).setPreferredWidth(136);
					table.getColumnModel().getColumn(2).setPreferredWidth(111);
					table.getColumnModel().getColumn(3).setPreferredWidth(111);
					table.getColumnModel().getColumn(4).setPreferredWidth(78);
					table.getColumnModel().getColumn(5).setPreferredWidth(43);
					table.getColumnModel().getColumn(6).setPreferredWidth(104);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(1031, 130, 141, 36);
		contentPane.add(btnNewButton_3);
		
		JButton Sửa = new JButton("Sửa");
		Sửa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value0 = (table.getModel().getValueAt(row, 0).toString());
				String value1 = (table.getModel().getValueAt(row, 1).toString());
				String value2 = (table.getModel().getValueAt(row, 2).toString());
				String value3 = (table.getModel().getValueAt(row, 3).toString());
				String value4 = (table.getModel().getValueAt(row, 4).toString());
				int value5 = Integer.parseInt( table.getValueAt(row, 5).toString());
				String value6 = (table.getModel().getValueAt(row, 6).toString());
				String query = "UPDATE Sach_XD3901 SET Ma_sach = '" +value0+ "',Ten_sach = N\'"+value1+"',Tac_gia = '"+value2+"', Nha_XB = '"+value3+"', Ngay_XB ='"+value4+"', Don_gia = '"+value5+"', Gioi_thieu = '"+value6+"'WHERE [Ma_sach] = '"+value0+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Sach_XD3901";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(0).setPreferredWidth(38);
				table.getColumnModel().getColumn(1).setPreferredWidth(136);
				table.getColumnModel().getColumn(2).setPreferredWidth(111);
				table.getColumnModel().getColumn(3).setPreferredWidth(111);
				table.getColumnModel().getColumn(4).setPreferredWidth(78);
				table.getColumnModel().getColumn(5).setPreferredWidth(43);
				table.getColumnModel().getColumn(6).setPreferredWidth(104);
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
		});
		Sửa.setFont(new Font("Dialog", Font.PLAIN, 14));
		Sửa.setBounds(470, 69, 115, 36);
		contentPane.add(Sửa);
		
		JLabel lblNewLabel = new JLabel("ID sách");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1024, 182, 67, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sách");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(1024, 243, 67, 26);
		contentPane.add(lblNewLabel_1);
		
		tacgiaSach = new JTextField();
		tacgiaSach.setBounds(1101, 299, 115, 36);
		contentPane.add(tacgiaSach);
		tacgiaSach.setColumns(10);
		
		NXB = new JTextField();
		NXB.setBounds(1101, 363, 115, 36);
		contentPane.add(NXB);
		NXB.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tác giả");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(1024, 304, 67, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà XB");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(1024, 367, 67, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Trở lại");
		btnNewButton_2_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeFrame hmfrm = new HomeFrame();
				hmfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(618, 69, 115, 36);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Xuất file Excel");
		btnNewButton_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SachExcel();
					Process process = Runtime.getRuntime().exec("cmd /c start Thongtinsach.xlsx ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setBounds(1031, 413, 141, 36);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin sách");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(40, 10, 241, 55);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBackground(new Color(210, 105, 30));
		Nen1.setBounds(25, 10, 1204, 95);
		Nen1.setOpaque(true);
		contentPane.add(Nen1);
		
		JLabel Nen2 = new JLabel("");
		Nen2.setBackground(new Color(184, 134, 11));
		Nen2.setOpaque(true);
		Nen2.setBounds(1012, 116, 217, 346);
		contentPane.add(Nen2);
		
		JLabel Nen0 = new JLabel("New label");
		Nen0.setBounds(0, 0, 1254, 585);
	    ImageIcon icon = new ImageIcon("icontoUse/Full-HD-Library-Wallpaper.jpg");
	    Nen0.setIcon(icon);
		contentPane.add(Nen0);
		
        model = (DefaultTableModel) table.getModel();
        showTable();
	}
}
