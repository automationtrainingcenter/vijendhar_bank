package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgListener extends BaseClass implements ITestListener, ISuiteListener{

	@Override
	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName()+" passed");
		report.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseClass) currentClass).getDriver();
		String imgPath = captureScreenShot("screenshots", result.getName(), driver);
		test.log(LogStatus.FAIL, result.getName()+" failed"+ test.addScreenCapture(imgPath));
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName()+" skipped");
		report.endTest(test);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		report = new ExtentReports(getFilePath("reports", "report1.html"));
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		report.close();
	}

}
