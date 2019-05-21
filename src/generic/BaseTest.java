package generic;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConstant{
	
	public static WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod(alwaysRun=true)
	public void openApplication(){
		 /*driver = new FirefoxDriver();*/
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		String ITO = Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeoutPeriod = Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult result){
		int status = result.getStatus();
		
		if(status == 1) {
			Reporter.log(result.getName() +" is paased", true);
			
			System.out.println("the test method  "+ result.getName()+" is pass");
			
		}
		else
		{
			Reporter.log(result.getMethod() +"is Failed",true);
			Lib.getPhoto(driver,IMG_PATH,result.getName());
		}
		driver.close();
	}

	
	

}
