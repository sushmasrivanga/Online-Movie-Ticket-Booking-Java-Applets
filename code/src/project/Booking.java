package project;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.EntityReference;

import org.w3c.dom.DOMStringList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Booking extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextField seat, totalcost;
	Choice type, block, time;
	JLabel typelbl, blocklbl, timelbl, mblbl, rblbl, inputseatlbl, totallbl, title;
	private JTextField seatNumbertxt;
	private JTextField totalPricetxt;
	private int selectedSeat;
	static String movieNameFile="D:\\project\\moviename.txt";
	static String loggedInUserFile = "D:\\project\\loggedinuser.txt";
	static String bookingHistoryFile = "D:\\project\\BookingHistory.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
		setTitle("Movie Ticket Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 514);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(470, 85, 55, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Time:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(470, 140, 55, 24);
		contentPane.add(lblNewLabel_2);

		Choice choice_2 = new Choice();
		
		choice_2.setBounds(531, 146, 95, 18);
		contentPane.add(choice_2);
		choice_2.add("11:00 A.M");
		choice_2.add("02:30 P.M");
		choice_2.add("06:00 P.M");
		choice_2.add("09:30 P.M");

		JLabel lblNewLabel_3 = new JLabel("Seat Number:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(39, 79, 151, 37);
		contentPane.add(lblNewLabel_3);

		seatNumbertxt = new JTextField();
		seatNumbertxt.setEditable(false);
		seatNumbertxt.setBounds(205, 90, 96, 19);
		contentPane.add(seatNumbertxt);
		seatNumbertxt.setColumns(10);

		JLabel total_Price = new JLabel("Total Price:");
		total_Price.setFont(new Font("Tahoma", Font.BOLD, 14));
		total_Price.setBounds(39, 140, 95, 24);
		contentPane.add(total_Price);

		totalPricetxt = new JTextField();
		totalPricetxt.setEditable(false);
		totalPricetxt.setBounds(205, 145, 96, 19);
		contentPane.add(totalPricetxt);
		totalPricetxt.setColumns(10);

		JButton Button_1 = new JButton("1");
		Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("1");
				totalPricetxt.setText("250/-");
				selectedSeat = 1;
			}
		});
		Button_1.setBounds(39, 208, 48, 48);
		contentPane.add(Button_1);

		JButton Button_2 = new JButton("2");
		Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("2");
				totalPricetxt.setText("250/-");
				selectedSeat = 2;
			}
		});
		Button_2.setBounds(97, 208, 48, 48);
		contentPane.add(Button_2);

		JButton Button_3 = new JButton("3");
		Button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("3");
				totalPricetxt.setText("250/-");
				selectedSeat = 3;
			}
		});
		Button_3.setBounds(155, 208, 48, 48);
		contentPane.add(Button_3);

		JButton Button_4 = new JButton("4");
		Button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("4");
				totalPricetxt.setText("250/-");
				selectedSeat = 4;
			}
		});
		Button_4.setBounds(273, 208, 48, 48);
		contentPane.add(Button_4);

		JButton Button_5 = new JButton("5");
		Button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("5");
				totalPricetxt.setText("250/-");
				selectedSeat = 5;
			}
		});
		Button_5.setBounds(331, 208, 48, 48);
		contentPane.add(Button_5);

		JButton Button_6 = new JButton("6");
		Button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("6");
				totalPricetxt.setText("250/-");
				selectedSeat = 6;
			}
		});
		Button_6.setBounds(389, 208, 48, 48);
		contentPane.add(Button_6);

		JButton Button_7 = new JButton("7");
		Button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("7");
				totalPricetxt.setText("250/-");
				selectedSeat = 7;
			}
		});
		Button_7.setBounds(447, 208, 48, 48);
		contentPane.add(Button_7);

		JButton Button_8 = new JButton("8");
		Button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("8");
				totalPricetxt.setText("250/-");
				selectedSeat = 8;
			}
		});
		Button_8.setBounds(563, 208, 48, 48);
		contentPane.add(Button_8);

		JButton Button_9 = new JButton("9");
		Button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("9");
				totalPricetxt.setText("250/-");
				selectedSeat = 9;
			}
		});
		Button_9.setBounds(621, 208, 48, 48);
		contentPane.add(Button_9);

		JButton Button_10 = new JButton("10");
		Button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("10");
				totalPricetxt.setText("250/-");
				selectedSeat = 10;
			}
		});
		Button_10.setBounds(679, 208, 48, 48);
		contentPane.add(Button_10);

		JButton Button_11 = new JButton("11");
		Button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("11");
				totalPricetxt.setText("200/-");
				selectedSeat = 11;
			}
		});
		Button_11.setBounds(39, 266, 48, 48);
		contentPane.add(Button_11);

		JButton Button_12 = new JButton("12");
		Button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("12");
				totalPricetxt.setText("200/-");
				selectedSeat = 12;
			}
		});
		Button_12.setBounds(97, 266, 48, 48);
		contentPane.add(Button_12);

		JButton Button_13 = new JButton("13");
		Button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("13");
				totalPricetxt.setText("200/-");
				selectedSeat = 13;
			}
		});
		Button_13.setBounds(155, 266, 48, 48);
		contentPane.add(Button_13);

		JButton Button_14 = new JButton("14");
		Button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("14");
				totalPricetxt.setText("200/-");
				selectedSeat = 14;
			}
		});
		Button_14.setBounds(273, 266, 48, 48);
		contentPane.add(Button_14);

		JButton Button_15 = new JButton("15");
		Button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("15");
				totalPricetxt.setText("200/-");
				selectedSeat = 15;
			}
		});
		Button_15.setBounds(331, 266, 48, 48);
		contentPane.add(Button_15);

		JButton Button_16 = new JButton("16");
		Button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("16");
				totalPricetxt.setText("200/-");
				selectedSeat = 16;
			}
		});
		Button_16.setBounds(389, 266, 48, 48);
		contentPane.add(Button_16);

		JButton Button_17 = new JButton("17");
		Button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("17");
				totalPricetxt.setText("200/-");
				selectedSeat = 17;
			}
		});
		Button_17.setBounds(447, 266, 48, 48);
		contentPane.add(Button_17);

		JButton Button_18 = new JButton("18");
		Button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("18");
				totalPricetxt.setText("200/-");
				selectedSeat = 18;
			}
		});
		Button_18.setBounds(563, 266, 48, 48);
		contentPane.add(Button_18);

		JButton Button_19 = new JButton("19");
		Button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("19");
				totalPricetxt.setText("200/-");
				selectedSeat = 19;
			}
		});
		Button_19.setBounds(621, 266, 48, 48);
		contentPane.add(Button_19);

		JButton Button_20 = new JButton("20");
		Button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("20");
				totalPricetxt.setText("200/-");
				selectedSeat = 20;
			}
		});
		Button_20.setBounds(679, 266, 48, 48);
		contentPane.add(Button_20);

		JButton Button_21 = new JButton("21");
		Button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("21");
				totalPricetxt.setText("100/-");
				selectedSeat = 21;
			}
		});
		Button_21.setBounds(39, 324, 48, 48);
		contentPane.add(Button_21);

		JButton Button_22 = new JButton("22");
		Button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("22");
				totalPricetxt.setText("100/-");
				selectedSeat = 22;
			}
		});
		Button_22.setBounds(97, 324, 48, 48);
		contentPane.add(Button_22);

		JButton Button_23 = new JButton("23");
		Button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("22");
				totalPricetxt.setText("100/-");
				selectedSeat = 22;
			}
		});
		Button_23.setBounds(155, 324, 48, 48);
		contentPane.add(Button_23);

		JButton Button_24 = new JButton("24");
		Button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("24");
				totalPricetxt.setText("100/-");
				selectedSeat = 24;
			}
		});
		Button_24.setBounds(273, 324, 48, 48);
		contentPane.add(Button_24);

		JButton Button_25 = new JButton("25");
		Button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("25");
				totalPricetxt.setText("100/-");
				selectedSeat = 25;
			}
		});
		Button_25.setBounds(331, 324, 48, 48);
		contentPane.add(Button_25);

		JButton Button_26 = new JButton("26");
		Button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("26");
				totalPricetxt.setText("100/-");
				selectedSeat = 26;
			}
		});
		Button_26.setBounds(389, 324, 48, 48);
		contentPane.add(Button_26);

		JButton Button_27 = new JButton("27");
		Button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("27");
				totalPricetxt.setText("100/-");
				selectedSeat = 27;
			}
		});
		Button_27.setBounds(447, 324, 48, 48);
		contentPane.add(Button_27);

		JButton Button_28 = new JButton("28");
		Button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("28");
				totalPricetxt.setText("100/-");
				selectedSeat = 28;
			}
		});
		Button_28.setBounds(563, 324, 48, 48);
		contentPane.add(Button_28);

		JButton Button_29 = new JButton("29");
		Button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("29");
				totalPricetxt.setText("100/-");
				selectedSeat = 29;
			}
		});
		Button_29.setBounds(621, 324, 48, 48);
		contentPane.add(Button_29);

		JButton Button_30 = new JButton("30");
		Button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumbertxt.setText("30");
				totalPricetxt.setText("100/-");
				selectedSeat = 30;
			}
		});
		Button_30.setBounds(679, 324, 48, 48);
		contentPane.add(Button_30);

		JButton logoutbtn = new JButton("Logout");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();

			}
		});
		logoutbtn.setBounds(694, 434, 85, 21);
		contentPane.add(logoutbtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sushm\\Desktop\\java images\\sru-1.png"));
		lblNewLabel.setBounds(10, 10, 200, 48);
		contentPane.add(lblNewLabel);

		Choice choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				disableAllSeats(Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
			}
		});
		choice_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				disableAllSeats(Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
			}
		});
		
		choice.setBounds(531, 91, 95, 18);
		contentPane.add(choice);
		choice.add(LocalDate.now().toString());
		for (int i = 1; i < 7; i++) {
			choice.add(LocalDate.now().plusDays(i).toString());
		}

		JButton Pay_Button = new JButton("Pay");
		Pay_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBooking(choice, choice_2, selectedSeat);
				savePaymentInfoToAccount(selectedSeat, choice.getSelectedItem(), choice_2.getSelectedItem());
				disableSeat(selectedSeat, Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
				
				seatNumbertxt.setText("");
				totalPricetxt.setText("");
//				choice.select(0);
//				choice_2.select(0);
				JOptionPane.showMessageDialog(Pay_Button, "Your Booking is Succesful");

				
				// readBooking();
			}
		});
		Pay_Button.setBounds(312, 144, 85, 21);
		contentPane.add(Pay_Button);

		File file;
		BufferedReader bReader = null;
		String movieName = null;
		try {
			file = new File(movieNameFile);
			bReader = new BufferedReader(new FileReader(file));
			movieName = bReader.readLine();
			bReader.close();
		} catch (IOException e2) {
			// TODO: handle exception
			System.out.println("Exception Occured IO:::" + e2);
		} catch (Exception e2) {
			// TODO: handle exception
		}

		JLabel movieNamelbl = new JLabel("Movie Running Now: " + movieName);
		movieNamelbl.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 16));
		movieNamelbl.setBounds(325, 23, 273, 35);
		contentPane.add(movieNamelbl);
		
		
		
		JButton fetchSeatsButton = new JButton("Select");
		fetchSeatsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				reloadSeats
				disableBookedSeats(choice, choice_2,  Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
			}
		});
		fetchSeatsButton.setBounds(632, 144, 106, 21);
		contentPane.add(fetchSeatsButton);
		
		
		disableAllSeats(Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
		
		JButton btnNewButton = new JButton("Your History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookingHistory bookingHistory = new BookingHistory();
				bookingHistory.setVisible(true);
			}
		});
		btnNewButton.setBounds(563, 434, 106, 21);
		contentPane.add(btnNewButton);
	}
	
	
	public static String getLoggedInUser() {
		try {
			
			return readOldContent(loggedInUserFile);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return "";
	}
	
	public static String getMovieName() {
		return readOldContent(movieNameFile);
	}
	public static void savePaymentInfoToAccount(int seatNumber, String showDate, String showTime) {
		// Saving Format::::::::::::
		// Date Booked|UserName|Show Date|Show Time|Seat Number|MovieName|BookingID| 
		String loggedUser = getLoggedInUser();
		String movieName = getMovieName();
		java.util.Date date = new java.util.Date();
		long bookingId = date.getTime();
		String dateBooked = date.getDate() + "-" + date.getMonth() + "-" + (1900+date.getYear());
		String content;
		try {
			content = readOldContent(bookingHistoryFile);
			
			PrintWriter pWriter = new PrintWriter(new File(bookingHistoryFile));
			if(content==null || content == "") {
				pWriter.write(dateBooked+"|"+loggedUser+"|"+showDate+"|"+showTime+"|"+seatNumber+"|"+movieName+"|"+bookingId+"\n");
			}
			else {
				pWriter.write(content+dateBooked+"|"+loggedUser+"|"+showDate+"|"+showTime+"|"+seatNumber+"|"+movieName+"|"+bookingId+"\n");
			}
			pWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can't Save Booking History Exception Occured!");
		}
		
		
		
		
		
	}
	
	
	public static void disableAllSeats(JButton Button_1, JButton Button_2, JButton Button_3, JButton Button_4, JButton Button_5,
			JButton Button_6,JButton Button_7,JButton Button_8,JButton Button_9,JButton Button_10,JButton Button_11,JButton Button_12,JButton Button_13,
			JButton Button_14,JButton Button_15,JButton Button_16,JButton Button_17,JButton Button_18,JButton Button_19,JButton Button_20,JButton Button_21,
			JButton Button_22,JButton Button_23,JButton Button_24,JButton Button_25,JButton Button_26,JButton Button_27,JButton Button_28,JButton Button_29,JButton Button_30) {
		
		for(int i=1;i<=30;i++) {
			disableSeat(i, Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
		}		
	}
	
	
	public static void disableSeat(int selectedSeat, JButton Button_1, JButton Button_2, JButton Button_3, JButton Button_4, JButton Button_5,
			JButton Button_6,JButton Button_7,JButton Button_8,JButton Button_9,JButton Button_10,JButton Button_11,JButton Button_12,JButton Button_13,
			JButton Button_14,JButton Button_15,JButton Button_16,JButton Button_17,JButton Button_18,JButton Button_19,JButton Button_20,JButton Button_21,
			JButton Button_22,JButton Button_23,JButton Button_24,JButton Button_25,JButton Button_26,JButton Button_27,JButton Button_28,JButton Button_29,JButton Button_30) {
		switch (selectedSeat) {
		case 1:
			Button_1.setEnabled(false);
			break;
		case 2:
			Button_2.setEnabled(false);
			break;
		case 3:
			Button_3.setEnabled(false);
			break;
		case 4:
			Button_4.setEnabled(false);
			break;
		case 5:
			Button_5.setEnabled(false);
			break;
		case 6:
			Button_6.setEnabled(false);
			break;
		case 7:
			Button_7.setEnabled(false);
			break;
		case 8:
			Button_8.setEnabled(false);
			break;
		case 9:
			Button_9.setEnabled(false);
			break;
		case 10:
			Button_10.setEnabled(false);
			break;
		case 11:
			Button_11.setEnabled(false);
			break;
		case 12:
			Button_12.setEnabled(false);
			break;
		case 13:
			Button_13.setEnabled(false);
			break;
		case 14:
			Button_14.setEnabled(false);
			break;
		case 15:
			Button_15.setEnabled(false);
			break;
		case 16:
			Button_16.setEnabled(false);
			break;
		case 17:
			Button_17.setEnabled(false);
			break;
		case 18:
			Button_18.setEnabled(false);
			break;
		case 19:
			Button_19.setEnabled(false);
			break;
		case 20:
			Button_20.setEnabled(false);
			break;
		case 21:
			Button_21.setEnabled(false);
			break;
		case 22:
			Button_22.setEnabled(false);
			break;
		case 23:
			Button_23.setEnabled(false);
			break;
		case 24:
			Button_24.setEnabled(false);
			break;
		case 25:
			Button_25.setEnabled(false);
			break;
		case 26:
			Button_26.setEnabled(false);
			break;
		case 27:
			Button_27.setEnabled(false);
			break;
		case 28:
			Button_28.setEnabled(false);
			break;
		case 29:
			Button_29.setEnabled(false);
			break;
		case 30:
			Button_30.setEnabled(false);
			break;
		}
	}
	
	public static void enableSeat(int selectedSeat, JButton Button_1, JButton Button_2, JButton Button_3, JButton Button_4, JButton Button_5,
			JButton Button_6,JButton Button_7,JButton Button_8,JButton Button_9,JButton Button_10,JButton Button_11,JButton Button_12,JButton Button_13,
			JButton Button_14,JButton Button_15,JButton Button_16,JButton Button_17,JButton Button_18,JButton Button_19,JButton Button_20,JButton Button_21,
			JButton Button_22,JButton Button_23,JButton Button_24,JButton Button_25,JButton Button_26,JButton Button_27,JButton Button_28,JButton Button_29,JButton Button_30) {
		switch (selectedSeat) {
		case 1:
			Button_1.setEnabled(true);
			break;
		case 2:
			Button_2.setEnabled(true);
			break;
		case 3:
			Button_3.setEnabled(true);
			break;
		case 4:
			Button_4.setEnabled(true);
			break;
		case 5:
			Button_5.setEnabled(true);
			break;
		case 6:
			Button_6.setEnabled(true);
			break;
		case 7:
			Button_7.setEnabled(true);
			break;
		case 8:
			Button_8.setEnabled(true);
			break;
		case 9:
			Button_9.setEnabled(true);
			break;
		case 10:
			Button_10.setEnabled(true);
			break;
		case 11:
			Button_11.setEnabled(true);
			break;
		case 12:
			Button_12.setEnabled(true);
			break;
		case 13:
			Button_13.setEnabled(true);
			break;
		case 14:
			Button_14.setEnabled(true);
			break;
		case 15:
			Button_15.setEnabled(true);
			break;
		case 16:
			Button_16.setEnabled(true);
			break;
		case 17:
			Button_17.setEnabled(true);
			break;
		case 18:
			Button_18.setEnabled(true);
			break;
		case 19:
			Button_19.setEnabled(true);
			break;
		case 20:
			Button_20.setEnabled(true);
			break;
		case 21:
			Button_21.setEnabled(true);
			break;
		case 22:
			Button_22.setEnabled(true);
			break;
		case 23:
			Button_23.setEnabled(true);
			break;
		case 24:
			Button_24.setEnabled(true);
			break;
		case 25:
			Button_25.setEnabled(true);
			break;
		case 26:
			Button_26.setEnabled(true);
			break;
		case 27:
			Button_27.setEnabled(true);
			break;
		case 28:
			Button_28.setEnabled(true);
			break;
		case 29:
			Button_29.setEnabled(true);
			break;
		case 30:
			Button_30.setEnabled(true);
			break;
		}
	}
	
	public static void disableBookedSeats(Choice dateChoice, Choice timeChoice, JButton Button_1, JButton Button_2, JButton Button_3, JButton Button_4, JButton Button_5,
			JButton Button_6,JButton Button_7,JButton Button_8,JButton Button_9,JButton Button_10,JButton Button_11,JButton Button_12,JButton Button_13,
			JButton Button_14,JButton Button_15,JButton Button_16,JButton Button_17,JButton Button_18,JButton Button_19,JButton Button_20,JButton Button_21,
			JButton Button_22,JButton Button_23,JButton Button_24,JButton Button_25,JButton Button_26,JButton Button_27,JButton Button_28,JButton Button_29,JButton Button_30) {
		String dateSelected = dateChoice.getSelectedItem();
		String timeSelected = timeChoice.getSelectedItem();
		dateSelected = dateSelected.replace("-", "");
		timeSelected = timeSelected.replace(":", "");
		timeSelected = timeSelected.replace(".", "");
		timeSelected = timeSelected.replace(" ", "");
		String fileName = "D:\\project\\" + dateSelected + timeSelected + ".txt";
		String oldContent = readOldContent(fileName);
		
		ArrayList<Integer> seatNumbers = new ArrayList<Integer>();
		
		seatNumbers = getSeatNumbersFromString(oldContent);
		
		System.out.println("Already Booked Seats:" + seatNumbers);
		
		for(int i=1;i<=30;i++) {
			if(seatNumbers.contains(i)) {
				continue;
			}
			enableSeat(i, Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
		}
		
		for(int seatNumber: seatNumbers) {
			disableSeat(seatNumber, Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_10, Button_11, Button_12, Button_13, Button_14, Button_15, Button_16, Button_17, Button_18, Button_19, Button_20, Button_21, Button_22, Button_23, Button_24, Button_25, Button_26, Button_27, Button_28, Button_29, Button_30);
		}
		
		
	}
	
	

	public static ArrayList<Integer> getSeatNumbersFromString(String content){
		Pattern pattern = Pattern.compile("\\d+");
		if(content==null) {
			return new ArrayList<Integer>();
		}
		Matcher m = pattern.matcher(content);
		ArrayList<Integer> seatNumbers = new ArrayList<Integer>();
		while(m.find()) {
			seatNumbers.add(Integer.parseInt(m.group()));
		}
		
		return seatNumbers; 
		
	}
	public static void saveBooking(Choice dateChoice, Choice timeChoice, int selectedSeat) {
		String dateSelected = dateChoice.getSelectedItem();
		String timeSelected = timeChoice.getSelectedItem();
		dateSelected = dateSelected.replace("-", "");
		timeSelected = timeSelected.replace(":", "");
		timeSelected = timeSelected.replace(".", "");
		timeSelected = timeSelected.replace(" ", "");

		System.out.println(dateSelected + timeSelected + ".txt");
		try {
			String fileName = "D:\\project\\" + dateSelected + timeSelected + ".txt";
			String oldContent = readOldContent(fileName);

			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter pWriter = new PrintWriter(file);

			pWriter.append(oldContent + "#" + selectedSeat + "#");

			pWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static String readOldContent(String fileName) {

		try {
			FileReader fReader = new FileReader(new File(fileName));
			int ch;
			StringBuilder sBuilder = new StringBuilder();
			while((ch=fReader.read())!=-1)
			{
				sBuilder.append((char)ch);
			}
			fReader.close();
			
			return sBuilder.toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void readBooking() {

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
