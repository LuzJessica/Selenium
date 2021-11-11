import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com");// in this approach all the componets are fully load
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");//here no
		driver.navigate().back();//back to google
		driver.navigate().forward();//go forward, in this case to rahulsheetyacademy
	}

}
