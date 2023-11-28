import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
//		System.setProperty(webdriver.chrome.driver,"path");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticelement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); // Static dropdown
		Select dropdown = new Select(staticelement);																										
		dropdown.selectByIndex(2);
		dropdown.getFirstSelectedOption();
		dropdown.selectByVisibleText("AED");
		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 1; i <= 5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();              // dynamic dropdown
		driver.findElement(By.xpath("//table[@id=\"citydropdown\"]//a[@value=\"BLR\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();

//		Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement option : options)
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}

		}

//			Checkboxes
		driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).click();
		Boolean cond = driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).isSelected();
		Assert.assertTrue(cond);
		
//		Select active Calendar
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

//		Calendar is enabled or disabled
		driver.findElement(By.id("input[id*=\"Trip_0\"]"));
		// Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());   //Sometime it doesn't work in box is disable in mode				
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("input[id*=Trip_1]")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
		} else
		{
			Assert.assertTrue(false);
		}
	}

}
