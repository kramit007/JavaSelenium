import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day "));
		int no = dates.size();
		for (int i = 0; i < no; i++) {
			String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();   // handle date
			if (text.equalsIgnoreCase("28")) {
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}
		}
	}

}
