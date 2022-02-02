package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Execution.AccountEXE;
import gui.LibrarianPortalFrame;
import values.Account;

public class AddAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDtextField;
	private JTextField NametextField;
	private JTextField DepartmenttextField;
	private JTextField CoursetextField;
	private JTextField EmailtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddAccount dialog = new AddAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddAccount() {
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		
		JLabel lblAddAccount = new JLabel("New Account");
		lblAddAccount.setIcon(new ImageIcon(AddAccount.class.getResource("/img/addUser_50px.png")));
		lblAddAccount.setForeground(new Color(255, 102, 0));
		lblAddAccount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddAccount.setBounds(39, 33, 237, 74);
		panel.add(lblAddAccount);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(153, 102, 0));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(39, 133, 98, 17);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name :  ");
		lblName.setForeground(new Color(153, 102, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(38, 185, 89, 17);
		panel.add(lblName);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setForeground(new Color(153, 102, 0));
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(38, 238, 98, 16);
		panel.add(lblCourse);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setForeground(new Color(153, 102, 0));
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(38, 291, 98, 17);
		panel.add(lblDepartment);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(153, 102, 0));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(41, 339, 98, 17);
		panel.add(lblEmail);
		
		IDtextField = new JTextField();
		IDtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IDtextField.setColumns(10);
		IDtextField.setBounds(147, 131, 232, 20);
		panel.add(IDtextField);
		
		NametextField = new JTextField();
		NametextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NametextField.setColumns(10);
		NametextField.setBounds(147, 185, 232, 20);
		panel.add(NametextField);
		
		DepartmenttextField = new JTextField();
		DepartmenttextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DepartmenttextField.setColumns(10);
		DepartmenttextField.setBounds(146, 288, 232, 20);
		panel.add(DepartmenttextField);
		
		CoursetextField = new JTextField();
		CoursetextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CoursetextField.setColumns(10);
		CoursetextField.setBounds(146, 236, 232, 20);
		panel.add(CoursetextField);
		
		EmailtextField = new JTextField();
		EmailtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailtextField.setColumns(10);
		EmailtextField.setBounds(147, 337, 232, 20);
		panel.add(EmailtextField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AddAccountButton = new JButton("Add Account");
				AddAccountButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Account accountValues = new Account();
				
					//fields that needs to be filled out
						boolean isFilled = !IDtextField.getText().equals("") && !NametextField.getText().equals("")
											&& !DepartmenttextField.getText().equals("") && !CoursetextField.getText().equals("");
						try {
							if(isFilled) {
								
							//setting the values
								AccountEXE.setValues(accountValues, IDtextField.getText(),
														NametextField.getText(),
														CoursetextField.getText(),
														DepartmenttextField.getText(),
														EmailtextField.getText());
								
								JOptionPane.showMessageDialog(null, AccountEXE.exeInsertStatements(accountValues));
								
								setVisible(false);
								LibrarianPortalFrame frame = new LibrarianPortalFrame();
								frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
								}
							} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				AddAccountButton.setActionCommand("OK");
				buttonPane.add(AddAccountButton);
				getRootPane().setDefaultButton(AddAccountButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
