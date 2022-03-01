package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

public WebDriver driver;
public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<WebDriver>();
public WebDriver init_driver(String browser) {
	
	System.out.println("browser value is: "+ browser);
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());	
	}
	else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());
	}		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	return getDriver();
}
/**
 * this is used to get driver with ThreadLocal
 * @return
 */
public static synchronized WebDriver getDriver() {
	return tlDriver.get();
}
}
