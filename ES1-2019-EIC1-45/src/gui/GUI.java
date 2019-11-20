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
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
					window.frame.pack();
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
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem PMDQualityMenu = new JMenuItem("PMD Quality");
		PMDQualityMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}
			
		});
		menuBar.add(PMDQualityMenu);
		
		JMenuItem IPlasmaQualityMenu = new JMenuItem("iPlasma Quality\r\n");
		IPlasmaQualityMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}
			
		});
		menuBar.add(IPlasmaQualityMenu);
		
		JMenuItem VisualizeRulesMenu = new JMenuItem("Visualize Rules");
		VisualizeRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				panel_2.setVisible(!panel_2.isVisible());
			}
			
		});
		menuBar.add(VisualizeRulesMenu);
		
		JMenuItem AddNewRulesMenu = new JMenuItem("Add new rules");
		AddNewRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}
			
		});
		menuBar.add(AddNewRulesMenu);
		
		JMenuItem exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		menuBar.add(exitMenu);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
