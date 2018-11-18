package in.srssprojects.keximbank;

import org.testng.annotations.Test;

public class TestExecution extends BaseClass{
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetailsPage branchDetailsPageObj;
	
	@Test(priority = 0)
	public void launch() {
		bankHomePageObj = launchBrowser(BrowserName.chrome, "http://srssprojects.in");
		
	}
	
	@Test(priority = 1)
	public void login() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPassword("Admin");
		adminHomePageObj = bankHomePageObj.clickLogin();
	}
	
	@Test(priority =2)
	public void branchSearch() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchDetailsPageObj.selectCountry("UK");
		branchDetailsPageObj.selectState("England");
		branchDetailsPageObj.selectCity("LONDON");
		branchDetailsPageObj.clickSearch();
	}
	
	@Test(priority = 30)
	public void tearDown() {
		closeBrowser();
	}

}
