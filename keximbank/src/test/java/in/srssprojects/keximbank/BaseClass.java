package in.srssprojects.keximbank;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;

	/**
	 * returns path of the fileName which is in the folderName folder must be inside
	 * the project root folder and file name must contain extensions also
	 * 
	 * @param folderName
	 * @param fileName
	 * @return
	 *
	 */
	public String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	public BankHomePage launchBrowser(BrowserName name, String url) {
		switch (name) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", getFilePath("resources", "chromedriver.exe"));
			driver = new ChromeDriver();
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver", getFilePath("resources", "geckodriver.exe"));
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser name is invalid");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new BankHomePage(driver);
	}

	public void closeBrowser() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	public static void tableHelper(WebElement table, String id, String operation) {
//		locate rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		iterate over the rows
		for (int i = 1; i < rows.size(); i++) {
//			locate cells in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
//			id is in first cell, edit is second cell from last, delete is in last cell
			if (cells.get(0).getText().equals(id)) {
				if (operation.equalsIgnoreCase("edit")) {
					cells.get(cells.size() - 2).findElement(By.tagName("a")).click();
					break;
				} else if (operation.equalsIgnoreCase("delete")) {
					cells.get(cells.size() - 1).findElement(By.tagName("a")).click();
					break;
				} else {
					System.out.println("invalid operation");
				}
			}
		}

	}

}
