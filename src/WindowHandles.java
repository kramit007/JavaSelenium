import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.className("blinkingText")).click();
	    Set<String> ids = driver.getWindowHandles();
	    Iterator<String> it = ids.iterator();
	    String parentID = it.next();
	    String childID = it.next();
	    driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText());
		String email = driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].split("with")[0].trim();
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(email);

	}

}
