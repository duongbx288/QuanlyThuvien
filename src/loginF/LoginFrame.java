package loginF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import view.HomeFrame;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Tentaikhoan;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPasswordField Matkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Đăng nhập chương trình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(0, 0, 618, 410);
		lblNewLabel.setOpaque(true);
	    ImageIcon icon = new ImageIcon("icontoUse/library-interior-empty-room-reading-with-books-wooden-shelves_33099-1722.jpg");
	    lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);

		
		Tentaikhoan = new JTextField();
		Tentaikhoan.setFont(new Font("Dialog", Font.PLAIN, 12));
		Tentaikhoan.setBounds(790, 239, 160, 20);
		contentPane.add(Tentaikhoan);
		Tentaikhoan.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] c = Matkhau.getPassword();
				String passText = String.valueOf(c);
				String account = Tentaikhoan.getText();
				String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Thư_viện_trg3901";
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection(url, account, passText);
					System.out.println("Ket noi thanh cong");
					HomeFrame inputfrm = new HomeFrame();
					inputfrm.setVisible(true);
					contentPane.setVisible(false);
					dispose();
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Tên tài khoản hoặc mật khẩu không đúng");
					e2.printStackTrace();
				}
			}});
		btnNewButton.setBounds(829, 330, 119, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(666, 238, 106, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(666, 286, 83, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quản lý thư viện");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(153, 153, 204));
		lblNewLabel_3.setBounds(681, 54, 269, 91);
		lblNewLabel_3.setOpaque(true);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(153, 51, 255));
		lblNewLabel_4.setBounds(618, 0, 396, 195);
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4);
		
		Matkhau = new JPasswordField();
		Matkhau.setBounds(790, 287, 160, 20);
		contentPane.add(Matkhau);
		
		this.setLocationRelativeTo(null);
	}
}
