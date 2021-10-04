package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;

public class StatisticFrame extends JFrame {

	private JPanel contentPane;
    Connection conn;
    String query;
    Statement st;
    ResultSet rs;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticFrame frame = new StatisticFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StatisticFrame() {
		setTitle("Thông tin về thư viện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Trở lại");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeFrame hmfrm = new HomeFrame();
				hmfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(827, 453, 75, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Sách");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(178, 34, 34));
		lblNewLabel.setForeground(Color.WHITE);
    	try {	
    		query = "SELECT COUNT(Ma_sach) AS so_sach FROM Sach_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		lblNewLabel.setText("Số sách có trong thư viện là: " + rs.getString("so_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		lblNewLabel.setBounds(59, 114, 820, 51);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Độc giả");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBackground(new Color(119, 136, 153));
		lblNewLabel_1.setForeground(Color.WHITE);
    	try {	
    		query = "SELECT COUNT(Ma_doc_gia) AS so_sach FROM DocGia_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		lblNewLabel_1.setText("Số độc giả tham gia thư viện là: " + rs.getString("so_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		lblNewLabel_1.setBounds(59, 177, 409, 51);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thủ thư");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBackground(new Color(178, 34, 34));
		lblNewLabel_2.setForeground(Color.WHITE);
    	try {	
    		query = "SELECT COUNT(Ma_thu_thu) AS so_sach FROM Thuthu_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		lblNewLabel_2.setText("Số thủ thư trong thư viện là: " + rs.getString("so_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		lblNewLabel_2.setBounds(59, 240, 820, 51);
		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mượn sách");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBackground(new Color(119, 136, 153));
		lblNewLabel_3.setForeground(Color.WHITE);
    	try {	
    		query = "SELECT COUNT(Ma_muon_tra) AS so_sach FROM Muontra_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		lblNewLabel_3.setText("Số lần độc giả mượn sách là: " + rs.getString("so_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		lblNewLabel_3.setBounds(59, 303, 820, 51);
		lblNewLabel_3.setOpaque(true);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Trả sách");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_4.setBackground(new Color(178, 34, 34));
		lblNewLabel_4.setForeground(Color.WHITE);
    	try {	
    		query = "SELECT COUNT(Ma_muon_tra) AS so_sach FROM Chitiet_Muon_XD3901";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		lblNewLabel_4.setText("Sách đã được trả : " + rs.getString("so_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		lblNewLabel_4.setBounds(59, 366, 409, 51);
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Thông tin về thư viện");
		lblNewLabel_5.setBackground(new Color(0, 128, 0));
		lblNewLabel_5.setFont(new Font("Corbel Light", Font.PLAIN, 32));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(59, 24, 409, 62);
		contentPane.add(lblNewLabel_5);
		
		JLabel trasach1 = new JLabel("");
		trasach1.setForeground(Color.WHITE);
		trasach1.setFont(new Font("Dialog", Font.PLAIN, 18));
    	try {	
    		query = "SELECT COUNT(Ma_muon_tra) as So_sach\r\n" + 
    				"FROM Chitiet_Muon_XD3901\r\n" + 
    				"GROUP BY Trang_thai_sach\r\n" + 
    				"HAVING Trang_thai_sach LIKE '%Lành%'";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		trasach1.setText("Sách còn nguyên vẹn khi trả về : " + rs.getString("So_sach"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		trasach1.setBackground(new Color(178, 34, 34));
		trasach1.setOpaque(true);
		trasach1.setBounds(480, 363, 399, 54);
		contentPane.add(trasach1);
		
		JLabel docgia1 = new JLabel("");
		docgia1.setForeground(Color.WHITE);
		docgia1.setFont(new Font("Dialog", Font.PLAIN, 18));
    	try {	
    		query = "SELECT COUNT(Ma_doc_gia) as So_doc_gia\r\n" + 
    				"FROM DocGia_XD3901\r\n" + 
    				"WHERE (2020 - DATEPART(yyyy,Ngay_sinh)) > 20";
    	    conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901;username=sa;password=thuvienXD");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
        		docgia1.setText("Độc giả trong thư viện có tuổi trên 20: " + rs.getString("So_doc_gia"));
            }
    	} catch(SQLException e1) {
    		e1.printStackTrace();
    	}
		docgia1.setBackground(new Color(119, 136, 153));
		docgia1.setOpaque(true);
		docgia1.setBounds(480, 177, 399, 51);
		contentPane.add(docgia1);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 938, 509);
	    ImageIcon icon = new ImageIcon("icontoUse/Library-Wallpaper.jpg");
	    Nen0.setIcon(icon);
		contentPane.add(Nen0);
		
		this.setLocationRelativeTo(null);
		
	}
}
