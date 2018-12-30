package otherconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendersDemo {
	@Test
	public void calenderHandling() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("hotel-checkin-hp-hotel")).click();
		boolean status = false;
		do {
			List<WebElement> captions = driver
					.findElements(By.xpath("//caption[@class='datepicker-cal-month-header']"));
			for (WebElement caption : captions) {
				if (caption.getText().contains("Sep")) {
					status = true;
				}
			}

			if (status) {
				WebElement calender = driver
						.findElement(By.xpath("//caption[contains(text(),'Sep 2019')]/parent::table/tbody"));
				List<WebElement> rows = calender.findElements(By.tagName("tr"));
				boolean flag = false;
				for (WebElement row : rows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().contains("16")) {
							cell.findElement(By.tagName("button")).click();
							flag = true;
							break; // cells loop
						}
					}
					if (flag) {
						break; // rows loop
					}
				}
			} else {
				driver.findElement(By.xpath("//div[@class='datepicker-cal']//button[2]")).click();
			}
		} while (status == false);
	}

}
