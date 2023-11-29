import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
//		Invoking different Browsers

		// Chrome
		// System.setProperty(webdriver.chrome.driver,"D:\\Eclips\\Chromedriver\\chromedriver"");
		WebDriver driver = new ChromeDriver();

		// EnternetExplored
//		System.setProperty("wedriver.edge.driver", "D:\\Eclips\\Chromedriver\\edgedriver");
//		WebDriver driver = new EdgeDriver();

		// FireFox
//		System.setProperty("wedriver.gecko.driver", "D:\\Eclips\\Chromedriver\\gockodriver");
//		WebDriver driver = new FireFoxDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		driver.navigate().forward();
	}

}
