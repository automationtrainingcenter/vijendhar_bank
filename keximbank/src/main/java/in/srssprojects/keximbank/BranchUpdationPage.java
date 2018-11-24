package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BranchUpdationPage {
	WebDriver driver;

	public BranchUpdationPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using ="txtbnameU")
	private WebElement branchName;
	
	
	public void updateBrnachName(String newBranchName) {
		this.branchName.clear();
		this.branchName.sendKeys(newBranchName); 
	}

}
