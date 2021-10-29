import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {
	
		/*Using interface Webdriver so we dont need to implement one
		objetc to each broswer*/
		
		//Setting chrome driver path, key = key of interface selenium webdriver and value = the path in local system where the driver is
		
		/* Implementation for Chrome Broswer
		
		System.setProperty("webdriver.com.driver", "C:\\Users\\Alex\\SeleniumCourse\\SeleniumCourse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		*/
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alex\\SeleniumCourse\\SeleniumCourse\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());//get the title of the website mentioned in line command on line 14 e shows it
		System.out.println(driver.getCurrentUrl());//get the current url when the browser comes up
		driver.close();//closes the browser window originaly open, and the driver.quit closes all the windows opened during the execution
	}

}
