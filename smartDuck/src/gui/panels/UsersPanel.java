package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class UsersPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UsersPanel() {
		
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBackground(new Color(255, 255, 255));
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setAlignmentY(0.0f);
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Users Panel");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setAlignmentY(0.0f);
		jpnlHeader.add(lblNewLabel);
		
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBackground(new Color(255, 255, 255));
		jpnlButtons.setAlignmentX(0.0f);
		jpnlButtons.setAlignmentY(0.0f);
		jpnlButtons.setMaximumSize(new Dimension(32767, 75));
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlHeader.add(jpnlButtons);
		
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		/*jbtnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblStudents.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a student first before updating.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String studentNumber = (String) studentTableModel.getValueAt(rowIndex, 0);
				Student student = studentRepository.getByStudentNumber(studentNumber);
				
				updateStudentDialog.initializeDialog(student);
				updateStudentDialog.setVisible(true);
			}
		});
		*/
		jpnlButtons.add(jbtnUpdate);
		
		JButton jbtnDelete = new JButton("Delete");
		/*jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblStudents.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a student first before deleting.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
					String studentNumber = (String) studentTableModel.getValueAt(rowIndex, 0);
					studentRepository.deleteByStudentNumber(studentNumber);
					studentTableModel.refresh();
				}
			}
		});
		*/
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(jbtnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(0.0f);
		add(scrollPane);
		
		//jtblAccounts = new JTable();
		//jtblAccounts.setRowHeight(25);
		//jtblAccounts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		
		//String[] arrColumnNames = {"Account ID", "Account Name", "Address", "City", "Province", "Country", "Role", "Contact Number", "Email"};
		//DefaultTableModel objtableModel = new DefaultTableModel(arrColumnNames, 0);
		//AccountEXE.ReadAccountTable(objtableModel);
		//jtblAccounts.setModel(objtableModel);
		
		
		//accountTableModel = new AccountTableModel();
		//accountTableModel.accountPanel = this;
		//jtblAccounts.setModel(accountTableModel);
		
		
		//scrollPane.setViewportView(jtblAccounts);

	}

}
