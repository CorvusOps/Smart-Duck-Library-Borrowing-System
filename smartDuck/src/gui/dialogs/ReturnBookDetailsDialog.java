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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.TextField;

public class ReturnBookDetailsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReturnBookDetailsDialog dialog = new ReturnBookDetailsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnBookDetailsDialog() {
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
		
		JLabel lblReturnFormDetails = new JLabel("RETURN FORM DETAILS");
		lblReturnFormDetails.setIcon(new ImageIcon(ReturnBookDetailsDialog.class.getResource("/img/returnBookDialog_50px.png")));
		lblReturnFormDetails.setForeground(new Color(102, 0, 0));
		lblReturnFormDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReturnFormDetails.setBounds(64, 22, 273, 56);
		panel.add(lblReturnFormDetails);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(51, 0, 0));
		separator.setBackground(new Color(51, 0, 0));
		separator.setBounds(124, 69, 213, 2);
		panel.add(separator);
		
		TextField ISBNBookDetail = new TextField();
		ISBNBookDetail.setEnabled(false);
		ISBNBookDetail.setEditable(false);
		ISBNBookDetail.setBounds(140, 162, 231, 22);
		panel.add(ISBNBookDetail);
		
		JLabel lblIsbnBookDetails = new JLabel("ISBN :");
		lblIsbnBookDetails.setForeground(new Color(153, 102, 0));
		lblIsbnBookDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbnBookDetails.setBounds(45, 162, 48, 16);
		panel.add(lblIsbnBookDetails);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(153, 102, 0));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(45, 210, 48, 16);
		panel.add(lblTitle);
		
		TextField TitleBookDetail = new TextField();
		TitleBookDetail.setEnabled(false);
		TitleBookDetail.setEditable(false);
		TitleBookDetail.setBounds(140, 210, 231, 22);
		panel.add(TitleBookDetail);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(153, 102, 0));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(45, 256, 23, 17);
		panel.add(lblId);
		
		TextField IDAccountDetail = new TextField();
		IDAccountDetail.setEditable(false);
		IDAccountDetail.setBounds(140, 256, 231, 22);
		panel.add(IDAccountDetail);
		
		JLabel lblName = new JLabel("Name :  ");
		lblName.setForeground(new Color(153, 102, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(45, 304, 52, 17);
		panel.add(lblName);
		
		TextField NameAccountDetail = new TextField();
		NameAccountDetail.setEditable(false);
		NameAccountDetail.setBounds(140, 304, 231, 22);
		panel.add(NameAccountDetail);
		
		JLabel lblBorrowFormNo = new JLabel("Borrow Form No. :");
		lblBorrowFormNo.setForeground(new Color(153, 102, 0));
		lblBorrowFormNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBorrowFormNo.setBounds(45, 116, 119, 16);
		panel.add(lblBorrowFormNo);
		
		TextField ISBNBookDetail_1 = new TextField();
		ISBNBookDetail_1.setEnabled(false);
		ISBNBookDetail_1.setEditable(false);
		ISBNBookDetail_1.setBounds(170, 116, 201, 22);
		panel.add(ISBNBookDetail_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ReturnBookButton = new JButton("Return Book");
				ReturnBookButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				ReturnBookButton.setActionCommand("OK");
				buttonPane.add(ReturnBookButton);
				getRootPane().setDefaultButton(ReturnBookButton);
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
