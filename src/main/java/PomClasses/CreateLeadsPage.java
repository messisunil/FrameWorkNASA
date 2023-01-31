package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains all the element locators and respective business libraries of CreateLeads page
 * @author sunil
 *
 */
public class CreateLeadsPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement createLeadsHeader;
	@FindBy(xpath = "//select[@name='salutationtype']") private WebElement salutation;
	@FindBy(xpath = "//input[@name='lastname']") private WebElement lastName;
	@FindBy(xpath = "//input[@name='company']") private WebElement company;
	@FindBy(xpath = "//div[@align='center']/input[@class='crmbutton small save'][1]") private WebElement saveButton;
	
	//Initialization
	public CreateLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get createLeads page header name
	 * @return
	 */
	public String getCreateLeadsHeader()
	{
		return createLeadsHeader.getText();
	}
	/**
	 * This method is used to select salutation
	 * @param web
	 * @param value
	 */
	public void selectSalutation(WebDriverUtility web, String value)
	{
		web.dropDown(salutation, value);
	}
	/**
	 * This method is used to enter last name
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName.sendKeys(lastName);
	}
	/**
	 * This method is used to enter company name
	 * @param companyName
	 */
	public void setCompany(String companyName)
	{
		this.company.sendKeys(companyName);
	}
	/**
	 * This method is used to click save button
	 */
	public void clickSave()
	{
		saveButton.click();
	}
	
}
