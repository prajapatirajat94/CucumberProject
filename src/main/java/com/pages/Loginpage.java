package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
private WebDriver driver;
//1. By locators:
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signinbutton = By.id("SubmitLogin");
	private By forgotpwd = By.linkText("Forgot your password?");
	

//2.Constructor of page class
public Loginpage(WebDriver driver) {
	this.driver=driver;
}

//3.Page actions:(behaviour) of the page the form of methods

public String getLoginPage() {
	return driver.getTitle();
}
public boolean isForgotPwdlinjExist() {
	return driver.findElement(forgotpwd).isDisplayed();
}
public void enterusername(String username) {
	driver.findElement(emailId).sendKeys(username);
}
public void enterpassword(String pwd) {
	driver.findElement(password).sendKeys(pwd);
}
public void clickonlogin() {
	driver.findElement(signinbutton).click();;
}
}
