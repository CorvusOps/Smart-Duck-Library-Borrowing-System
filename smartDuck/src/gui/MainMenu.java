package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import gui.dialogs.AddAccount;
import gui.dialogs.IssueBook;	

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 6, 784, 93);
		pnlHeader.setBackground(new Color(204, 153, 102));
		contentPane.add(pnlHeader);
		
		JPanel pnlAddUser = new JPanel();
		pnlAddUser.setBounds(42, 110, 213, 183);
		pnlAddUser.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlAddUser.setBackground(SystemColor.menu);
		pnlAddUser.setLayout(null);
		contentPane.add(pnlAddUser);
		
		JLabel lblAddUser = new JLabel("");
		lblAddUser.setBounds(32, 11, 171, 172);
		lblAddUser.setIcon(new ImageIcon(MainMenu.class.getResource("/img/addUser_150px.png")));
		
		lblAddUser.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	AddAccount frame = new AddAccount();
		    	frame.setVisible(true);
		    }  
		});
		pnlAddUser.add(lblAddUser);
		
	
		JPanel pnlBorrowForm = new JPanel();
		pnlBorrowForm.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlBorrowForm.setBounds(265, 110, 213, 183);
		pnlBorrowForm.setBackground(SystemColor.menu);
		contentPane.add(pnlBorrowForm);
		pnlBorrowForm.setLayout(null);
		
		JLabel lblBorrowForm = new JLabel("");
		lblBorrowForm.setBounds(37, 22, 150, 150);
		lblBorrowForm.setIcon(new ImageIcon(MainMenu.class.getResource("/img/borrowForm_150px.png")));
		pnlBorrowForm.add(lblBorrowForm);
		
		JPanel pnlReturnForm = new JPanel();
		pnlReturnForm.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlReturnForm.setBounds(488, 110, 213, 183);
		pnlReturnForm.setBackground(SystemColor.menu);
		contentPane.add(pnlReturnForm);
		pnlReturnForm.setLayout(null);
		
		JLabel lblReturnForm = new JLabel("");
		lblReturnForm.setBounds(32, 11, 160, 161);
		lblReturnForm.setIcon(new ImageIcon(MainMenu.class.getResource("/img/returnBook_150px.png")));
		pnlReturnForm.add(lblReturnForm);
		
		JPanel pnlAddBook = new JPanel();
		pnlAddBook.setBounds(6, 308, 254, 146);
		pnlAddBook.setBackground(SystemColor.menu);
		contentPane.add(pnlAddBook);
		pnlAddBook.setLayout(null);
		
		JLabel lblAddBook = new JLabel("");
		lblAddBook.setIcon(new ImageIcon(MainMenu.class.getResource("/img/book_150px.png")));
		lblAddBook.setBounds(20, 0, 234, 135);
		pnlAddBook.add(lblAddBook);
		
		lblAddBook.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	IssueBook frame = new IssueBook();
		    	frame.setVisible(true);
		    }  
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(275, 304, 513, 146);
		panel_2.setBackground(SystemColor.menu);
		contentPane.add(panel_2);
	}
}
