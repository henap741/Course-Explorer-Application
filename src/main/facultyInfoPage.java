package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;

public class facultyInfoPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facultyInfoPage frame = new facultyInfoPage();
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
	public facultyInfoPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel infoLabel = new JLabel("<html>\r\n"
//				+ "  <body>\r\n"
//				+ "    <p>Contact:</p>\r\n"
//				+ "    <p>Representatives of the Admissions Office are happy to answer your questions or to meet with you to for an advising appointment to discuss your application.</p>\r\n"
//				+ "    <p>Current Osgoode students are another great source of information and guidance for prospective and newly admitted students. To speak with one of our Student Ambassadors. Import content from or to arrange a tour, please contact our Student Recruitment Coordinator at recruitment@osgoode.yorku.ca.</p>\r\n"
//				+ "    <p>Office of Admissions and Student Services<br>\r\n"
//				+ "    Osgoode Hall Law School<br>\r\n"
//				+ "    1012 Ignat Kaneff Building<br>\r\n"
//				+ "    York University<br>\r\n"
//				+ "    4700 Keele Street<br>\r\n"
//				+ "    Toronto, Ontario M3J 1P3</p>\r\n"
//				+ "    <p>Telephone: 416-736-5712<br>\r\n"
//				+ "    Email: admissions@osgoode.yorku.ca</p>\r\n"
//				+ "    <p><a href='http://www.yorku.ca/maps/'>Click here</a> to find the Ignat Kaneff Building on an interactive campus map of York University.</p>\r\n"
//				+ "    <p>Hours of Operation:<br>\r\n"
//				+ "    Monday to Friday – 8:30am-4:30pm<br>\r\n"
//				+ "    In June, July and August the office closes at 3:30pm on Fridays</p>\r\n"
//				+ "    <p>Admissions Office Staff:<br>\r\n"
//				+ "    Mya Rimon, Assistant Dean, Students – mrimon@osgoode.yorku.ca<br>\r\n"
//				+ "    Marcos Ramos Jr, Manager, Admissions & Financial Services – mramos@osgoode.yorku.ca<br>\r\n"
//				+ "    Louise Resendes, Recruitment & Admissions Officer – lresendes@osgoode.yorku.ca<br>\r\n"
//				+ "    Vicky Faclaris, Recruitment & Admissions Coordinator – vfaclaris@osgoode.yorku.ca<br>\r\n"
//				+ "    Student Recruitment Coordinator – recruitment@osgoode.yorku.ca</p>\r\n"
//				+ "  </body>\r\n"
//				+ "</html>\r\n");
		
		JButton settings_button = new JButton("Settings");
		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		settings_button.setBounds(10, 231, 91, 23);
		contentPane.add(settings_button);
		
		JButton back_button = new JButton("Back");
		back_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		back_button.setBounds(122, 11, 62, 23);
		back_button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        mainMenuPage mainMenuPage = new mainMenuPage();
		        mainMenuPage.setVisible(true);
		        dispose();
		      }
		    });
		    contentPane.add(back_button, BorderLayout.WEST);
		
		JButton home_button = new JButton("Home");
		home_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		home_button.setBounds(186, 11, 68, 23);
		home_button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        mainMenuPage mainMenuPage = new mainMenuPage();
		        mainMenuPage.setVisible(true);
		        dispose();
		      }
		    });
		    contentPane.add(home_button, BorderLayout.EAST);
		    
		    JLabel info_label = new JLabel("<html>\r\n"
		    		+ "  <body>\r\n"
		    		+ "    <p>Contact:</p>\r\n"
		    		+ "    <p>Representatives of the Admissions Office are happy to answer your questions or to meet with you to for an advising appointment to discuss your application.</p>\r\n"
		    		+ "    <p>Current Osgoode students are another great source of information and guidance for prospective and newly admitted students. To speak with one of our Student Ambassadors.</p>\r\n"
		    		+ "    <p>Import content from or to arrange a tour, please contact our Student Recruitment Coordinator at recruitment@osgoode.yorku.ca.</p>\r\n"
		    		+ "    <p>Office of Admissions and Student Services<br>\r\n"
		    		+ " <p> </p>"
		    		+ "    Osgoode Hall Law School<br>\r\n"
		    		+ "    1012 Ignat Kaneff Building<br>\r\n"
		    		+ "    York University<br>\r\n"
		    		+ "    4700 Keele Street<br>\r\n"
		    		+ "    Toronto, Ontario M3J 1P3</p>\r\n"
		    		+ " <p> </p>\n"
		    		+ "    <p>Telephone: 416-736-5712<br>\r\n"
		    		+ "    Email: admissions@osgoode.yorku.ca</p>\r\n"
		    		+ "    <p><a href='http://www.yorku.ca/maps/'>Click here</a> to find the Ignat Kaneff Building on an interactive campus map of York University.</p>\r\n"
		    		+ " <p> </p>\n"
		    		+ "    <p>Hours of Operation:<br>\r\n"
		    		+ "    Monday to Friday – 8:30am-4:30pm<br>\r\n"
		    		+ "    In June, July and August the office closes at 3:30pm on Fridays</p>\r\n"
		    		+ " <p> </p>\n"
		    		+ "    <p>Admissions Office Staff:<br>\r\n"
		    		+ "    Mya Rimon, Assistant Dean, Students – mrimon@osgoode.yorku.ca<br>\r\n"
		    		+ "    Marcos Ramos Jr, Manager, Admissions & Financial Services – mramos@osgoode.yorku.ca<br>\r\n"
		    		+ "    Louise Resendes, Recruitment & Admissions Officer – lresendes@osgoode.yorku.ca<br>\r\n"
		    		+ "    Vicky Faclaris, Recruitment & Admissions Coordinator – vfaclaris@osgoode.yorku.ca<br>\r\n"
		    		+ "    Student Recruitment Coordinator – recruitment@osgoode.yorku.ca</p>\r\n"
		    		+ "  </body>\r\n"
		    		+ "</html>"
		    		);
		    info_label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		    //info_label.setBounds(122, 76, 306, 178);
		    contentPane.add(info_label);
		    JScrollPane scrollPane = new JScrollPane(info_label);
		    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    scrollPane.setBounds(122, 76, 306, 178);
		    //scrollPane.setBounds(411, 76, 17, 48);
		    contentPane.add(scrollPane);

		    JLabel title_label = new JLabel("Faculty Contact Information");
		    title_label.setForeground(new Color(0, 0, 0));
		    title_label.setEnabled(false);
		    title_label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		    title_label.setBounds(122, 45, 306, 20);
		    contentPane.add(title_label);
	}
}
