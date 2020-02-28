import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.CheckBox;
import com.hp.lft.sdk.java.CheckBoxDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.MenuDescription;
import com.hp.lft.sdk.java.RadioButton;
import com.hp.lft.sdk.java.RadioButtonDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;

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
        Desktop.launchAut("javaw.exe", new String[] {"-cp","SwingSampleApp_x86.jar","MainWindow" }, "C:\\Program Files (x86)\\Silk\\Silk Test Sample Applications\\ng\\sampleapplications\\java\\swing");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
    	
		Window swingSampleApplicationWindow = Desktop.describe(Window.class, new WindowDescription.Builder()
				.title("Swing Sample Application").build());
		Menu componentsMenu = swingSampleApplicationWindow.describe(Menu.class, new MenuDescription.Builder()
				.label("Components").build());
		Menu jTextComponentsMenu = componentsMenu.describe(Menu.class, new MenuDescription.Builder()
				.label("JTextComponents").build());
		jTextComponentsMenu.select();

		Window textSamplerDemoWindow = Desktop.describe(Window.class, new WindowDescription.Builder()
				.title("TextSamplerDemo").build());
		Editor jTextFieldEditor = textSamplerDemoWindow.describe(Editor.class, new EditorDescription.Builder()
				.attachedText("JTextField:").build());
		jTextFieldEditor.setText("test");

		Editor jPasswordFieldEditor = textSamplerDemoWindow.describe(Editor.class, new EditorDescription.Builder()
				.attachedText("JPasswordField:").build());
		jPasswordFieldEditor.setSecure("5e5916e981221e2f0c9a0b681d7fc109");

		textSamplerDemoWindow.close();

		Menu jCheckBoxMenu = componentsMenu.describe(Menu.class, new MenuDescription.Builder()
				.label("JCheckBox").build());
		jCheckBoxMenu.select();

		Dialog jCheckBoxDialog = swingSampleApplicationWindow.describe(Dialog.class, new DialogDescription.Builder()
				.title("JCheckBox").build());
		CheckBox teethCheckBox = jCheckBoxDialog.describe(CheckBox.class, new CheckBoxDescription.Builder()
				.attachedText("Teeth").build());
		teethCheckBox.setState(com.hp.lft.sdk.CheckedState.UNCHECKED);

		teethCheckBox.setState(com.hp.lft.sdk.CheckedState.CHECKED);

		Button closeButton = jCheckBoxDialog.describe(Button.class, new ButtonDescription.Builder()
				.label("Close").build());
		closeButton.click();

		Menu jRadioButtonMenu = componentsMenu.describe(Menu.class, new MenuDescription.Builder()
				.label("JRadioButton").build());
		jRadioButtonMenu.select();

		Dialog jRadioButtonDialog = swingSampleApplicationWindow.describe(Dialog.class, new DialogDescription.Builder()
				.title("JRadioButton").build());
		RadioButton catRadioButton = jRadioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.attachedText("Cat").build());
		catRadioButton.set();

		RadioButton dogRadioButton = jRadioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.attachedText("Dog").build());
		dogRadioButton.set();

		RadioButton rabbitRadioButton = jRadioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.attachedText("Rabbit").build());
		rabbitRadioButton.set();

		RadioButton pigRadioButton = jRadioButtonDialog.describe(RadioButton.class, new RadioButtonDescription.Builder()
				.attachedText("Pig").build());
		pigRadioButton.set();

		Button closeButton1 = jRadioButtonDialog.describe(Button.class, new ButtonDescription.Builder()
				.label("Close").build());
		closeButton1.click();

		swingSampleApplicationWindow.close();

	
    	
    }
 
}