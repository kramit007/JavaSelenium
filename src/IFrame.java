import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
		// driver.switchTo().frame(0); through index
		Actions ac = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("div[id=\"draggable\"]"));
		ac.dragAndDropBy(source, 50, 55).build().perform();
		driver.switchTo().defaultContent();

	}

}
