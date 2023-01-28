package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the element locators and respective business libraries of login page
 * @author sunil
 *
 */
public class LoginPage {
	//Declaration
	@FindBy(xpath = "//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']") private WebElement userNameTF;
	@FindBy(xpath = "//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']") private WebElement passwordTF;
	@FindBy(id = "submitButton") private WebElement loginButton;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to login into the application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username, String password)
	{
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButton.click();
	}

}
