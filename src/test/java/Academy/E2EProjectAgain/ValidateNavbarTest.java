package Academy.E2EProjectAgain;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import resources.Base;

public class ValidateNavbarTest extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void OpenBrowser() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
	}

	@Test
	public void ValidateNav() throws IOException {

		HomePageObject hp = new HomePageObject(driver);
		Assert.assertTrue(hp.getNavbar().isDisplayed());
		log.info("successfully validated navbar");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}

}
