import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificates {

	public static void main(String[] args) {
		
		
		//SSL Certificates
		
		
		ChromeOptions c = new ChromeOptions();
		c.setAcceptInsecureCerts(true);
		
		
		
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://expired.badssl.com/");
		System.out.println("The page title is : " +driver.getTitle());
		

	}

}
