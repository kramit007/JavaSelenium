import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
//		To handle month
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) 
		{				
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
//		To handle data
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day "));
		int no = dates.size();
		for (int i = 0; i < no; i++) {
			String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText(); 
			if (text.equalsIgnoreCase("22")) {
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}
		}
	}

}
