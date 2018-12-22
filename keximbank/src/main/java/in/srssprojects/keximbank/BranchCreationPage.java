package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {

	WebDriver driver;

	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;

	}

	// Branch Name
	@FindBy(how = How.ID_OR_NAME, using = "txtbName")
	private WebElement branchName;

	// Address1
	@FindBy(how = How.ID_OR_NAME, using = "txtAdd1")
	private WebElement addressLine1;

	// zipcode
	@FindBy(how = How.ID_OR_NAME, using = "txtZip")
	private WebElement zipcode;

	// country drop down

	@FindBy(how = How.ID_OR_NAME, using = "lst_counrtyU")
	private WebElement country;

	// state drop down

	@FindBy(how = How.ID_OR_NAME, using = "lst_stateI")
	private WebElement state;

	// city drop down
	@FindBy(how = How.ID_OR_NAME, using = "lst_cityI")
	private WebElement city;

	// submit
	@FindBy(how = How.ID_OR_NAME, using = "btn_insert")
	private WebElement submit;

	// roles
	@FindBy(how = How.XPATH, using = "//img[@src='images/Roles_but.jpg']")
	private WebElement roles;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// enter branch name
	public void branchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}

	public void addressOne(String address1) {
		this.addressLine1.sendKeys(address1);
	}

	// enter zipcode
	public void zipCode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}

	// select country
	public void country(String country) {
		Select c = new Select(this.country);
		c.selectByVisibleText(country);
	}

	// select state
	public void state(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	// select city
	public void city(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

	// clickonsubmit
	public Alert submit() {
		this.submit.click();
		return driver.switchTo().alert();
	}

	// reset button
	public void clickReset() {
		this.reset.click();
	}

//	click cancel button
	public BranchDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	public RoleDetailsPage home() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	public boolean validateBranchCreation() {
		// TODO Auto-generated method stub
		return this.branchName.isDisplayed() && driver.getTitle().equals("admin_banker_master");
	}
}