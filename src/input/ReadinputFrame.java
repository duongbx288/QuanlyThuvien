package input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ReadersController;
import model.Readers;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReadinputFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private String value;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ReadinputFrame dialog = new ReadinputFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReadinputFrame() {
		setTitle("Thêm thông tin về độc giả");
		setBounds(100, 100, 564, 528);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 \u0111\u1ED9c gi\u1EA3");
		lblNewLabel.setBounds(46, 70, 65, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u1ED9c gi\u1EA3");
		lblNewLabel_1.setBounds(46, 117, 78, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_2.setBounds(46, 169, 65, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_3.setBounds(46, 217, 65, 13);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_4.setBounds(46, 264, 65, 13);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CMND");
		lblNewLabel_5.setBounds(46, 307, 65, 13);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(46, 356, 65, 13);
		contentPanel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(174, 63, 245, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 110, 245, 28);
		contentPanel.add(textField_1);
		
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(174, 397, 245, 28);
		contentPanel.add(textField_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		comboBox.setBounds(174, 161, 245, 28);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_7.setBounds(46, 404, 78, 13);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Th\u00F4ng tin \u0111\u1ED9c gi\u1EA3");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(153, 10, 243, 28);
		contentPanel.add(lblNewLabel_7_1);
		
		JLabel Anh1 = new JLabel("");
		Anh1.setBounds(451, 10, 91, 120);
		ImageIcon img = new ImageIcon("icontoUse/man-icon (1).png");
		Anh1.setIcon(img);
		contentPanel.add(Anh1);
		
		JLabel Nen0 = new JLabel("");
		Nen0.setBounds(0, 0, 550, 491);
		contentPanel.add(Nen0);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thêm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Readers s = new Readers();
						s.setmadg(textField.getText());
						s.settendg(textField_1.getText());
						s.setgioitinhdg(comboBox.getSelectedItem().toString());
						s.setdiachidg(textField_3.getText());
				        try {
				            s.setnsinhdg(new SimpleDateFormat("dd/MM/yyyy").parse(textField_4.getText()));
				        } catch (java.text.ParseException e1) {
				        	JOptionPane.showMessageDialog(rootPane, "Ngày tháng năm sinh không hợp lệ");
							e1.printStackTrace();
						}
						s.setcmnddg(textField_5.getText());
						s.setemaildg(textField_6.getText());
						s.setsdtdg(textField_7.getText());
		                
						if(new ReadersController().addDocgia(s)) {
							JOptionPane.showMessageDialog(rootPane, "Add Success!");
							textField.setText("");
							textField_1.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
						} else {
							JOptionPane.showMessageDialog(rootPane, "Failed :(");
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			JButton btnNewButton = new JButton("Reset");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("");
					textField_1.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
				}
			});
			buttonPane.add(btnNewButton);
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
