package project;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	static String bookingsHistoryFile = "D:\\project\\BookingHistory.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingHistory frame = new BookingHistory();
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
	public BookingHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		Date Booked|UserName|Show Date|Show Time|Seat Number|MovieName|BookingID| 
		String[] columns ={"Date Booked", "User Name", "Show Date","Show Time","Seat Number","Movie Name","Booking ID"};
		
		String[][] values = getData();		
		table.setModel(new DefaultTableModel(values,columns));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0; i<columns.length; i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("Back to Bookings");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}

	public static String[][] getData() {
		String[][] data = new String[100][7];
		ArrayList<String> data1= new ArrayList<String>();
		String loggedInUser = Booking.getLoggedInUser();
		int counter = 0;
		try {
			FileReader fReader = new FileReader(new File(bookingsHistoryFile));
			StringBuilder sBuilder = new StringBuilder();
//			fReader.read()
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			int no_of_records=0;
			while((line=bReader.readLine())!=null)
			{
				System.out.println(line);
				String str[] = line.split("\\|");
				String bookedDate = str[0];
				String userName = str[1];
				String showDate = str[2];
				String showTime = str[3];
				String seatNumber = str[4];
				String MovieName = str[5];
				String BookingId = str[6];				
				if(userName.equals(loggedInUser))
				{
					data1.add(bookedDate);
					data1.add(userName);
					data1.add(showDate);
					data1.add(showTime);
					data1.add(seatNumber);
					data1.add(MovieName);
					data1.add(BookingId);
//					System.out.println(bookedDate+userName+showDate+showTime+seatNumber+MovieName+BookingId);
					no_of_records++;
				}
				else {
					continue;
				}
			}
			fReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String arr[] = data1.toArray(new String[data1.size()]);
		System.out.println(arr.length + " " +arr.length/7);
		for(String s:arr) {
			System.out.println(s);
		}
		for(int i=0;i<arr.length;i+=7) {
			data[counter][0] = arr[i];
			data[counter][1] = arr[i+1];
			data[counter][2] = arr[i+2];
			data[counter][3] = arr[i+3];
			data[counter][4] = arr[i+4];
			data[counter][5] = arr[i+5];
			data[counter][6] = arr[i+6];
			counter++;
		}

		return data;
	}
	
	public static String[][] getData1() {
		
		int no_of_records=0;
		int total_records_found =0;
		int counter=0;
		ArrayList<String> data1= new ArrayList<String>();
		String loggedInUser = Booking.getLoggedInUser();
		String bookingsHistory = Booking.readOldContent(bookingsHistoryFile);
		System.out.println(bookingsHistory);
		String lines[] = bookingsHistory.split("\r\n");
		System.out.println("Lenth of lines"+lines.length);
		
		for(String line:lines) {
			String str[] = line.split("\\|");
			String bookedDate = str[0];
			String userName = str[1];
			String showDate = str[2];
			String showTime = str[3];
			String seatNumber = str[4];
			String MovieName = str[5];
			String BookingId = str[6];	
			if(userName.equals(loggedInUser))
			{
				data1.add(bookedDate);
				data1.add(userName);
				data1.add(showDate);
				data1.add(showTime);
				data1.add(seatNumber);
				data1.add(MovieName);
				data1.add(BookingId);
//				System.out.println(bookedDate+userName+showDate+showTime+seatNumber+MovieName+BookingId);
				no_of_records++;
			}
			total_records_found++;
		}
		
		System.out.println("Number of Records Found: "+no_of_records);
		System.out.println("Number of Total Records Found: "+total_records_found);
		String arr[] = data1.toArray(new String[data1.size()]);
//		System.out.println(arr.length + " " +arr.length/7);
		String[][] data = new String[arr.length/7][7];
//		while(counter<no_of_records)
//		{
			for(int i=0;i<arr.length;i+=7) {
				
				data[counter][0] = arr[i];
				data[counter][1] = arr[i+1];
				data[counter][2] = arr[i+2];
				data[counter][3] = arr[i+3];
				data[counter][4] = arr[i+4]; System.out.println(arr[i+4]);
				data[counter][5] = arr[i+5];
				data[counter][6] = arr[i+6];
				counter++;
			}
//			System.out.println(counter);
//		}		
		return data;
	}
	
	
}
