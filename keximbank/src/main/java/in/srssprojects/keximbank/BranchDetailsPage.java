package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class BranchDetailsPage {
	WebDriver driver;

	public BranchDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

//	country dropdown
	@FindBy(how = How.ID_OR_NAME, using = "lst_countryS")
	private WebElement country;

//	state dropdown
	@FindBy(how = How.ID_OR_NAME, using = "lst_stateS")
	private WebElement state;

//	city dropdown
	@FindBy(how = How.ID_OR_NAME, using = "lst_cityS")
	private WebElement city;

//	search button
	@FindBy(how = How.ID_OR_NAME, using = "btn_search")
	private WebElement search;

//	clear button
	@FindBy(how = How.ID_OR_NAME, using = "btn_clsearch")
	private WebElement clear;

//	new branch button
	@FindBy(how = How.ID_OR_NAME, using = "BtnNewBR")
	private WebElement newBranch;
	
	
//	branch details table body
	@FindBy(how = How.XPATH, using = "//table[@id='DG_bankdetails']/tbody")
	private WebElement branchTable;
	
	
//	select country
	public void selectCountry(String country) {
		new Select(this.country).selectByVisibleText(country);
	}

//	select state
	public void selectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

//	select city
	public void selectCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

//	click search
	public void clickSearch() {
		this.search.click();
	}

//	click clear
	public void clickClear() {
		this.clear.click();
	}

//	click new branch
	public BranchCreationPage clickNewBranch() {
		this.newBranch.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}

//	click on edit button in table return BranchUpdationPage
	public BranchUpdationPage clickEditInTable(String branchId) {
		TableHelper.handleTable(this.branchTable, branchId, "edit");
		return PageFactory.initElements(driver, BranchUpdationPage.class);
	}

//	click on delete button in table return BranchUpdationPage
	public Alert clickDeleteInTable(String branchId) {
		TableHelper.handleTable(this.branchTable, branchId, "delete");
		return driver.switchTo().alert();
	}

}
