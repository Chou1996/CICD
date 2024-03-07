package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class LoginPage extends BasePage  {
	public static WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTextfield;

	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement passwordtextfield;

	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//a[.='Forgot your password?']")
	private WebElement forgotyourpasswordLink;

	@FindBy(xpath = "//a[.='actiTIME Inc.']")
	private WebElement actitimeincLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage loginMethod() throws IOException, InterruptedException {
		usernameTextfield.sendKeys("admin");
		passwordtextfield.sendKeys("manager");
		keepmeloggedinCheckbox.click();
		loginButton.click();
		Thread.sleep(3000);
		HomePage Home = new HomePage(driver);
		return Home;
	}

	public void forgotyourpasswordMethod() {
		forgotyourpasswordLink.click();
	}

	public void actitimeincMethod() {
		actitimeincLink.click();
	}
}
