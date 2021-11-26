import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		
		//This action helps to move the mouse to an specific element and execute some actions on it
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		.sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(move).click().contextClick().build().perform();
		
		
		

	}

}
