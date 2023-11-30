import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOption {

	public static void main(String[] args) {
//		(https://chromedriver.chromium.org/capabilities) in this link have all the ChromeOptions code
	
		ChromeOptions options = new ChromeOptions();
		// FirefoxOptions options1 = new FirefoxOptions();
		// EdgeOptions options2 = new EdgeOptions();
		
//		To accept insecure certificates
		options.setAcceptInsecureCerts(true);
		
//		To set Proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
//		Block pop-up windows
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
//		To change default download drirectry
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options); // passed option in driver so it will know how to deal with insecure certs.														// insucre links
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}	

}
