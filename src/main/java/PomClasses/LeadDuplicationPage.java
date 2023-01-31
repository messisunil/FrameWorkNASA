package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Lead duplication page
 * @author sunil
 *
 */
public class LeadDuplicationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement duplicationPageHeader;
	@FindBy(xpath = "//input[@name='lastname']") private WebElement LastName;
	@FindBy(xpath = "//div[@align='center']/input[@class='crmbutton small save'][1]") private WebElement saveButton;
	
	//Initialization
	 public LeadDuplicationPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Utilization
	 /**
	  * This method is used to get duplication page header text
	  */
	 public String getDupluicatePageHeaderText()
	 {
		return duplicationPageHeader.getText();
	 }
	 /**
	  * This method is used to clear the last name field
	  */
	 public void clearLastName()
	 {
		 LastName.clear();
	 }
	 /**
	  * This method is used to enter last name text field
	  * @param lastName
	  */
	 public void setLastName(CharSequence lastName)
	 {
		 this.LastName.sendKeys(lastName);
	 }
	 /**
	  * This method is used to click the save button
	  */
	 public void clickSaveButton()
	 {
		 saveButton.click();
	 }
}
