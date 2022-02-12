package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUD.AccountCRUD;
import CRUD.BookCRUD;
import Execution.AccountEXE;
import Execution.BookEXE;
import gui.dialogs.EditAccountDialog;
import gui.dialogs.EditBookDialog;

@SuppressWarnings("serial")
public class BooksPanel extends JPanel {
	
	private JTable jtblBooks;
	DefaultTableModel objtableModel;
	protected BookCRUD bookCRUD;

	/**
	 * Create the panel.
	 */
	public BooksPanel() {
		
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
		
		JLabel lblNewLabel = new JLabel("Book Panel");
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
		jpnlButtons.add(jbtnUpdate);
		
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(jbtnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(0.0f);
		add(scrollPane);
		
		jtblBooks = new JTable();
		jtblBooks.setRowHeight(25);
		jtblBooks.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		String[] arrColumnNames = {"ISBN", "Title", "Author"};
		objtableModel = new DefaultTableModel(arrColumnNames, 0);
		BookEXE.ReadBookTable(objtableModel);
		jtblBooks.setModel(objtableModel);
			
		scrollPane.setViewportView(jtblBooks);
		
	//Update Action Listener
			jbtnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						int rowIndex = jtblBooks.getSelectedRow();
						
						if(rowIndex == -1) {
							JOptionPane.showMessageDialog(
									null,
									"Please select a student first before updating.",
									"Warning",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						String ISBN = (String) objtableModel.getValueAt(rowIndex, 0);
						
						EditBookDialog editBookDialog = new EditBookDialog(ISBN);
						editBookDialog.setVisible(true);

					}
			});
			
		//Delete Action Listener	
			jbtnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						int rowIndex = jtblBooks.getSelectedRow();
						
						if(rowIndex == -1) {
							JOptionPane.showMessageDialog(
									null,
									"Please select a student first before deleting.",
									"Warning",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
							String ISBN = (String) objtableModel.getValueAt(rowIndex, 0);
							 
							BookCRUD.DeleteBook(ISBN);
						//refresh the table
							refreshTable();
						}
				}
			});
			
		}
		public void refreshTable() {
			objtableModel.setRowCount(0);
			BookEXE.ReadBookTable(objtableModel);
		}

}
