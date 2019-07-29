package com.imaginea.corridortaskJen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseCode {

	Properties prop = new Properties();
	WebDriver driver;
	String nodeURL;


	@Parameters({ "MyBrowser" })
	@Test
	public void mainDriverForChrome(String mybrowser) {
		System.out.println(" driver  name from the testng xml file is " + mybrowser);
		org.testng.Assert.assertEquals("chrome", mybrowser, " value not matched");

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		// DesiredCapabilities capability = DesiredCapabilities.chrome();
		// DesiredCapabilities capability = DesiredCapabilities.firefox();
		// capability.setBrowserName("firefox");
		// capability.setBrowserName("chrome");
		// capability.setPlatform(Platform.WIN10);
		// nodeURL = "http://172.16.48.140:5566/wd/hub";
		// driver = new RemoteWebDriver(new URL(nodeURL), capability);
		
		driver = new ChromeDriver();
		String baseUrl = "https://corridor.pramati.com";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String expectedTitle = "Corridor | Our Innovation Hub";
		String actualTitle = "";
		actualTitle = driver.getTitle();
		System.out.println(" title from the site " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "testpassed");
	}

	/*
	 * public void mainDriverForFirfox( String mybrowser) {
	 * System.out.println(" driver name from the testing xml file"+ mybrowser);
	 * Assert.assertEquals("firefox", mybrowser);
	 * System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
	 * WebDriver driver = new FirefoxDriver(); }
	 */
	@BeforeMethod
	public void propertyFileload() {
		File file = new File("./src/test/java/com/imaginea/corridortaskJen/dataFile.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInput);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void commonLogin() {
		WebElement LinkToCorridor = driver
				.findElement(By.xpath("//li[@id='menu-item-15255']//a[contains(text(),'LOGIN')]"));
		LinkToCorridor.click();
		WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		email.sendKeys(prop.getProperty("username"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(prop.getProperty("pass"));
		WebElement submitbtn = driver.findElement(By.xpath("//input[@id='loginButton'] "));
		submitbtn.click();
	}

	public void commonLogout() {
		WebElement logoutbtn = driver
				.findElement(By.xpath("//li[@id='menu-item-16097']//a[contains(text(),'LOGOUT')] "));
		logoutbtn.click();
		WebElement confirmbtn = driver.findElement(By.xpath("//a[contains(text(),'log out')]"));
		confirmbtn.click();
	}
}


