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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class IssueBook extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ISBNtextField;
	private JTextField IDtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IssueBook dialog = new IssueBook();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IssueBook() {
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
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setIcon(new ImageIcon(IssueBook.class.getResource("/img/books_50px.png")));
		lblIssueBook.setForeground(new Color(255, 102, 0));
		lblIssueBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIssueBook.setBounds(118, 38, 200, 74);
		panel.add(lblIssueBook);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 102, 0));
		separator.setBackground(new Color(204, 102, 0));
		separator.setBounds(118, 106, 181, 6);
		panel.add(separator);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setForeground(new Color(153, 102, 0));
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(40, 146, 48, 16);
		panel.add(lblIsbn);
		
		ISBNtextField = new JTextField();
		ISBNtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ISBNtextField.setColumns(10);
		ISBNtextField.setBounds(143, 144, 211, 20);
		panel.add(ISBNtextField);
		
		JLabel lblAccId = new JLabel("Account ID :");
		lblAccId.setForeground(new Color(153, 102, 0));
		lblAccId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccId.setBounds(40, 197, 84, 16);
		panel.add(lblAccId);
		
		IDtextField = new JTextField();
		IDtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IDtextField.setColumns(10);
		IDtextField.setBounds(143, 195, 211, 20);
		panel.add(IDtextField);
		
		JLabel lblIssueDate = new JLabel("Issue Date :");
		lblIssueDate.setForeground(new Color(153, 102, 0));
		lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssueDate.setBounds(40, 252, 84, 16);
		panel.add(lblIssueDate);
		
		JDateChooser IssueDate = new JDateChooser();
		IssueDate.setBounds(143, 248, 211, 20);
		panel.add(IssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date :");
		lblDueDate.setForeground(new Color(153, 102, 0));
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDueDate.setBounds(40, 307, 84, 16);
		panel.add(lblDueDate);
		
		JDateChooser DueDate = new JDateChooser();
		DueDate.setBounds(143, 303, 211, 20);
		panel.add(DueDate);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton IssueButton = new JButton("Issue Book");
				IssueButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						IssuanceConfirmation confirmation = new IssuanceConfirmation();
						confirmation.setVisible(true);
					}
				});
				IssueButton.setActionCommand("OK");
				buttonPane.add(IssueButton);
				getRootPane().setDefaultButton(IssueButton);
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
