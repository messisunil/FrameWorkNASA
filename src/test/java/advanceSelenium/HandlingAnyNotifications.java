package advanceSelenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingAnyNotifications {
	public static void mediaStream()
	{
		HashMap<String, Integer> contentSettings = new HashMap<String,Integer>();
		contentSettings.put("media_stream", 1);
		
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", contentSettings);
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://webcamtests.com/");
		driver.findElement(By.xpath("//button[@id='webcam-launcher']")).click();
		driver.quit();
		
	}
	
	public static void notifications()
	{
		HashMap<String,Integer> contentSetting = new HashMap<>();
		contentSetting.put("geolocation", 2);
		contentSetting.put("notifications", 2);
		
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", contentSetting);
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		
	}
	
	public static void micTest()
	{
		HashMap<String, Integer> contentSettings = new HashMap<String,Integer>();
		contentSettings.put("media_stream", 0);
		
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", contentSettings);
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
		driver.quit();
	}
	
	public static void main(String[] args) {
		micTest();
	}
}
