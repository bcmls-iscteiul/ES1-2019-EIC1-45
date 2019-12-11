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
import javax.swing.SwingUtilities;

import org.apache.commons.math3.analysis.function.Add;

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
import java.lang.reflect.AnnotatedTypeVariable;
import java.net.NoRouteToHostException;
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

/**
 * This class represents a line of the excel file.
 * 
 * @author Bernando Sequeira
 * @author Joao Pinto
 *
 */

public class GUI {

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Main Frame used
	 */
	private JFrame frame;
	/**
	 * JTable used to show the Excel file
	 */
	private JTable ExcelTable;
	/**
	 * Object containing the Excel File(Apache)
	 */
	private ExcelFile excelfile;
	/**
	 * Container used along with CardLayout
	 */
	private Container container;
	/**
	 * Defining CardLayout
	 */
	private CardLayout layout = new CardLayout();

	/**
	 * Launch the application.
	 */

	private ArrayList<Rule> ruleList;
	JPanel DCIPanel;
	JPanel DIIPanel;
	JPanel ADCIPanel;
	JPanel ADIIPanel;
	private Rule isLongRule = new Rule("isLong", "LOC", "CYCLO", 80., 10., true, true, true, false);
	private Rule isFeatureRule = new Rule("isFeatureEnvy", "ATFD", "LAA", 4., 0.42, true, false, true, true);

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
		ruleList = new ArrayList<>();
		ruleList.add(isFeatureRule);
		ruleList.add(isLongRule);
		initialize();
		// screenSize();
	}

	/**
	 * Implements all Swing components used. Includes a exit button.
	 */

	private void DCI() {
		Object[] listDCI_DII_ADCI_ADII = this.convertRulesToGUI();
		DCIPanel = new JPanel();
		String[] DCIcolumnNames = { "MethodID", "DCI" };
		JTable DCITable = new JTable((Object[][]) listDCI_DII_ADCI_ADII[0], DCIcolumnNames);
		DCITable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d1 = DCITable.getPreferredSize();
		d1.height = 600;
		DCITable.setPreferredScrollableViewportSize(d1);
		JScrollPane pane2 = new JScrollPane(DCITable);
		DCIPanel.add(pane2, BorderLayout.CENTER);
	}

	private void DII() {
		Object[] listDCI_DII_ADCI_ADII = this.convertRulesToGUI();
		DIIPanel = new JPanel();
		String[] DIIcolumnNames = { "MethodID", "DII" };
		JTable DIITable = new JTable((Object[][]) listDCI_DII_ADCI_ADII[1], DIIcolumnNames);
		DIITable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d2 = DIITable.getPreferredSize();
		d2.height = 600;
		DIITable.setPreferredScrollableViewportSize(d2);
		JScrollPane pane3 = new JScrollPane(DIITable);
		DIIPanel.add(pane3, BorderLayout.CENTER);
	}

	private void ADCI() {
		Object[] listDCI_DII_ADCI_ADII = this.convertRulesToGUI();

		ADCIPanel = new JPanel();
		String[] ADCIcolumnNames = { "MethodID", "ADCI" };
		JTable ADCITable = new JTable((Object[][]) listDCI_DII_ADCI_ADII[2], ADCIcolumnNames);
		ADCITable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d3 = ADCITable.getPreferredSize();
		d3.height = 600;
		ADCITable.setPreferredScrollableViewportSize(d3);
		JScrollPane pane4 = new JScrollPane(ADCITable);
		ADCIPanel.add(pane4, BorderLayout.CENTER);
	}

	private void ADII() {
		Object[] listDCI_DII_ADCI_ADII = this.convertRulesToGUI();
		ADIIPanel = new JPanel();
		String[] ADIIcolumnNames = { "MethodID", "ADII" };
		JTable ADIITable = new JTable((Object[][]) listDCI_DII_ADCI_ADII[3], ADIIcolumnNames);
		ADIITable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d4 = ADIITable.getPreferredSize();
		d4.height = 600;
		ADIITable.setPreferredScrollableViewportSize(d4);
		JScrollPane pane5 = new JScrollPane(ADIITable);
		ADIIPanel.add(pane5, BorderLayout.CENTER);
	}

	private void allDefects() {
		DCI();
		DII();
		ADCI();
		ADII();
	}

	private void initialize() {
		frame = new JFrame();
		container = frame.getContentPane();
		try {
			excelfile = new ExcelFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// frame.setBounds(100, 100, 881, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layout);

		// Show Excel in GUI
		JPanel excelPanel = new JPanel();

		String[] columnNames = { "MethodID", "package", "class", "method", "LOC", "CYCLO", "ATFD", "LAA",
				"Is Long Method", "iPlasma", "PMD", "Is feature envy" };

		ExcelTable = new JTable(convertToStringMatrix(), columnNames);
		ExcelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d = ExcelTable.getPreferredSize();
		d.height = 600;
		ExcelTable.setPreferredScrollableViewportSize(d);
		JScrollPane pane = new JScrollPane(ExcelTable);
		excelPanel.add(pane, BorderLayout.CENTER);
		container.add("ExcelPanel", excelPanel);
		//

		// Show DCI,DII,ADCI,ADII tables
		allDefects();
		container.add("DCIPanel", DCIPanel);

		container.add("DIIPanel", DIIPanel);

		container.add("ADCIPanel", ADCIPanel);

		container.add("ADIIPanel", ADIIPanel);
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

		JMenuItem defineThresholds = new JMenuItem("Define Thresholds");
		JPanel thresholdPanel = new JPanel(new BorderLayout());
		container.add("thresholdPanel", thresholdPanel);
		defineThresholds.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(container, "thresholdPanel");
			}

		});
		menuBar.add(defineThresholds);

		JPanel isLongPanel = new JPanel(new GridLayout(3, 2));
		JLabel LOCLabel = new JLabel("Define new Threshold for LOC: ");
		JTextField LOCValue = new JTextField();
		JLabel CYCLOLabel = new JLabel("Define new Threshold for CYCLO: ");
		JTextField CYCLOValue = new JTextField();
		JButton submitIsLong = new JButton("Submit isLong");
		submitIsLong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isLongRule.setThreshold1(Double.parseDouble(LOCValue.getText()));
				isLongRule.setThreshold2(Double.parseDouble(CYCLOValue.getText()));
				allDefects();
				getFrame().repaint();
				getFrame().validate();
			}
		});

		thresholdPanel.add(isLongPanel, BorderLayout.NORTH);
		isLongPanel.add(LOCLabel);
		isLongPanel.add(LOCValue);
		isLongPanel.add(CYCLOLabel);
		isLongPanel.add(CYCLOValue);
		isLongPanel.add(submitIsLong);

		JPanel isFeaturePanel = new JPanel(new GridLayout(3, 2));
		JLabel ATFDLabel = new JLabel("Define new Threshold for ATFD: ");
		JTextField ATFDValue = new JTextField();
		JLabel LAALabel = new JLabel("Define new Threshold for LAA: ");
		JTextField LAAValue = new JTextField();
		JButton submitIsFeature = new JButton("Submit isFeatureEnvy");
		submitIsFeature.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isFeatureRule.setThreshold1(Double.parseDouble(ATFDValue.getText()));
				isFeatureRule.setThreshold2(Double.parseDouble(LAAValue.getText()));
				allDefects();
				getFrame().repaint();
				getFrame().validate();
			}
		});
		thresholdPanel.add(isFeaturePanel, BorderLayout.SOUTH);
		isFeaturePanel.add(ATFDLabel);
		isFeaturePanel.add(ATFDValue);
		isFeaturePanel.add(LAALabel);
		isFeaturePanel.add(LAAValue);
		isFeaturePanel.add(submitIsFeature);

		JMenuItem visualizeRules = new JMenuItem("Visualize Rules");
		JPanel visualizeRulesPanel = new JPanel();
		container.add(visualizeRulesPanel, "visualizeRules");

		menuBar.add(visualizeRules);

		JMenu VisualizeRulesMenu = new JMenu("Quality");

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
				layout.show(container, "DIIPanel");
			}

		});
		JMenuItem adci = new JMenuItem("ADCI");
		adci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout.show(container, "ADCIPanel");
			}

		});
		JMenuItem adii = new JMenuItem("ADII");
		adii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout.show(container, "ADIIPanel");
			}

		});

		VisualizeRulesMenu.add(dci);
		VisualizeRulesMenu.add(dii);
		VisualizeRulesMenu.add(adci);
		VisualizeRulesMenu.add(adii);

		menuBar.add(VisualizeRulesMenu);

		JPanel newRulesPanelMain = new JPanel(new BorderLayout());
		JPanel newRulesPanelCheckBox = new JPanel(new GridLayout(2, 2, 10, 10));
		newRulesPanelMain.add(newRulesPanelCheckBox, BorderLayout.NORTH);
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
		for (JCheckBox c : checkboxList) {
			c.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int count = 0;
					for (JCheckBox c : checkboxList) {
						if (c.isSelected()) {
							count += 1;
						}
						if (count > 2) {
							JCheckBox check = (JCheckBox) e.getSource();
							check.setSelected(false);
							JOptionPane.showMessageDialog(null, "You can only select 2 checkboxes");
						}
					}
				}
			});
		}
		ButtonGroup methodChooser = new ButtonGroup();
		JRadioButton is_feature_envy = new JRadioButton("is_feature_envy", true);
		JRadioButton is_long_method = new JRadioButton("is_long_method");
		methodChooser.add(is_feature_envy);
		methodChooser.add(is_long_method);
		ButtonGroup andOr = new ButtonGroup();
		JRadioButton andButton = new JRadioButton("And", true);
		JRadioButton orButton = new JRadioButton("Or");
		andOr.add(andButton);
		andOr.add(orButton);
		ButtonGroup moreLessArg1 = new ButtonGroup();
		JRadioButton biggerButtonArg1 = new JRadioButton("Arg 1 >", true);
		JRadioButton smallerButtonArg1 = new JRadioButton("Arg 1 <");
		moreLessArg1.add(biggerButtonArg1);
		moreLessArg1.add(smallerButtonArg1);
		ButtonGroup moreLessArg2 = new ButtonGroup();
		JRadioButton biggerButtonArg2 = new JRadioButton("Arg 1 >", true);
		JRadioButton smallerButtonArg2 = new JRadioButton("Arg 2 <");
		moreLessArg2.add(biggerButtonArg2);
		moreLessArg2.add(smallerButtonArg2);
		JPanel newRulesPanelRadioButtons = new JPanel(new GridLayout(4, 2));
		newRulesPanelMain.add(newRulesPanelRadioButtons, BorderLayout.CENTER);
		newRulesPanelRadioButtons.add(is_feature_envy);
		newRulesPanelRadioButtons.add(is_long_method);
		newRulesPanelRadioButtons.add(andButton);
		newRulesPanelRadioButtons.add(orButton);
		newRulesPanelRadioButtons.add(biggerButtonArg1);
		newRulesPanelRadioButtons.add(smallerButtonArg1);
		newRulesPanelRadioButtons.add(biggerButtonArg2);
		newRulesPanelRadioButtons.add(smallerButtonArg2);

		JPanel newRulesPanelTextFields = new JPanel(new GridLayout(3, 2));
		newRulesPanelMain.add(newRulesPanelTextFields, BorderLayout.SOUTH);
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
				for (JCheckBox c : checkboxList) {
					if (Arg1.equals("") && c.isSelected()) {
						Arg1 = c.getText();
						checkBoxCount++;
					} else if (Arg2.equals("") && c.isSelected()) {
						Arg2 = c.getText();
						checkBoxCount++;
					}
				}
				if (checkBoxCount == 2 && !arg1Value.getText().equals("") && !arg2Value.getText().equals("")) {
					Double threshold1, threshold2;
					try {
						threshold1 = Double.parseDouble(arg1Value.getText());
						threshold2 = Double.parseDouble(arg2Value.getText());
					} catch (NumberFormatException exc) {
						JOptionPane.showMessageDialog(null, "Make sure you entered numbers in the Text Fields.");
						return;
					}
					Boolean greaterArg1 = false;
					if (biggerButtonArg1.isSelected()) {
						greaterArg1 = true;
					}
					Boolean greaterArg2 = false;
					if (biggerButtonArg2.isSelected()) {
						greaterArg2 = true;
					}
					Boolean andValue = false;
					if (andButton.isSelected()) {
						andValue = true;
					}
					Boolean isFeatureEnvy = false;
					if (is_feature_envy.isSelected()) {
						isFeatureEnvy = true;
					}
					Rule newCustomRule = new Rule("Custom", Arg1, Arg2, threshold1, threshold2, greaterArg1,
							greaterArg2, andValue, isFeatureEnvy);
					ruleList.add(newCustomRule);
					calculateNewRule(newCustomRule);
					layout.show(container, "ExcelPanel");
					// newRulesPanelMain.setVisible(!newRulesPanelMain.isVisible());
					// excelPanel.setVisible(!excelPanel.isVisible());
				} else if (checkBoxCount != 2) {
					JOptionPane.showMessageDialog(null, "You must select two arguments.");
				} else if (arg1Value.getText().equals("") || arg2Value.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Make sure you entered both values for the thresholds.");
				}

			}

		});
		newRulesPanelTextFields.add(arg1Label);
		newRulesPanelTextFields.add(arg1Value);
		newRulesPanelTextFields.add(arg2Label);
		newRulesPanelTextFields.add(arg2Value);
		newRulesPanelTextFields.add(submitButton);

		container.add("AddNewRules", newRulesPanelMain);
		AddNewRulesMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layout.show(container, "AddNewRules");
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

		visualizeRules.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(container, "visualizeRules");
				visualizeRulesPanel.removeAll();
				for (Rule r : ruleList) {
					String labelText = "";
					if (r.getGreaterArg1() && r.getGreaterArg2() && r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " > " + r.getThreshold1() + " && " + r.getArg2() + " > "
								+ r.getThreshold2();
						System.out.println("> > &&");
					} else if (r.getGreaterArg1() && r.getGreaterArg2() && !r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " > " + r.getThreshold1() + " || " + r.getArg2() + " > "
								+ r.getThreshold2();
						System.out.println("> > ||");
					} else if (r.getGreaterArg1() && !r.getGreaterArg2() && r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " > " + r.getThreshold1() + " && " + r.getArg2() + " < "
								+ r.getThreshold2();
						System.out.println("> < &&");
					} else if (r.getGreaterArg1() && !r.getGreaterArg2() && !r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " > " + r.getThreshold1() + " || " + r.getArg2() + " < "
								+ r.getThreshold2();
						System.out.println("> < ||");
					} else if (!r.getGreaterArg1() && r.getGreaterArg2() && r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " < " + r.getThreshold1() + " && " + r.getArg2() + " > "
								+ r.getThreshold2();
						System.out.println("< > &&");
					} else if (!r.getGreaterArg1() && r.getGreaterArg2() && !r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " < " + r.getThreshold1() + " || " + r.getArg2() + " > "
								+ r.getThreshold2();
						System.out.println("< > ||");
					} else if (!r.getGreaterArg1() && !r.getGreaterArg2() && r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " < " + r.getThreshold1() + " && " + r.getArg2() + " < "
								+ r.getThreshold2();
						System.out.println("< < &&");
					} else if (!r.getGreaterArg1() && !r.getGreaterArg2() && !r.getAndValue()) {
						labelText = r.getName() + r.getArg1() + " < " + r.getThreshold1() + " || " + r.getArg2() + " < "
								+ r.getThreshold2();
						System.out.println("< < ||");
					}
					JLabel label = new JLabel(labelText);
					visualizeRulesPanel.add(label);
					if (r.getName().equals("Custom")) {
						JButton edit = new JButton("Edit Custom Rule");
						visualizeRulesPanel.add(edit);
						edit.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								for (JCheckBox c : checkboxList) {
									if (c.getText().equals(r.getArg1()) || c.getText().equals(r.getArg2())) {
										c.setSelected(true);
									} else {
										c.setSelected(false);
									}
								}
								if (r.getAndValue()) {
									andButton.setSelected(true);
								} else {
									orButton.setSelected(false);
								}
								if (r.getGreaterArg1()) {
									biggerButtonArg1.setSelected(true);
								} else {
									smallerButtonArg1.setSelected(true);
								}
								if (r.getGreaterArg2()) {
									biggerButtonArg2.setSelected(true);
								} else {
									smallerButtonArg2.setSelected(true);
								}
								arg1Value.setText(r.getThreshold1().toString());
								arg2Value.setText(r.getThreshold2().toString());
								ruleList.remove(r);
								layout.show(container, "AddNewRules");
							}
						});

					}

					allDefects();
					getFrame().repaint();
					getFrame().validate();

				}
			}
		});
		// frame.getContentPane().add(excelPanel);
		// frame.getContentPane().add(newRulesPanelMain);
		// newRulesPanelMain.setVisible(false);

	}

	/**
	 * Gets the excelfile in an ExcelFile object
	 * 
	 * @return matrix containing every row and column in Strings
	 */
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

	/**
	 * Gets the boolean array which defines the DCI, DII, ADCI, ADII(Qualities)
	 * 
	 * @return array with 4 arrays containing the ID of the method and the boolen
	 *         related to the rule
	 */

	public Object[] convertRulesToGUI() {
		List<ExcelObject> list = excelfile.getExcelObjects();
		int contador = 0;
		Object[][] tempDCI = new Object[list.size()][list.size()];
		Object[][] tempDII = new Object[list.size()][list.size()];
		Object[][] tempADCI = new Object[list.size()][list.size()];
		Object[][] tempADII = new Object[list.size()][list.size()];
		for (ExcelObject eo : list) {
			boolean dci = eo.defineIndicators(eo)[0];
			boolean dii = eo.defineIndicators(eo)[1];
			boolean adci = eo.defineIndicators(eo)[2];
			boolean adii = eo.defineIndicators(eo)[3];
			Object[] tempDCIM = { eo.getId(), dci };
			tempDCI[contador] = tempDCIM;
			Object[] tempDIIM = { eo.getId(), dii };
			tempDII[contador] = tempDIIM;
			Object[] tempADCIM = { eo.getId(), adci };
			tempADCI[contador] = tempADCIM;
			Object[] tempADIIM = { eo.getId(), adii };
			tempADII[contador] = tempADIIM;
			contador++;
		}
		Object[] final_list = { tempDCI, tempDII, tempADCI, tempADII };
		return final_list;
	}

	private void calculateNewRule(Rule newRule) {
		for (int i = 0; i < this.ExcelTable.getRowCount(); i++) {
			double arg1Value, arg2Value;
			switch (newRule.getArg1()) {
			case ("LOC"):
				arg1Value = (double) this.ExcelTable.getValueAt(i, 4);
				System.out.println(arg1Value);
				break;
			case ("CYCLO"):
				arg1Value = (double) this.ExcelTable.getValueAt(i, 5);
				System.out.println(arg1Value);
				break;
			case ("AFTD"):
				arg1Value = (double) this.ExcelTable.getValueAt(i, 6);
				System.out.println(arg1Value);
				break;
			default:
				arg1Value = 0;
			}
			switch (newRule.getArg2()) {
			case ("CYCLO"):
				arg2Value = (double) this.ExcelTable.getValueAt(i, 5);
				System.out.println(arg2Value);
				break;
			case ("AFTD"):
				arg2Value = (double) this.ExcelTable.getValueAt(i, 6);
				System.out.println(arg2Value);
				break;
			case ("LAA"):
				arg2Value = (double) this.ExcelTable.getValueAt(i, 7);
				System.out.println(arg2Value);
				break;
			default:
				arg2Value = 0;
			}
			Boolean isTrue = false;
			if (newRule.getGreaterArg1() && newRule.getGreaterArg2() && newRule.getAndValue()) {
				isTrue = arg1Value >= newRule.getThreshold1() && arg2Value >= newRule.getThreshold2();
				System.out.println("> > &&");
			} else if (newRule.getGreaterArg1() && newRule.getGreaterArg2() && !newRule.getAndValue()) {
				isTrue = arg1Value >= newRule.getThreshold1() || arg2Value >= newRule.getThreshold2();
				System.out.println("> > ||");
			} else if (newRule.getGreaterArg1() && !newRule.getGreaterArg2() && newRule.getAndValue()) {
				isTrue = arg1Value >= newRule.getThreshold1() && arg2Value < newRule.getThreshold2();
				System.out.println("> < &&");
			} else if (newRule.getGreaterArg1() && !newRule.getGreaterArg2() && !newRule.getAndValue()) {
				isTrue = arg1Value >= newRule.getThreshold1() || arg2Value < newRule.getThreshold2();
				System.out.println("> < ||");
			} else if (!newRule.getGreaterArg1() && newRule.getGreaterArg2() && newRule.getAndValue()) {
				isTrue = arg1Value < newRule.getThreshold1() && arg2Value >= newRule.getThreshold2();
				System.out.println("< > &&");
			} else if (!newRule.getGreaterArg1() && newRule.getGreaterArg2() && !newRule.getAndValue()) {
				isTrue = arg1Value < newRule.getThreshold1() || arg2Value >= newRule.getThreshold2();
				System.out.println("< > ||");
			} else if (!newRule.getGreaterArg1() && !newRule.getGreaterArg2() && newRule.getAndValue()) {
				isTrue = arg1Value < newRule.getThreshold1() && arg2Value < newRule.getThreshold2();
				System.out.println("< < &&");
			} else if (!newRule.getGreaterArg1() && !newRule.getGreaterArg2() && !newRule.getAndValue()) {
				isTrue = arg1Value < newRule.getThreshold1() || arg2Value < newRule.getThreshold2();
				System.out.println("< < ||");
			}
			if (newRule.getIsFeatureEnvy()) {
				this.ExcelTable.setValueAt(isTrue, i, 11);
			} else {
				this.ExcelTable.setValueAt(isTrue, i, 8);
			}
		}

	}

}
