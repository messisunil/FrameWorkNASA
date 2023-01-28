package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Organization Information page
 * @author sunil
 *
 */
public class OrganizationInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement headerInfo;
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']") private WebElement organizationNameInList;
	@FindBy(xpath = "//a[text()='Organizations']") private WebElement organizationLink;
	
	//Initialization
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get header name
	 * @return
	 */
	public String veryHeaderInfo()
	{
		return headerInfo.getText();
	}
	/**
	 * This method is used to get organization name from the  organization list
	 * @return
	 */
	public String orgNameFromList()
	{
		return organizationNameInList.getText();
	}
	/**
	 * This method is used to go to organization page
	 */
	public void goToOrganization()
	{
		organizationLink.click();
	}
}
