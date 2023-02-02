package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Create events
 * @author sunil
 *
 */
public class EventsPage {
	//Declaration
	@FindBy(xpath = "//input[@name='subject']")private WebElement subject;
	@FindBy(xpath = "//input[@id='jscal_field_date_start']") private WebElement startDate;
	@FindBy(xpath = "//input[@name='time_start']") private WebElement time;
	@FindBy(xpath = "//input[@id='jscal_field_due_date']") private WebElement endDate;
	@FindBy(xpath = "//table[@class='mailClient mailClientBg']/descendant::input[@class='crmbutton small save']") private WebElement save;
	
	
	//Initialization
	 public EventsPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Utilization
	 /**
	  * This method is used to set subject
	  * @param subject
	  */
	 public void setSubject(String subject)
	 {
		this.subject.sendKeys(subject);
	 }
	 /**
	  * This method is used to set start date of an event
	  * @param startDate
	  */
	 public void setStartDate(String startDate)
	 {
		 this.startDate.sendKeys(startDate);
	 }
	 /**
	  * This method is used to set an event start time
	  * @param time
	  */
	 public void setStartTime(String time)
	 {
		 this.time.sendKeys(time);
	 }
	 /**
	  * This method is used to set end date of an event
	  * @param endDate
	  */
	 public void setEndDate(String endDate)
	 {
		 this.endDate.sendKeys(endDate);
	 }
	 /**
	  * This method is used to click save 
	  */
	 public void clickSave()
	 {
		 save.click();
	 }
}
