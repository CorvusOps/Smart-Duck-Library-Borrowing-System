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

import CRUD.BorrowFormCRUD;
import CRUD.BookCRUD;
import Execution.AccountEXE;
import Execution.BookEXE;
import gui.LibrarianPortalFrame;
import values.Book;

public class EditBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ISBNtextField;
	private JTextField TitletextField;
	private JTextField AuthortextField;
	static String ISBN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditBookDialog dialog = new EditBookDialog(ISBN);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditBookDialog(String ISBN) {
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
		
		JLabel lblAddBook = new JLabel("Edit Book");
		lblAddBook.setIcon(new ImageIcon(EditBookDialog.class.getResource("/img/addBook_50px.png")));
		lblAddBook.setForeground(new Color(255, 102, 0));
		lblAddBook.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddBook.setBounds(37, 33, 237, 74);
		panel.add(lblAddBook);
		
		JLabel lbISBN = new JLabel("ISBN :");
		lbISBN.setForeground(new Color(153, 102, 0));
		lbISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbISBN.setBounds(39, 133, 98, 17);
		panel.add(lbISBN);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(153, 102, 0));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(38, 185, 89, 17);
		panel.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setForeground(new Color(153, 102, 0));
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuthor.setBounds(38, 238, 98, 16);
		panel.add(lblAuthor);
		
		ISBNtextField = new JTextField();
		ISBNtextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ISBNtextField.setColumns(10);
		ISBNtextField.setBounds(147, 131, 232, 20);
		panel.add(ISBNtextField);
		
		TitletextField = new JTextField();
		TitletextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TitletextField.setColumns(10);
		TitletextField.setBounds(147, 185, 232, 20);
		panel.add(TitletextField);
		
		AuthortextField = new JTextField();
		AuthortextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AuthortextField.setColumns(10);
		AuthortextField.setBounds(146, 236, 232, 20);
		panel.add(AuthortextField);
		
		setTexts(ISBN);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AddAccountButton = new JButton("Save");
				AddAccountButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Book bookValues = new Book();
						
					//fields that needs to be filled out
						boolean isFilled = !ISBNtextField.getText().equals("") && !TitletextField.getText().equals("")
											&& !AuthortextField.getText().equals("");		
						try {
							if(isFilled) {
								
							//setting the values
								BookEXE.setValues(bookValues, ISBNtextField.getText(),
														TitletextField.getText(),
														AuthortextField.getText());
								
								JOptionPane.showMessageDialog(null, BookEXE.exeUpdateStatements(bookValues));
								setVisible(false);
								
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
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setTexts(String ISBN) {
		//set the texts to the JTextFields of the details of the Book and the Borrower

			Book bookValues = BorrowFormCRUD.getBookDetails(ISBN);
			
			ISBNtextField.setText(bookValues.getISBN());
			TitletextField.setText(bookValues.getTitle());
			AuthortextField.setText(bookValues.getAuthor());
	}
}
