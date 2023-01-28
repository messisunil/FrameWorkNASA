package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 *  This class contains all the element locators and respective business libraries of Home page
 * @author sunil
 *
 */
public class HomePage {
	//Declaration
	@FindBy(linkText = "Home") private  WebElement homePageName ;
	@FindBy(xpath = "//td[@class='tabSelected']/following::td[@class='small']/descendant::a[contains(text(),'Organizations')]") private WebElement organizationTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement usernameImage;
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement signoutButton;
	@FindBy(xpath = "//td/a[contains(text(),'Contacts')]") private WebElement contacts;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to verify home page
	 * @return
	 */
	public String verifyHomePage()
	{
		 return homePageName.getText();
	}
	/**
	 * This method is used to perform click action on organization tab
	 */
	public void clickOrganization()
	{
		organizationTab.click();
	}
	/**
	 * This method is used to signout from the application
	 * @param web
	 */
	public void signOutFromApplication(WebDriverUtility web)
	{
		web.mouseHover(usernameImage);
		signoutButton.click();
	}
	/**
	 * This method is used to click contacts tab
	 */
	public void clickContacts()
	{
		contacts.click();
	}
}
