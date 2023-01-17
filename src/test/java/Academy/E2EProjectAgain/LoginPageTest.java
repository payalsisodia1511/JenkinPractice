package Academy.E2EProjectAgain;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import resources.Base;


public class LoginPageTest extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void OpenBrowser() throws IOException {
		driver = initializeDriver();
		
	}
	@Test(dataProvider = "getData")
	public void LoginFunctionality(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		HomePageObject l = new HomePageObject(driver);
		l.getLogin().click();
		LoginPageObject lp = new LoginPageObject(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info(text);
		lp.getLoginBtn().click();

	}

	@DataProvider
	public Object getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "nonrestrickeduser";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "123456";
		data[1][2] = "restrickeduser";

		return data;
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
