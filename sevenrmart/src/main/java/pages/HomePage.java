package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::div/a")
	WebElement moreinfoadmin;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement pword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath = "//div/nav/ul[2]/li/a")
	WebElement image;
	@FindBy(xpath = "//div/nav/ul[2]/li/div/a[2]")
	WebElement logout;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signinpage;

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	public AdminUsersPage clickMoreInformationAdmin() {
		moreinfoadmin.click();
		return new AdminUsersPage(driver);
	}

	public HomePage admin() {
		image.click();
		return this;
	}

	public HomePage userLogout() {
		logout.click();
		return this;
	}

	public boolean isSigninPageDisplayed() {
		return signinpage.isDisplayed();
	}
}
