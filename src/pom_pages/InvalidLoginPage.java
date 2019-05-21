package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class InvalidLoginPage {
	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[contains(text(),\"invalid\")]|//span[contains(text(),\"Please try again\")]")
	private WebElement verify;
	
	public InvalidLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String un) {
		unTB.sendKeys(un);
		
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
		
	}

	public void clickLogin() {
		loginBtn.click();
		
	}
	
	public void verifyLogin(String expectedMSG) {
		String actual_result = verify.getText();
		//Assert.assertEquals(actual_result, expectedMSG);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actual_result, expectedMSG);
		s.assertAll();
		
	}

	
}
