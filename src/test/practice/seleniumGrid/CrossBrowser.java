package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void bm(String browser) throws MalformedURLException
	{
		URL url = new URL("http://192.168.29.49:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		
		switch(browser)
		{
		case "chrome": cap.setBrowserName(browser);break;
		case "firefox": cap.setBrowserName(browser); break;
		case "edge": cap.setBrowserName(browser);break;
		default: System.out.println("not valid");
		}
		
		driver = new RemoteWebDriver(url,cap);
		driver.manage().window().maximize();
	}
	
	@Test
	public void openFb() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
}
