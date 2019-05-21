/*package script;

public class TestLogin {

}*/
package script;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pom_pages.LoginPage;
public class TestLogin extends BaseTest{
	@Test
	public void testLogin(){
		LoginPage l = new LoginPage(driver);
		String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		
		String etitle = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
		System.out.println("Expected title is :"+etitle);
	
		String actualtitle = driver.getTitle();
		System.out.println("Actual title  is : "+actualtitle);
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualtitle, etitle);
		s.assertAll();

		
		Reporter.log("The Home page is displayed ",true);
		
	}}

