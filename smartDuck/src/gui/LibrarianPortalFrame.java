package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
		setMinimumSize(new Dimension(550, 430));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		panelWelcome.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		/*panelWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				WelcomePage objWelcome = new WelcomePage();
				objWelcome.setVisible(true);
			}
		});
		*/
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
		//Image WelcomeImage = new ImageIcon(this.getClass().getResource("/LogoWelcomeLibrarian500px100px.png")).getImage();
		panelWelcome.setLayout(new GridLayout(0, 1, 0, 0));
		//lblWelcomeImgLabel.setIcon(new ImageIcon(WelcomeImage));
		lblWelcomeImgLabel.setBounds(27, 19, 106, 130);
		panelWelcome.add(lblWelcomeImgLabel);
		
//Form Panel Top in
		
		//FormPanel
		JPanel panelForm = new JPanel();
		panelForm.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		/*panelForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormDialog objFormDialog = new FormDialog();
				objFormDialog.setVisible(true);
			}
		});
		*/
		GridBagConstraints gbc_panelForm = new GridBagConstraints();
		gbc_panelForm.insets = new Insets(0, 0, 5, 5);
		gbc_panelForm.gridx = 0;
		gbc_panelForm.gridy = 1;
		contentPane.add(panelForm, gbc_panelForm);
		
		//img
		JLabel lblFormImgLabel = new JLabel("");
		lblFormImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblFormImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Image FormImage = new ImageIcon(this.getClass().getResource("/LogoForm250px.png")).getImage();
		panelForm.setLayout(new GridLayout(0, 1, 0, 0));
		//lblFormImgLabel.setIcon(new ImageIcon(FormImage));
		lblFormImgLabel.setBounds(27, 19, 106, 130);
		panelForm.add(lblFormImgLabel);
		
//Add Book to Library Panel in
		
		//AddBookPanel
		JPanel panelAddBook = new JPanel();
		panelAddBook.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		/*panelAddBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddBookDialog objBook = new AddBookDialog();
				objBook.setVisible(true);
			}
		});*/
		GridBagConstraints gbc_panelAddBook = new GridBagConstraints();
		gbc_panelAddBook.insets = new Insets(0, 0, 5, 5);
		gbc_panelAddBook.gridx = 1;
		gbc_panelAddBook.gridy = 1;
		contentPane.add(panelAddBook, gbc_panelAddBook);
		
		//img
		JLabel lblAddLibrarianImgLabel = new JLabel("");
		lblAddLibrarianImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblAddLibrarianImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Image AddLibrarianImage = new ImageIcon(this.getClass().getResource("/AddBookLibrary125px.png")).getImage();
		panelAddBook.setLayout(new GridLayout(0, 1, 0, 0));
		//lblAddLibrarianImgLabel.setIcon(new ImageIcon(AddLibrarianImage));
		lblAddLibrarianImgLabel.setBounds(27, 19, 106, 130);
		panelAddBook.add(lblAddLibrarianImgLabel);
		
//Add ISBN Panel in
		
		//AddISBNPanel
		JPanel panelAddISBN = new JPanel();
		panelAddISBN.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		/*panelAddISBN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddISBNDialog objISBN = new AddISBNDialog();
				objISBN.setVisible(true);
			}
		});*/
		GridBagConstraints gbc_panelAddISBN = new GridBagConstraints();
		gbc_panelAddISBN.insets = new Insets(0, 0, 5, 0);
		gbc_panelAddISBN.fill = GridBagConstraints.BOTH;
		gbc_panelAddISBN.gridx = 2;
		gbc_panelAddISBN.gridy = 1;
		contentPane.add(panelAddISBN, gbc_panelAddISBN);

		//img
		JLabel lblAddBookImgLabel = new JLabel("");
		lblAddBookImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblAddBookImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Image AddBookImage = new ImageIcon(this.getClass().getResource("/LogoBook125px.png")).getImage();
		panelAddISBN.setLayout(new GridLayout(0, 1, 0, 0));
		//lblAddBookImgLabel.setIcon(new ImageIcon(AddBookImage));
		lblAddBookImgLabel.setBounds(27, 19, 106, 130);
		panelAddISBN.add(lblAddBookImgLabel);
		
		JPanel panelNewPanel = new JPanel();
		GridBagConstraints gbc_panelNewPanel = new GridBagConstraints();
		gbc_panelNewPanel.insets = new Insets(0, 0, 0, 5);
		gbc_panelNewPanel.fill = GridBagConstraints.BOTH;
		gbc_panelNewPanel.gridx = 0;
		gbc_panelNewPanel.gridy = 2;
		contentPane.add(panelNewPanel, gbc_panelNewPanel);
		
//View Log Panel in
		
		//viewLogPanel
		JPanel panelViewLog = new JPanel();
		panelViewLog.setBorder(new LineBorder(new Color(255, 228, 181), 5, true));
		/*panelViewLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				LogFramePage logs = new LogFramePage();
				logs.setVisible(true);
			}
		});*/
		GridBagConstraints gbc_panelViewLog = new GridBagConstraints();
		gbc_panelViewLog.gridwidth = 2;
		gbc_panelViewLog.gridx = 1;
		gbc_panelViewLog.gridy = 2;
		contentPane.add(panelViewLog, gbc_panelViewLog);
		
		//img
		JLabel lblLogImgLabel = new JLabel("");
		lblLogImgLabel.setBounds(new Rectangle(23, 123, 45, 67));
		lblLogImgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Image LogImage = new ImageIcon(this.getClass().getResource("/LogoLog250px125px.png")).getImage();
		panelViewLog.setLayout(new GridLayout(0, 1, 0, 0));
		//lblLogImgLabel.setIcon(new ImageIcon(LogImage));
		lblLogImgLabel.setBounds(27, 19, 106, 130);
		panelViewLog.add(lblLogImgLabel);	
	}
}

