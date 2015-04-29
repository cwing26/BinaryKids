package tutorial;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//tests key GUI elements of the pre tutorial pages
public class PreTutorialTest {

	Controller controller;
	//Controller controller;
	
	SegundaPage segundaPage;
	FirstPage firstPage;
	
	@Before
	public void setUp() throws Exception 
	{
		controller = new Controller();
		segundaPage = new SegundaPage(controller);
		firstPage = new FirstPage(controller);
	}

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLightButtonClick() 
	{
		assertFalse(segundaPage.oneClicked);
	}
	
	@Test
	public void testConvertLabelClick() 
	{
		String decimalNum = "54";
		
		assertEquals(segundaPage.convertLabel.getText(), decimalNum);
	}
	
	@Test
	public void testCheckboxes() 
	{
		assertFalse(firstPage.skype);
		assertFalse(firstPage.game);
		assertFalse(firstPage.email);
		assertFalse(firstPage.youtube);
		assertFalse(firstPage.fb);
		assertFalse(firstPage.instagram);
		assertFalse(firstPage.cellPhone);
		
	}
	
}





