package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of Lead information page
 * @author sunil
 *
 */
public class LeadInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement leadInfoHeader;
	@FindBy(xpath = "//td[@class='dvtTabCache']/input[@name='Duplicate']") private WebElement duplicate;
	@FindBy(xpath = "//a[@class='hdrLink']") private WebElement leadsPage;
	
	//Initialization
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get lead information header text
	 * @return
	 */
	public String getLeadInfoHeaderText()
	{
		return leadInfoHeader.getText();
	}
	/**
	 * This method is used to click duplicate button
	 */
	public void clickDuplicateButton()
	{
		duplicate.click();
	}
	/**
	 * This method is used to click go to leads page 
	 */
	public void goToLeadsPage()
	{
		leadsPage.click();
	}
}
