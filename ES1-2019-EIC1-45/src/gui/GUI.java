package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private JTable ExcelTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
		/*        
		 * needs to be full
		 * table needs to ocupy full right side
		 */
				} catch (Exception e) {
					e.printStackTrace();

				} 
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 881, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton iplasmaButton = new JButton("Qualidade iPlasma");
		iplasmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		panel_1.add(iplasmaButton);
		
		JButton PMDButton = new JButton("Qualidade PMD");
		panel_1.add(PMDButton);
		
		JButton UserRulesButton = new JButton("Regras User");
		panel_1.add(UserRulesButton);
		
		
	
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		@SuppressWarnings("deprecation")
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", 5, false},
			    {"John", "Doe",
			     "Rowing", 3, true},
			    {"Sue", "Black",
			     "Knitting", 2, false},
			    {"Jane", "White",
			     "Speed reading", 20, true},
			    {"Joe", "Brown",
			     "Pool", 10, false}
			};
		ExcelTable = new JTable(data, columnNames);
		panel_2.add(ExcelTable);
	}

}
