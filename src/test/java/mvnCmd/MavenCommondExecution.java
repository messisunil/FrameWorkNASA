package mvnCmd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MavenCommondExecution {
	WebDriver driver;
	@Parameters("browser")	
	@Test
	public void fb(String browser)
	{
		switch(browser)
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "firefox" : driver = new FirefoxDriver() ; break;
		case "edge" : driver = new EdgeDriver(); break;
		default: System.out.println("invalid browser");
		}
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
	
}
