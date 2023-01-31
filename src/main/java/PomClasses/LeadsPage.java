package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Leads page
 * @author sunil
 *
 */
public class LeadsPage {
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Lead...']") private WebElement createLeadsButton;
	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement getLastName;
	//Initialization
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method is used to click create leads button
	 */
	public void clickCreateLeads()
	{
		createLeadsButton.click();
	}
	/**
	 * This method is used to get last name from the list
	 * @return
	 */
	public String getLastNameFromList()
	{
		return getLastName.getText();
	}
	
}
