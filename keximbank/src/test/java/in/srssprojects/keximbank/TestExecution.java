package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TestExecution extends BaseClass {
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetailsPage branchDetailsPageObj;
	BranchCreationPage branchCreationPageObj;
	RoleDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	EmployeeDetailsPage employeeDetailsPageObj;
	EmployeeCreationPage employeeCreationPageObj;
	BranchUpdationPage branchUpdationPageObj;
	RoleUpdationPage roleUpdationPageObj;
	EmployeeUpdationPage employeeUpdationPageObj; 
	Alert alert;

	@Test(priority = 0)
	public void launch() {
		bankHomePageObj = launchBrowser(BrowserName.chrome, "http://srssprojects.in");

	}

	@Test(priority = 1)
	public void login2() {
		bankHomePageObj.fillUserName(SampleData.username);
		bankHomePageObj.fillPassword(SampleData.password);
		adminHomePageObj = bankHomePageObj.clickLogin();
	}

	@Test(priority = 1)
	public void login1WithInvalidData() {
		bankHomePageObj.fillUserName(SampleData.username);
		bankHomePageObj.fillPassword(SampleData.invalidPassword);
		adminHomePageObj = bankHomePageObj.clickLogin();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 2)
	public void branchSearch() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchDetailsPageObj.selectCountry(SampleData.bs_country);
		branchDetailsPageObj.selectState(SampleData.bs_state);
		branchDetailsPageObj.selectCity(SampleData.bs_city);
		branchDetailsPageObj.clickSearch();
	}

	@Test(priority = 3)
	public void branchCreation() {
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		branchCreationPageObj.branchName(SampleData.bc_branchName);
		branchCreationPageObj.addressOne("roadno2");
		branchCreationPageObj.zipCode("34567");
		branchCreationPageObj.country("INDIA");
		branchCreationPageObj.state("Tamil Nadu");
		branchCreationPageObj.city("MADHURAI");
		alert = branchCreationPageObj.submit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 4)
	public void branchCreationWithDuplicateData() {
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		branchCreationPageObj.branchName("TNAGAR2");
		branchCreationPageObj.addressOne("roadno2");
		branchCreationPageObj.zipCode("34567");
		branchCreationPageObj.country("INDIA");
		branchCreationPageObj.state("Tamil Nadu");
		branchCreationPageObj.city("MADHURAI");
		alert = branchCreationPageObj.submit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 5)
	public void branchCreationWithBlankData() {
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		alert = branchCreationPageObj.submit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 6)
	public void branchCreationReset() {
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		branchCreationPageObj.branchName("TNAGAR2");
		branchCreationPageObj.addressOne("roadno2");
		branchCreationPageObj.zipCode("34567");
		branchCreationPageObj.country("INDIA");
		branchCreationPageObj.state("Tamil Nadu");
		branchCreationPageObj.city("MADHURAI");
		branchCreationPageObj.clickReset();
	}

	@Test(priority = 7)
	public void branchCreationCancel() {
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		branchCreationPageObj.branchName("TNAGAR2");
		branchCreationPageObj.addressOne("roadno2");
		branchCreationPageObj.zipCode("34567");
		branchCreationPageObj.country("INDIA");
		branchCreationPageObj.state("Tamil Nadu");
		branchCreationPageObj.city("MADHURAI");
		branchCreationPageObj.clickCancel();
	}

	@Test(priority = 8)
	public void roleDetails() {
		roleDetailsPageObj = branchCreationPageObj.home();
	}

	@Test(priority = 9)
	public void roleCreation() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName("BankkManagrrr");
		roleCreationPageObj.fillRoleDesc("mangerialactivities");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(priority = 10)
	public void roleCreationWithDuplicateData() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName("BankkManagrrr");
		roleCreationPageObj.fillRoleDesc("mangerialactivities");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 11)
	public void roleCreationWithBlankData() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 12)
	public void roleCreationReset() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName("BankkManagrrr");
		roleCreationPageObj.fillRoleDesc("mangerialactivities");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
	}

	@Test(priority = 10)
	public void roleCreationCancel() {
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName("BankkManagrrr");
		roleCreationPageObj.clickCancel();

	}

	@Test(priority = 11)
	public void empCreation() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName("micheal");
		employeeCreationPageObj.fillEmpPwd("password");
		employeeCreationPageObj.selectEmpBranch("TNAGAR2");
		employeeCreationPageObj.selectEmpRole("BankkManagrrr");
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 12)
	public void empCreationWithDuplicateData() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName("micheal");
		employeeCreationPageObj.fillEmpPwd("password");
		employeeCreationPageObj.selectEmpBranch("TNAGAR2");
		employeeCreationPageObj.selectEmpRole("BankkManagrrr");
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 13)
	public void empCreationWithBlankData() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 14)
	public void empCreationReset() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName("micheal");
		employeeCreationPageObj.fillEmpPwd("password");
		employeeCreationPageObj.selectEmpBranch("TNAGAR2");
		employeeCreationPageObj.selectEmpRole("BankkManagrrr");
		employeeCreationPageObj.clickReset();
	}

	@Test(priority = 15)
	public void empCreationCancel() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.clickCancel();
	}

	@Test(priority = 16)
	public void updateBranch() throws InterruptedException {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchUpdationPageObj = branchDetailsPageObj.clickEditInTable("333878");
		branchUpdationPageObj.updateBrnachName("newLingampallyBranchCHH");
		alert = branchUpdationPageObj.updateBranchClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
        alert.accept();
	}

	@Test(priority = 17)
	public void deleteBranch() throws InterruptedException {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		alert = branchDetailsPageObj.clickDeleteInTable("103");
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
	}
	
	@Test(priority = 18)
	public void updateRole() throws InterruptedException {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleUpdationPageObj = roleDetailsPageObj.clickEditInTable("18999");
		roleUpdationPageObj.updateRoleName("mkjkj");
		alert = roleUpdationPageObj.updateRoleClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
        alert.accept();
	}

	@Test(priority = 19)
	public void deleteRole() throws InterruptedException {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		alert = roleDetailsPageObj.clickDeleteInTable("17");
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
	}
	
	
	@Test(priority = 20)
	public void updateEmployee() throws InterruptedException {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeUpdationPageObj = employeeDetailsPageObj.clickEditInTable("6462");
		employeeUpdationPageObj.updateEmpName("asdffds");
		alert = employeeUpdationPageObj.updateEmpClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
        alert.accept();
	}

	@Test(priority = 21)
	public void deleteEmployee() throws InterruptedException {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		alert = employeeDetailsPageObj.clickDeleteInTable("6462");
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	

	@Test(priority = 30)
	public void tearDown() {
		closeBrowser();
	}

}
