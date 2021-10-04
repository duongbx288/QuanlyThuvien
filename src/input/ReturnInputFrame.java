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

import controller.LoaningsController;
import controller.ReturningsController;
import model.Loanings;
import model.Returnings;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ReturnInputFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ReturnInputFrame dialog = new ReturnInputFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReturnInputFrame() {
		setTitle("Thêm thông tin trả sách");
		setBounds(100, 100, 564, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã đơn mượn");
		lblNewLabel.setBounds(57, 70, 99, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel_1.setBounds(57, 117, 65, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ng\u00E0y tr\u1EA3");
		lblNewLabel_2.setBounds(57, 165, 65, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tr\u1EA1ng th\u00E1i s\u00E1ch");
		lblNewLabel_3.setBounds(57, 217, 99, 13);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ti\u1EC1n ph\u1EA1t");
		lblNewLabel_4.setBounds(57, 264, 65, 13);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ghi ch\u00FA");
		lblNewLabel_5.setBounds(57, 307, 65, 13);
		contentPanel.add(lblNewLabel_5);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("Nh\u1EADp th\u00F4ng tin tr\u1EA3 s\u00E1ch");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(153, 10, 243, 28);
		contentPanel.add(lblNewLabel_7);
		
		JLabel Anh1 = new JLabel("");
		Anh1.setBounds(442, 10, 100, 120);
		ImageIcon img = new ImageIcon("icontoUse/Receipt-3-Icon (1).png");
		Anh1.setIcon(img);
		contentPanel.add(Anh1);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 550, 422);
		contentPanel.add(Nen0);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thêm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Returnings s = new Returnings();
						s.setMamt(textField.getText());
						s.setMasach(textField_1.getText());
				        try {
				            s.setNgaytra(new SimpleDateFormat("dd/MM/yyyy").parse(textField_2.getText()));
				        } catch (java.text.ParseException e1) {
							e1.printStackTrace();
						}
						s.setTrangthai(textField_3.getText());
				        try{
							s.setTienphat(Integer.parseInt(textField_4.getText()));
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(rootPane, "Nhập giá không hợp lệ");
							e2.printStackTrace();
						}
						s.setGhichu(textField_5.getText());
		                
						if(new ReturningsController().addTrasach(s)) {
							JOptionPane.showMessageDialog(rootPane, "Add Success!");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
						} else {
							JOptionPane.showMessageDialog(rootPane, "Thất bại có thể do mã sách, mã mượn sách không hợp lệ.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
					}
				});
				buttonPane.add(btnNewButton);
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
		}
        this.setLocationRelativeTo(null);
	}

}
