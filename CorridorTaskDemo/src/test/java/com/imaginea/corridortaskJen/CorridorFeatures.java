package com.imaginea.corridortaskJen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.imaginea.corridortaskJen.Utility;
import com.imaginea.corridortaskJen.BaseCode;

public class CorridorFeatures extends BaseCode {

	@Test(priority = 2)
	public void profileLaunch() {
		WebElement app = driver.findElement(By.xpath("//ul[1]//li[2]//a[1]"));
		app.click();
		WebElement profilelunch = driver
				.findElement(By.xpath("//div[@id='page-wrap']//div[5]//div[1]//div[2]//div[1]//a[1]"));
		profilelunch.click();
		WebElement personaldetails = driver.findElement(By.xpath("//li[2]//a[1]//div[1]"));
		personaldetails.click();
		WebElement linktext = driver.findElement(By.xpath("// span[contains(text(),'Personal')]"));
		linktext.click();
		WebElement enterData = driver
				.findElement(By.xpath(" //div[@name='container22']//input[@placeholder='Enter text']"));
		enterData.sendKeys(prop.getProperty("mobile"));
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		WebElement btnToCancel = driver.findElement(By.xpath("//button[@name='buttonCancelPersonalDetails']"));
		btnToCancel.click();
		WebElement btnToBack = driver.findElement(By.xpath("//img[@class='anchor-image-icon ng-scope'] "));
		btnToBack.click();
		// commonLogout();
	}

	@Test(priority = 1)
	public void letsMeet() {
		// commonLogin();
		WebElement letsmeet = driver.findElement(By.xpath("//div[10]//div[1]//div[2]//div[1]//a[1] "));
		letsmeet.click();
		Select drplocation = new Select(driver.findElement(By.xpath("//select[@name='location_formWidget']")));
		drplocation.selectByVisibleText(prop.getProperty("location"));
		WebElement avalabity = driver.findElement(By.xpath("//span[contains(text(),'Check Availability')]"));
		avalabity.click();
		Select room = new Select(
				driver.findElement(By.xpath("//div[@name='gridcolumn19']//select[@placeholder='Select value']")));
		room.selectByValue("number:1");
		Select projectname = new Select(driver.findElement(By.xpath("//select[@placeholder='Select Project']")));
		projectname.selectByValue("string:ADP");
		WebElement commit = driver.findElement(By.xpath("//textarea[@placeholder='Enter value']"));
		commit.sendKeys(" hello");
		WebElement restbtn = driver.findElement(By.xpath("//span[contains(text(),'Reset')]"));
		restbtn.click();
		WebElement signout = driver.findElement(By.xpath("//img[@name='AppLogo']"));
		signout.click(); // commonLogout();

	}

	@Test(priority = 0)
	public void HolidayList() {
		commonLogin();
		WebElement holidaylink = driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//a[1]"));
		holidaylink.click();
		WebElement banbtn = driver.findElement(By.xpath("//span[contains(text(),'Hyderabad')]"));
		banbtn.click();
		WebElement btnhyd = driver.findElement(By.xpath("//li[2]//a[1]//div[1]"));
		btnhyd.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		WebElement banbtn1 = driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"));
		banbtn1.click();
		String results = driver
				.findElement(By.xpath("//div[@name='tabpane2']//div[@class='tab-body app-ng-transclude']")).getText();
		System.out.println(" holiday list " + results);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement btnToBack = driver.findElement(By.xpath("//span[@class='btn-caption']"));
		btnToBack.click();

	}

	@Test(priority = 4)
	public void phoneBook() {
		// commonLogin();
		WebElement

		lunchbtn = driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//a[1]"));
		lunchbtn.click();
		/*
		 * WebElement hydbtn =
		 * driver.findElement(By.xpath("//div[2]//ul//li[2]//label[1]//span"));
		 * hydbtn.click();Due Date: "7/11/2
		 */
		WebElement searchbtn = driver.findElement(By.xpath("//div//main//div[1]//input[@placeholder='Search']"));
		searchbtn.sendKeys(prop.getProperty("name"));
		String nameToPrint = driver.findElement(By.xpath("//div[4]//a[1]//span[1]")).toString();
		System.out.println(" details are " + nameToPrint);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 60); WebElement waitbt =
		 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.
		 * xpath("//div[2]//a[1]//span[contains(text(),'Back To Apps')]")));
		 * waitbt.click();
		 */
		WebElement liinkforbackfromtrip = driver.findElement(By.xpath("//span[contains(text(),'Back To Apps')]"));
		//	liinkforbackfromtrip.click();
			Actions action= new Actions(driver);
			action.moveToElement(liinkforbackfromtrip).click().build().perform();
//	Wait waits  = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS);
		/*
		 * WebElement backToHome = driver.findElement(By.
		 * xpath("//div[2]//a[1]//span[contains(text(),'Back To Apps')]"));
		 * backToHome.click();
		 */
		/*
		 * WebElement linkforback =
		 * driver.findElement(By.xpath("//a[@name='anchor1']")); linkforback.click();
		 */
		/*
		 * WebElement linkng = driver.findElement(By.linkText("Back To Apps"));
		 * linkng.click();
		 */
		/*
		 * WebElement element = driver.findElement(By.partialLinkText("Back To Apps"));
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(element).click();
		 */
		 commonLogout();
	}

	@Test(priority = 3)
	public void TripToPlan() {
		WebElement lunchbtnTotrip = driver
				.findElement(By.xpath("//div[@id='page-wrap']//div[5]//div[1]//div[3]//div[1]//a[1]"));
		lunchbtnTotrip.click();
		Select drpfrm = new Select(
				driver.findElement(By.xpath("//div[@name='container8']//select[@placeholder='select']")));
		drpfrm.selectByValue("number:1");
		Select drpto = new Select(
				driver.findElement(By.xpath("//div[@name='container9']//select[@placeholder='select']")));
		drpto.selectByValue("number:3");
		Select drppur = new Select(
				driver.findElement(By.xpath("//div[@name='container7']//select[@placeholder='select'] ")));
		drppur.selectByValue("number:4");
		WebElement flyNO = driver
				.findElement(By.xpath("//div[@name='container9_1']//input[@placeholder='Enter text']"));
		flyNO.sendKeys(prop.getProperty("flyno"));
		WebElement commitsectios = driver.findElement(By.xpath("//textarea[@placeholder='Place your text']"));
		commitsectios.sendKeys(prop.getProperty("committrip"));
		WebElement checkbutton = driver.findElement(By.xpath("//span[contains(text(),'Hotel')] "));
		checkbutton.click();
		Select drprelations = new Select(
				driver.findElement(By.xpath("//div[@name='container38']//select[@placeholder='select']")));
		drprelations.selectByValue("number:2");
		WebElement btn1 = driver.findElement(By.xpath("//span[contains(text(),'Reset')]"));
		btn1.click();
		WebElement requests = driver.findElement(By.xpath("//span[contains(text(),'My Requests')]"));
		requests.click();
		WebElement liinkforbackfromtrip = driver.findElement(By.xpath("//span[contains(text(),'Back To Apps')]"));
	//	liinkforbackfromtrip.click();
		Actions action= new Actions(driver);
		action.moveToElement(liinkforbackfromtrip).click().build().perform();
////span[contains(text(),'Back To Apps')]
		/*
		 * WebElement element = driver.findElement(By.partialLinkText("Back To Apps"));
		 * element.click();
		 */ /*
			 * Actions actions = new Actions(driver);
			 * actions.moveToElement(element).click();
			 */
	//	commonLogout();

	}

	@AfterMethod
	public void tearDown(ITestResult result)

	{
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, result.getName());
		}
	}

}


