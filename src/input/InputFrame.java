package input;

import java.awt.BorderLayout;
import view.BookFrame;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BooksController;
import model.Books;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

public class InputFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			InputFrame dialog = new InputFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InputFrame() {
		setTitle("Thêm sách mới");
		setBounds(100, 100, 564, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel.setBounds(57, 70, 65, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn s\u00E1ch");
		lblNewLabel_1.setBounds(57, 117, 65, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn t\u00E1c gi\u1EA3");
		lblNewLabel_2.setBounds(57, 165, 65, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nh\u00E0 XB");
		lblNewLabel_3.setBounds(57, 217, 65, 13);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y XB");
		lblNewLabel_4.setBounds(57, 264, 65, 13);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_5.setBounds(57, 307, 65, 20);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ch\u00FA th\u00EDch");
		lblNewLabel_6.setBounds(57, 356, 65, 13);
		contentPanel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(163, 62, 245, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 109, 245, 28);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 157, 245, 28);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 209, 245, 28);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(163, 256, 245, 28);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(163, 299, 245, 28);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(163, 348, 245, 28);
		contentPanel.add(textField_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nh\u1EADp th\u00F4ng tin s\u00E1ch");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(153, 10, 243, 28);
		contentPanel.add(lblNewLabel_7);
		
		JLabel Anh1 = new JLabel("");
		Anh1.setBounds(437, 10, 105, 120);
		ImageIcon img = new ImageIcon("icontoUse/Books-2-icon (2).png");
		Anh1.setIcon(img);
		contentPanel.add(Anh1);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 554, 459);
		contentPanel.add(Nen0);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thêm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Books s = new Books();
                        s.setmasach(textField.getText());
						s.settensach(textField_1.getText());
						s.settacgia(textField_2.getText());
						s.setnhaxb(textField_3.getText());
				        try {
				            s.setngayxb(new SimpleDateFormat("dd/MM/yyyy").parse(textField_4.getText()));
				        } catch (java.text.ParseException e1) {
                            JOptionPane.showMessageDialog(rootPane, "Ngày tháng xuất bản không hợp lệ");
							e1.printStackTrace();
						}
						try{
							s.setdongia(Integer.parseInt(textField_5.getText()));
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(rootPane, "Nhập giá không hợp lệ");
							e2.printStackTrace();
						}
						s.setgthieu(textField_6.getText());
		                
						if(new BooksController().addSach(s)) {
							JOptionPane.showMessageDialog(rootPane, "Add Success!");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
						} else {
							JOptionPane.showMessageDialog(rootPane, "Sai sót do thông tin nhập không hợp lệ");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Hủy");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setLocationRelativeTo(null);
	}
}
