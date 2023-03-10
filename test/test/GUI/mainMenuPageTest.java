package test.GUI;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import main.BusinessLogic.ProgramPathway.OsgoodeLawSchool;
import main.GUI.Pages.mainMenuPage;
import static org.junit.Assert.*;

import org.junit.Before;

public class mainMenuPageTest {

    private OsgoodeLawSchool osgoode;
    private mainMenuPage mainMenu;

    @Before
    public void setUp() {
        mainMenu = new mainMenuPage(); // initialize the mainMenu object
        mainMenu.setVisible(true); // make the mainMenu visible
    }

    @Test
    public void testContentPaneNotNull() {
        mainMenuPage mainMenu = new mainMenuPage(); // create a new instance
        assertNotNull(mainMenu.getContentPane());
    }


    @Test
	public void testConstructor() {
		OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
		mainMenuPage mainMenuPage = new mainMenuPage(osgoode);
		assertNotNull("mainMenuPage should not be null", mainMenuPage);
		assertEquals("mainMenuPage should have the correct width", 450, mainMenuPage.getWidth());
		assertEquals("mainMenuPage should have the correct height", 300, mainMenuPage.getHeight());
	}
}
