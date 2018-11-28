package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BranchUpdationPage {
	WebDriver driver;

	public BranchUpdationPage(WebDriver driver) {
		this.driver = driver;
	}
    //branch name
	@FindBy(how = How.ID, using ="txtbnameU")
	private WebElement branchName;
	
	// branch address
	@FindBy(how = How.ID, using ="txtadd1u")
	private WebElement addressUpdate;
	
	//pincode
	@FindBy(how = How.ID_OR_NAME, using = "txtzipu")
	private WebElement zipcode;
	
	// country drop down

	@FindBy(how = How.ID_OR_NAME, using = "drlst_countryU")
	private WebElement country;

	// state drop down

	@FindBy(how = How.ID_OR_NAME, using = "lst_stateU")
	private WebElement state;

	// city drop down
	@FindBy(how = How.ID_OR_NAME, using = "lst_stateU")
	private WebElement city;
	//update button 
	@FindBy(how = How.ID, using ="btnupdate")
	private WebElement branchUpdate;
	
	//update branch
	public void updateBrnachName(String newBranchName) {
		this.branchName.clear();
		this.branchName.sendKeys(newBranchName); 
	}
	//update adddress
	public void updateBrnachAddress(String newBranchAddress) {
		this.addressUpdate.clear();
		this.branchName.sendKeys(newBranchAddress);
		}
		
		//update zipcode
		public void updateZipcode(String newZipcode) {
			this.zipcode.clear();
			this.branchName.sendKeys(newZipcode);
		}
			// update country
			public void updateCountry(String newCountry) {
				new Select(this.country).selectByVisibleText(newCountry);
			}

			// select state
			public void updateState(String newState) {
				new Select(this.state).selectByVisibleText(newState);
			}

			// select city
			public void updateCity(String newCity) {
				new Select(this.city).selectByVisibleText(newCity);
			}


	public Alert updateBranchClick() {
		this.branchUpdate.click();
		return driver.switchTo().alert();
	}

}
	
