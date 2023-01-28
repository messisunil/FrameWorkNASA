package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Contact Information page
 * @author sunil
 *
 */
public class ContactInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement informationPageHeaderName;
	@FindBy(xpath = "//span[@id='dtlview_Last Name']") private WebElement ContactLastName;
	@FindBy(xpath = "//a[.='Contacts' and @class='hdrLink']") private WebElement contactpageLink;
	
	//Initialization
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get the contact page information header name
	 * @return
	 */
	public String getInfoPageHeaderName()
	{
		return informationPageHeaderName.getText();
	}
	/**
	 * This method is used to get the last name of contact
	 * @return
	 */
	public String getContactLastName()
	{
		return ContactLastName.getText();
	}
	/**
	 * This method is used to go to contact page
	 */
	public void goToContactpage()
	{
		contactpageLink.click();
	}
}
