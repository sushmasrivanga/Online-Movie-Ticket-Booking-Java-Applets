package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.sound.sampled.Line;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField unametxt;
	private Boolean loginSuccess = false;
	private JPasswordField passwordField;
	static String loginImage="D:\\project\\images\\login.png";
	static String sruImage="D:\\project\\images\\sru-1.png";
	static String passwordFile = "D:\\project\\passwords.txt";
	static String loggedInUserFile = "D:\\project\\loggedinuser.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Movie Ticket Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login_label = new JLabel("Login");
		login_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		login_label.setBounds(271, 27, 58, 33);
		contentPane.add(login_label);
		
		JLabel user = new JLabel("Username:");
		user.setFont(new Font("Tahoma", Font.BOLD, 13));
		user.setBounds(69, 107, 94, 27);
		contentPane.add(user);
		
		unametxt = new JTextField();
		unametxt.setBounds(213, 112, 125, 19);
		contentPane.add(unametxt);
		unametxt.setColumns(10);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Tahoma", Font.BOLD, 13));
		pass.setBounds(69, 180, 94, 27);
		contentPane.add(pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 185, 125, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = unametxt.getText();
				String pass = passwordField.getText();
				File file;
				BufferedReader bReader = null;
				try {
					
					file = new File(passwordFile);
					bReader = new BufferedReader(new FileReader(file));
					String line;
					while((line = bReader.readLine())!=null) {
						String[] credintials = line.split(",");
						if(credintials[0].equals(uname) && credintials[1].equals(pass)) {
							PrintWriter pWriter = new PrintWriter(new File(loggedInUserFile));
							pWriter.write(uname);
							pWriter.close();
							Booking booking = new Booking();
							booking.setVisible(true);
							dispose();
						}
					}
					bReader.close();
				} catch (IOException e2) {
					// TODO: handle exception
					System.out.println("Exception Occured IO:::" + e2);
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(263, 307, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel pic = new JLabel("");
		
		pic.setIcon(new ImageIcon(loginImage));
		pic.setBounds(376, 66, 222, 231);
		contentPane.add(pic);
		
		JLabel sru = new JLabel("");
		
		sru.setIcon(new ImageIcon(sruImage));
		sru.setBounds(10, 10, 200, 48);
		contentPane.add(sru);
		
		
	}
}
