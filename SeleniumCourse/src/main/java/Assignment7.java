import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Scrolling until Web Table Example
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(2000);
		
		//Show number of lines
		List<WebElement> tableLines = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println("Number of lines: "+ tableLines.size());
		
		//Show number of columns
		List<WebElement> tableColumns = driver.findElements(By.cssSelector(".table-display tr th"));
		System.out.println("Number of columns: "+ tableColumns.size());
		
		//Show content of line number 2
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
			

	}

}
