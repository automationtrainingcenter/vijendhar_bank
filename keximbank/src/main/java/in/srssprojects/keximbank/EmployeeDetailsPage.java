package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage {

	WebDriver driver;
	
	public EmployeeDetailsPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	// new employee
	@FindBy(how=How.ID_OR_NAME,using = "BtnNew")
	private WebElement newEmployee;
	
	//role details table
		@FindBy(how=How.XPATH,using = "//table[@id='DGBanker']/tbody")
		private WebElement employeeTable;

	
	// click on new employee
	
	public EmployeeCreationPage employeeClick() {
		
		this.newEmployee.click();
		
		return PageFactory.initElements(driver,EmployeeCreationPage.class);
		
	}
	
	//click on edit table to return role updation page
	public EmployeeUpdationPage clickEditInTable(String employeeId) {
		TableHelper.handleTable(this.employeeTable, employeeId, "edit");
		return PageFactory.initElements(driver, EmployeeUpdationPage.class);
	}
		
	//click on delete in table to return alert
		public Alert clickDeleteInTable(String employeeId) {
			TableHelper.handleTable(this.employeeTable, employeeId, "delete");
			return driver.switchTo().alert();
	
}}


