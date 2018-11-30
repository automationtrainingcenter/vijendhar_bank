package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}

//	home button
	@FindBy(how = How.XPATH, using = "//img[@src='images/images/admin_but_01.jpg']")
	private WebElement home;

//	change password
	@FindBy(how = How.XPATH, using = "//img[@src='images/admin_but_02.jpg']")
	private WebElement changePassword;

//	logout
	@FindBy(how = How.XPATH, using = "//img[@src='images/admin_but_03.jpg']")
	private WebElement logout;

//	branches
	@FindBy(how = How.XPATH, using = "//img[@src='images/Branches_but.jpg']")
	private WebElement branches;

//	roles
	@FindBy(how = How.XPATH, using = "//img[@src='images/Roles_but.jpg']")
	private WebElement roles;

//	employees images/emp_btn.jpg
	@FindBy(how = How.XPATH, using = "//img[@src='images/emp_btn.jpg']")
	private WebElement employees;

//	users
	@FindBy(how = How.XPATH, using = "//img[@src='images/images/emp_btn.jpg']")
	private WebElement users;

// click on home
	public AdminHomePage clickHome() {
		this.home.click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}

//	click on change password
	public void clickChangePassword() {
		this.changePassword.click();
	}

//	click on logout
	public BankHomePage clickLogout() {
		this.logout.click();
		return new BankHomePage(driver);
	}

//	click on branches
	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

//	click on roles
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

//	click on users
	public void clickUsers() {
		this.users.click();
	}

//	click on employees
	public EmployeeDetailsPage clickEmployees() {
		this.employees.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}

}
