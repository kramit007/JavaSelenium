import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
//		System.setProperty(webdriver.chrome.driver,"path");
		WebDriver driver = new ChromeDriver();
		
//		to maximize window
		driver.manage().window().maximize();
		
//		to delete all cookies
//		driver.manage().deleteAllCookies();
		
//		to add cookies
//		driver.manage().addCookie(null);		
		
		driver.get("https://www.google.com/");
		
//		to take screenshot
//		link to download jars for FileUtils : https://commons.apache.org/proper/commons-io/download_io.cgi		
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\Eclips\\Screenshots\\screenshot.png"));   //C drive will not allow to take screenshot because it is secure use different drive
		
	}

}
