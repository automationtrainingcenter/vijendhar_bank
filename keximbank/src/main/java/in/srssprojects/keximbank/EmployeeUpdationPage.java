package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class EmployeeUpdationPage {
	
	WebDriver driver;
	
			public EmployeeUpdationPage(WebDriver driver) {
			this.driver = driver;
		}

		// employee name - txtUname
		@FindBy(how = How.ID_OR_NAME, using = "txtBnameU")
		private WebElement newEmpName;

		// employee pwd - txtLpwd
		@FindBy(how = How.ID_OR_NAME, using = "txtPwdU")
		private WebElement newEmpPwd;
		// emp role - lst_Roles
		@FindBy(how = How.ID_OR_NAME, using = "lstrolesU")
		private WebElement newEmpRole;

		// emp branch - lst_Branch
		@FindBy(how = How.ID_OR_NAME, using = "lstBidU")
		private WebElement newEmpBranch;

		// submit button
		@FindBy(how = How.ID_OR_NAME, using = "BtnUpdate")
		private WebElement updateEmployeeSubmit;

		

		

		// fill emp name
		public void updateEmpName(String uEmpName) {
			this.newEmpName.clear();
			this.newEmpName.sendKeys(uEmpName);
		}

		// fill emp pwd
		public void fillEmpPwd(String uEmpPwd) {
			this.newEmpPwd.clear();
			this.newEmpPwd.sendKeys(uEmpPwd);
		}

		// select emp role
		public void selectEmpRole(String uEmpRole) {
			new Select(this.newEmpRole).selectByVisibleText(uEmpRole);
		}

		// select emp branch
		public void selectEmpBranch(String uEmpBranch) {
			new Select(this.newEmpBranch).selectByVisibleText(uEmpBranch);

		}

		// click on submit button
		public Alert updateEmpClick() {
			this.updateEmployeeSubmit.click();
			return driver.switchTo().alert();
		}

}
