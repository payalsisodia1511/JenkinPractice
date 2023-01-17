package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

	 WebDriver driver;
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("div[class='text-center'] h2");
	By navbar = By.cssSelector(".navbar-right");
	By popup = By.xpath("//button[text()='NO THANKS']");

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
	public List<WebElement> getPopUpSize() {
		return driver.findElements(popup);
	}
}
