package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import excel.ExcelFile;
import excel.ExcelObject;

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
					window.frame.setResizable(false);
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

		JPanel panel_2 = new JPanel();

		String[] columnNames = { "MethodID", "package", "class", "method", "LOC", "CYCLO", "ATFD", "LAA",
				"Is Long Method", "iPlasma", "PMD", "Is feature envy" };

		JTable ExcelTable = new JTable(convertToStringMatrix(), columnNames);
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
		// change

		JMenu VisualizeRulesMenu = new JMenu("Visualize Rules");
		JMenuItem dci = new JMenuItem("DCI");
		dci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel dciPanel = new JPanel();
				if (panel_2.isVisible()) {
					panel_2.setVisible(false);
					JLabel label = new JLabel("O valor do DCI e ");
					dciPanel.add(label);
					frame.add(dciPanel);
				} else {
					frame.removeAll();
					frame.repaint();
					panel_2.setVisible(true);
				}

			}

		});
		JMenuItem dii = new JMenuItem("DII");
		dii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}

		});
		JMenuItem adci = new JMenuItem("ADCI");
		adci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}

		});
		JMenuItem adii = new JMenuItem("ADII");
		adii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
			}

		});

		VisualizeRulesMenu.add(dci);
		VisualizeRulesMenu.add(dii);
		VisualizeRulesMenu.add(adci);
		VisualizeRulesMenu.add(adii);

		VisualizeRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				panel_2.setVisible(!panel_2.isVisible());
			}

		});
		menuBar.add(VisualizeRulesMenu);
		
		JPanel newRulesPanelMain = new JPanel(new BorderLayout());
		JPanel newRulesPanelCheckBox = new JPanel(new GridLayout(2,2,10,10));
		newRulesPanelMain.add(newRulesPanelCheckBox,BorderLayout.NORTH);
		JMenuItem AddNewRulesMenu = new JMenuItem("Add new rules");
		ArrayList<JCheckBox> checkboxList = new ArrayList<>();
		JCheckBox LOCBox = new JCheckBox("LOC");
		checkboxList.add(LOCBox);
		newRulesPanelCheckBox.add(LOCBox);
		JCheckBox CYCLOBox = new JCheckBox("CYCLO");
		checkboxList.add(CYCLOBox);
		newRulesPanelCheckBox.add(CYCLOBox);
		JCheckBox AFTDBox = new JCheckBox("AFTD");
		checkboxList.add(AFTDBox);
		newRulesPanelCheckBox.add(AFTDBox);
		JCheckBox LAABox = new JCheckBox("LAA");
		checkboxList.add(LAABox);
		newRulesPanelCheckBox.add(LAABox);
		ButtonGroup methodChooser = new ButtonGroup();
		JRadioButton is_feature_envy = new JRadioButton("is_feature_envy",true);
		JRadioButton is_long_method = new JRadioButton("is_long_method");
		methodChooser.add(is_feature_envy);
		methodChooser.add(is_long_method);
		ButtonGroup andOr = new ButtonGroup();
		JRadioButton andButton = new JRadioButton("And",true);
		JRadioButton orButton = new JRadioButton("Or");
		andOr.add(andButton);
		andOr.add(orButton);
		ButtonGroup moreLessArg1 = new ButtonGroup();
		JRadioButton biggerButtonArg1 = new JRadioButton("Arg 1 >",true);
		JRadioButton smallerButtonArg1 = new JRadioButton("Arg 1 <");
		moreLessArg1.add(biggerButtonArg1);
		moreLessArg1.add(smallerButtonArg1);
		ButtonGroup moreLessArg2 = new ButtonGroup();
		JRadioButton biggerButtonArg2 = new JRadioButton("Arg 1 >",true);
		JRadioButton smallerButtonArg2 = new JRadioButton("Arg 2 <");
		moreLessArg2.add(biggerButtonArg2);
		moreLessArg2.add(smallerButtonArg2);
		JPanel newRulesPanelRadioButtons = new JPanel(new GridLayout(4,2));
		newRulesPanelMain.add(newRulesPanelRadioButtons,BorderLayout.CENTER);
		newRulesPanelRadioButtons.add(is_feature_envy);
		newRulesPanelRadioButtons.add(is_long_method);
		newRulesPanelRadioButtons.add(orButton);
		newRulesPanelRadioButtons.add(andButton);
		newRulesPanelRadioButtons.add(biggerButtonArg1);
		newRulesPanelRadioButtons.add(smallerButtonArg1);
		newRulesPanelRadioButtons.add(biggerButtonArg2);
		newRulesPanelRadioButtons.add(smallerButtonArg2);
		
		JPanel newRulesPanelTextFields = new JPanel(new GridLayout(2,1));
		newRulesPanelMain.add(newRulesPanelTextFields,BorderLayout.SOUTH);
		JTextField arg1Value = new JTextField("Insert Threshold for the first argument:");
		JTextField arg2Value = new JTextField("Insert Threshold for the second argument:");
		newRulesPanelTextFields.add(arg1Value);
		newRulesPanelTextFields.add(arg2Value);
		
		
		
		
		
		AddNewRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_2.setVisible(!panel_2.isVisible());
				newRulesPanelMain.setVisible(!newRulesPanelMain.isVisible());
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
		frame.getContentPane().add(panel_2);
		frame.getContentPane().add(newRulesPanelMain);
		newRulesPanelMain.setVisible(false);
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
		for (ExcelObject eo : list) {
			Object[] temp = { eo.getId(), eo.getPckage(), eo.getClass(), eo.getMethod(), eo.getLoc(), eo.getCyclo(),
					eo.getAtfd(), eo.getLaa(), eo.isIs_long_method(), eo.isiPlasma(), eo.isPMD(),
					eo.isIs_feature_envy() };
			matrixGUI[contador] = temp;
			contador++;
		}
		return matrixGUI;

	}
}
