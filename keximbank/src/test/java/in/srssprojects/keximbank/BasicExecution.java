package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {

	@BeforeClass(groups = { "branch", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	public void launch() {
		bankHomePageObj = launchBrowser(BrowserName.chrome, "http://srssprojects.in");

	}

	@AfterClass(groups = { "branch", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	public void tearDown() {
		closeBrowser();
	}

}
