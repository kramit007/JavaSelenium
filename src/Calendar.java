import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();		
//		To handle month
		while (!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().trim().contains("March")) 
		{				
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
//		To handle date
		int count = driver.findElements(By.className("flatpickr-day")).size();		
		for (int i = 0; i <count; i++) {
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText(); 
			if (text.equalsIgnoreCase("22")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
	}

}
