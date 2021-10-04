package view;

import java.awt.EventQueue;
import java.util.ArrayList;

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
import controller.ReadersController;
import input.ReadinputFrame;
import model.Readers;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;

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
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReadersFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model;
	public ArrayList<Readers> list;
	private JTextField IDdocgia;
	private JTextField tendocgia;
	private JTextField diachidg;
	private JTextField sdtdg;
	String value;
	
	public void showTable() {
		for (Readers s : list) {
			model.addRow(new Object[]{
				s.getmadg(), s.gettendg(), s.getgioitinhdg(), s.getdiachidg(), s.getnsinhdg(), s.getcmnddg(), s.getemaildg(), s.getsdtdg()
			});
		}
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
		         cell.setCellValue(resultSet.getString("Ma_doc_gia"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Ten_doc_gia"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Gioi_tinh"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getString("Dia_chi"));
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getDate("Ngay_sinh"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("CMND"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Email"));
		         cell = row.createCell(8);
		         cell.setCellValue(resultSet.getString("Dien_thoai"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinDocgia.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinDocgia.xlsx written successfully");
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
					ReadersFrame frame = new ReadersFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReadersFrame() {
		setTitle("Độc_giảXD3901");
		list = new ReadersController().getListDocgia();
		
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
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u1ED9c gi\u1EA3", "T\u00EAn \u0111\u1ED9c gi\u1EA3", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y sinh", "CMND", "Email", "\u0110i\u1EC7n tho\u1EA1i"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(165);
		table.getColumnModel().getColumn(4).setPreferredWidth(56);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(105);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight()+20);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadinputFrame inputfrm = new ReadinputFrame();
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
				      String query = "SELECT * FROM DocGia_XD3901 ";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 
						table.getColumnModel().getColumn(0).setPreferredWidth(40);
						table.getColumnModel().getColumn(1).setPreferredWidth(90);
						table.getColumnModel().getColumn(2).setPreferredWidth(45);
						table.getColumnModel().getColumn(3).setPreferredWidth(165);
						table.getColumnModel().getColumn(4).setPreferredWidth(56);
						table.getColumnModel().getColumn(5).setPreferredWidth(55);
						table.getColumnModel().getColumn(6).setPreferredWidth(105);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBounds(165, 69, 115, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				if(row1 == -1) {
					
				} else {
				int opt = JOptionPane.showConfirmDialog(null,"Are u sure to delete this information","Xóa dữ liệu về độc giả",JOptionPane.YES_NO_OPTION);
				if(opt == 0) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value = (table.getModel().getValueAt(row, 0).toString());
				String query = "DELETE FROM Docgia_XD3901 WHERE [Ma_doc_gia] = '"+value+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM DocGia_XD3901 ";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(45);
				table.getColumnModel().getColumn(3).setPreferredWidth(165);
				table.getColumnModel().getColumn(4).setPreferredWidth(56);
				table.getColumnModel().getColumn(5).setPreferredWidth(55);
				table.getColumnModel().getColumn(6).setPreferredWidth(105);
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
				}
			}
		});
		btnNewButton_2.setBounds(304, 69, 115, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
					      String query = "SELECT * FROM DocGia_XD3901 WHERE Ma_doc_gia LIKE '%" + IDdocgia.getText() + "%' AND Ten_doc_gia LIKE N\'%" + tendocgia.getText() + "%' AND Gioi_tinh LIKE N\'%" + value + "%' AND Dia_chi LIKE N\'%" + diachidg.getText() +"%' AND Dien_thoai LIKE '%" + sdtdg.getText() + "%'";
					      PreparedStatement st = conn.prepareStatement(query);
					      ResultSet rs = st.executeQuery();
					      table.setModel(DbUtils.resultSetToTableModel(rs)); 
							table.getColumnModel().getColumn(0).setPreferredWidth(40);
							table.getColumnModel().getColumn(1).setPreferredWidth(90);
							table.getColumnModel().getColumn(2).setPreferredWidth(45);
							table.getColumnModel().getColumn(3).setPreferredWidth(165);
							table.getColumnModel().getColumn(4).setPreferredWidth(56);
							table.getColumnModel().getColumn(5).setPreferredWidth(55);
							table.getColumnModel().getColumn(6).setPreferredWidth(105);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			}
		});
		btnNewButton_3.setBounds(1032, 126, 115, 36);
		contentPane.add(btnNewButton_3);
		
		JButton Sua = new JButton("Sửa");
		Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value0 = (table.getModel().getValueAt(row, 0).toString());
				String value1 = (table.getModel().getValueAt(row, 1).toString());
				String value2 = (table.getModel().getValueAt(row, 2).toString());
				String value3 = (table.getModel().getValueAt(row, 3).toString());
				String value4 = (table.getModel().getValueAt(row, 4).toString());
				String value5 = (table.getModel().getValueAt(row, 5).toString());
				String value6 = (table.getModel().getValueAt(row, 6).toString());
				String value7 = (table.getModel().getValueAt(row, 7).toString());
				String query = "UPDATE Docgia_XD3901 SET Ma_doc_gia = '"+value0+"', Ten_doc_gia = N\'"+value1+"', Gioi_tinh = N\'"+value2+"', Dia_chi = N\'"+value3+"', Ngay_sinh = '"+value4+"', CMND = '"+value5+"', Email = '"+value6+"', Dien_thoai = '"+value7+"' WHERE [Ma_doc_gia] = '"+value0+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			    String query1 = "SELECT * FROM DocGia_XD3901 ";
			    PreparedStatement st = conn.prepareStatement(query1);
			    ResultSet rs = st.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(45);
				table.getColumnModel().getColumn(3).setPreferredWidth(165);
				table.getColumnModel().getColumn(4).setPreferredWidth(56);
				table.getColumnModel().getColumn(5).setPreferredWidth(55);
				table.getColumnModel().getColumn(6).setPreferredWidth(105);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		Sua.setFont(new Font("Dialog", Font.PLAIN, 14));
		Sua.setBounds(452, 69, 115, 36);
		contentPane.add(Sua);
		
		IDdocgia = new JTextField();
		IDdocgia.setColumns(10);
		IDdocgia.setBounds(1103, 179, 115, 36);
		contentPane.add(IDdocgia);
		
		tendocgia = new JTextField();
		tendocgia.setColumns(10);
		tendocgia.setBounds(1103, 244, 115, 36);
		contentPane.add(tendocgia);
		
		diachidg = new JTextField();
		diachidg.setColumns(10);
		diachidg.setBounds(1103, 373, 115, 36);
		contentPane.add(diachidg);
		
		sdtdg = new JTextField();
		sdtdg.setColumns(10);
		sdtdg.setBounds(1103, 435, 115, 36);
		contentPane.add(sdtdg);
		
		JLabel lblMcGi = new JLabel("Mã độc giả");
		lblMcGi.setBounds(1020, 184, 67, 26);
		contentPane.add(lblMcGi);
		
		JLabel lblTncGi = new JLabel("Tên độc giả");
		lblTncGi.setBounds(1020, 249, 67, 26);
		contentPane.add(lblTncGi);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(1020, 316, 67, 26);
		contentPane.add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(1020, 378, 67, 26);
		contentPane.add(lblaCh);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(1020, 440, 67, 26);
		contentPane.add(lblinThoi);
		
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
		btnNewButton_2_1.setBounds(596, 69, 115, 36);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Xuất file Excel");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DocgiaExcel();
					Process process = Runtime.getRuntime().exec("cmd /c start ThongtinDocgia.xlsx ");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, "Xuất hiện lỗi khi xuất file");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3_1.setBounds(1032, 482, 115, 36);
		contentPane.add(btnNewButton_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                value = comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		comboBox.setBounds(1103, 306, 115, 36);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin độc giả");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(40, 10, 241, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBackground(new Color(210, 105, 30));
		Nen1.setBounds(25, 10, 1203, 95);
		Nen1.setOpaque(true);
		contentPane.add(Nen1);
		
		JLabel Nen2 = new JLabel("");
		Nen2.setBackground(new Color(184, 134, 11));
		Nen2.setBounds(1012, 115, 216, 412);
		Nen2.setOpaque(true);
		contentPane.add(Nen2);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(12, 0, 1275, 585);
	    ImageIcon icon = new ImageIcon("icontoUse/Library-Wallpaper.jpg");
	    Nen0.setIcon(icon);
		contentPane.add(Nen0);
		

		model = (DefaultTableModel) table.getModel();
        showTable();
	}
}
