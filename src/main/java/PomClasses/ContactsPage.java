package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Contacts page
 * @author sunil
 *
 */
public class ContactsPage {
	//declaration
	@FindBy(xpath = "//img[contains(@alt,'Create Contact...')]") private WebElement createContactButton;
	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[4]/a") private WebElement contactLastName;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to click the create contact tab
	 */
	public void clickCreateContacts()
	{
		createContactButton.click();
	}
	/**
	 * This method is used to get the contact last name present on the list of contacts
	 * @return
	 */
	public String getLastNameFromList()
	{
		 return contactLastName.getText();
	}
}
