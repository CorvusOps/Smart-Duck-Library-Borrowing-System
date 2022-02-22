package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class WelcomePageFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePageFrame frame = new WelcomePageFrame();
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
	public WelcomePageFrame() {
		setBackground(new Color(255, 255, 255));
		setResizable(false);
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/smart-duck-logo-550x350-w-bulb.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBackground(new Color(255, 255, 204));
		pnlLogo.setLayout(null);
		GridBagConstraints gbc_pnlLogo = new GridBagConstraints();
		gbc_pnlLogo.insets = new Insets(0, 0, 0, 5);
		gbc_pnlLogo.fill = GridBagConstraints.BOTH;
		gbc_pnlLogo.gridx = 0;
		gbc_pnlLogo.gridy = 0;
		contentPane.add(pnlLogo, gbc_pnlLogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WelcomePageFrame.class.getResource("/img/smart-duck-logo-550x350-w-bulb.png")));
		lblNewLabel.setBounds(-98, 72, 568, 318);
		pnlLogo.add(lblNewLabel);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(255, 255, 255));
		pnlLogin.setLayout(null);
		GridBagConstraints gbc_pnlLogin = new GridBagConstraints();
		gbc_pnlLogin.fill = GridBagConstraints.BOTH;
		gbc_pnlLogin.gridx = 1;
		gbc_pnlLogin.gridy = 0;
		contentPane.add(pnlLogin, gbc_pnlLogin);
		
		JPanel container = new JPanel();
		container.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		container.setBackground(new Color(255, 255, 204));
		container.setBounds(36, 125, 298, 280);
		pnlLogin.add(container);
		container.setLayout(null);
		
		JLabel lblLoginLabel = new JLabel("Login");
		lblLoginLabel.setBounds(126, 26, 70, 31);
		container.add(lblLoginLabel);
		lblLoginLabel.setForeground(new Color(153, 51, 0));
		lblLoginLabel.setFont(new Font("Default_SC", Font.PLAIN, 25));
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(10, 97, 77, 19);
		container.add(lblUsername);
		lblUsername.setForeground(new Color(153, 51, 0));
		lblUsername.setFont(new Font("Default_SC", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 157, 77, 19);
		container.add(lblPassword);
		lblPassword.setForeground(new Color(153, 51, 0));
		lblPassword.setFont(new Font("Default_SC", Font.PLAIN, 13));
		
		txtFldUsername = new JTextField();
		txtFldUsername.setBounds(97, 96, 188, 20);
		container.add(txtFldUsername);
		txtFldUsername.setColumns(10);
		
		JButton MenuButton = new JButton("Confirm");
		MenuButton.setBounds(168, 224, 120, 25);
		container.add(MenuButton);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(97, 156, 188, 20);
		container.add(passwordField);
		
		MenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				String username = txtFldUsername.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				
				

				try {
					if(username.equals("admin") && password.equals("admin")) {
						setVisible(false);
						LibrarianPortalFrame frame = new LibrarianPortalFrame();
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Wrong username and password. Try Again.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		MenuButton.setBackground(new Color(255, 204, 102));
		MenuButton.setForeground(new Color(153, 51, 0));
		MenuButton.setFont(new Font("Default_SC", Font.PLAIN, 13));
	}
}



