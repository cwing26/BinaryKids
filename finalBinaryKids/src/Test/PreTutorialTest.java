package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Tutorial.Controller;
import Tutorial.binaryTechPage;
import Tutorial.binaryApplicationPage;

//tests key GUI elements of the pre tutorial pages
public class PreTutorialTest {

	Controller controller;
	
	binaryApplicationPage baPage;
	
	binaryTechPage btPage;
	
	@Before
	public void setUp() throws Exception 
	{
		controller = new Controller();
		controller.init();
		baPage = new binaryApplicationPage(controller);
		btPage = new binaryTechPage(controller);
	}

	
	@After
	public void tearDown() throws Exception {
	}

	//test whether the light button display and click 
	//is initialized correctly on the binary association page 
	@Test
	public void testLightButtonClick() 
	{
		assertFalse(baPage.oneClicked);
	}
	
	//tests whether the conversion label click
	//works on the binary application page
	@Test
	public void testConvertLabelClick() 
	{
		String binaryNum = "110110";
		boolean equal = binaryNum.equals(baPage.convertLabel.getText().toString());
		
		assertTrue(equal);
	}
	
	
	//tests whether the checkbox flag values on the binary
	//technology place accruately keep track of checkbox
	//activity, they should all be false at initialization
	@Test
	public void testCheckboxes() 
	{
		assertFalse(btPage.skype);
		assertFalse(btPage.game);
		assertFalse(btPage.email);
		assertFalse(btPage.youtube);
		assertFalse(btPage.fb);
		assertFalse(btPage.instagram);
		assertFalse(btPage.cellPhone);
		
	}
	
}





