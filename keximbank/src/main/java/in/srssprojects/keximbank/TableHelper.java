package in.srssprojects.keximbank;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableHelper{

	public static void handleTable(WebElement table, String id, String operation) {
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
