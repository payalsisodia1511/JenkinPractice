package Academy.E2EProjectAgain;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;

import resources.Base;

public class ValidateTitle extends Base {
	WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void OpenBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Validatetitle() throws IOException {
		HomePageObject hp = new HomePageObject(driver);
		Assert.assertEquals(hp.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated title");
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
