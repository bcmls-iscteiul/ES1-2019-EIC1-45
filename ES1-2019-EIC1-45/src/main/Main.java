package main;

import java.awt.EventQueue;

import gui.GUI;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.convertToStringMatrix();
					window.getFrame().pack();
					window.getFrame().setResizable(false);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

}
