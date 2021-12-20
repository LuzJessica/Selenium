import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocator {

	public static void main(String[] args) {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		/*The relative locator are used to help us find a element that has no Selenium supported locator (tagName, id, etc...)
		 * Lets see the use of above(), bellow(), toLeftOf(), toRightOff(), */
		WebElement nameEditBox = driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		WebElement loveIceCreamcheck = driver.findElement(By.id("exampleCheck1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(loveIceCreamcheck)).getText());
		
		WebElement employeeCheck = driver.findElement(By.id("inlineRadio2"));
		System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(employeeCheck)).getText());
		
		
	}

}
