package input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LibrariansController;
import model.Librarians;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class LiinputFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			LiinputFrame dialog = new LiinputFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LiinputFrame() {
		setTitle("Thêm thông tin thủ thư");
		setBounds(100, 100, 564, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã thủ thư");
		lblNewLabel.setBounds(57, 70, 65, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên thủ thư");
		lblNewLabel_1.setBounds(57, 117, 65, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giới tính ");
		lblNewLabel_2.setBounds(57, 165, 65, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sinh");
		lblNewLabel_3.setBounds(57, 217, 65, 13);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CMND");
		lblNewLabel_4.setBounds(57, 264, 65, 13);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(57, 307, 65, 13);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Điện thoại");
		lblNewLabel_6.setBounds(57, 356, 65, 13);
		contentPanel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(174, 63, 245, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 110, 245, 28);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(174, 158, 245, 28);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(174, 210, 245, 28);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(174, 257, 245, 28);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(174, 300, 245, 28);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(174, 349, 245, 28);
		contentPanel.add(textField_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nhập thông tin thủ thư");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(153, 10, 243, 28);
		contentPanel.add(lblNewLabel_7);
		
		JLabel Anh1 = new JLabel("");
		Anh1.setBounds(451, 10, 91, 120);
		ImageIcon img = new ImageIcon("icontoUse/man-icon (1).png");
		Anh1.setIcon(img);
		contentPanel.add(Anh1);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 550, 451);
		contentPanel.add(Nen0);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thêm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Librarians s = new Librarians();
						s.setmatt(textField.getText());
						s.settentt(textField_1.getText());
						s.setgttt(textField_2.getText());
						s.setcmndtt(textField_4.getText());
				        try {
				            s.setngaysinhtt(new SimpleDateFormat("dd/MM/yyyy").parse(textField_3.getText()));
				        } catch (java.text.ParseException e1) {
							JOptionPane.showMessageDialog(rootPane, "Khai báo ngày tháng không hợp lệ");
							e1.printStackTrace();
						}
						s.setemailtt(textField_5.getText());
						s.setsdtt(textField_6.getText());
		                
						if(new LibrariansController().addThuthu(s)) {
							JOptionPane.showMessageDialog(rootPane, "Add Success!");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
						} else {
							JOptionPane.showMessageDialog(rootPane, "Failed :(");
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton okButton1 = new JButton("Reset");
				okButton1.addActionListener(new ActionListener() {
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
				okButton1.setActionCommand("OK");
				buttonPane.add(okButton1);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			this.setLocationRelativeTo(null);
		}
	}
}
