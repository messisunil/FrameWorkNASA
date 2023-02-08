package mvnCmd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MVNCommondParameter {
	@Test
	public void test1()
	{
		WebDriver driver = null;
		String browser = System.getProperty("BROWSER");
		switch(browser) {
		case "chrome": driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver();break;
		default: System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(System.getProperty("URL"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}	
