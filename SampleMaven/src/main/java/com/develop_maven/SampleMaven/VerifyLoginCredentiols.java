package com.develop_maven.SampleMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLoginCredentiols {
WebDriver driver;
Properties prop;

String propath="D:\\Selenium_Demp\\New folder\\Ramki\\SampleMaven\\ki.properties";
	public void setUP(String brow){
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Demp\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		prop=new Properties();
		try {
			prop.load(new FileInputStream(propath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public void loginToApp(){
		
		String urrl=prop.getProperty("url");
		driver.navigate().to(urrl);
		String title = driver.getTitle();
		System.out.println("my app title is----"+title);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management")){
			System.out.println("pass");
		}
		else {
			System.out.println("Not");
		}
/*	Assert.assertEquals("OrangeHRM - New Level of HR Management",title);
		Reporter.log("my login page displayed");*/
		
		
		driver.findElement(By.xpath(prop.getProperty("unxpath"))).sendKeys(prop.getProperty("un"));
		driver.findElement(By.xpath(prop.getProperty("pwxpath"))).sendKeys(prop.getProperty("pw"));
		driver.findElement(By.xpath(prop.getProperty("loginxpath"))).click();
		
		
	}
	public void tearDown(){
		driver.close();
		driver.quit();
	}
		
	public void addEmploye() throws InterruptedException{
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("addEmployeidenti")))).click();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(prop.getProperty("iframe")));
		driver.switchTo().frame(prop.getProperty("iframe"));
		driver.findElement(By.xpath(prop.getProperty("addEmployeidenti"))).click();
		
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(prop.getProperty("iframe")));
		String addemptext=driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText();
		if(addemptext.equals(prop.getProperty("addemptext"))){
			System.out.println("text dis");
		}
		else {
			System.out.println("text not");
		}
		driver.findElement(By.xpath("//*[@id='txtEmpLastName']")).sendKeys(prop.getProperty("lastname"));
		Thread.sleep(2000);
		driver.findElement(By.name("txtEmpFirstName")).sendKeys(prop.getProperty("firstname"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("savebuttonidenti"))).click();
		
		String pertext=driver.findElement(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2")).getText();
		if(addemptext.equals(prop.getProperty("persenolpagetext"))){
			System.out.println("text2 dis");
		}
		else {
			System.out.println("text2 not");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("save2buttonidenti"))).click();
		driver.findElement(By.xpath("//*[@id='txtEmpNickName']")).sendKeys(prop.getProperty("nickname"));
		driver.findElement(By.xpath(prop.getProperty("save2buttonidenti"))).click();
		 
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(prop.getProperty("logoutxpath"))).click();
	}
/*	public static void main(String[] args) {
			
			
			VerifyLoginCredentiols browser=new VerifyLoginCredentiols();
			browser.setUP("chrome");
			browser.loginToApp();
			browser.tearDown();
		}*/
}
