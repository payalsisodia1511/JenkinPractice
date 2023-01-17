package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import resources.Base;

public class StepDefination extends Base {

	@Given("^Initialize the broser with chrome$")
	public void initialize_the_broser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^Click on login link in home page to land on sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {
	
		HomePageObject l = new HomePageObject(driver);
		 Thread.sleep(10000);
		 if(l.getPopUp().isDisplayed())
		 {
			 l.getPopUp().click();
		 }
	
		l.getLogin().click();
	}

//	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and Logs in$")
//	public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
//		LoginPageObject lp = new LoginPageObject(driver);
//		lp.getEmail().sendKeys(strArg1);
//		lp.getPassword().sendKeys(strArg2);
//		lp.getLoginBtn().click();
//	}
	 @When("^ User enters (.+) and (.+) and Logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPageObject lp = new LoginPageObject(driver);
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLoginBtn().click();
	    }
	 @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	      driver.close();
	    }

}
