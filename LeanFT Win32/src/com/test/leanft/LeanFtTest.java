package com.test.leanft;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.stdwin.EditField;
import com.hp.lft.sdk.stdwin.EditFieldDescription;
import com.hp.lft.sdk.stdwin.Menu;
import com.hp.lft.sdk.stdwin.MenuDescription;
import com.hp.lft.sdk.stdwin.RadioButton;
import com.hp.lft.sdk.stdwin.RadioButtonDescription;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;

import unittesting.UnitTestClassBase;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    	
    	Desktop.launchAut("testapp.exe", new String [] {}, "C:\\Program Files (x86)\\Silk\\Silk Test Sample Applications\\ng\\sampleapplications\\win32");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
    	
		Window testApplicationWindow = Desktop.describe(Window.class, new WindowDescription.Builder()
				.childWindow(false)
				.ownedWindow(false)
				.windowClassRegExp("TestApp")
				.windowTitleRegExp("Test Application").build());
		Menu menu = testApplicationWindow.describe(Menu.class, new MenuDescription.Builder()
				.type(com.hp.lft.sdk.stdwin.MenuType.MENU).build());
		menu.select("Control;Radio button...");

		Dialog radioButtonDialog = testApplicationWindow.describe(Dialog.class, new DialogDescription.Builder()
				.childWindow(false)
				.ownedWindow(true)
				.nativeClass("#32770")
				.text("Radio Button").build());
		RadioButton theSecondChoiceRadioButton = radioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.nativeClass("Button")
				.text("The second choice").build());
		theSecondChoiceRadioButton.set();

		RadioButton theThirdChoiceRadioButton = radioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.nativeClass("Button")
				.text("The third choice").build());
		theThirdChoiceRadioButton.set();

		RadioButton theCustomChoiceRadioButton = radioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.nativeClass("Button")
				.text("The custom choice").build());
		theCustomChoiceRadioButton.set();

		Button exitButton = radioButtonDialog.describe(Button.class, new ButtonDescription.Builder()
				.nativeClass("Button")
				.text("&Exit").build());
		exitButton.click();

		menu.select("Control;Textfield...");

		Dialog textFieldDialog = testApplicationWindow.describe(Dialog.class, new DialogDescription.Builder()
				.childWindow(false)
				.ownedWindow(true)
				.nativeClass("#32770")
				.text("Text Field").build());
		EditField theSingleLineTextFieldEditField = textFieldDialog.describe(EditField.class, new EditFieldDescription.Builder()
				.attachedText("The single line text field")
				.nativeClass("Edit").build());
		theSingleLineTextFieldEditField.setText("Hello");

		theSingleLineTextFieldEditField.sendKeys(com.hp.lft.sdk.Keys.RETURN);

		menu.select("Control;Static text...");

		Dialog staticTextDialog = testApplicationWindow.describe(Dialog.class, new DialogDescription.Builder()
				.childWindow(false)
				.ownedWindow(true)
				.nativeClass("#32770")
				.text("Static text").build());
		Button setLabelButton = staticTextDialog.describe(Button.class, new ButtonDescription.Builder()
				.nativeClass("Button")
				.text("Set Label").build());
		setLabelButton.click();

		Button exitButton1 = staticTextDialog.describe(Button.class, new ButtonDescription.Builder()
				.nativeClass("Button")
				.text("&Exit").build());
		exitButton1.click();

		testApplicationWindow.close();

    }

}