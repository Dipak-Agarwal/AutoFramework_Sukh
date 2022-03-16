package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.Log;

public class OrangeHrmDashboardPage extends ElementUtils {
	
	private int timeOut = 10;
	
	private By textLink_username=By.id("welcome");
	private By link_logout=By.xpath("//a[text()='Logout']");
	
//	WebDriver driver;
//	
//	@FindBy(id="welcome")
//	WebElement textLink_username;
//	
//	@FindBy(xpath="//a[text()='Logout']")
//	WebElement link_logout;
//	
//	public OrangeHrmDashboardPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this.getClass());
//	}
	
	public void checkSuccessfulLogin() throws Exception {
		clickOnElement(textLink_username, timeOut, "Could not click on logged in user link");
		Log.info("Clicked on logged in user link");
		verifyElementVisible(link_logout, timeOut, "Logout link not displayed");
		Log.info("Logout link displayed");
	}
	
//	public void checkSuccessfulLogin() throws Exception {
//		clickOnElement(driver, textLink_username, timeOut, "Could not click on logged in user link");
//		Log.info("Clicked on logged in user link");
//		verifyElementVisible(driver, link_logout, timeOut, "Logout link not displayed");
//		Log.info("Logout link displayed");
//	}
	
}

