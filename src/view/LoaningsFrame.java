package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import controller.LoaningsController;
import controller.ReadersController;
import input.LoaningInputFrame;
import model.Loanings;
import net.proteanit.sql.DbUtils;

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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;


public class LoaningsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model;
	public ArrayList<Loanings> list;
	private JTextField mamt;
	private JTextField madg;
	private JTextField matt;

	public void showTable() {
		for (Loanings s : list) {
			model.addRow(new Object[]{
				s.getmamt1(), s.getmadg1(), s.getmatt1(), s.getnmuon(), s.getnhentra(), s.gettiencoc()
			});
		}
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
		         cell.setCellValue(resultSet.getString("Ma_muon_tra"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Ma_doc_gia"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Ma_thu_thu"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getDate("Ngay_muon"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("Ngay_hen_tra"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Tien_coc"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinMuontra.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinMuontra.xlsx written successfully");
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
					LoaningsFrame frame = new LoaningsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoaningsFrame() {
		
		setTitle("Mượn_trảXD3901");
		list = new LoaningsController().getListMuontra();
		
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u01A1n cho m\u01B0\u1EE3n s\u00E1ch", "M\u00E3 \u0111\u1ED9c gi\u1EA3", "M\u00E3 th\u1EE7 th\u01B0", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y h\u1EB9n tr\u1EA3", "Ti\u1EC1n c\u1ECDc"
			}
		));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight()+20);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaningInputFrame inputfrm = new LoaningInputFrame();
				inputfrm.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 69, 115, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				      String query = "SELECT * FROM Muontra_XD3901";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBounds(170, 69, 115, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				if(row1 == -1) {
					
				} else {
				int opt = JOptionPane.showConfirmDialog(null,"Are u sure to delete the chosen information","Xóa thông tin đơn mượn sách",JOptionPane.YES_NO_OPTION);
				if(opt == 0) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value = (table.getModel().getValueAt(row, 0).toString());
				String query = "DELETE  FROM Muontra_XD3901 WHERE [Ma_muon_tra] = '"+value+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Muontra_XD3901 ";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs)); 
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
				}
			}
		});
		btnNewButton_2.setBounds(308, 69, 115, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Sửa");
		btnNewButton_5.addActionListener(new ActionListener() {
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
				String query = "UPDATE Muontra_XD3901 SET Ma_muon_tra = '"+value0+"', Ma_doc_gia = '"+value1+"', Ma_thu_thu = '"+value2+"', Ngay_muon = '"+value3+"', Ngay_hen_tra = '"+value4+"', Tien_coc = '"+value5+"' WHERE [Ma_muon_tra] = '"+value0+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM Muontra_XD3901 ";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs)); 
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		btnNewButton_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_5.setBounds(444, 69, 115, 36);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				      String query = "SELECT * FROM Muontra_XD3901 WHERE Ma_muon_tra LIKE '%" + mamt.getText() + "%' AND Ma_doc_gia LIKE N\'%" + madg.getText() + "%' AND Ma_thu_thu LIKE N\'%" + matt.getText() + "%'";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_3.setBounds(1026, 127, 115, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Xuất file Excel");
		btnNewButton_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MuonsachExcel();
					Process process = Runtime.getRuntime().exec("cmd /c start ThongtinMuontra.xlsx ");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane,"Có lỗi khi xuất file Excel");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setBounds(1026, 388, 115, 36);
		contentPane.add(btnNewButton_3_1);

		
		mamt = new JTextField();
		mamt.setColumns(10);
		mamt.setBounds(1095, 195, 115, 36);
		contentPane.add(mamt);
		
		madg = new JTextField();
		madg.setColumns(10);
		madg.setBounds(1095, 258, 115, 36);
		contentPane.add(madg);
		
		matt = new JTextField();
		matt.setColumns(10);
		matt.setBounds(1095, 322, 115, 36);
		contentPane.add(matt);
		
		JLabel lblMnCho = new JLabel("Mã đơn cho");
		lblMnCho.setBounds(1018, 195, 67, 18);
		contentPane.add(lblMnCho);
		
		JLabel lblMcGi_1 = new JLabel("Mã độc giả");
		lblMcGi_1.setBounds(1018, 258, 67, 26);
		contentPane.add(lblMcGi_1);
		
		JLabel lblMThTh = new JLabel("Mã thủ thư");
		lblMThTh.setBounds(1018, 322, 67, 26);
		contentPane.add(lblMThTh);
		
		JLabel lblMnSch = new JLabel("mượn sách");
		lblMnSch.setBounds(1018, 213, 67, 18);
		contentPane.add(lblMnSch);
		
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
		btnNewButton_2_1.setBounds(582, 69, 115, 36);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin mượn sách");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(40, 10, 241, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBackground(new Color(210, 105, 30));
		Nen1.setBounds(27, 10, 1200, 95);
		Nen1.setOpaque(true);
		contentPane.add(Nen1);
		
		JLabel Nen2 = new JLabel("");
		Nen2.setBackground(new Color(184, 134, 11));
		Nen2.setBounds(1012, 116, 215, 346);
		Nen2.setOpaque(true);
		contentPane.add(Nen2);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 1254, 569);
		ImageIcon icon = new ImageIcon("icontoUse/Huge-Library-Wallpaper.jpg");
		Nen0.setIcon(icon);
		contentPane.add(Nen0);
		
		JButton btnNewButton_2_1_1 = new JButton("Sửa");
		btnNewButton_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBounds(582, 69, 115, 36);
		contentPane.add(btnNewButton_2_1_1);
		    
        model = (DefaultTableModel) table.getModel();
        showTable();
	}
}
