package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import gui.dialogs.AddAccount;
import gui.dialogs.AddBookDialog;
import gui.dialogs.IssueBook;
import gui.dialogs.ReturnBookDialog;
import gui.panels.BorrowFormPanel;
import gui.panels.ReturnFormPanel;

public class LibrarianPortalFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianPortalFrame frame = new LibrarianPortalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibrarianPortalFrame() {
		setTitle("Smart Owl Library");
		setMinimumSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new LineBorder(new Color(244, 164, 96), 5, true));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
//Welcome Panel Top in
		
		//WelcomePanel
		JPanel panelWelcome = new JPanel();
		panelWelcome.setBackground(Color.WHITE);
		panelWelcome.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				WelcomePageFrame objWelcome = new WelcomePageFrame();
				objWelcome.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_panelWelcome = new GridBagConstraints();
		gbc_panelWelcome.gridwidth = 3;
		gbc_panelWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_panelWelcome.gridx = 0;
		gbc_panelWelcome.gridy = 0;
		contentPane.add(panelWelcome, gbc_panelWelcome);
		
		//img
		JLabel lblWelcomeImgLabel = new JLabel("");
		lblWelcomeImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblWelcomeImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelWelcome.setLayout(new GridLayout(0, 1, 0, 0));
		lblWelcomeImgLabel.setIcon(new ImageIcon(LibrarianPortalFrame.class.getResource("/img/smartDuckWelcome_500x125px.png")));
		lblWelcomeImgLabel.setBounds(27, 19, 106, 130);
		panelWelcome.add(lblWelcomeImgLabel);
		
//Add User Form Panel
		
		//Add User Panel
		JPanel panelForm = new JPanel();
		panelForm.setBackground(Color.WHITE);
		panelForm.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddAccount objFormDialog = new AddAccount();
				objFormDialog.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_panelForm = new GridBagConstraints();
		gbc_panelForm.insets = new Insets(0, 0, 5, 5);
		gbc_panelForm.gridx = 0;
		gbc_panelForm.gridy = 1;
		contentPane.add(panelForm, gbc_panelForm);
		
		//img
		JLabel lblAddAccountImgLabel = new JLabel("");
		lblAddAccountImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblAddAccountImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelForm.setLayout(new GridLayout(0, 1, 0, 0));
		lblAddAccountImgLabel.setIcon(new ImageIcon(LibrarianPortalFrame.class.getResource("/img/addUser_w_tag_150px.png")));
		lblAddAccountImgLabel.setBounds(27, 19, 106, 130);
		panelForm.add(lblAddAccountImgLabel);
		
//Borrow Form
		
		//AddBookPanel
		JPanel panelBorrowForm = new JPanel();
		panelBorrowForm.setBackground(Color.WHITE);
		panelBorrowForm.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelBorrowForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BorrowFormPanel objForm = new BorrowFormPanel();
				objForm.setVisible(true);
			}
		});
		GridBagConstraints gbc_panelBorrowForm = new GridBagConstraints();
		gbc_panelBorrowForm.insets = new Insets(0, 0, 5, 5);
		gbc_panelBorrowForm.gridx = 1;
		gbc_panelBorrowForm.gridy = 1;
		contentPane.add(panelBorrowForm, gbc_panelBorrowForm);
		
		//img
		JLabel lblBorrowFormImgLabel = new JLabel("");
		lblBorrowFormImgLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			// redirect to IssueBookDialog
				IssueBook objFormDialog = new IssueBook();
				objFormDialog.setVisible(true);
			}
		});
		lblBorrowFormImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblBorrowFormImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image AddLibrarianImage = new ImageIcon(this.getClass().getResource("/img/borrowForm_w_tag_150px.png")).getImage();
		panelBorrowForm.setLayout(new GridLayout(0, 1, 0, 0));
		lblBorrowFormImgLabel.setIcon(new ImageIcon(AddLibrarianImage));
		lblBorrowFormImgLabel.setBounds(27, 19, 106, 130);
		panelBorrowForm.add(lblBorrowFormImgLabel);
		
//Return Form Panel
		
		//ReturnFormPanel
		JPanel panelReturnForm = new JPanel();
		panelReturnForm.setBackground(Color.WHITE);
		panelReturnForm.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelReturnForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReturnFormPanel objReturn = new ReturnFormPanel();
				objReturn.setVisible(true);
			}
		});
		GridBagConstraints gbc_panelReturnForm = new GridBagConstraints();
		gbc_panelReturnForm.insets = new Insets(0, 0, 5, 0);
		gbc_panelReturnForm.gridx = 2;
		gbc_panelReturnForm.gridy = 1;
		contentPane.add(panelReturnForm, gbc_panelReturnForm);

		//img
		JLabel lblReturnBookImgLabel = new JLabel("");
		lblReturnBookImgLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// redirect to ReturnBookDialog
				ReturnBookDialog objFormDialog = new ReturnBookDialog();
				objFormDialog.setVisible(true);
			}
		});
		lblReturnBookImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblReturnBookImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image ReturnBookImage = new ImageIcon(this.getClass().getResource("/img/returnBook_w_tag_150px.png")).getImage();
		panelReturnForm.setLayout(new GridLayout(0, 1, 0, 0));
		lblReturnBookImgLabel.setIcon(new ImageIcon(ReturnBookImage));
		lblReturnBookImgLabel.setBounds(27, 19, 106, 130);
		panelReturnForm.add(lblReturnBookImgLabel);
		
//AddBook Panel
		
		//AddBook Panel
		JPanel panelAddBook = new JPanel();
		panelAddBook.setBackground(Color.WHITE);
		panelAddBook.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelAddBook.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			AddBookDialog objAddBook = new AddBookDialog();
			objAddBook.setVisible(true);
		}
		});
		
		GridBagConstraints gbc_panelAddBook = new GridBagConstraints();
		gbc_panelAddBook.insets = new Insets(0, 0, 0, 5);
		gbc_panelAddBook.gridx = 0;
		gbc_panelAddBook.gridy = 2;
		contentPane.add(panelAddBook, gbc_panelAddBook);
		
		//img
		JLabel lblAddBookImgLabel = new JLabel("");
		lblAddBookImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblAddBookImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image AddBookImage = new ImageIcon(this.getClass().getResource("/img/addBook_w_tag_150px.png")).getImage();
		panelAddBook.setLayout(new GridLayout(0, 1, 0, 0));
		lblAddBookImgLabel.setIcon(new ImageIcon(AddBookImage));
		lblAddBookImgLabel.setBounds(27, 19, 106, 130);
		panelAddBook.add(lblAddBookImgLabel);
		
//View Log Panel in
		
		//viewLogPanel
		JPanel panelViewLog = new JPanel();
		panelViewLog.setBackground(Color.WHITE);
		panelViewLog.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		panelViewLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				LogFrame logs = new LogFrame();
				logs.setVisible(true);
			}
		});
		GridBagConstraints gbc_panelViewLog = new GridBagConstraints();
		gbc_panelViewLog.gridwidth = 2;
		gbc_panelViewLog.gridx = 1;
		gbc_panelViewLog.gridy = 2;
		contentPane.add(panelViewLog, gbc_panelViewLog);
		
		//img
		JLabel lblLogImgLabel = new JLabel("");
		lblLogImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblLogImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image LogImage = new ImageIcon(this.getClass().getResource("/img/logs_w_tag_300x150px.png")).getImage();
		panelViewLog.setLayout(new GridLayout(0, 1, 0, 0));
		lblLogImgLabel.setIcon(new ImageIcon(LogImage));
		lblLogImgLabel.setBounds(27, 19, 106, 130);
		panelViewLog.add(lblLogImgLabel);	
	}
}

