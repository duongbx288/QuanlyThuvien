package view;

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

import controller.LibrariansController;
import input.LiinputFrame;
import model.Librarians;
import net.proteanit.sql.DbUtils;

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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class LibrariansFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public ArrayList<Librarians> list;
	DefaultTableModel model;
	private JTextField idtt;
	private JTextField tentt;
	private JTextField sdttt;
	String value;

	public void showTable() {
		for (Librarians s : list) {
			model.addRow(new Object[]{
				s.getmatt(), s.gettentt(), s.getgttt(), s.getngaysinhtt(), s.getcmndtt(), s.getemailtt(), s.getsdttt()
			});
		}
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
		      spreadsheet.setDefaultColumnWidth(25);
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
		         cell.setCellValue(resultSet.getString("Ma_thu_thu"));
		         cell = row.createCell(2);
		         cell.setCellValue(resultSet.getString("Ten_thu_thu"));
		         cell = row.createCell(3);
		         cell.setCellValue(resultSet.getString("Gioi_tinh"));
		         cell = row.createCell(4);
		         cell.setCellValue(resultSet.getDate("Ngay_sinh"));
		         cell.setCellStyle(cellStyle);
		         cell = row.createCell(5);
		         cell.setCellValue(resultSet.getString("CMND"));
		         cell = row.createCell(6);
		         cell.setCellValue(resultSet.getString("Email"));
		         cell = row.createCell(7);
		         cell.setCellValue(resultSet.getString("Dien_thoai"));
		         i++;
		      }

		      FileOutputStream out = new FileOutputStream(new File("ThongtinThuthu.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("ThongtinThuthu.xlsx written successfully");
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
					LibrariansFrame frame = new LibrariansFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibrariansFrame() {
		
		setTitle("Thủ_thưXD3901");
		list = new LibrariansController().getListThuthu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 603);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 115, 977, 441);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u1EE7 th\u01B0", "T\u00EAn th\u1EE7 th\u01B0", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "CMND", "Email", "\u0110i\u1EC7n tho\u1EA1i"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(52);
		table.getColumnModel().getColumn(5).setPreferredWidth(133);
		table.setRowHeight(table.getRowHeight()+20);
		table.setFillsViewportHeight(true);
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiinputFrame inputfrm = new LiinputFrame();
				inputfrm.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 69, 115, 36);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				      String query = "SELECT * FROM Thuthu_XD3901 ";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 
						table.getColumnModel().getColumn(0).setPreferredWidth(55);
						table.getColumnModel().getColumn(1).setPreferredWidth(131);
						table.getColumnModel().getColumn(2).setPreferredWidth(50);
						table.getColumnModel().getColumn(4).setPreferredWidth(52);
						table.getColumnModel().getColumn(5).setPreferredWidth(133);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setBounds(163, 69, 115, 36);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				if(row1 == -1) {
					
				} else {
				int opt = JOptionPane.showConfirmDialog(null,"Are u sure to delete the information","Xóa thông tin thủ thư",JOptionPane.YES_NO_OPTION);
				if(opt == 0) {
				try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				int row = table.getSelectedRow();
				String value = (table.getModel().getValueAt(row, 0).toString());
				String query = "DELETE  FROM Thuthu_XD3901 WHERE [Ma_thu_thu] = '"+value+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			      String query1 = "SELECT * FROM Thuthu_XD3901 ";
			      PreparedStatement st = conn.prepareStatement(query1);
			      ResultSet rs = st.executeQuery();
			      table.setModel(DbUtils.resultSetToTableModel(rs)); 
					table.getColumnModel().getColumn(0).setPreferredWidth(55);
					table.getColumnModel().getColumn(1).setPreferredWidth(131);
					table.getColumnModel().getColumn(2).setPreferredWidth(50);
					table.getColumnModel().getColumn(4).setPreferredWidth(52);
					table.getColumnModel().getColumn(5).setPreferredWidth(133);
				} catch (SQLException e1) {e1.printStackTrace();}
			    }
				}
			}
		});
		btnNewButton_2.setBounds(303, 69, 115, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
				      String query = "SELECT * FROM Thuthu_XD3901 WHERE Ma_thu_thu LIKE '%" + idtt.getText() + "%' AND Ten_thu_thu LIKE N\'%" + tentt.getText() + "%' AND Gioi_tinh LIKE N\'%" + value + "%' AND Dien_thoai LIKE '%" + sdttt.getText() +"%'";
				      PreparedStatement st = conn.prepareStatement(query);
				      ResultSet rs = st.executeQuery();
				      table.setModel(DbUtils.resultSetToTableModel(rs)); 
						table.getColumnModel().getColumn(0).setPreferredWidth(55);
						table.getColumnModel().getColumn(1).setPreferredWidth(131);
						table.getColumnModel().getColumn(2).setPreferredWidth(50);
						table.getColumnModel().getColumn(4).setPreferredWidth(52);
						table.getColumnModel().getColumn(5).setPreferredWidth(133);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_3.setBounds(1040, 126, 115, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1_1 = new JButton("Sửa");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
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
				String query = "UPDATE Thuthu_XD3901 SET  Ma_thu_thu = '"+value0+"', Ten_thu_thu = N\'"+value1+"', Gioi_tinh = N\'"+value2+"', Ngay_sinh = '"+value3+"', CMND = '"+value4+"', Email = '"+value5+"',Dien_thoai = '"+value6+"' WHERE [Ma_thu_thu] = '"+value0+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.executeUpdate();
			      String query1 = "SELECT * FROM Thuthu_XD3901 ";
			      PreparedStatement st = conn.prepareStatement(query1);
			      ResultSet rs = st.executeQuery();
			      table.setModel(DbUtils.resultSetToTableModel(rs)); 
					table.getColumnModel().getColumn(0).setPreferredWidth(55);
					table.getColumnModel().getColumn(1).setPreferredWidth(131);
					table.getColumnModel().getColumn(2).setPreferredWidth(50);
					table.getColumnModel().getColumn(4).setPreferredWidth(52);
					table.getColumnModel().getColumn(5).setPreferredWidth(133);
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2_1_1.setBounds(445, 69, 115, 36);
		contentPane.add(btnNewButton_2_1_1);
		
		idtt = new JTextField();
		idtt.setBounds(1101, 181, 115, 36);
		contentPane.add(idtt);
		idtt.setColumns(10);
		
		tentt = new JTextField();
		tentt.setBounds(1101, 242, 115, 36);
		contentPane.add(tentt);
		tentt.setColumns(10);
		
		sdttt = new JTextField();
		sdttt.setColumns(10);
		sdttt.setBounds(1101, 362, 115, 36);
		contentPane.add(sdttt);
		
		JLabel lblIdThTh = new JLabel("ID Thủ thư");
		lblIdThTh.setForeground(Color.WHITE);
		lblIdThTh.setBounds(1024, 181, 67, 26);
		contentPane.add(lblIdThTh);
		
		JLabel lblTnThTh = new JLabel("Tên thủ thư");
		lblTnThTh.setForeground(Color.WHITE);
		lblTnThTh.setBounds(1024, 242, 67, 26);
		contentPane.add(lblTnThTh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setForeground(Color.WHITE);
		lblGiiTnh.setBounds(1024, 303, 67, 26);
		contentPane.add(lblGiiTnh);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setForeground(Color.WHITE);
		lblinThoi.setBounds(1024, 362, 67, 26);
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
		btnNewButton_2_1.setBounds(584, 69, 115, 36);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Xuất file Excel");
		btnNewButton_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ThuthuExcel();
					Process process = Runtime.getRuntime().exec("cmd /c start ThongtinThuthu.xlsx ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setBounds(1040, 410, 115, 36);
		contentPane.add(btnNewButton_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		comboBox.setBounds(1101, 298, 115, 36);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin thủ thư");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel Light", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(40, 10, 241, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBackground(new Color(210, 105, 30));
		Nen1.setBounds(25, 10, 1202, 95);
		Nen1.setOpaque(true);
		contentPane.add(Nen1);
		
		JLabel Nen2 = new JLabel("");
		Nen2.setBackground(new Color(184, 134, 11));
		Nen2.setBounds(1012, 116, 215, 346);
		Nen2.setOpaque(true);
		contentPane.add(Nen2);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 1254, 585);
	    ImageIcon icon = new ImageIcon("icontoUse/HD-Library-Wallpaper.jpg");
	    Nen0.setIcon(icon);
		contentPane.add(Nen0);
		
        model = (DefaultTableModel) table.getModel();
        showTable();
	}
}
