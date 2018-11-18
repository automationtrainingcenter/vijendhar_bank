package in.srssprojects.keximbank;

import org.testng.annotations.Test;

public class TestExecution extends BaseClass{
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetailsPage branchDetailsPageObj;
	BranchCreationPage branchCreationPageObj; 
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
	
	@Test(priority = 3)
	public void branchCreation() {
	   branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
	   branchCreationPageObj.branchName("TNAGAR");
	   branchCreationPageObj.addressOne("roadno1");
	   branchCreationPageObj.zipCode("34567");
	   branchCreationPageObj.country("INDIA");
	   branchCreationPageObj.state("Tamil Nadu");
	   branchCreationPageObj.city("MADHURAI");
	   branchCreationPageObj.submit();
	   
	}
	
	
	
	@Test(priority = 30)
	public void tearDown() {
		closeBrowser();
	}

}
