package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {

	WebDriver driver;
	// constructor

	public RoleDetailsPage(WebDriver driver) {

		this.driver = driver;
	}

	// newrole
	@FindBy(how = How.ID_OR_NAME, using = "btnRoles")
	private WebElement newRole;

	// role details table
	@FindBy(how = How.XPATH, using = "//table[@id='DGRoles']/tbody")
	private WebElement roleTable;

//clickonnewrole

	public RoleCreationPage roleClick() {

		this.newRole.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}

	// click on edit table to return role updation page
	public RoleUpdationPage clickEditInTable(String roleId) {
		TableHelper.handleTable(this.roleTable, roleId, "edit");
		return PageFactory.initElements(driver, RoleUpdationPage.class);
	}

	// click on delete in table to return alert
	public Alert clickDeleteInTable(String roleId) {
		TableHelper.handleTable(this.roleTable, roleId, "delete");
		return driver.switchTo().alert();

	}

	public boolean validateRoleDetails() {
		// TODO Auto-generated method stub
		return this.newRole.isDisplayed() && driver.getTitle().equals("Admin_Roles_details");
	}
}