package PomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains all the element locators and respective business libraries of Create new Contact page
 * @author sunil
 *
 */
public class CreateContactPage {
	//Initialization
	@FindBy(xpath = "//select[@name='salutationtype']") private WebElement salutation;
	@FindBy(xpath = "//input[@name='firstname']") private WebElement firstName;
	@FindBy(xpath = "//input[@name='lastname']") private WebElement lastName;
	@FindBy(xpath = "//input[@class='crmButton small save']") private WebElement saveButton;
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement pageHeaderName;
	@FindBy(xpath = "//input[@name='account_name']/../img") private WebElement addOrganization;
	@FindBy(xpath = "(//table[@class='small'])[3]/tbody/descendant::a") private List<WebElement> selectOrganization;
	
	//Declaration
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
		public void clickAddOrganization()
		{
			addOrganization.click();
		}
	
		public void selectOrganization(WebDriverUtility web, String organizationName)
		{
			web.childBrowserPopup();
			List<WebElement> companyList = selectOrganization;
		
			for (int i = 0; i < companyList.size(); i++) {
				String company = companyList.get(i).getText();
				if (company.equalsIgnoreCase(organizationName)) {
					companyList.get(i).click();
					break;
				}
			}
		}
	
	/**
	 * This method is used to select the salutation by value
	 * @param web
	 * @param value 
	 */
	public void selectSalutation(WebDriverUtility web, String value)
	{
		web.dropDown(salutation, value);
	}
	/**
	 * This method is used to enter first Name
	 * @param firstname
	 */
	public void setFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	/**
	 * This method is used to enter last name
	 * @param lastname
	 */
	public void setLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	/**
	 * This method is used to click save button
	 */
	public void clickSaveButton()
	{
		saveButton.click();
	}
	/**
	 * This method is used to get page header name
	 * @return
	 */
	public String verifyCreateNweContactPage()
	{
		return pageHeaderName.getText();
	}
	
	
}
