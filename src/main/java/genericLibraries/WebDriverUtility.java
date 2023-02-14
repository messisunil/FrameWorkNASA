package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all reusable methods of webDriver
 * @author sunil
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	Select select;
	Actions action;
	/**
	 * This method is used to launch different browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
			case "chrome": driver = new ChromeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			case "edge": driver = new EdgeDriver(); break;
			default: System.out.println("Invalid browser");
		}
		
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public void navigateToApplication(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to wait until web element loaded into the page
	 * @param Time_in_seconds
	 */
	public void waitTillElementFound(long Time_in_seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time_in_seconds));
	}
	/**
	 * This method is used to wait explicitly web element appear in the page
	 * @param element
	 * @param Time_in_seconds
	 */
	public void explicitWait(WebElement element, long Time_in_seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Time_in_seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to mouse hover to the particular element
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to select an option based on the index
	 * @param index
	 * @param element
	 */
	public void dropDown(int index, WebElement element)
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select an option based on the value
	 * @param element
	 * @param value
	 */
	public void dropDown(WebElement element, String value)
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select an option based on the text
	 * @param text
	 * @param element
	 */
	public void dropDown(String text, WebElement element)
	{
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method is used to get the parent window ID
	 * @return
	 */
	public String getParentWindowHandleID()
	{
		return driver.getWindowHandle();
	}
	/**
	 * This method is used to select child window
	 */
	public void childBrowserPopup()
	{
		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
			driver.switchTo().window(window);
		}
	}
	/**
	 * This method is used to switch to frame using index
	 * @param index
	 */
	public void switchToFrame(String index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to fram using web element
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to accept the alert
	 */
	public void alertOK()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss the alert
	 */
	public void alertCancel()
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to disable the notifications
	 * @return
	 */
	public ChromeOptions disableNotifications()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notification");
		return option;
	}
	/**
	 * This method is used to take screenshot of web page in file
	 * @param javaUtil
	 * @param classname
	 * @return
	 */
	public String getScreenshot(JavaUtility javaUtil, String classname , WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String currentTime = javaUtil.getCurrentTime();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+classname+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	/**
	 * This method is used to fetch the screenshot based on Base64 format
	 * @return
	 */
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method is used to scroll the page till the web element
	 * @param element
	 */
	public void scrollTillElement(Object element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoview(true)", element);

	}
	/**
	 * This method is used to close the current window
	 */
	public void closeCurrentWindow()
	{
		driver.close();
	}
	/**
	 * This method is used to close all the windows
	 */
	public void closeWindows()
	{
		driver.quit();
	}
	/**
	 * This method is used to double click on the element
	 * @param element
	 */
	public void doubleClickOnTheElement(WebElement element)
	{
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on the element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop an element
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebElement src, WebElement dest)
	{
		action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	/**
	 * This method is used to navigate to the application
	 * @param browser
	 * @param url
	 * @param timeout
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long timeout) {
		driver = launchBrowser(browser);
		maximizeBrowser();
		navigateToApplication(url);
		waitTillElementFound(timeout);
		return driver;	
	}
	/**
	 * This method is used to convert dynamic xpath to web element
	 * @param dynamicPath
	 * @param replaceData
	 * @return
	 */
	public WebElement convertDynamicXpathToWebElement(String dynamicPath, String replaceData)
	{
		String requiredPath = String.format(dynamicPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}
}
