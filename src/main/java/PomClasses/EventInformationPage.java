package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement eventInfoHeader;
	@FindBy(xpath = "//td[contains(.,'Event Name') and @class='cellLabel']/parent::tr/td[@class='cellInfo']") private WebElement eventName;
	
	//Initialization
	public EventInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getEventInfoHeader()
	{
		return eventInfoHeader.getText();
	}
	
	public String getEventName()
	{
		return eventName.getText();
	}
}
