package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TestExecution extends BaseClass{
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetailsPage branchDetailsPageObj;
	BranchCreationPage branchCreationPageObj; 
	RoleDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	EmployeeDetailsPage employeeDetailsPageObj;
	EmployeeCreationPage employeeCreationPageObj;
	Alert alert=driver.switchTo().alert();
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
	   branchCreationPageObj.branchName("TNAGAR2");
	   branchCreationPageObj.addressOne("roadno2");
	   branchCreationPageObj.zipCode("34567");
	   branchCreationPageObj.country("INDIA");
	   branchCreationPageObj.state("Tamil Nadu");
	   branchCreationPageObj.city("MADHURAI");
	   branchCreationPageObj.submit();
	   alert.accept();
	   	}
 /**
	@Test(priority=4)
	public void roleDetails() {
		roleDetailsPageObj = branchCreationPageObj.home();
		
	}
	
	@Test(priority=5)
	public void roleCreation() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName("BankkManagr1");
		roleCreationPageObj.fillRoleDesc("mangerialactivities1");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.roleSubmit();
		alert.accept();
		
	}
	
	@Test(priority=6)
	public void empDetails() {
		employeeDetailsPageObj = roleCreationPageObj.empClick(); 
		
	}
	
	@Test(priority=7)
	public void empCreation() {
		employeeCreationPageObj=employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName("micheal");
		employeeCreationPageObj.fillEmpPwd("password");
		employeeCreationPageObj.selectEmpBranch("TNAGAR2");
		employeeCreationPageObj.selectEmpRole("BankkManagr1");
		employeeCreationPageObj.empClick();
		alert.accept();
	}
	
	//@Test(priority = 30)
	//public void tearDown() {
		//closeBrowser();
	//}
**/
}
