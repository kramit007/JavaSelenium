import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperties(webdriver.chorme.driver,"path");
		String name = "Amit";
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				driver.manage().window().maximize();
				driver.findElement(By.id("name")).sendKeys(name);
				driver.findElement(By.id("alertbtn")).click();
				String text = driver.switchTo().alert().getText();
				System.out.println(text);
				driver.switchTo().alert().accept();             // To handle alert need to switch driver to alert box
				driver.findElement(By.id("name")).sendKeys(name);
				driver.findElement(By.id("confirmbtn")).click();
				driver.switchTo().alert().dismiss();

	}

}
