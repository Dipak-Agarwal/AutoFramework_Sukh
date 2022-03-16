package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;
import utilities.ElementUtils;
import utilities.Log;

public class OrangeHrmLoginPage extends ElementUtils {
	
	private int timeOut = 10;
	
	private By textBox_username=By.id("txtUsername");
	private By textBox_password=By.id("txtPassword");
	private By button_Login=By.id("btnLogin");
	
//	private WebDriver driver;
//	
//	@FindBy(id="txtUsername")
//	WebElement textBox_username;
//	
//	@FindBy(id="txtPassword")
//	WebElement textBox_password;
//	
//	@FindBy(id="btnLogin")
//	WebElement button_Login;
//	
//	public OrangeHrmLoginPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, OrangeHrmLoginPage.class);
//	}
	
	public void checkLogin(String username, String password) throws Exception {
		enterValueForTextBox(textBox_username, username, timeOut, "Could not enter "+username+" in username text box");
		Log.info("Entered "+username+" in username text box");
		enterValueForTextBox(textBox_password, password, timeOut, "Could not enter "+password+" in password text box");
		Log.info("Entered "+password+" in password text box");
		clickOnElement(button_Login, timeOut, "Could not click on Login button");
		Log.info("Clicked on Login button");
	}
	
//	public void checkLogin(String username, String password) throws Exception {
//		enterValueForTextBox(driver, textBox_username, username, timeOut, "Could not enter "+username+" in username text box");
//		Log.info("Entered "+username+" in username text box");
//		enterValueForTextBox(driver, textBox_password, password, timeOut, "Could not enter "+password+" in password text box");
//		Log.info("Entered "+password+" in password text box");
//		clickOnElement(driver, button_Login, timeOut, "Could not click on Login button");
//		Log.info("Clicked on Login button");
//	}
	
}

