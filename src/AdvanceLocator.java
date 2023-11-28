import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceLocator {

	public static void main(String[] args) {
		//System.setProperty(webdriver.chrome.driver,"");
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
			String text=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText(); //Parent - Child - Siblings
			System.out.println(text);
			String text1 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[1]")).getText();  // Parent - child - to Parent
			System.out.println(text1);
			}
	
	//one more way Parent child: //table[@id="citydropdown"]//a[@value="BLR"]
	}


