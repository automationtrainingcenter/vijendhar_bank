package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	
	WebDriver driver;
	
	public RoleCreationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//Role Name
	@FindBy(how=How.ID_OR_NAME,using="txtRname")
	private WebElement roleName;
	
	//Role Desc
	@FindBy(how =How.ID_OR_NAME, using="txtRDesc")
	private WebElement roleDesc;
	
	//Role Type
	@FindBy(how=How.ID_OR_NAME,using="lstRtypeN")
	private WebElement roleType;
	
	//roleSubmit
	@FindBy(how=How.ID_OR_NAME,using="btninsert")
	private WebElement roleSubmit;
	
	//Employees
	@FindBy(how=How.XPATH,using="//img[@src='images/emp_btn.jpg']")
    private WebElement employees;
	
	
	//fillrolename
	public void fillRoleName(String roleName) {
		this.roleName.sendKeys(roleName);
	}
	
     //fill role desc
	public void fillRoleDesc(String roleDesc) {

		this.roleDesc.sendKeys(roleDesc);
	}
	
	public void selectRoleType(String roleType) {
		new Select(this.roleType).selectByVisibleText(roleType);
		
	}
	
	public void roleSubmit() {
		this.roleSubmit.click();
	}

	public EmployeeDetailsPage empClick() {
		
		this.employees.click();
		
		return PageFactory.initElements(driver,EmployeeDetailsPage.class);
	}
	
}


