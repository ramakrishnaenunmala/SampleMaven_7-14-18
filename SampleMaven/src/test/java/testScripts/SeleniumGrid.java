package testScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGrid {
	WebDriver driver1;
	//WebDriver driver2;
	String BaseURL1;
//	String BaseURL2;
	String NodeURL1;
	//String NodeURL2;
	DesiredCapabilities Capability;
	DesiredCapabilities Capability2;
	DesiredCapabilities Capabilitychrome;
	@BeforeClass
	public void SetUp() throws MalformedURLException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Ramki_Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver=new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Demp\\chromedriver_win32 (1)\\chromedriver.exe");
		BaseURL1 = "http://apps.qaplanet.in/qahrm/index.php";
		//BaseURL2 = "http://classroom:90/qahrm";
		NodeURL1 = "http://192.168.0.138:5555/wd/hub";
		//NodeURL2 = "http://192.168.0.101:5555/wd/hub";
		
		Capability =  DesiredCapabilities.chrome();
		Capability.setBrowserName("chrome");
		Capability.setPlatform(Platform.WINDOWS);
		
		//another browser
		//Capability2 = DesiredCapabilities.firefox();
		//Capability2.setBrowserName("firfox");
		//Capability2.setPlatform(Platform.WINDOWS);
		
		driver1 = new RemoteWebDriver(new URL(NodeURL1), Capability);
		//driver2 = new RemoteWebDriver(new URL(NodeURL2), Capability);

	}
	@AfterClass
	public void AfterTest() 
	{
		driver1.close();
		//driver2.quit();
	}
	@Test
	public void ApplicationAccess2() throws MalformedURLException, InterruptedException {
		driver1.get(BaseURL1);
		Thread.sleep(10000);
		driver1.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		driver1.findElement(By.name("txtPassword")).sendKeys("user1");
		driver1.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		if (driver1.getTitle().equals("OrangeHRM"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver1.findElement(By.linkText("Logout")).click();
}
}
