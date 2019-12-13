package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.GUI;
import gui.Rule;

class GUITests {
		GUI gui;
		
	@BeforeEach
	void setUp() throws Exception {
		gui = new GUI();
	}

	@Test
	void testArrayListToArray() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ola");
		
		assertNotNull(gui.arrayListToArray(list));
	}

}
