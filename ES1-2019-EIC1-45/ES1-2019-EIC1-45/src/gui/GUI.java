package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import excel.ExcelFile;
import excel.ExcelObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private Container container;
	private CardLayout layout = new CardLayout();

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
		//screenSize();
	}
	
	private void screenSize() {
		//size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		//height of the task bar
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;

		//available size of the screen 
		frame.setLocation(screenSize.width - frame.getWidth(), screenSize.height - taskBarSize - frame.getHeight());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		container = frame.getContentPane();
		try {
			excelfile = new ExcelFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//frame.setBounds(100, 100, 881, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layout);

		//Show Excel in GUI
		JPanel excelPanel = new JPanel();
		

		String[] columnNames = { "MethodID", "package", "class", "method", "LOC", "CYCLO", "ATFD", "LAA",
				"Is Long Method", "iPlasma", "PMD", "Is feature envy" };

		JTable ExcelTable = new JTable(convertToStringMatrix(), columnNames);
		ExcelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d = ExcelTable.getPreferredSize();
		d.height = 600;
		ExcelTable.setPreferredScrollableViewportSize( d );
		JScrollPane pane = new JScrollPane(ExcelTable);
		excelPanel.add(pane, BorderLayout.CENTER);
		container.add("ExcelPanel" ,excelPanel);
		//

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem showExcel = new JMenuItem("Show Excel Table");
		showExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout.show(container, "ExcelPanel");
			}
			
		});
		menuBar.add(showExcel);

		JMenuItem PMDQualityMenu = new JMenuItem("PMD Quality");
		PMDQualityMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		menuBar.add(PMDQualityMenu);

		JMenuItem IPlasmaQualityMenu = new JMenuItem("iPlasma Quality\r\n");
		IPlasmaQualityMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		menuBar.add(IPlasmaQualityMenu); 
		// change
		

		JMenu VisualizeRulesMenu = new JMenu("Visualize Rules");
		
		JPanel DCIPanel = new JPanel();
		JTextField dciTF = new JTextField("It works");
		DCIPanel.add(dciTF);
		container.add("DCIPanel", DCIPanel);
		JMenuItem dci = new JMenuItem("DCI");
		dci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout.show(container, "DCIPanel");

			}

		});
		JMenuItem dii = new JMenuItem("DII");
		dii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		JMenuItem adci = new JMenuItem("ADCI");
		adci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		JMenuItem adii = new JMenuItem("ADII");
		adii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		for(JCheckBox c : checkboxList) {
			c.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int count = 0;
					for (JCheckBox c : checkboxList) {
						if (c.isSelected()) {
							count +=1;
						}
						if (count > 2) {
							JCheckBox check =(JCheckBox) e.getSource();
							check.setSelected(false);
							JOptionPane.showMessageDialog(null, "You can only select 2 checkboxes");
						}
					}
				}
			});
		}
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
		newRulesPanelRadioButtons.add(andButton);
		newRulesPanelRadioButtons.add(orButton);
		newRulesPanelRadioButtons.add(biggerButtonArg1);
		newRulesPanelRadioButtons.add(smallerButtonArg1);
		newRulesPanelRadioButtons.add(biggerButtonArg2);
		newRulesPanelRadioButtons.add(smallerButtonArg2);

		JPanel newRulesPanelTextFields = new JPanel(new GridLayout(3,2));
		newRulesPanelMain.add(newRulesPanelTextFields,BorderLayout.SOUTH);
		JLabel arg1Label = new JLabel("Insert Threshold for the first argument:");
		JTextField arg1Value = new JTextField();
		JLabel arg2Label = new JLabel("Insert Threshold for the second argument:");
		JTextField arg2Value = new JTextField();
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int checkBoxCount = 0;
				String Arg1 = "";
				String Arg2 = "";
				for(JCheckBox c : checkboxList) {
					if(Arg1.equals("")&&c.isSelected()) {
						Arg1 = c.getText();
						checkBoxCount++;
					}else if (Arg2.equals("")&& c.isSelected()){
						Arg2 = c.getText();
						checkBoxCount++;
					}
				}
				if(checkBoxCount == 2 && !arg1Value.getText().equals("") && !arg2Value.getText().equals("")) {
					Double threshold1, threshold2;
					try {
						threshold1 = Double.parseDouble(arg1Value.getText());
						threshold2 = Double.parseDouble(arg2Value.getText());
					} catch (NumberFormatException exc) {
						JOptionPane.showMessageDialog(null, "Make sure you entered numbers in the Text Fields.");
						return;
					}
					Boolean greaterArg1 = false;
					if(biggerButtonArg1.isSelected()) {
						greaterArg1 = true;
					}
					Boolean greaterArg2 = false;
					if(biggerButtonArg2.isSelected()) {
						greaterArg2 = true;
					}
					Boolean andValue = false;
					if(andButton.isSelected()) {
						andValue = true;
					}
					Boolean isFeatureEnvy = false;
					if(is_feature_envy.isSelected()) {
						isFeatureEnvy=true;
					}
					calculateNewRule(Arg1,Arg2,threshold1,threshold2,greaterArg1,greaterArg2,andValue,isFeatureEnvy);
					newRulesPanelMain.setVisible(!newRulesPanelMain.isVisible());
					excelPanel.setVisible(!excelPanel.isVisible());
				}else if(checkBoxCount!=2) {
					JOptionPane.showMessageDialog(null, "You must select two arguments.");
				}else if (arg1Value.getText().equals("")||arg2Value.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Make sure you entered both values for the thresholds.");
				}

			}

			private void calculateNewRule(String arg1, String arg2, Double threshold1, Double threshold2,
					Boolean greaterArg1, Boolean greaterArg2, Boolean andValue,Boolean isFeatureEnvy) {
				for(int i =0; i<ExcelTable.getRowCount();i++) {
					double arg1Value,arg2Value;
					switch(arg1) {
						case("LOC"):
							arg1Value = (double) ExcelTable.getValueAt(i, 4);
							System.out.println(arg1Value);
							break;
						case("CYCLO"):
							arg1Value = (double) ExcelTable.getValueAt(i, 5);
							System.out.println(arg1Value);
							break;
						case("AFTD"):
							arg1Value = (double) ExcelTable.getValueAt(i, 6);
							System.out.println(arg1Value);
							break;
						default:
							arg1Value = 0;
					}
					switch(arg2) {
						case("CYCLO"):
							arg2Value = (double) ExcelTable.getValueAt(i, 5);
							System.out.println(arg2Value);
							break;
						case("AFTD"):
							arg2Value = (double) ExcelTable.getValueAt(i, 6);
							System.out.println(arg2Value);
							break;
						case("LAA"):
							arg2Value = (double) ExcelTable.getValueAt(i, 7);
							System.out.println(arg2Value);
							break;
						default:
							arg2Value = 0;
					}
					Boolean isTrue=false;
					if(greaterArg1&&greaterArg2&&andValue) {
						isTrue = arg1Value >= threshold1 && arg2Value >=threshold2;
						System.out.println("> > &&");
					}else if(greaterArg1&&greaterArg2&&!andValue) {
						isTrue = arg1Value >= threshold1 || arg2Value >= threshold2; 
						System.out.println("> > ||");
					}else if(greaterArg1&&!greaterArg2&&andValue) {
						isTrue = arg1Value >= threshold1 && arg2Value < threshold2; 
						System.out.println("> < &&");
					}else if(greaterArg1&&!greaterArg2&&!andValue) {
						isTrue = arg1Value >= threshold1 || arg2Value < threshold2; 
						System.out.println("> < ||");
					}else if(!greaterArg1&&greaterArg2&&andValue) {
						isTrue = arg1Value < threshold1 && arg2Value >= threshold2;
						System.out.println("< > &&");
					}else if(!greaterArg1&&greaterArg2&&!andValue) {
						isTrue = arg1Value < threshold1 || arg2Value >= threshold2;
						System.out.println("< > ||");
					}else if(!greaterArg1&&!greaterArg2&&andValue) {
						isTrue = arg1Value < threshold1 && arg2Value < threshold2; 
						System.out.println("< < &&");
					}else if(!greaterArg1&&!greaterArg2&&!andValue) {
						isTrue = arg1Value < threshold1 || arg2Value >= threshold2; 
						System.out.println("< < ||");
					}
					if(isFeatureEnvy) {
						ExcelTable.setValueAt(isTrue, i, 11);
					}else {
						ExcelTable.setValueAt(isTrue, i, 8);
					}
				}
				
			}
		});
		newRulesPanelTextFields.add(arg1Label);
		newRulesPanelTextFields.add(arg1Value);
		newRulesPanelTextFields.add(arg2Label);
		newRulesPanelTextFields.add(arg2Value);
		newRulesPanelTextFields.add(submitButton);





		AddNewRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excelPanel.setVisible(!excelPanel.isVisible());
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
		frame.getContentPane().add(excelPanel);
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
