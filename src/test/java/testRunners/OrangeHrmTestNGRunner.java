package testRunners;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.OrangeHrmDashboardPage;
import pages.OrangeHrmLoginPage;
import utilities.DriverFactory;
import utilities.ExcelUtils;
import utilities.ExtentTestManager;
import utilities.ReadProperties;

public class OrangeHrmTestNGRunner {
	private static final ReadProperties readProp = new ReadProperties();
//	private OrangeHrmLoginPage orangeHrmLoginPage;
//	OrangeHrmDashboardPage orangeHrmDashboardPage;
//	WebDriver driver;
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) throws Exception {
		DriverFactory.init_driver(browser);
		System.out.println(Thread.currentThread().getId() + " : " + DriverFactory.getDriver());
	}

	@Test(description = "Verify login functionality", dataProvider = "Authentication")
	public void verifyLoginFunctionality(String username, String password) throws Exception {
		ExtentTestManager.startTest("Verify Login Functionality with username as "+username+" and password as "+password, "Verify Login Functionality with username as "+username+" and password as "+password);
		System.out.println(
				Thread.currentThread().getId() + " : " + DriverFactory.getDriver() + " : verifyLoginFunctionality");
		OrangeHrmLoginPage orangeHrmLoginPage = new OrangeHrmLoginPage();
//		orangeHrmLoginPage = new OrangeHrmLoginPage();
//		orangeHrmLoginPage.navigateToUrl(DriverFactory.getDriver(), readProp.getPropertyValue("OrangeHRM_URL"));
//		DriverFactory.getDriver().get(readProp.getPropertyValue("OrangeHRM_URL"));
		orangeHrmLoginPage.navigateToUrl(readProp.getPropertyValue("OrangeHRM_URL"));
		orangeHrmLoginPage.checkLogin(username, password);
		OrangeHrmDashboardPage orangeHrmDashboardPage = new OrangeHrmDashboardPage();
		orangeHrmDashboardPage.checkSuccessfulLogin();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		DriverFactory.closeBrowser();
	}

	@DataProvider(parallel=true)
	public Object[][] Authentication(Method method) throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("./TestData/TestData1.xlsx", "Sheet1", method.getName());
		return (testObjArray);
	}
}
