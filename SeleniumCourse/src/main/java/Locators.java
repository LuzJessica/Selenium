import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Alex\\\\SeleniumCourse\\\\SeleniumCourse\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//setting time to selenium so it can waits for a response and will not show error when could not access an object thar is not ready yet
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		/*
		 * To find elements we need go to go the web page and click on the element we want to inspect, click with right button
		 * and click inspect. This will show us the attributes of the element and then we need to find an attribute that
		 * is supported by Selenium.
		 * In the exemple below we are inspecting the email and password fields. 
		 * For this, the locator that we find was the id and name, respectively. 
		 * So we will use this to access the elements and make some action.
		 * What the example do is, after finding the elements, set the email and password in the fields and, after that
		 * click on the Login Button to start session.
		 * */
		driver.findElement(By.id("inputUsername")).sendKeys("jessicaluz");
		driver.findElement(By.name("inputPassword")).sendKeys("senhaTeste");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		
	}

}
