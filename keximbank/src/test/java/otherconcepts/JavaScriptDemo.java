package otherconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("samsung galaxy s9 plus");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object valueInSearch = js.executeScript("return arguments[0].value",search);
		System.out.println(valueInSearch.toString());
		
		js.executeScript("document.documentElement.scrollBy(0, 300)");
		Thread.sleep(5000);
		
		WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
		js.executeScript("arguments[0].scrollIntoView()", facebookLink);
		Thread.sleep(5000);
		driver.close();
	}

}
