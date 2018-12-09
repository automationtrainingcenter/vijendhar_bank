package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {

	@BeforeClass(groups = { "branch","data_driven", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	@Parameters({"url", "browserName"})
	public void launch(String url, String brName) {
		bankHomePageObj = launchBrowser(brName, url);

	}

	@AfterClass(groups = { "branch","data_driven", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	public void tearDown() {
		closeBrowser();
	}

}
