import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty(webdriver.chrome.driver, "path");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//		locators
		driver.findElement(By.id("inputUsername")).sendKeys("Amit");           //By ID attribute
		driver.findElement(By.name("inputPassword")).sendKeys("password");     //By Name attribute
		driver.findElement(By.className("signInBtn")).click();                 //By Class Name
		String text =driver.findElement(By.cssSelector("p.error")).getText();  //By Css Selector
		System.out.println(text);
		driver.findElement(By.linkText("Forgot your password?")).click();      //Link Text
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("Amit");                //By Xpath
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys("amit@gmail.com");  //By Css Selector
		driver.findElement(By.xpath("//input[@type=\"text\"][2]")).clear();                             //By Xpath and index
		driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(3)")).sendKeys("amit@gmail.com"); //By CssSelector child Note: we use index in Xpath and nth in css
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345678");   //By Xpath Parent to child
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String pass = getPass(driver);
	    driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();  // By parent child index
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("amit");
	    driver.findElement(By.cssSelector("input[placeholder*=Pass]")).sendKeys(pass);    //By Regular Expression css selector
	    driver.findElement(By.id("chkboxOne")).click();
	    driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();      //By Regular Expression Xpath
	    Thread.sleep(1000);
	    String conf = driver.findElement(By.tagName("p")).getText();
	    System.out.println(conf);
	    Assert.assertEquals(conf, "You are successfully logged in.");                   
	    driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click();    // By Text 
		driver.close();     
	}
	public static String getPass(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); 
	    String pass = driver.findElement(By.cssSelector("form p")).getText(); //By CssSelector Parent to child
	    String[] Pass1 = pass.split("'");
	    String acPass = Pass1[1].split("'")[0];
	    return acPass;
	}

}
