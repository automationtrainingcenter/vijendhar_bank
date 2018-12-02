package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.testng.Assert;
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
	String alertText;
	public void fillBranchCrationForm(String bname, String address1, String zipcode, String country, String state,
			String city) {
		branchCreationPageObj.branchName(bname);
		branchCreationPageObj.addressOne(address1);
		branchCreationPageObj.zipCode(zipcode);
		branchCreationPageObj.country(country);
		branchCreationPageObj.state(state);
		branchCreationPageObj.city(city);
	}
	
	public String acceptAlert() {
		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		return alertText;
	}

	@Test(priority = 1, groups = { "branch", "search", "create", "role", "createCancel", "reset", "employee", "cancel",
			"invalid", "update", "delete" })
	public void login2() {
		bankHomePageObj.fillUserName(SampleData.username);
		bankHomePageObj.fillPassword(SampleData.password);
		adminHomePageObj = bankHomePageObj.clickLogin();
		Assert.assertTrue(adminHomePageObj.validateLogin());
	}

	@Test(priority = 1, enabled = false)
	public void login1WithInvalidData() {
		bankHomePageObj.fillUserName(SampleData.username);
		bankHomePageObj.fillPassword(SampleData.invalidPassword);
		adminHomePageObj = bankHomePageObj.clickLogin();
		alertText = acceptAlert();
		Assert.assertTrue(alertText.contains("InCnorrect"));
	}

	@Test(priority = 2, groups = { "branch", "search" })
	public void branchSearch() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchDetailsPageObj.selectCountry(SampleData.bs_country);
		branchDetailsPageObj.selectState(SampleData.bs_state);
		branchDetailsPageObj.selectCity(SampleData.bs_city);
		branchDetailsPageObj.clickSearch();
		
	}

	@Test(priority = 3, groups = { "branch", "create" })
	public void branchCreation() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		fillBranchCrationForm(SampleData.bc_branchName, SampleData.bc_branchAddress, SampleData.bc_branchZipcode,
				SampleData.bc_branchCountry, SampleData.bc_branchState, SampleData.bc_branchCity);
		alertText = acceptAlert();
		Assert.assertTrue(alertText.contains("successfully"));
	}

	@Test(priority = 4, groups = { "branch", "create", "invalid" })
	public void branchCreationWithDuplicateData() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		fillBranchCrationForm(SampleData.bc_branchName, SampleData.bc_branchAddress, SampleData.bc_branchZipcode,
				SampleData.bc_branchCountry, SampleData.bc_branchState, SampleData.bc_branchCity);
		alertText = acceptAlert();
		Assert.assertTrue(alertText.contains("already"));
	}

	@Test(priority = 5, groups = { "branch", "create", "invalid" })
	public void branchCreationWithBlankData() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		alertText = acceptAlert();
		Assert.assertTrue(alertText.contains("fill"));
	}

	@Test(priority = 6, groups = { "branch", "reset" })
	public void branchCreationReset() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
		fillBranchCrationForm(SampleData.bc_branchName, SampleData.bc_branchAddress, SampleData.bc_branchZipcode,
				SampleData.bc_branchCountry, SampleData.bc_branchState, SampleData.bc_branchCity);
		branchCreationPageObj.clickReset();
		
	}

	@Test(priority = 7, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
//		fillBranchCrationForm(SampleData.bc_branchName, SampleData.bc_branchAddress, SampleData.bc_branchZipcode, SampleData.bc_branchCountry, SampleData.bc_branchState, SampleData.bc_branchCity);
		branchCreationPageObj.clickCancel();
	}

	@Test(priority = 8)
	public void roleDetails() {
		roleDetailsPageObj = branchCreationPageObj.home();
	}

	@Test(priority = 9, groups = { "role", "create" })
	public void roleCreation() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName(SampleData.rc_roleName);
		roleCreationPageObj.fillRoleDesc(SampleData.rc_roleDesc);
		roleCreationPageObj.selectRoleType(SampleData.rc_roleType);
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(priority = 10, groups = { "role", "create", "invalid" })
	public void roleCreationWithDuplicateData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName(SampleData.rc_roleName);
		roleCreationPageObj.fillRoleDesc(SampleData.rc_roleDesc);
		roleCreationPageObj.selectRoleType(SampleData.rc_roleType);
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 11, groups = { "role", "create", "invalid" })
	public void roleCreationWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		alert = roleCreationPageObj.roleSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 12, groups = { "role", "reset" })
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName(SampleData.rc_roleName);
		roleCreationPageObj.fillRoleDesc(SampleData.rc_roleDesc);
		roleCreationPageObj.selectRoleType(SampleData.rc_roleType);
		roleCreationPageObj.clickReset();
	}

	@Test(priority = 10, groups = { "role", "cancel" })
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.roleClick();
		roleCreationPageObj.fillRoleName(SampleData.rc_roleName);
		roleCreationPageObj.clickCancel();

	}

	@Test(priority = 11, groups = { "employee", "create" })
	public void empCreation() {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName(SampleData.ec_empName);
		employeeCreationPageObj.fillEmpPwd(SampleData.ec_empPwd);
		employeeCreationPageObj.selectEmpBranch(SampleData.ec_empBranch);
		employeeCreationPageObj.selectEmpRole(SampleData.ec_empRole);
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 12, groups = { "employee", "create", "invalid" })
	public void empCreationWithDuplicateData() {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName(SampleData.ec_empName);
		employeeCreationPageObj.fillEmpPwd(SampleData.ec_empPwd);
		employeeCreationPageObj.selectEmpBranch(SampleData.bc_branchName);
		employeeCreationPageObj.selectEmpRole(SampleData.ec_empRole);
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 13, groups = { "employee", "create", "invalid" })
	public void empCreationWithBlankData() {
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		alert = employeeCreationPageObj.empClick();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 14, groups = { "employee", "reset" })
	public void empCreationReset() {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.fillEmpName(SampleData.ec_empName);
		employeeCreationPageObj.fillEmpPwd(SampleData.ec_empPwd);
		employeeCreationPageObj.selectEmpBranch(SampleData.ec_empBranch);
		employeeCreationPageObj.selectEmpRole(SampleData.ec_empRole);
		employeeCreationPageObj.clickReset();
	}

	@Test(priority = 15, groups = { "employee", "cancel" })
	public void empCreationCancel() {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeCreationPageObj = employeeDetailsPageObj.employeeClick();
		employeeCreationPageObj.clickCancel();
	}

	@Test(priority = 16, groups = { "branch", "update" })
	public void updateBranch() throws InterruptedException {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		branchUpdationPageObj = branchDetailsPageObj.clickEditInTable(SampleData.bu_branchId);
		branchUpdationPageObj.updateBrnachName(SampleData.bc_branchName);
		alert = branchUpdationPageObj.updateBranchClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
	}

	@Test(priority = 17, groups = { "branch", "delete" })
	public void deleteBranch() throws InterruptedException {
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		alert = branchDetailsPageObj.clickDeleteInTable(SampleData.bd_branchId);
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
	}

	@Test(priority = 18, groups = { "update", "role" })
	public void updateRole() throws InterruptedException {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleUpdationPageObj = roleDetailsPageObj.clickEditInTable(SampleData.ru_roleId);
		roleUpdationPageObj.updateRoleName(SampleData.rc_roleName);
		alert = roleUpdationPageObj.updateRoleClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
	}

	@Test(priority = 19, groups = { "role", "delete" })
	public void deleteRole() throws InterruptedException {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		alert = roleDetailsPageObj.clickDeleteInTable(SampleData.rd_roleId);
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
	}

	@Test(priority = 20, groups = { "employee", "update" })
	public void updateEmployee() throws InterruptedException {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		employeeUpdationPageObj = employeeDetailsPageObj.clickEditInTable(SampleData.empu_empId);
		employeeUpdationPageObj.updateEmpName(SampleData.ec_empName);
		alert = employeeUpdationPageObj.updateEmpClick();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
	}

	@Test(priority = 21, groups = { "employee", "delete" })
	public void deleteEmployee() throws InterruptedException {
		employeeDetailsPageObj = adminHomePageObj.clickEmployees();
		alert = employeeDetailsPageObj.clickDeleteInTable(SampleData.empd_empId);
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

}
