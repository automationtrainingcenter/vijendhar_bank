package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {

	WebDriver driver;

	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	// employee name - txtUname
	@FindBy(how = How.ID_OR_NAME, using = "txtUname")
	private WebElement empName;

	// employee pwd - txtLpwd
	@FindBy(how = How.ID_OR_NAME, using = "txtLpwd")
	private WebElement empPwd;
	// emp role - lst_Roles
	@FindBy(how = How.ID_OR_NAME, using = "lst_Roles")
	private WebElement empRole;

	// emp branch - lst_Branch
	@FindBy(how = How.ID_OR_NAME, using = "lst_Branch")
	private WebElement empBranch;

	// submit button
	@FindBy(how = How.ID_OR_NAME, using = "BtnSubmit")
	private WebElement EmpSubmitBtn;

	@FindBy(how = How.ID_OR_NAME, using = "btnreset")
	private WebElement reset;

	@FindBy(how = How.ID_OR_NAME, using = "btnCancel")
	private WebElement cancel;

	// fill emp name
	public void fillEmpName(String empName) {
		this.empName.sendKeys(empName);
	}

	// fill emp pwd
	public void fillEmpPwd(String empPwd) {
		this.empPwd.sendKeys(empPwd);
	}

	// select emp role
	public void selectEmpRole(String empRole) {
		new Select(this.empRole).selectByVisibleText(empRole);
	}

	// select emp branch
	public void selectEmpBranch(String empBranch) {
		new Select(this.empBranch).selectByVisibleText(empBranch);

	}

	// click on submit button
	public Alert empClick() {
		this.EmpSubmitBtn.click();
		return driver.switchTo().alert();
	}

//	click reset
	public void clickReset() {
		this.reset.click();
	}

//	click cancel
	public EmployeeDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}

	public boolean validateEmpCreation() {
		// TODO Auto-generated method stub
		return this.empName.isDisplayed() && driver.getTitle().equals("Admin_Emp_details");
	}
}
