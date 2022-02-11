package gui.dialogs;
/*
 * This Jdialog is for viewing of details of a book that is being issued, 
 * If confirmed, it will be saved in the database
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import Execution.BorrowFormEXE;
import values.BorrowForm;

public class IssuanceConfirmation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static String ISBN, AccID, Status;
	static Date issueDate, dueDate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IssuanceConfirmation dialog = new IssuanceConfirmation(ISBN, AccID, Status, issueDate, dueDate);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IssuanceConfirmation(String ISBN, String AccID, String status, Date issuedate, Date dueDate) {
		setBounds(100, 100, 439, 513);
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
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				IssueBookConfirmationPanel panel = new IssueBookConfirmationPanel();
				panel.setTexts(ISBN, AccID);
				panel.setPreferredSize(new Dimension(370, 600));
				scrollPane.setViewportView(panel);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ConfirmButton = new JButton("Confirm");
				ConfirmButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
				//set the values in the database
						BorrowForm borrowFormValues = new BorrowForm();
						BorrowFormEXE.setValues(borrowFormValues, AccID,
								ISBN,
								"Issued",
								issuedate,
								dueDate);
		
						JOptionPane.showMessageDialog(null, BorrowFormEXE.exeInsertStatements(borrowFormValues));
						
						setVisible(false);
					}
				});
				ConfirmButton.setActionCommand("OK");
				buttonPane.add(ConfirmButton);
				getRootPane().setDefaultButton(ConfirmButton);
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
