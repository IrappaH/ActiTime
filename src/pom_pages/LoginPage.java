/*package pom_pages;

public class LoginPage {

}
*/
package pom_pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
public class LoginPage {
	//declaration
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	//initialisation
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Utilisation
	public void setUsername(String un){
		unTB.sendKeys(un);
	}
	public void setPassword(String pw){
		pwTB.sendKeys(pw);
	}
	public void clickLogin(){
		loginBtn.click();
	}
	/*
	@FindBy(xpath="//title[.='actiTIME -  Enter Time-Track']")
	private WebElement Title;
	
	
	public void verify(String etitle) {
		
		String Eres = Title.getText();
		assertEquals(etitle, Eres);
		
		
	}*/
}
