package otherconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliDemo {
	public static void main(String[] args) throws Exception {
		Screen screen  = new Screen();
		Pattern filePath = new Pattern(".\\images\\filepath.png");
		Pattern open = new Pattern(".\\images\\open.png");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//choose file and click on it
		driver.findElement(By.xpath("//div[contains(text(), 'Choose file')]")).click();
		Thread.sleep(3000);
//		sikuli code
		screen.find(filePath);
		screen.type(filePath, "E:\\selenium\\web services testing.docx");
		Thread.sleep(5000);
		screen.find(open);
		screen.click(open);
		Thread.sleep(5000);
		driver.close();
	}

}
