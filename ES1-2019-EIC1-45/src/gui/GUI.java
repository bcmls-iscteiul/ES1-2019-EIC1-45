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

import excel.ExcelFile;
import excel.ExcelObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI {

	private JFrame frame;
	private JTable ExcelTable;
	private ExcelFile excelfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.convertToStringMatrix();
					window.frame.pack();
					window.frame.setVisible(true);
					/*
					 * needs to be full table needs to ocupy full right side
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
		try {
			excelfile = new ExcelFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setBounds(100, 100, 881, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		String[] columnNames = { "MethodID", "package", "class", "method", "LOC","CYCLO","ATFD", "LAA" , "Is Long Method", "iPlasma", "PMD", "Is feature envy"};
		

		
		
		JTable ExcelTable= new JTable(convertToStringMatrix(), columnNames);
		 ExcelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	       JScrollPane pane = new JScrollPane(ExcelTable);
		panel_2.add(pane, BorderLayout.CENTER);

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
	
	private Object[][] convertToStringMatrix() {
		List<ExcelObject> list = excelfile.getExcelObjects();
		Object[][] matrixGUI = new Object[list.size()][12];
		int contador = 0;
		for(ExcelObject eo : list) {
			Object[] temp = {eo.getId(),eo.getPckage(),eo.getClass(),eo.getMethod(),eo.getLoc(),eo.getCyclo(),eo.getAtfd(),eo.getLaa(),eo.isIs_long_method(),eo.isiPlasma(),eo.isPMD(),eo.isIs_feature_envy()};
			matrixGUI[contador] = temp;
			contador++;
		}
		return matrixGUI;
		
	}
}
