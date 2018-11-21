package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {
	
	WebDriver driver;
	//constructor
	
	public RoleDetailsPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//newrole
	@FindBy(how=How.ID_OR_NAME, using = "btnRoles")
     private WebElement newRole;



//clickonnewrole

public RoleCreationPage roleClick() {
	
	this.newRole.click();
	return PageFactory.initElements(driver,RoleCreationPage.class );
}
}