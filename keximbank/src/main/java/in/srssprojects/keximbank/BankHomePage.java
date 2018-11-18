package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BankHomePage {
	WebDriver driver;

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

//	user name
	public WebElement userName() {
		return driver.findElement(By.name("txtuId"));
	}

//	password
	public WebElement password() {
		return driver.findElement(By.name("txtPword"));
	}

//	login button
	public WebElement loginButton() {
		return driver.findElement(By.name("login"));
	}

//	fill username
	public void fillUserName(String userName) {
		this.userName().sendKeys(userName);
	}

//	fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}

//	click on login 
	public AdminHomePage clickLogin() {
		this.loginButton().click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}
}
