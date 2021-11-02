import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Alex\\\\SeleniumCourse\\\\SeleniumCourse\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com");// in this approach all the componets are fully load
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");//here no
		driver.navigate().back();//back to google
		driver.navigate().forward();//go forward, in this case to rahulsheetyacademy
	}

}
