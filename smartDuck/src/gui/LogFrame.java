package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.panels.BooksPanel;
import gui.panels.BorrowFormPanel;
import gui.panels.ReturnFormPanel;
import gui.panels.UsersPanel;

@SuppressWarnings("serial")
public class LogFrame extends JFrame {

	private JPanel contentPane;
	
	private gui.panels.UsersPanel userPanel = new UsersPanel();
	private gui.panels.BooksPanel bookPanel = new BooksPanel();
	private gui.panels.BorrowFormPanel borrowFormPanel = new BorrowFormPanel();
	private gui.panels.ReturnFormPanel returnFormPanel = new ReturnFormPanel();
	
	
	private JPanel currentShownPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogFrame frame = new LogFrame();
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
	public LogFrame() {
		
		setTitle("Smart Duck Library");
		setMinimumSize(new Dimension(1050, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

//Side bar panel
		
		JPanel jpnlSidebar = new JPanel();
		jpnlSidebar.setBorder(new EmptyBorder(0, 0, 0, 0));
		jpnlSidebar.setBackground(new Color(255, 228, 181));
		jpnlSidebar.setPreferredSize(new Dimension(185, 10));
		jpnlSidebar.setMinimumSize(new Dimension(185, 10));
		contentPane.add(jpnlSidebar, BorderLayout.WEST);
		GridBagLayout gbl_jpnlSidebar = new GridBagLayout();
		gbl_jpnlSidebar.columnWidths = new int[]{185, 0};
		gbl_jpnlSidebar.rowHeights = new int[]{95, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlSidebar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpnlSidebar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlSidebar.setLayout(gbl_jpnlSidebar);
		
//image logo label
		
		JLabel jlblLogo = new JLabel();
		jlblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		//Image LogoImage = new ImageIcon(this.getClass().getResource("/Logo185px.png")).getImage();
		//jlblLogo.setIcon(new ImageIcon(LogoImage));
		GridBagConstraints gbc_jlblLogo = new GridBagConstraints();
		gbc_jlblLogo.insets = new Insets(0, 0, 5, 0);
		gbc_jlblLogo.anchor = GridBagConstraints.NORTHWEST;
		gbc_jlblLogo.gridx = 0;
		gbc_jlblLogo.gridy = 0;
		jpnlSidebar.add(jlblLogo, gbc_jlblLogo);
		
		/*if(currentShownPanel != null && currentShownPanel != welcomePanel)
			remove(currentShownPanel);
		currentShownPanel = welcomePanel;
		getContentPane().add(welcomePanel, BorderLayout.CENTER);
		*/
		
// space ? xD
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.anchor = GridBagConstraints.WEST;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 1;
		jpnlSidebar.add(rigidArea, gbc_rigidArea);

//Users button
		
		JButton btnUsers = new JButton("Users");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentShownPanel != null && currentShownPanel != userPanel)
					remove(currentShownPanel);
				currentShownPanel = userPanel;
				getContentPane().add(userPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		
		btnUsers.setBackground(new Color(255, 228, 181));
		btnUsers.setFocusPainted(false);
		btnUsers.setBorderPainted(false);
		GridBagConstraints gbc_btnUsers = new GridBagConstraints();
		gbc_btnUsers.anchor = GridBagConstraints.WEST;
		gbc_btnUsers.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsers.gridx = 0;
		gbc_btnUsers.gridy = 2;
		jpnlSidebar.add(btnUsers, gbc_btnUsers);
		
//Books button
		
		JButton btnBooks = new JButton("Books");
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentShownPanel != null && currentShownPanel != bookPanel)
					remove(currentShownPanel);
				currentShownPanel = bookPanel;
				getContentPane().add(bookPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		btnBooks.setBackground(new Color(255, 228, 181));
		btnBooks.setFocusPainted(false);
		btnBooks.setBorderPainted(false);
		GridBagConstraints gbc_btnBooks = new GridBagConstraints();
		gbc_btnBooks.insets = new Insets(0, 0, 5, 0);
		gbc_btnBooks.anchor = GridBagConstraints.WEST;
		gbc_btnBooks.gridx = 0;
		gbc_btnBooks.gridy = 3;
		jpnlSidebar.add(btnBooks, gbc_btnBooks);
		
//Borrow Form button
		
		JButton btnBorrowForm = new JButton("Borrow Forms");
		btnBorrowForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentShownPanel != null && currentShownPanel != borrowFormPanel)
					remove(currentShownPanel);
				currentShownPanel = borrowFormPanel;
				getContentPane().add(borrowFormPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		
		btnBorrowForm.setBackground(new Color(255, 228, 181));
		btnBorrowForm.setFocusPainted(false);
		btnBorrowForm.setBorderPainted(false);
		GridBagConstraints gbc_btnBorrowForm = new GridBagConstraints();
		gbc_btnBorrowForm.anchor = GridBagConstraints.WEST;
		gbc_btnBorrowForm.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrowForm.gridx = 0;
		gbc_btnBorrowForm.gridy = 4;
		jpnlSidebar.add(btnBorrowForm, gbc_btnBorrowForm);
		
//book details buttons
		
		JButton btnReturnForm = new JButton("Return Forms");
		btnReturnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentShownPanel != null && currentShownPanel != returnFormPanel)
					remove(currentShownPanel);
				currentShownPanel = returnFormPanel;
				getContentPane().add(returnFormPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		btnReturnForm.setBackground(new Color(255, 228, 181));
		btnReturnForm.setFocusPainted(false);
		btnReturnForm.setBorderPainted(false);
		GridBagConstraints gbc_btnReturnForm = new GridBagConstraints();
		gbc_btnReturnForm.insets = new Insets(0, 0, 5, 0);
		gbc_btnReturnForm.anchor = GridBagConstraints.WEST;
		gbc_btnReturnForm.gridx = 0;
		gbc_btnReturnForm.gridy = 5;
		jpnlSidebar.add(btnReturnForm, gbc_btnReturnForm);
		
//spaces thingy
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.anchor = GridBagConstraints.WEST;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 6;
		jpnlSidebar.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 7;
		jpnlSidebar.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_3.gridx = 0;
		gbc_rigidArea_3.gridy = 8;
		jpnlSidebar.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_4.gridx = 0;
		gbc_rigidArea_4.gridy = 9;
		jpnlSidebar.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_5.gridx = 0;
		gbc_rigidArea_5.gridy = 10;
		jpnlSidebar.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_6.gridx = 0;
		gbc_rigidArea_6.gridy = 11;
		jpnlSidebar.add(rigidArea_6, gbc_rigidArea_6);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_7.gridx = 0;
		gbc_rigidArea_7.gridy = 12;
		jpnlSidebar.add(rigidArea_7, gbc_rigidArea_7);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_8 = new GridBagConstraints();
		gbc_rigidArea_8.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_8.gridx = 0;
		gbc_rigidArea_8.gridy = 13;
		jpnlSidebar.add(rigidArea_8, gbc_rigidArea_8);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_9 = new GridBagConstraints();
		gbc_rigidArea_9.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_9.gridx = 0;
		gbc_rigidArea_9.gridy = 14;
		jpnlSidebar.add(rigidArea_9, gbc_rigidArea_9);
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_10 = new GridBagConstraints();
		gbc_rigidArea_10.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_10.gridx = 0;
		gbc_rigidArea_10.gridy = 15;
		jpnlSidebar.add(rigidArea_10, gbc_rigidArea_10);
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_11 = new GridBagConstraints();
		gbc_rigidArea_11.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_11.gridx = 0;
		gbc_rigidArea_11.gridy = 16;
		jpnlSidebar.add(rigidArea_11, gbc_rigidArea_11);
		
//space thingys end
//return button
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LibrarianPortalFrame pageLibrarian = new LibrarianPortalFrame();
				pageLibrarian.setVisible(true);
			}
		});
		btnReturn.setBackground(new Color(255, 228, 181));
		btnReturn.setFocusPainted(false);
		btnReturn.setBorderPainted(false);
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.anchor = GridBagConstraints.WEST;
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 17;
		jpnlSidebar.add(btnReturn, gbc_btnReturn);
		

	}

}
