import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClasss {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
//		to perform Mouse hover
		ac.moveToElement(driver.findElement(By.cssSelector("a[id=\"nav-link-accountList\"]"))).build().perform();
//		To right click
		ac.moveToElement(driver.findElement(By.cssSelector("a[id=\"nav-link-accountList\"]"))).contextClick().build().perform();
//		to enter value
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello world").build().perform();
//      to enter value and select
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello world").doubleClick().build().perform();
	}

}