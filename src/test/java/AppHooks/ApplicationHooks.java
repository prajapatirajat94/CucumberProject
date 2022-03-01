package AppHooks;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utill.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

private DriverFactory driverFactory; 	
private WebDriver driver;
private ConfigReader configreader;
Properties prop;
	
@Before(order=0)
public void getProperty() {
	configreader = new ConfigReader();
	prop=configreader.init_prop();
}
@Before(order=1)
public void launchbrowser() {
	driverFactory = new DriverFactory();
	driver =driverFactory.init_driver(prop.getProperty("browser"));
}
@After(order=0)
public void quitbrowser() {
	driver.quit();
}
@After(order=1)
public void teardown(Scenario scenario){
	if(scenario.isFailed()) {
		//take screenshots:
		String screenshotName=scenario.getName().replaceAll(" ", "_");		
		byte [] Sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(Sourcepath, "image/png", screenshotName);
	}
}
	
	
	
}
