package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Organization page
 * @author sunil
 *
 */
public class OrganizationPage {
	//Declaration
	@FindBy(xpath = "//a[@class='hdrLink']") private WebElement organizationPageName;
	@FindBy(xpath = "//td[@class='moduleName']/following::td/descendant::img[@title='Create Organization...']") private WebElement plusbutton;
	@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement orgName;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to verify organization page name
	 * @return
	 */
	public String verifyOrganizationPageName()
	{
		 return organizationPageName.getText();
	}
	/**
	 * This method is used to verify created organization name in organizations list
	 * @return
	 */
	public String verifyOrgNameInOrganizationPage()
	{
		 return orgName.getText();
	}
	/**
	 * This method is used to click plus button
	 */
	public void clickPlusButton()
	{
		plusbutton.click();
	}
}
