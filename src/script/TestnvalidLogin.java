package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pom_pages.InvalidLoginPage;

public class TestnvalidLogin extends BaseTest{
	
	@Test
	public void testinvalidLogin(){	
		
		
		int rc=Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
		System.out.println("Total number of rows getting from Excel invalid sheet: "+rc);
		for(int i=1;i<=rc;i++) 
			{
				String un=Lib.getCellValue(EXCEL_PATH,"InvalidLogin",i,0);
				String pw=Lib.getCellValue(EXCEL_PATH,"InvalidLogin",i,1);
				String expectedMSG=Lib.getCellValue(EXCEL_PATH,"InvalidLogin",i,2);		
				
				
				InvalidLoginPage ln = new InvalidLoginPage(driver);	
				ln.setUsername(un);
				Reporter.log("Username entered ",true);
				ln.setPassword(pw);
				Reporter.log("Password entered ",true);
				ln.clickLogin();
				Reporter.log("the login button clicked ",true);
				ln.verifyLogin(expectedMSG);
				Reporter.log("Verified invalid inputs ",true);
		
			}
		
	}
}


