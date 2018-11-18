package in.srssprojects.keximbank;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;
	/**
	 * returns path of the fileName which is in the folderName
	 * folder must be inside the project root folder
	 * and file name must contain extensions also
	 * @param folderName
	 * @param fileName
	 * @return
	 *
	 */
	public String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}
	
	public void launchBrowser(BrowserName name, String url) {
		switch (name) {
		case chrome:
			System.setProperty("webdriver.chrome.driver",getFilePath("resources", "chromedriver.exe"));
			driver = new ChromeDriver();
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver",getFilePath("resources", "geckodriver.exe"));
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser name is invalid");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
