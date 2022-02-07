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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class ReturnBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReturnBookDialog dialog = new ReturnBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnBookDialog() {
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
		
		JLabel lblIssueBook = new JLabel("Return Book");
		lblIssueBook.setIcon(new ImageIcon(ReturnBookDialog.class.getResource("/img/returnBookDialog_50px.png")));
		lblIssueBook.setForeground(new Color(255, 102, 0));
		lblIssueBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIssueBook.setBounds(99, 38, 200, 74);
		panel.add(lblIssueBook);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 102, 0));
		separator.setBackground(new Color(204, 102, 0));
		separator.setBounds(154, 95, 145, 8);
		panel.add(separator);
		
		JLabel lblBorrowFormNo = new JLabel("Borrow Form No :");
		lblBorrowFormNo.setForeground(new Color(153, 102, 0));
		lblBorrowFormNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBorrowFormNo.setBounds(40, 146, 118, 16);
		panel.add(lblBorrowFormNo);
		
		JLabel lblReturnDate = new JLabel("Return Date :");
		lblReturnDate.setForeground(new Color(153, 102, 0));
		lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnDate.setBounds(40, 192, 84, 16);
		panel.add(lblReturnDate);
		
		JDateChooser ReturnDate = new JDateChooser();
		ReturnDate.setBounds(164, 192, 200, 20);
		panel.add(ReturnDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(164, 145, 200, 22);
		panel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ReturnButton = new JButton("View Details");
				ReturnButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						ReturnBookDetailsDialog viewDetails = new ReturnBookDetailsDialog();
						viewDetails.setVisible(true);
					}
				});
				ReturnButton.setActionCommand("OK");
				buttonPane.add(ReturnButton);
				getRootPane().setDefaultButton(ReturnButton);
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
