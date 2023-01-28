package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains all the element locators and respective business libraries of  create Organization page
 * @author sunil
 *
 */
public class CreateOrganizationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement headerName;
	@FindBy(xpath = "//input[@name='accountname']") private WebElement accountName;
	@FindBy(xpath = "//select[@name='industry']") private WebElement industry;
	@FindBy(xpath = "//select[@name='accounttype']") private WebElement type;
	@FindBy(xpath = "//div[@align='center']/input[@class='crmbutton small save'][1]") private WebElement saveButton;
	
	//Initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get header name
	 * @return
	 */
	public String verifyHeader()
	{
		return headerName.getText();
	}
	/**
	 * This method is used to set organization name
	 * @param name
	 */
	public void setOrganizationName(String name)
	{
		accountName.sendKeys(name);
	}
	/**
	 * This method is used to select industry
	 * @param web
	 * @param industryType
	 */
	public void selectIndustry(WebDriverUtility web, String industryType)
	{
		web.dropDown(industry, industryType);
	}
	/**
	 * This method is used to select type
	 * @param web
	 * @param typeValue
	 */
	public void selectType(WebDriverUtility web, String typeValue)
	{
		web.dropDown(type, typeValue);
	}
	/**
	 * This method is used to click save button
	 */
	public void clickSave()
	{
		saveButton.click();
	}
	
	
}
