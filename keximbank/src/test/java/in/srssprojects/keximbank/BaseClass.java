package in.srssprojects.keximbank;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;

	/**
	 * returns path of the fileName which is in the folderName folder must be inside
	 * the project root folder and file name must contain extensions also
	 * 
	 * @param folderName
	 * @param fileName
	 * @return
	 *
	 */
	public WebDriver getDriver() {
		return driver;
	}

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy HH_mm_ss");
		return df.format(date);
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
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		LogListener listener = new LogListener();
		edriver.register(listener);
		driver = edriver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return new BankHomePage(driver);
	}

	public BankHomePage launchBrowser(String brName, String url) {
		BankHomePage obj = null;
		if (brName.equalsIgnoreCase("chrome")) {
			obj = launchBrowser(BrowserName.chrome, url);
		} else if (brName.equalsIgnoreCase("firefox")) {
			obj = launchBrowser(BrowserName.firefox, url);
		} else {
			throw new RuntimeException("browser name is invalid");
		}
		return obj;
	}

	public BankHomePage launchBrowser(String brName, String url, String nodeUrl, String os) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if(os.equalsIgnoreCase("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}else if(os.equalsIgnoreCase("mac")) {
			caps.setPlatform(Platform.MAC);
		}else if(os.equalsIgnoreCase("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		if(brName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName(BrowserType.CHROME);
		}else if(brName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName(BrowserType.FIREFOX);
		}
		
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		LogListener listener = new LogListener();
		edriver.register(listener);
		driver = edriver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
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

	public String captureScreenShot(String folderName, String fileName, WebDriver driver) {
		File srcImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destImage = new File(getFilePath(folderName, fileName + getDate() + ".png"));
		System.out.println("image captured");
		try {
			BufferedImage bi = ImageIO.read(srcImage);
			ImageIO.write(bi, "png", destImage);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return destImage.getAbsolutePath();
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
