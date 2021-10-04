package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginF.LoginFrame;


import javax.swing.UIManager;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

    JPanel contentPane;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeFrame() {
		setTitle("Quản lý thư viện _ BuiXuanDuong_20183901");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD th\u01B0 vi\u1EC7n ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Corbel Light", Font.BOLD, 28));
		lblNewLabel.setBounds(28, 12, 244, 85);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thông tin người đọc của thư viện");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadersFrame rdrfrm = new ReadersFrame();
				rdrfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(514, 129, 418, 70);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thông tin sách có trong thư viện");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				BookFrame bkfrm = new BookFrame();
				bkfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(41, 129, 418, 70);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thông tin thủ thư trong thư viện");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrariansFrame libfrm = new LibrariansFrame();
				libfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_2.setBounds(41, 246, 418, 70);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thông tin đơn mượn sách");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaningsFrame loanfrm = new LoaningsFrame();
				loanfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_3.setBounds(514, 246, 418, 70);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Thông tin sách đã trả");
		btnNewButton_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturningsFrame retfrm = new ReturningsFrame();
				retfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(41, 367, 418, 73);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Thống kê thông tin trong thư viện");
		btnNewButton_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticFrame stcfrm = new StatisticFrame();
				stcfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(514, 368, 418, 70);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_4 = new JButton("Đăng xuất");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int YesNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?","Đăng xuất", JOptionPane.YES_NO_OPTION);
				if (YesNo == 0) {
				LoginFrame inputfrm = new LoginFrame();
				inputfrm.setVisible(true);
				contentPane.setVisible(false);
				dispose();}
				else {}
			}
		});
		btnNewButton_4.setBounds(863, 478, 97, 30);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 51, 0));
		lblNewLabel_2.setBounds(12, 12, 295, 85);
		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u1EC1n 3");
		lblNewLabel_3.setBackground(new Color(51, 51, 0));
		lblNewLabel_3.setBounds(12, 12, 357, 85);
		lblNewLabel_3.setOpaque(true);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u1EC1n 4");
		lblNewLabel_4.setBackground(new Color(153, 51, 0));
		lblNewLabel_4.setBounds(12, 12, 405, 85);
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(204, 51, 0));
		lblNewLabel_6.setBounds(12, 12, 440, 85);
		lblNewLabel_6.setOpaque(true);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBackground(new Color(255, 51, 0));
		lblNewLabel_7.setBounds(12, 12, 466, 85);
		lblNewLabel_7.setOpaque(true);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBackground(new Color(255, 153, 0));
		lblNewLabel_8.setBounds(12, 12, 482, 85);
		lblNewLabel_8.setOpaque(true);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 153, 51));
		lblNewLabel_1.setBounds(12, 12, 962, 85);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(new Color(102, 153, 51));
		lblNewLabel_5.setBounds(0, 0, 985, 522);
	    ImageIcon icon = new ImageIcon("icontoUse/photo-1507842217343-583bb7270b66.jpg");
	    lblNewLabel_5.setIcon(icon);
		contentPane.add(lblNewLabel_5);
			
		this.setLocationRelativeTo(null);
	}
}
