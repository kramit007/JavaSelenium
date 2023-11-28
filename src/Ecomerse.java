import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecomerse {

	public static void main(String[] args) {
		String[] items = { "Brocolli", "Cucumber", "Beetroot" };
		// System.setProperties(webdriver.chrome.driver, "path");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));                         //Implicit wait
		addItems(driver, items);
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		driver.findElement(By.cssSelector("input[class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class=\"promoBtn\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));                      //Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"promoInfo\"]")));
		System.out.println(driver.findElement(By.cssSelector("span[class=\"promoInfo\"]")).getText());

	}

	public static void addItems(WebDriver driver, String[] items) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int count = 0;
		for (int i = 0; i < products.size(); i++) {
			String product = products.get(i).getText().split("-")[0].trim();
			List<String> itemrequired = Arrays.asList(items);
			if (itemrequired.contains(product)) {
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				count++;
				if (count == items.length) {
					break;
				}
			}

		}

	}
}
