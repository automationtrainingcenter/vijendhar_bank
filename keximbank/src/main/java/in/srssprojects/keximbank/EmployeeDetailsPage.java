package in.srssprojects.keximbank;

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
	
	// click on new employee
	
	public EmployeeCreationPage employeeClick() {
		
		this.newEmployee.click();
		
		return PageFactory.initElements(driver,EmployeeCreationPage.class);
		
	}
}


