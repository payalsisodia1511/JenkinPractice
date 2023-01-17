package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	public WebDriver driver;
	By email=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By loginbtn = By.cssSelector("input[value='Log In']");


	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginbtn);
	}
}
