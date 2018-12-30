package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {

	@BeforeClass(groups = { "branch","data_driven", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	@Parameters({"url", "browserName", "nodeurl", "os"})
	public void launch(String url, String brName, String nodeUrl, String os) {
		bankHomePageObj = launchBrowser(brName, url, nodeUrl, os);

	}

	@AfterClass(groups = { "branch","data_driven", "search", "create", "role", "createCancel", "reset", "employee" , "cancel" , "invalid", "update", "delete"})
	public void tearDown() {
		closeBrowser();
	}

}
