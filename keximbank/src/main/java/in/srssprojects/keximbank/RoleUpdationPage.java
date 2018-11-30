package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RoleUpdationPage {

	WebDriver driver;
	
	public RoleUpdationPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	
	//Role Name
	@FindBy(how=How.ID_OR_NAME,using="txtrNameU")
	private WebElement newRoleName;
	
	//Role Desc
	@FindBy(how =How.ID_OR_NAME, using="txtrdescU")
	private WebElement newRroleDesc;
	
	//Role Type
	@FindBy(how=How.ID_OR_NAME,using="lstRtype")
	private WebElement newRoleType;
	
	//roleSubmit
	@FindBy(how=How.ID_OR_NAME,using="btnupdate")
	private WebElement newRoleSubmit;
	
	public void updateRoleName(String uRoleName) {
		this.newRoleName.clear();
		this.newRoleName.sendKeys(uRoleName); 
	}
	public void updateRoleDesc(String uRoleDesc) {
		this.newRroleDesc.clear();
		this.newRroleDesc.sendKeys(uRoleDesc); 
	}
	
	public void UpdateRoleType(String uRoleType) {
		new Select(this.newRoleType).selectByVisibleText(uRoleType);
	}
	
	public Alert updateRoleClick() {
		this.newRoleSubmit.click();
		return driver.switchTo().alert();
}}
