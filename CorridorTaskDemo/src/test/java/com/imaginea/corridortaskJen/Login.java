package com.imaginea.corridortaskJen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends BaseCode {
	@Test
	public void loginIntoCorridor() {
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

	@Test
	public void logoutFromCorridor() {
		WebElement logoutbtn = driver
				.findElement(By.xpath("//li[@id='menu-item-16097']//a[contains(text(),'LOGOUT')] "));
		logoutbtn.click();
		WebElement confirmbtn = driver.findElement(By.xpath("//a[contains(text(),'log out')]"));
		confirmbtn.click();

	}
}
