package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.ReturnFormCRUD;
import Execution.AccountEXE;
import Execution.ReturnFormEXE;
import gui.dialogs.EditReturnDialog;

public class ReturnFormPanel extends JPanel {
	
	private JTable jtblReturnForm;
	DefaultTableModel objtableModel;
	protected ReturnFormCRUD returnFormCRUD;

	/**
	 * Create the panel.
	 */
	public ReturnFormPanel() {
		
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
		
		JLabel lblNewLabel = new JLabel("Return Form Panel");
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
		
		JButton jbtnRefresh = new JButton("Refresh");
		jbtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		jbtnRefresh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(jbtnRefresh);
		
		
		jtblReturnForm = new JTable();
		jtblReturnForm.setRowHeight(25);
		jtblReturnForm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		
		String[] arrColumnNames = {"Return Form No.", "Borrow Form ID", "Return Date"};
		objtableModel = new DefaultTableModel(arrColumnNames, 0);
		ReturnFormEXE.ReadAccountTable(objtableModel);
		jtblReturnForm.setModel(objtableModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(0.0f);
		add(scrollPane);
		scrollPane.setViewportView(jtblReturnForm);
		
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblReturnForm.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first before updating.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				int returnNo = (int) objtableModel.getValueAt(rowIndex, 0);
			//	System.out.println("Row index value: " + objtableModel.getValueAt(rowIndex, 0));
				EditReturnDialog editReturnForm = new EditReturnDialog(returnNo);
				editReturnForm.setVisible(true);

			}
		});
		
		jpnlButtons.add(jbtnUpdate);
		
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblReturnForm.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select an item first before deleting.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
					int ReturnFormNo = (int) jtblReturnForm.getValueAt(rowIndex, 0);
					ReturnFormCRUD.DeleteReturnForm(ReturnFormNo);
					//refresh the table
					refreshTable();
				
				}
				
			}
		});
		
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(jbtnDelete);
		
		
		
	}
	public void refreshTable() {
		objtableModel.setRowCount(0);
		ReturnFormEXE.ReadAccountTable(objtableModel);
	}

}
