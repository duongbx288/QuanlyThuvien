package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.BooksController;
import controller.ReturningsController;
import input.InputFrame;
import input.ReturnInputFrame;
import model.Books;
import model.Returnings;
import net.proteanit.sql.DbUtils;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class ReturningsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model;
	public ArrayList<Returnings> list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField MaMT;
	private JTextField Masach;
	private JLabel lblMMnTr;
	private JLabel lblMSch;
	private JLabel lblTrngThiSch;
	private JTextField trangthai;
	private JButton Sua;
	
	public void showTable() {
		for (Returnings s : list) {
			model.addRow(new Object[]{
				s.getMamt(), s.getMasach(), s.getNgaytra(), s.getTrangthai(), s.getTienphat(), s.getGhichu()
			});
		}
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
		         cell.setCellValue(resultSet.getString("Ma_muon_tra"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Ma_sach"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getDate("Ngay_tra"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("Trang_thai_sach"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getInt("Tien_phat"));
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Ghi_chu"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinTrasach.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinTrasach.xlsx written successfully");
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
					ReturningsFrame frame = new ReturningsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReturningsFrame() {
		setTitle("Chi_tiết_trả_sách_XD3901");
		list = new ReturningsController().getListMuontra();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 100, 1264, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 115, 977, 441);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma_muon_tra", "Ma_sach", "Ngay_tra", "Trang_thai_sach", "Tien_phat", "Ghi_chu"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(172);
		table.setRowHeight(table.getRowHeight()+20);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnInputFrame inputfrm = new ReturnInputFrame();
				inputfrm.setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 69, 115, 36);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {  
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
			      String query = "SELECT * FROM Chitiet_Muon_XD3901";
			      PreparedStatement st = conn.prepareStatement(query);
			      ResultSet rs = st.executeQuery();
			      table.setModel(DbUtils.resultSetToTableModel(rs));
					table.getColumnModel().getColumn(3).setPreferredWidth(93);
					table.getColumnModel().getColumn(5).setPreferredWidth(172);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		btnNewButton_1.setBounds(180, 69, 115, 36);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				if (row1 == -1) {
					
				} else {
				int opt = JOptionPane.showConfirmDialog(null,"Are u sure to delete the information","Xóa thông tin trả sách",JOptionPane.YES_NO_OPTION);
				if(opt == 0) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value = (table.getModel().getValueAt(row, 0).toString());
				String query = "DELETE  FROM Chitiet_Muon_XD3901 WHERE [Ma_muon_tra] = '"+value+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Chitiet_Muon_XD3901";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(3).setPreferredWidth(93);
				table.getColumnModel().getColumn(5).setPreferredWidth(172);
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
				}
			}
		});
		btnNewButton_2.setBounds(315, 69, 115, 36);
		contentPane.add(btnNewButton_2);
		
		Sua = new JButton("Sửa");
		Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value0 = (table.getModel().getValueAt(row, 0).toString());
				String value1 = (table.getModel().getValueAt(row, 1).toString());
				String value2 = (table.getModel().getValueAt(row, 2).toString());
				String value3 = (table.getModel().getValueAt(row, 3).toString());
				int value4 = Integer.parseInt( table.getValueAt(row, 4).toString());
				String value5 = (table.getModel().getValueAt(row, 5).toString());
				String query = "UPDATE Chitiet_Muon_XD3901 SET Ma_muon_tra = '"+value0+"', Ma_sach = '"+value1+"', Ngay_tra = '"+value2+"', Trang_thai_sach = N\'"+value3+"', Tien_phat = '"+value4+"', Ghi_chu = N\'"+value5+"' WHERE [Ma_muon_tra] = '"+value0+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Chitiet_Muon_XD3901";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(3).setPreferredWidth(93);
				table.getColumnModel().getColumn(5).setPreferredWidth(172);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		Sua.setFont(new Font("Dialog", Font.PLAIN, 14));
		Sua.setBounds(455, 69, 115, 36);
		contentPane.add(Sua);
		
		
		btnNewButton_3 = new JButton("Trở lại");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeFrame hmfrm = new HomeFrame();
				hmfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_3.setBounds(593, 69, 115, 36);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try { 
					  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
					  String query = "SELECT * FROM Chitiet_Muon_XD3901 WHERE Ma_muon_tra LIKE '%" + MaMT.getText() + "%' AND Ma_sach LIKE '%" + Masach.getText() + "%' AND Trang_thai_sach LIKE N\'%"+  trangthai.getText() +"%' ";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 
						table.getColumnModel().getColumn(3).setPreferredWidth(93);
						table.getColumnModel().getColumn(5).setPreferredWidth(172);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_4.setBounds(1029, 125, 115, 36);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Xuất file Excel");
		btnNewButton_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TrasachExcel();
					Process process = Runtime.getRuntime().exec("cmd /c start ThongtinTrasach.xlsx ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(1029, 407, 115, 33);
		contentPane.add(btnNewButton_5);
		
		
		MaMT = new JTextField();
		MaMT.setColumns(10);
		MaMT.setBounds(1113, 183, 115, 36);
		contentPane.add(MaMT);
		
		Masach = new JTextField();
		Masach.setColumns(10);
		Masach.setBounds(1113, 255, 115, 36);
		contentPane.add(Masach);
		
		trangthai = new JTextField();
		trangthai.setColumns(10);
		trangthai.setBounds(1113, 327, 115, 36);
		contentPane.add(trangthai);
		
		lblMMnTr = new JLabel("Mã mượn trả");
		lblMMnTr.setBounds(1019, 187, 84, 26);
		contentPane.add(lblMMnTr);
		
		lblMSch = new JLabel("Mã sách");
		lblMSch.setBounds(1019, 259, 84, 26);
		contentPane.add(lblMSch);
		
		lblTrngThiSch = new JLabel("Trạng thái");
		lblTrngThiSch.setBounds(1019, 327, 67, 19);
		contentPane.add(lblTrngThiSch);
		
		JLabel lblTrngThiSch_1 = new JLabel("sách");
		lblTrngThiSch_1.setBounds(1019, 360, 59, 13);
		contentPane.add(lblTrngThiSch_1);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin trả sách");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(40, 10, 241, 55);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBackground(new Color(210, 105, 30));
		Nen1.setBounds(24, 10, 1216, 95);
		Nen1.setOpaque(true);
		contentPane.add(Nen1);
		
		JLabel Nen2 = new JLabel("");
		Nen2.setBackground(new Color(184, 134, 11));
		Nen2.setBounds(1012, 116, 228, 346);
		Nen2.setOpaque(true);
		contentPane.add(Nen2);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 1254, 585);
	    ImageIcon icon = new ImageIcon("icontoUse/Old-Library-Wallpaper.jpg");
	    Nen0.setIcon(icon);
		contentPane.add(Nen0);
		
		
        model = (DefaultTableModel) table.getModel();
        showTable();
        this.setLocationRelativeTo(null);
	}

}
